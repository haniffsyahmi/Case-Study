import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        eWallet myWallet = new eWallet();

        int choice;

        do {
            System.out.println("\ne-Wallet Menu:");
            System.out.println("1. Top Up e-Wallet");
            System.out.println("2. Make Payment");
            System.out.println("3. Display monthly transactions");
            System.out.println("4. Exit");

            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            System.out.println();

            switch (choice) {
                case 1:
                    topUpEWallet(scanner, myWallet);
                    break;
                case 2:
                    makePayment(scanner, myWallet);
                    break;
                case 3:
                    displayAndCalculateEverything(myWallet);
                    break;
                case 4:
                    System.out.println("Exiting the e-Wallet. Thank you!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }

        } while (choice != 4);

        scanner.close();
    }

    private static void topUpEWallet(Scanner scanner, eWallet wallet) {
        System.out.print("Enter the amount to top up: ");
        double amount = scanner.nextDouble();
        System.out.println();

        Transactions.TopUpMethod topUpMethod;

        do {
            topUpMethod = selectTopUpMethod(scanner);

            switch (topUpMethod) {
                case CREDIT_CARD:
                    topUpCreditCard(amount, wallet);
                    break;
                case DEBIT_CARD:
                    topUpDebitCard(amount, wallet);
                    break;
                case ONLINE_BANKING:
                    topUpOnlineBanking(amount, wallet);
                    break;
                case CASH:
                    topUpCash(amount, wallet);
                    break;
                default:
                    System.out.println("Invalid top-up method. Please try again.");
                    break;
            }
        } while (topUpMethod == null);
    }

    private static Transactions.TopUpMethod selectTopUpMethod(Scanner scanner) {
        System.out.println("Select top-up method:");
        System.out.println("1. Credit Card");
        System.out.println("2. Debit Card");
        System.out.println("3. Online Banking");
        System.out.println("4. Cash");

        System.out.println();
        System.out.print("Enter your choice: ");
        int choice = scanner.nextInt();
        System.out.println();

        switch (choice) {
            case 1:
                return Transactions.TopUpMethod.CREDIT_CARD;
            case 2:
                return Transactions.TopUpMethod.DEBIT_CARD;
            case 3:
                return Transactions.TopUpMethod.ONLINE_BANKING;
            case 4:
                return Transactions.TopUpMethod.CASH;
            default:
                System.out.println("Invalid choice. Defaulting to Cash.");
                return Transactions.TopUpMethod.CASH;
        }
    }

    private static void topUpCreditCard(double amount, eWallet wallet) {
        Transactions newTransaction = new Transactions(amount, 0, Transactions.TopUpMethod.CREDIT_CARD);
        wallet.addTransaction(newTransaction);
        System.out.println();
        System.out.println("e-Wallet topped up successfully.");
        System.out.println("You received RM 0.50 cashback!");
    }

    private static void topUpDebitCard(double amount, eWallet wallet) {
        Transactions newTransaction = new Transactions(amount, 0, Transactions.TopUpMethod.DEBIT_CARD);
        wallet.addTransaction(newTransaction);
        System.out.println();
        System.out.println("e-Wallet topped up successfully.");
    }

    private static void topUpOnlineBanking(double amount, eWallet wallet) {
        Transactions newTransaction = new Transactions(amount, 0, Transactions.TopUpMethod.ONLINE_BANKING);
        wallet.addTransaction(newTransaction);
        System.out.println();
        System.out.println("e-Wallet topped up successfully.");
    }

    private static void topUpCash(double amount, eWallet wallet) {
        Transactions newTransaction = new Transactions(amount, 0, Transactions.TopUpMethod.CASH);
        wallet.addTransaction(newTransaction);
        System.out.println();
        System.out.println("e-Wallet topped up successfully.");
    }

    private static void makePayment(Scanner scanner, eWallet wallet) {
        System.out.print("Enter the amount to pay: ");
        double amount = scanner.nextDouble();
        System.out.println();

        Transactions newTransaction = new Transactions(0, amount, Transactions.TopUpMethod.CASH);
        wallet.addTransaction(newTransaction);

        System.out.println();
        System.out.println("Payment made successfully.");
    }

    private static void displayAndCalculateEverything(eWallet wallet) {
        double remainingAmount = wallet.getTotalBalance();

        System.out.println("\nMonthly Transactions:");
        for (Transactions transaction : wallet.getMonthlyTransactions()) {
            remainingAmount -= transaction.getPayment();
            System.out.println(transaction);
        }

        System.out.println("\nTotal Balance: RM " + wallet.getTotalBalance());
    }
}
