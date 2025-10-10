// File: PaymentAfter.java

// Base class
abstract class Payment {
    public abstract void process(double amount);
}

class CreditCardPayment extends Payment {
    @Override
    public void process(double amount) {
        System.out.println("Credit Card: $" + amount);
    }
}

class DebitCardPayment extends Payment {
    @Override
    public void process(double amount) {
        System.out.println("Debit Card: $" + amount);
    }
}

class PayPalPayment extends Payment {
    @Override
    public void process(double amount) {
        System.out.println("PayPal: $" + amount);
    }
}

public class BeforePattern {
    public static void main(String[] args) {
        Payment payment = new CreditCardPayment();

        // Pattern matching with instanceof (Java 17)
        if (payment instanceof CreditCardPayment cc) {
            cc.process(100); // No cast needed
        } else if (payment instanceof DebitCardPayment dc) {
            dc.process(200);
        } else if (payment instanceof PayPalPayment pp) {
            pp.process(300);
        }
    }
}
