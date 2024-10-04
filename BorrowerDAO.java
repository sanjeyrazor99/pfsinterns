

import java.util.ArrayList;
import java.util.List;

public class BorrowerDAO {
    private List<Borrower> borrowers = new ArrayList<>();
    private int nextId = 1;

    public void addBorrower(Borrower borrower) {
        borrower.setBorrowerId(nextId++);
        borrowers.add(borrower);
    }

    public List<Borrower> getAllBorrowers() {
        return new ArrayList<>(borrowers);
    }

    public void updateBorrower(Borrower borrower) {
        for (int i = 0; i < borrowers.size(); i++) {
            if (borrowers.get(i).getBorrowerId() == borrower.getBorrowerId()) {
                borrowers.set(i, borrower);
                return;
            }
        }
    }

    public void deleteBorrower(int borrowerId) {
        borrowers.removeIf(borrower -> borrower.getBorrowerId() == borrowerId);
    }
}
