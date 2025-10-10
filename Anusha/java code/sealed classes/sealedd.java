public class sealedd {

    // Sealed abstract class
    public abstract sealed static class Payment 
            permits CreditCardPayment, DebitCardPayment, PayPalPayment {
        public abstract void processPayment(double amount);
    }

    public static final class CreditCardPayment extends Payment {
        @Override
        public void processPayment(double amount) {
            System.out.println("Processing credit card payment: $" + amount);
        }
    }

    public static final class DebitCardPayment extends Payment {
        @Override
        public void processPayment(double amount) {
            System.out.println("Processing debit card payment: $" + amount);
        }
    }

    public static final class PayPalPayment extends Payment {
        @Override
        public void processPayment(double amount) {
            System.out.println("Processing PayPal payment: $" + amount);
        }
    }

    public static void main(String[] args) {
        Payment p1 = new CreditCardPayment();
        Payment p2 = new DebitCardPayment();
        Payment p3 = new PayPalPayment();

        processPayment(p1);
        processPayment(p2);
        processPayment(p3);
    }

    public static void processPayment(Payment payment) {
        payment.processPayment(100.0);

        if (payment instanceof CreditCardPayment) {
            System.out.println("Handled credit card specifics");
        } else if (payment instanceof DebitCardPayment) {
            System.out.println("Handled debit card specifics");
        } else if (payment instanceof PayPalPayment) {
            System.out.println("Handled PayPal specifics");
        }
    }
}
