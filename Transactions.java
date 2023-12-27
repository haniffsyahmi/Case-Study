import java.util.Date;
import java.util.Calendar;
import java.text.SimpleDateFormat;

public class Transactions {
    public enum TopUpMethod {
        CREDIT_CARD, DEBIT_CARD, ONLINE_BANKING, CASH;
    }

    private double balance;             // initialize variables by Q
    private double payment;
    private Date transactionDate;
    private double remainingAmount;
    private TopUpMethod topUpMethod;

    public Transactions(double balance, double payment, TopUpMethod topUpMethod) { // constructor method by Q
        this.balance = balance;
        this.payment = payment;
        this.transactionDate = new Date();
        this.remainingAmount = balance - payment;

        if (topUpMethod == TopUpMethod.CREDIT_CARD) {   // cashback method by Ipin
            this.remainingAmount += 0.50;
        }

        this.topUpMethod = topUpMethod;
    }

    public double getBalance() {                // getter method by Q
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

    public double calculateDiscount() {                  // calculate discount method by Syahmi
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
    public String toString() {              // generate recorded transaction by Qays
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return "Transaction on " + dateFormat.format(transactionDate) +
                ": Balance=" + balance +
                ", Payment=" + payment +
                ", Remaining Amount=" + remainingAmount +
                ", Top-Up Method=" + topUpMethod;
    }
}
