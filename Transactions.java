import java.util.Date;
import java.util.Calendar;
import java.text.SimpleDateFormat;
public class Transactions{
    private double balance;
    private double payment;
    private Date transactiondate;
    private double remainingAmount;

    public Transaction(double balance, double payment) {
        this.balance = balance;
        this.payment = payment;
        this.transactiondate = new Date();
        this.remainingAmount = balance - payment;
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

    public Date gettransactionDate() {
        return transactiondate;
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
        return "Transaction on " + dateFormat.format(transactiondate) +
                ": Balance=" + balance +
                ", Payment=" + payment +
                ", Remaining Amount=" + remainingAmount;
    }
}
