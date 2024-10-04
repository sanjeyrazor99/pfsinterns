

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TransactionDAO {
    private List<Transaction> transactions = new ArrayList<>();
    private int nextId = 1;

    public void addTransaction(Transaction transaction) {
        transaction.setTransactionId(nextId++);
        transactions.add(transaction);
    }

    public List<Transaction> getAllTransactions() {
        return new ArrayList<>(transactions);
    }

    public void updateTransaction(Transaction transaction) {
        for (int i = 0; i < transactions.size(); i++) {
            if (transactions.get(i).getTransactionId() == transaction.getTransactionId()) {
                transactions.set(i, transaction);
                return;
            }
        }
    }

    public void deleteTransaction(int transactionId) {
        transactions.removeIf(transaction -> transaction.getTransactionId() == transactionId);
    }
}
