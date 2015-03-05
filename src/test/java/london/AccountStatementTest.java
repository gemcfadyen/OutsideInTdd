package london;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class AccountStatementTest {

    @Test
    public void should_add_deposit_transaction_to_statement() {
        AccountStatement statement = new AccountStatement();
        Transaction depositedTransaction = new Transaction("12/01/2015", 122);

        statement.deposit(depositedTransaction);

        assertTrue(statement.getTransactions().contains(depositedTransaction));
    }

    @Test
    public void should_add_withdraw_transaction_to_statement() {
        AccountStatement statement = new AccountStatement();
        Transaction withdrawTransaction = new Transaction("12/01/2015", 122);

        statement.withdraw(withdrawTransaction);

        assertTrue(statement.getTransactions().contains(withdrawTransaction));
    }

}