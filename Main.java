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
            System.out.println("3. Display Monthly Transactions");
            System.out.println("4. Exit");

            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    topUpEWallet(scanner, myWallet);
                    break;
                case 2:
                    makePayment(scanner, myWallet);
                    break;
                case 3:
                    displayMonthlyTransactions(myWallet);
                    break;
                case 4:
                    System.out.println("Exiting the e-Wallet. Thank you!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }

        } while (choice != 4);

        // Close the scanner
        scanner.close();
    }

    private static void topUpEWallet(Scanner scanner, eWallet wallet) {
        System.out.print("Enter the amount to top up: ");
        double amount = scanner.nextDouble();

        Transactions.TopUpMethod topUpMethod = selectTopUpMethod(scanner);

        Transactions newTransaction = new Transactions(amount, 0, topUpMethod);
        wallet.addTransaction(newTransaction);

        System.out.println("e-Wallet topped up successfully.");

        if (topUpMethod == Transactions.TopUpMethod.CREDIT_CARD) {
            System.out.println("You received RM 0.50 cashback!");
        }
    }

    private static Transactions.TopUpMethod selectTopUpMethod(Scanner scanner) {
        System.out.print("Select top-up method (CREDIT_CARD, DEBIT_CARD, ONLINE_BANKING, CASH): ");
        return Transactions.TopUpMethod.valueOf(scanner.next());
    }

    private static void makePayment(Scanner scanner, eWallet wallet) {
        System.out.print("Enter the amount to pay: ");
        double amount = scanner.nextDouble();

        Transactions newTransaction = new Transactions(0, amount, false);
        wallet.addTransaction(newTransaction);

        System.out.println("Payment made successfully.");
    }

    private static void displayMonthlyTransactions(eWallet wallet) {
        System.out.println("\nMonthly Transactions:");
        for (Transactions transaction : wallet.getMonthlyTransactions()) {
            System.out.println(transaction);
        }
    }
}
