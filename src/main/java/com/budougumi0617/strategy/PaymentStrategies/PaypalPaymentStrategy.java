/**
 * @file
 * @par File Name:
 * PaypalPaymentStrategy.java
 * @author budougumi0617
 * @date Created on 2016/09/26
 */
package com.budougumi0617.strategy.PaymentStrategies;

import com.budougumi0617.strategy.OnlinePaymentInterface.IPaymentStrategy;

/**
 * @author budougumi0617
 * @note no comment
 */
public class PaypalPaymentStrategy implements IPaymentStrategy {
	public void ProcessPayment() {
		System.out.println("Paypal payment chosen");
	}
}
