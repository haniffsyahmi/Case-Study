import java.util.ArrayList;
import java.util.Calendar;

public class eWallet {
    private ArrayList<Transactions> transactions;           // initialize ArrayList by Syahmi
    private double totalBalance;

    public eWallet() {                            // constructor method by Syahmi
        transactions = new ArrayList<Transactions>();
        totalBalance = 0;
    }

    public void addTransaction(Transactions transaction) {          // add transaction method by Syahmi
        transactions.add(transaction);
        updateTotalBalance(transaction.getRemainingAmount());
    }

    private void updateTotalBalance(double remainingAmount) {       // update total balance method by Qays
        totalBalance += remainingAmount;
    }

    public double getTotalBalance() {               // get total balance method by Qays
        return totalBalance;
    }

    public double calculateTotalDiscount() {        // calculate total discount method by Qays
        double totalDiscount = 0;
        for (Transactions transaction : transactions) {
            totalDiscount += transaction.calculateDiscount();
        }
        return totalDiscount;
    }

    public ArrayList<Transactions> getMonthlyTransactions() {           // get monthly transactions method by Qays
        ArrayList<Transactions> monthlyTransactions = new ArrayList<Transactions>();
        Calendar calendar = Calendar.getInstance();
        int currentMonth = calendar.get(Calendar.MONTH);

        for (Transactions transaction : transactions) {
            calendar.setTime(transaction.getTransactionDate());
            if (calendar.get(Calendar.MONTH) == currentMonth) {
                monthlyTransactions.add(transaction);
            }
        }

        return monthlyTransactions;
    }
}
