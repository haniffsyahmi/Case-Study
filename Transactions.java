import java.text.SimpleDateFormat;
import java.util.Date;

public class Transaction {
    private double balance;
    private double payment;
    private Date date;
    private double remainingAmount;

    public Transaction(double balance, double payment) {
        this.balance = balance;
        this.payment = payment;
        this.date = new Date();
        this.remainingAmount = balance - payment;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getPayment() {
        return payment;
    }

    public void setPayment(double payment) {
        this.payment = payment;
    }

    public double getRemainingAmount() {
        return remainingAmount;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return "Transaction on " + dateFormat.format(date) +
                ": Balance=" + balance +
                ", Payment=" + payment +
                ", Remaining Amount=" + remainingAmount;
    }

    public static void main(String[] args) {
        Transaction transaction = new Transaction(100.0, 50.0);
        System.out.println("Balance: " + transaction.getBalance());
        System.out.println("Payment: " + transaction.getPayment());
        System.out.println("Remaining Amount: " + transaction.getRemainingAmount());
        transaction.setBalance(80.0);
        System.out.println("Updated Balance: " + transaction.getBalance());
    }
}
