import java.util.InputMismatchException;
import java.util.Scanner;

public class BankAccount {
    String customerName;
    int balance;
    String customerID;
    int previousTransactions;
    public BankAccount(String cName,String cID){
        customerName = cName;
        customerID = cID;
    }
    public void deposit(int amount){
        if(amount!=0){
            balance = balance + amount;
            previousTransactions = amount;
        }
    }
    public void withdraw(int amount){
        if(amount != 0) {
            balance = balance - amount;
            previousTransactions = -amount;
        }
    }
    public void getBalance(){
        System.out.println("Balance Amount: " + balance);
    }
    public void getPreviousTransactions(){
        if(previousTransactions > 0){
            System.out.println("Deposited: " + previousTransactions);
        }
        else if(previousTransactions < 0){
            System.out.println("Withdrawn: " + Math.abs(previousTransactions));
        }
        else{
            System.out.println("No Previous Transactions Occurred");
        }
    }
    public void show(){
        System.out.println("Welcome " + customerName);
        System.out.println("ID: " + customerID);
        char option;

        do{

            System.out.println("Please select any one of options below");
            System.out.println("A. Deposit");
            System.out.println("B. Withdraw");
            System.out.println("C. Check Balance");
            System.out.println("D. Previous Transactions");
            System.out.println("E. Exit");
            Scanner sc = new Scanner(System.in);
            option = sc.next().toUpperCase().charAt(0);

            switch (option) {
                case 'A' -> {
                    System.out.println("Enter the amount:");
                    int amt = sc.nextInt();
                    if (amt < 0)
                        System.out.println("Please enter valid amount");
                    else {
                        deposit(amt);
                        System.out.println(amt +" Deposited Successfully\n");
                    }
                }
                case 'B' -> {
                    System.out.println("Enter the amount:");
                    int amt2 = sc.nextInt();
                    if (balance > 0) {
                        if (amt2 < 0 || amt2 > balance)
                            System.out.println("You have " + balance + " balance. Please enter valid amount");
                        else {
                            withdraw(amt2);
                            System.out.println(amt2 +" Withdrawn Successfully\n");
                        }
                    } else {
                        System.out.println("Please deposit first!!!\n");
                    }
                }
                case 'C' -> getBalance();
                case 'D' -> getPreviousTransactions();
                case 'E' -> System.out.println("---------------------------------------");
                default -> System.out.println("Please select valid option or Try again\n");
            }

        }while(option != 'E');
        System.out.println("Thank you "+ customerName +" for choosing our service");
        System.out.println("-----------------------------------------------");
    }
}
