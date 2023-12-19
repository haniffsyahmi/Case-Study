import java.util.ArrayList;

public class eWallet {
    private ArrayList<Transactions> transactions;

    public eWallet() {
        transactions = new ArrayList<Transactions>();
    }

    public void addTransaction(Transactions transaction) {
        transactions.add(transaction);
    }

}
