package sealedClass;

public class DebitCard extends CardPayment{
	@Override
    public void pay() {
        System.out.println("Processing Debit Card payment...");
    }

}
