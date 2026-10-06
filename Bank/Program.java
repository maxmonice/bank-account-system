package Bank;

public class Program {
    public static void main(String[]args) {
        BankAccount obj1 = new BankAccount("Rafael M. Carlos III", 0,"A12549721");
        obj1.deposit(10000);
        obj1.withdraw(7000);
    }
}
