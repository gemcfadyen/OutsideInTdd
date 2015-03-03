package london;

import java.util.List;

/**
 * Created by Georgina on 27/02/2015.
 */
public class Account {
    private final AccountStatement statement;
    private final AccountDisplay display;
    private final DateService dateService;

    public Account(AccountStatement statement, AccountDisplay accountDisplay, DateService dateService) {
        this.statement = statement;
        this.display = accountDisplay;
        this.dateService = dateService;
    }

    public void deposit(int amount) {
        statement.deposit(new Transaction(dateService.now(), amount));
    }

    public void withdraw(int amount) {
        statement.withdraw(new Transaction(dateService.now(), amount));
    }

    public void printStatement() {
       display.display(statement.getTransactions());
    }
}
