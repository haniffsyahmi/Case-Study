public class EWalletManagementSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        EWallet eWallet = new EWallet();

        System.out.println("Welcome to the E-Wallet Management System!");

        while (true) {
            System.out.println("\n1. Top-up with Credit Card");
            System.out.println("3. Top-up with Online Banking");
            System.out.println("4. Check Balance");
            System.out.println("5. Exit");
            System.out.print("Select an option: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter top-up amount: $");
                    double topUpAmountCreditCard = scanner.nextDouble();

                    // Assuming the user is using a credit card
                    double cashbackCreditCard = 0.50;
                    eWallet.processTopUpWithCashback(topUpAmountCreditCard, cashbackCreditCard);

                    System.out.println("Top-up successful!");
                    break;

                case 2:
                case 3:
                    System.out.print("Enter top-up amount: $");
                    double topUpAmount = scanner.nextDouble();
                    eWallet.topUp(topUpAmount);
                    System.out.println("Top-up successful!");
                    break;

                case 4:
                    System.out.println("Current Balance: $" + eWallet.getBalance());
                    break;

                case 5:
                    System.out.println("Thank you for using the E-Wallet Management System. Goodbye!");
                    System.exit(0);

                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
}
