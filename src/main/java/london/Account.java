package london;

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

    public void deposit(double amount) {
        statement.deposit(new Transaction(dateService.now(), amount));
    }

    public void withdraw(double amount) {
        statement.withdraw(new Transaction(dateService.now(), negate(amount)));
    }

    public void printStatement() {
       display.display(statement.getTransactions());
    }

    private double negate(double amount) {
        return -amount;
    }
}
