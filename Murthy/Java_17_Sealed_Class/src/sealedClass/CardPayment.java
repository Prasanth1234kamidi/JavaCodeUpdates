package sealedClass;

public non-sealed class CardPayment extends PaymentMethod{
	@Override
    public void pay() {
        System.out.println("Processing card payment...");
    }

}
