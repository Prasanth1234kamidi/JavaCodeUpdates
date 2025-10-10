record BankAccount(String accountNumber, String owner, double balance) {}

public class RecordBank {
    public static void main(String[] args) {
        BankAccount account = new BankAccount("123456789", "Anusha", 5000.0);

        System.out.println(account); 
        // BankAccount[accountNumber=123456789, owner=Anusha, balance=5000.0]

        // Access fields
        System.out.println("Owner: " + account.owner()); 
        System.out.println("Balance: " + account.balance());

        // Records are immutable, cannot change fields
        // account.balance = 6000; // ❌ Compilation error
    }
}
