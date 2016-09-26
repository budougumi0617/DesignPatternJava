/**
 * @file
 * @par File Name:
 * TradeProcessor.java
 * @author budougumi0617
 * @date Created on 2016/08/28
 */
package com.budougumi0617.piyocode.trade;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author budougumi0617
 * @note Original code is created by
 *       garymcleanhall.
 * 
 * 
 *       Assume SQL command for add TradeRecord data to trade table in
 *       jdbc:dummysql://localhost/dummyurl.
 *
 *       Dummy database is defined as below.
 * 
 *       {@code
 *       dummysql>descrive trade
 *       +---------------------+------------+-----+
 *       | Field               | Type       | Key |
 *       +---------------------+------------+-----|
 *       | id                  | Int        | PRI |
 *       | sourceCurrency      | String     |     |
 *       | destinationCurrency | String     |     |
 *       | lots                | Float      |     |
 *       | price               | BigDecimal |     |
 *       +---------------------+------------+-----+
 *       }
 */
public class TradeProcessor {
	private static float LotSize = 100000f;
	private static long newid = 0;

	/**
	 * Read data, Parse strings, and submit record to database.
	 * 
	 * @param stream
	 *            input data
	 */
	public void ProcessTrades(InputStream stream) {
		// read rows
		List<String> lines = new ArrayList<String>();
		// use try-with-resources syntax.
		try (InputStreamReader isr = new InputStreamReader(stream);
				BufferedReader bfr = new BufferedReader(isr);) {

			String line;
			while ((line = bfr.readLine()) != null) {
				lines.add(line);
			}
		} catch (IOException ioe) {
			ioe.printStackTrace();
			return; // cannot open reader for stream.
		}

		List<TradeRecord> trades = new ArrayList<TradeRecord>();

		int lineCount = 1;
		for (String line : lines) {

			// validate data format.
			String[] fields = line.split(",");

			if (fields.length != 3) {
				System.out.printf("WARN: Line %d malformed. Only %d field(s) found.\n",
						lineCount, fields.length);
				continue;
			}

			if (fields[0].length() != 6) {
				System.out.printf("WARN: Trade currencies on line %d malformed: '%s'\n",
						lineCount, fields[0]);
				continue;
			}

			int tradeAmount;
			try {
				tradeAmount = Integer.parseInt(fields[1]);
			} catch (NumberFormatException nfe) {
				System.out.printf(
						"WARN: Trade amount on line %d not a valid Integer: '%s'\n",
						lineCount, fields[1]);
				continue;
			}

			// set each data to TradeRecord class.
			BigDecimal tradePrice;
			try {
				tradePrice = new BigDecimal(fields[2]);
			} catch (NumberFormatException nfe) {
				System.out.printf(
						"WARN: Trade amount on line %d not a valid BigDecimal: '%s'\n",
						lineCount, fields[2]);
				continue;
			}

			String sourceCurrencyCode = fields[0].substring(0, 3);
			String destinationCurrencyCode = fields[0].substring(3, 3);

			// calculate values
			TradeRecord trade = new TradeRecord();
			trade.SourceCurrency = sourceCurrencyCode;
			trade.DestinationCurrency = destinationCurrencyCode;
			trade.Lots = tradeAmount / LotSize;
			trade.Price = tradePrice;

			trades.add(trade);

			lineCount++;
		}

		// connect database, and create statements for submit data.
		String dummySqlCommand = "INSERT INTO trade VALUES (?, ?, ?, ?, ?);";
		// use try-with-resources syntax.
		// magic spell for connect SQL server.
		try (Connection connection = DriverManager
				.getConnection("jdbc:dummysql://localhost/dummyurl");
				PreparedStatement statement = connection
						.prepareStatement(dummySqlCommand);) {
			// magic spell.
			connection.setAutoCommit(false);

			// create SQL command for each trade record.
			for (TradeRecord trade : trades) {
				statement.setInt(1, (int) (newid++));
				statement.setString(2, trade.SourceCurrency);
				statement.setString(3, trade.DestinationCurrency);
				statement.setFloat(4, trade.Lots);
				statement.setBigDecimal(5, trade.Price);

				statement.addBatch();
				System.out.println(statement.toString());
			}

			int[] result = statement.executeBatch();
			System.out.println("Submit " + result.length + "records.");

			try {
				connection.commit();
				System.out.println("Submit success");
			} catch (SQLException e) {
				connection.rollback();
				System.out.println("Submit failed, execute rollback");
				e.printStackTrace();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
