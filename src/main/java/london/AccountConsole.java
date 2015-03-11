package london;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Georgina on 03/03/2015.
 */
public class AccountConsole implements AccountDisplay {
    private static final String STATEMENT_HEADER = "DATE | AMOUNT | BALANCE";
    private Console console;

    public AccountConsole(Console console) {
        this.console = console;
    }

    @Override
    public void display(List<Transaction> statements) {
        console.println(STATEMENT_HEADER);

        List<Transaction> originalList = new ArrayList<>(statements);
        int lastTransactionIndexToConsider = indexOfLastTransaction(originalList);

        Collections.reverse(statements);
        for (Transaction statement : statements) {
            double transactionAmount = statement.getAmount();
            console.println(statement.getDate()
                    + " | " + transactionAmount
                    + " | " + getCurrentBalance(originalList, lastTransactionIndexToConsider--));
        }
    }

    private int indexOfLastTransaction(List<Transaction> originalList) {
        return originalList.size() - 1;
    }

    private double getCurrentBalance(List<Transaction> originalList, int index) {
        double balance = 0;
        for (int i = 0; i <= index; i++) {
            balance += originalList.get(i).getAmount();
        }
        return balance;
    }
}
