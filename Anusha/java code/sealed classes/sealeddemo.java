// File: BankAccountBefore.java

// Base class
class BankAccount {
    private String accountNumber;

    public BankAccount(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getAccountNumber() {
        return accountNumber;
    }
}

// Subclasses
class SavingsAccount extends BankAccount {
    public SavingsAccount(String accountNumber) {
        super(accountNumber);
    }
}

class CurrentAccount extends BankAccount {
    public CurrentAccount(String accountNumber) {
        super(accountNumber);
    }
}

class LoanAccount extends BankAccount {
    public LoanAccount(String accountNumber) {
        super(accountNumber);
    }
}

// Main class to test
public class sealeddemo {
    public static void main(String[] args) {
        BankAccount sa = new SavingsAccount("SA123");
        BankAccount ca = new CurrentAccount("CA456");
        BankAccount la = new LoanAccount("LA789");

        System.out.println("Savings Account: " + sa.getAccountNumber());
        System.out.println("Current Account: " + ca.getAccountNumber());
        System.out.println("Loan Account: " + la.getAccountNumber());
    }
}
