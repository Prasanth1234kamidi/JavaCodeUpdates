package sealedClass;

public class CreditCard extends CardPayment{
	@Override
    public void pay() {
        System.out.println("Processing Credit Card payment...");
    }

}
