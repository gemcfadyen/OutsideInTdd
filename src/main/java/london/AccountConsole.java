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
        double balance = 0;
        int index = originalList.size() - 1;
        Collections.reverse(statements);
        for (Transaction statement : statements) {
            double transactionAmount = statement.getAmount();
            balance = getPreviousEntries(originalList, index) + transactionAmount;
            index--;
            console.println(statement.getDate() + " | " + transactionAmount + " | " + balance);
        }
    }

    private double getPreviousEntries(List<Transaction> originalList, int index) {
        double balance = 0;
        for (int i = 0; i < index; i++) {
            balance += originalList.get(i).getAmount();
        }
        return balance;
    }
}
