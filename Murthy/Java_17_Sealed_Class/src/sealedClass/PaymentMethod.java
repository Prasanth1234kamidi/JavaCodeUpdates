package sealedClass;

public sealed class PaymentMethod permits CardPayment,UPIPayment{
	public void pay() {
        System.out.println("Processing generic payment...");
    }

}
