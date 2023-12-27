import java.util.ArrayList;
import java.util.Calendar;

public class eWallet {
    private ArrayList<Transactions> transactions;           // 1. Create arraylist by Syahmi

    public eWallet() {                                      // 1. Constructor by Syahmi
        transactions = new ArrayList<Transactions>();
    }

    public void addTransaction(Transactions transaction) {  // 1. Add transaction by Syahmi
        transactions.add(transaction);
    }

    public double CalculateTotalDiscount() {                // 5. Calculate total discount by Qays
        double totalDiscount = 0;
        for (Transactions transaction : transactions) {
            totalDiscount += transaction.calculateDiscount();
        }
        return totalDiscount;
    }

    public ArrayList<Transactions> getMonthlyTransactions() {  // 5. Get monthly transactions by Qays
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
