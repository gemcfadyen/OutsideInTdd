package london;

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
        double balance = 0;
        Collections.reverse(statements);
        for (Transaction statement : statements) {
            System.out.println("statement: " + statement.toString());
            double transactionAmount = statement.getAmount();
            balance+= transactionAmount;
            console.println(statement.getDate() + " | " + transactionAmount + " | " + balance);
        }
    }
}
