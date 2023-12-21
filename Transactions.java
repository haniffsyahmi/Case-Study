import java.util.Date;
import java.util.Calendar;
import java.text.SimpleDateFormat;

public class Transactions{
    private double balance;                             // 2. Initialize variables by Q  
    private double payment;
    private Date transactionDate;
    private double remainingAmount;

    public Transaction(double balance, double payment) {    // 2. Constructor by Q
        this.balance = balance;
        this.payment = payment;
        this.transactionDate = new Date();
        this.remainingAmount = balance - payment;
    }

    public double getBalance() {                        // 2. Get balance by Q
        return balance;
    }
    
    public double getPayment() {                        // 2. Get payment by Q
        return payment;
    }

    public double getRemainingAmount() {                // 2. Get remaining amount by Q
        return remainingAmount;
    }

    public Date gettransactionDate() {                  // 2. Get transaction date by Q
        return transactionDate;
    }

    public double calculateDiscount() {                 // 3. Calculate discount by Syahmi
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(transactionDate);

        int hourOfDay = calendar.get(Calendar.HOUR_OF_DAY);

        if ((hourOfDay >= 12 && hourOfDay <= 14) || (hourOfDay >= 18 && hourOfDay <= 20)) {
            return 0.1 * balance;
        } else {
            return 0;
        }
    }
}
