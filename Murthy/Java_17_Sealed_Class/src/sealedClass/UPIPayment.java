package sealedClass;

public final class UPIPayment extends PaymentMethod{
	@Override
    public void pay() {
        System.out.println("Processing UPI payment...");
    }

}
