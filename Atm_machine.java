import java.util.Scanner;

class ATM {
    float balance = 0;
    int pin = 2308;
    String trans = "";

    public void checkpin() {
        System.out.println("ENTER YOUR PIN: ");
        Scanner sc = new Scanner(System.in);
        int enterpin = sc.nextInt();
        if (enterpin == pin) {
            menu();
        } else {
            System.out.println("ENTER A VALID PIN !!!");
        }
    }

    public void menu() {
        System.out.println("ENTER YOUR CHOICE: \n 1 - Check Account Balance \n 2 - Deposit Money \n 3 - Withdraw Money \n 4 - Mini Statement \n 5 - Exit");
        Scanner sc = new Scanner(System.in);
        int opt = sc.nextInt();
        if (opt == 1) {
            checkbalance();
        } else if (opt == 2) {
            deposit();
        } else if (opt == 3) {
            withdraw();
        } else if (opt == 4) {
            transhis();
        } else if (opt == 5) {
            System.out.println("THANK YOU!!! PLEASE VISIT AGAIN");
        } else {
            System.out.println("ENTER A VALID CHOICE !!!");
            menu();  // Prompt for choice again
        }
    }

    public void checkbalance() {
        System.out.println("YOUR BALANCE: " + balance + " ₹");
        menu();
    }

    public void deposit() {
        System.out.println("ENTER AMOUNT TO DEPOSIT: ");
        Scanner sc = new Scanner(System.in);
        float amount = sc.nextFloat();
        balance += amount;
        System.out.println("MONEY DEPOSITED SUCCESSFULLY!!!");
        System.out.println("CURRENT BALANCE: " + balance + " ₹");
        String str = amount + " ₹ has been Credited\n";
        trans = trans.concat(str);
        menu();
    }

    public void withdraw() {
        System.out.println("ENTER AMOUNT TO WITHDRAW: ");
        Scanner sc = new Scanner(System.in);
        float amount = sc.nextFloat();
        if (amount > balance) {
            System.out.println("INSUFFICIENT BALANCE !!!");
        } else {
            balance -= amount;
            System.out.println("MONEY WITHDRAWN SUCCESSFULLY!!!");
            System.out.println("CURRENT BALANCE: " + balance + " ₹");
            String str = amount + " ₹ has been Debited\n";
            trans = trans.concat(str);
        }
        menu();
    }

    public void transhis() {
        if (trans.isEmpty()) {
            System.out.println("NO TRANSACTIONS OCCURRED!!!");
        } else {
            System.out.println("\n" + trans);
        }
        menu();
    }
}

public class Atm_machine {
    public static void main(String[] args) {
        ATM obj = new ATM();
        obj.checkpin();
    }
}
