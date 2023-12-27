import java.util.Date;
import java.util.Calendar;
import java.text.SimpleDateFormat;

public class Transactions {
    public enum TopUpMethod {
        CREDIT_CARD, DEBIT_CARD, ONLINE_BANKING, CASH;
    }

    private double balance;
    private double payment;
    private Date transactionDate;
    private double remainingAmount;
    private TopUpMethod topUpMethod;

    public Transactions(double balance, double payment, TopUpMethod topUpMethod) {
        this.balance = balance;
        this.payment = payment;
        this.transactionDate = new Date();
        this.remainingAmount = balance - payment;
        this.topUpMethod = topUpMethod;

        // Apply cashback for Credit Card top-ups
        if (topUpMethod == TopUpMethod.CREDIT_CARD) {
            this.remainingAmount += 0.50; // RM 0.50 cashback
        }
    }

    public double getBalance() {
        return balance;
    }

    public double getPayment() {
        return payment;
    }

    public double getRemainingAmount() {
        return remainingAmount;
    }

    public Date getTransactionDate() {
        return transactionDate;
    }

    public TopUpMethod getTopUpMethod() {
        return topUpMethod;
    }

    public double calculateDiscount() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(transactionDate);

        int hourOfDay = calendar.get(Calendar.HOUR_OF_DAY);

        if ((hourOfDay >= 12 && hourOfDay <= 14) || (hourOfDay >= 18 && hourOfDay <= 20)) {
            return 0.1 * balance;
        } else {
            return 0;
        }
    }

    @Override
    public String toString() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return "Transaction on " + dateFormat.format(transactionDate) +
                ": Balance=" + balance +
                ", Payment=" + payment +
                ", Remaining Amount=" + remainingAmount +
                ", Top-Up Method=" + topUpMethod;
    }
}
