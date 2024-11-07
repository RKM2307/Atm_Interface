import java.util.Scanner;

class ATM {
    float balance = 0;
    int pin = 2308;
    String trans = "";
    int pinAttempts = 0;
    final int maxPinAttempts = 3;

    public void checkpin() {
        Scanner sc = new Scanner(System.in);
        pinAttempts = 0; // Reset attempts on each check
        while (pinAttempts < maxPinAttempts) {
            System.out.print("ENTER YOUR PIN : ");
            int enterpin = sc.nextInt();
            if (enterpin == pin) {
                System.out.println("PIN VERIFIED! ACCESS GRANTED.");
                menu(sc);  // Passing the scanner to menu method
                return;
            } else {
                pinAttempts++;
                int attemptsLeft = maxPinAttempts - pinAttempts;
                if (attemptsLeft > 0) {
                    System.out.println("INVALID PIN! " + attemptsLeft + " ATTEMPT(S) LEFT.");
                } else {
                    System.out.println("ACCOUNT LOCKED DUE TO TOO MANY FAILED ATTEMPTS.");
                    break;
                }
            }
        }
    }

    public void changepin(Scanner sc) {
        System.out.print("ENTER YOUR CURRENT PIN: ");
        int currentPin = sc.nextInt();

        if (currentPin == pin) {
            System.out.print("ENTER NEW PIN: ");
            int newPin = sc.nextInt();
            if (newPin > 999 && newPin <= 9999 && newPin != pin) {
                pin = newPin;
                System.out.println("PLEASE RE-ENTER YOUR NEW PIN TO CONFIRM.");
                checkpin(); // Re-authenticate with new PIN
            } else {
                System.out.println("INVALID NEW PIN! PLEASE CHOOSE A 4-DIGIT NUMBER DIFFERENT FROM THE CURRENT PIN.");
            }
        } else {
            System.out.println("INCORRECT CURRENT PIN!");
            menu(sc);  // Call menu again if PIN change fails
        }
    }

    public void menu(Scanner sc) {
        int opt;
        do {
            System.out.println("\nENTER YOUR CHOICE: \n 1 - Check Account Balance \n 2 - Deposit Money \n 3 - Withdraw Money \n 4 - Mini Statement \n 5 - Change PIN \n 6 - Exit");
            opt = sc.nextInt();
            switch (opt) {
                case 1:
                    checkbalance();
                    break;
                case 2:
                    deposit(sc);
                    break;
                case 3:
                    withdraw(sc);
                    break;
                case 4:
                    transhis();
                    break;
                case 5:
                    changepin(sc);
                    break;
                case 6:
                    System.out.println("THANK YOU!!! PLEASE VISIT AGAIN");
                    System.exit(0);;
                    break;
                default:
                    System.out.println("ENTER A VALID CHOICE !!!");
            }
        } while (opt != 6);
    }

    public void checkbalance() {
        System.out.println("YOUR BALANCE: " + balance + " ₹");
    }

    public void deposit(Scanner sc) {
        System.out.println("ENTER AMOUNT TO DEPOSIT: ");
        float amount = sc.nextFloat();
        if (amount > 0) {
            balance += amount;
            System.out.println("MONEY DEPOSITED SUCCESSFULLY!!!");
            System.out.println("CURRENT BALANCE: " + balance + " ₹");
            String str = amount + " ₹ has been Credited\n";
            trans = trans.concat(str);
        } else {
            System.out.println("INVALID AMOUNT! PLEASE ENTER A POSITIVE VALUE.");
        }
    }

    public void withdraw(Scanner sc) {
        System.out.println("ENTER AMOUNT TO WITHDRAW: ");
        float amount = sc.nextFloat();
        if (amount <= 0) {
            System.out.println("INVALID AMOUNT! PLEASE ENTER A POSITIVE VALUE.");
        } else if (amount > balance) {
            System.out.println("INSUFFICIENT BALANCE !!!");
        } else {
            balance -= amount;
            System.out.println("MONEY WITHDRAWN SUCCESSFULLY!!!");
            System.out.println("CURRENT BALANCE: " + balance + " ₹");
            String str = amount + " ₹ has been Debited\n";
            trans = trans.concat(str);
        }
    }

    public void transhis() {
        if (trans.isEmpty()) {
            System.out.println("NO TRANSACTIONS OCCURRED!!!");
        } else {
            System.out.println("\n" + trans);
        }
    }
}

public class Atm_machine {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);  // Create a single scanner instance
        ATM obj = new ATM();
        obj.checkpin();  // Start with pin check
        sc.close();  // Close the scanner once done
    }
}
