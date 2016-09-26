/**
 * @file
 * @par File Name:
 * OnlineCart.java
 * @author budougumi0617
 * @date Created on 2016/09/26
 */
package com.budougumi0617.strategy;

import java.util.HashMap;
import java.util.Map;

import com.budougumi0617.strategy.OnlinePaymentInterface.IPaymentStrategy;
import com.budougumi0617.strategy.PaymentStrategies.AmazonPaymentsPaymentStrategy;
import com.budougumi0617.strategy.PaymentStrategies.CreditCardPaymentStrategy;
import com.budougumi0617.strategy.PaymentStrategies.GoogleCheckoutPaymentStrategy;
import com.budougumi0617.strategy.PaymentStrategies.PaypalPaymentStrategy;

/**
 * @author budougumi0617
 * @note Original code is created by garymcleanhall.
 */
public class OnlineCart {

	public OnlineCart() {
		paymentStrategies = new HashMap<PaymentType, IPaymentStrategy>();
		paymentStrategies.put(PaymentType.CreditCard, new CreditCardPaymentStrategy());
		paymentStrategies.put(PaymentType.GoogleCheckout,
				new GoogleCheckoutPaymentStrategy());
		paymentStrategies.put(PaymentType.AmazonPayments,
				new AmazonPaymentsPaymentStrategy());
		paymentStrategies.put(PaymentType.Paypal, new PaypalPaymentStrategy());
	}

	public void CheckOut(PaymentType paymentType) {
		paymentStrategies.get(paymentType).ProcessPayment();
	}

	private Map<PaymentType, IPaymentStrategy> paymentStrategies;
}
