package london;

import com.google.common.collect.Lists;

import java.util.List;

/**
 * Created by Georgina on 27/02/2015.
 */
public class AccountStatement {
    private List<Transaction> statements = Lists.newArrayList();

    public void deposit(Transaction transaction) {
        statements.add(transaction);
    }

    public void withdraw(Transaction transaction) {
        statements.add(transaction);
    }

    public List<Transaction> getTransactions() {
        return statements;
    }
}
