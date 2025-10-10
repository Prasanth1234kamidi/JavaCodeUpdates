package sealedClass;

public class PaymentDemo {

	public static void main(String[] args) {
		 PaymentMethod payment1 = new CreditCard();
	        PaymentMethod payment2 = new DebitCard();
	        PaymentMethod payment3 = new UPIPayment();
	        payment1.pay();
	        payment2.pay();
	        payment3.pay();

	}

}
