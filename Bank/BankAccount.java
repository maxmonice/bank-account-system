package Bank;

public class BankAccount {
    private String accountName;
    private double accountBalance;
    private String accountId;

    // Parameterized Constructor
    public BankAccount(String accountName, double accountBalance, String accountId) {
        this.accountName = accountName;
        this.accountBalance = accountBalance;
        this.accountId = accountId;

    }

    // Empty Constructor For Child Class
    public BankAccount() {}

    // Setters
    private void setAccountName(String accountName) {
        this.accountName = accountName;
        return;

    }

    private void setAccountBalance(double accountBalance) {
        this.accountBalance = accountBalance;
        return;
    }

    private void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    // Getters
    public String getAccountName() {
        return accountName;
    }

    public double getAccountBalance() {
        return accountBalance;
    }

    public String getAccountId() {
        return accountId;
    }

    // Methods

    public void changeAccountName(String accountName) {
        setAccountName(accountName);
    }

    public void changeAccountId(String accountId) {
        setAccountId(accountId);
    }

    public void deposit(double amount) {
        double total = getAccountBalance() + amount;
        if (amount <= 0) {
            System.out.println("Please Enter An Amount Greater Than 0!");
            return;
        }

        if (total < 3000) {
            System.out.println("Your Current Balance is " + getAccountBalance());
            System.out.println("Your Balance Must Be At Least 3000!");
            return;
        }

        setAccountBalance(total);
        System.out.println("Your Balance Is Now " + total + "!");

    }

    public void withdraw(double amount) {
        double total = getAccountBalance() - amount;
        double maintainingBalance = 3000;

        if (amount <= 0) {
            System.out.println("Please Enter An Amount Greater Than 0!");
            return;
        }

        if (total < maintainingBalance) {
            System.out.println("Your Current Balance is " + getAccountBalance());
            System.out.println("Your Withdrawal Would Violate The Maintaining Balance Of " + maintainingBalance + "!");
            return;

        }

        setAccountBalance(total);
        System.out.println("Your Balance Is Now " + total + "!");

    }

    public void displayInformation() {
        System.out.println(getAccountName());
        System.out.println(getAccountBalance());
        System.out.println(getAccountId());

    }

}

