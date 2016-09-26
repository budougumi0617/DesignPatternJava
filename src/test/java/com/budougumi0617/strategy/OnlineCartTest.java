/**
 * @file
 * @par File Name:
 * OnlineCartTest.java
 * @author budougumi0617
 * @date Created on 2016/09/26
 */
package com.budougumi0617.strategy;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.when;

import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.budougumi0617.strategy.OnlinePaymentInterface.IPaymentStrategy;

/**
 * @author budougumi0617
 * @note no comment
 */
public class OnlineCartTest {
	Boolean called;

	class Dummy implements IPaymentStrategy {
		@Override
		public void ProcessPayment() {
			System.out.println("Be called");
			called = true;
		}

	}

	@Mock(name = "paymentStrategies")
	Map<PaymentType, IPaymentStrategy> paymentStrategies;

	// Mockito is able to inject stub to member variable in target class.
	@InjectMocks
	OnlineCart oc = new OnlineCart();

	@Before
	public void setup() {
		called = false;
		// Initialize stub class
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testCheckOut() {

		// Arrange
		PaymentType input = PaymentType.AmazonPayments;
		// Set behavior to stub.
		when(paymentStrategies.get((Object) PaymentType.AmazonPayments))
				.thenReturn((IPaymentStrategy) new Dummy());

		// Act
		oc.CheckOut(input);

		// Assert
		assertThat(called, is(true)); // Actually, we should use assertTrue()...

	}

}
