import java.util.Scanner;

public class MainTransaction {
    static double amount;
    public static void main(String[] args)
    {
        BankAccount account1 = new BankAccount("1234ABC" , 6000);
        Scanner sc = new Scanner(System.in);
        System.out.print(" Please enter the amount u want to deposit : ");
        amount = sc.nextInt();
        account1.deposit(amount);
        System.out.print(" Please enter the amount u want to withdraw : ");
        amount = sc.nextInt();
        account1.withdraw(amount);
        System.out.println("The Current available balance after this transaction is : " + account1.getBalance());
    }
}
