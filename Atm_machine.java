import java.util.Scanner;
import java.math.BigDecimal;

class ATM {
    private BigDecimal balance = BigDecimal.ZERO;
    private int pin = 2308;
    private StringBuilder trans = new StringBuilder();
    private int pinAttempts = 0;
    private final int maxPinAttempts = 3;

    public void checkPin(Scanner sc) {
        pinAttempts = 0; // Reset attempts on each check
        while (pinAttempts < maxPinAttempts) {
            System.out.print("ENTER YOUR PIN: ");
            int enteredPin = sc.nextInt();
            if (enteredPin == pin) {
                System.out.println("PIN VERIFIED! ACCESS GRANTED.");
                menu(sc);
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

    public void changePin(Scanner sc) {
        System.out.print("ENTER CURRENT PIN: ");
        int currentPin = sc.nextInt();

        if (currentPin == pin) {
            System.out.print("ENTER NEW 4-DIGIT PIN: ");
            int newPin = sc.nextInt();
            if (newPin > 999 && newPin <= 9999 && newPin != pin) {
                System.out.print("CONFIRM NEW PIN: ");
                int confirmPin = sc.nextInt();
                if (confirmPin == newPin) {
                    pin = newPin;
                    System.out.println("PIN CHANGED SUCCESSFULLY!");
                } else {
                    System.out.println("PIN MISMATCH! PIN NOT CHANGED.");
                }
            } else {
                System.out.println("INVALID NEW PIN! Must be a 4-digit number different from current PIN.");
            }
        } else {
            System.out.println("INCORRECT CURRENT PIN!");
        }
    }

    public void menu(Scanner sc) {
        int opt;
        do {
            System.out.println("\nENTER YOUR CHOICE:\n" +
                    "1 - Check Account Balance\n" +
                    "2 - Deposit Money\n" +
                    "3 - Withdraw Money\n" +
                    "4 - Mini Statement\n" +
                    "5 - Change PIN\n" +
                    "6 - Exit");
            opt = sc.nextInt();

            switch (opt) {
                case 1 -> checkBalance();
                case 2 -> deposit(sc);
                case 3 -> withdraw(sc);
                case 4 -> showTransactions();
                case 5 -> changePin(sc);
                case 6 -> {
                    System.out.println("THANK YOU! PLEASE VISIT AGAIN.");
                    System.exit(0);
                }
                default -> System.out.println("ENTER A VALID CHOICE!");
            }
        } while (opt != 6);
    }

    public void checkBalance() {
        System.out.println("YOUR BALANCE: ₹" + balance);
    }

    public void deposit(Scanner sc) {
        System.out.print("ENTER AMOUNT TO DEPOSIT: ₹");
        BigDecimal amount = sc.nextBigDecimal();
        if (amount.compareTo(BigDecimal.ZERO) > 0) {
            balance = balance.add(amount);
            System.out.println("MONEY DEPOSITED SUCCESSFULLY!");
            System.out.println("CURRENT BALANCE: ₹" + balance);
            trans.append("₹").append(amount).append(" has been Credited\n");
        } else {
            System.out.println("INVALID AMOUNT! PLEASE ENTER A POSITIVE VALUE.");
        }
    }

    public void withdraw(Scanner sc) {
        System.out.print("ENTER AMOUNT TO WITHDRAW: ₹");
        BigDecimal amount = sc.nextBigDecimal();
        if (amount.compareTo(BigDecimal.ZERO) <= 0) {
            System.out.println("INVALID AMOUNT! PLEASE ENTER A POSITIVE VALUE.");
        } else if (amount.compareTo(balance) > 0) {
            System.out.println("INSUFFICIENT BALANCE!");
        } else {
            balance = balance.subtract(amount);
            System.out.println("MONEY WITHDRAWN SUCCESSFULLY!");
            System.out.println("CURRENT BALANCE: ₹" + balance);
            trans.append("₹").append(amount).append(" has been Debited\n");
        }
    }

    public void showTransactions() {
        if (trans.isEmpty()) {
            System.out.println("NO TRANSACTIONS OCCURRED!");
        } else {
            System.out.println("\nTRANSACTION HISTORY:\n" + trans);
        }
    }
}

public class AtmMachine {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ATM atm = new ATM();
        atm.checkPin(sc);
        sc.close();
    }
}
