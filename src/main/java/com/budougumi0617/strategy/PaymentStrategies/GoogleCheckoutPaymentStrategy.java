/**
 * @file
 * @par File Name:
 * GoogleCheckoutPaymentStrategy.java
 * @author budougumi0617
 * @date Created on 2016/09/26
 */
package com.budougumi0617.strategy.PaymentStrategies;

import com.budougumi0617.strategy.OnlinePaymentInterface.IPaymentStrategy;

/**
 * @author budougumi0617
 * @note no comment
 */
public class GoogleCheckoutPaymentStrategy implements IPaymentStrategy {
	@Override
	public void ProcessPayment() {
		System.out.println("Google payment chosen");
	}
}
