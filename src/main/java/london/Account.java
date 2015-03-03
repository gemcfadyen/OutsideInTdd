package london;

/**
 * Created by Georgina on 27/02/2015.
 */
public class Account {
    private final AccountStatement statement;
    private final AccountConsole console;

    public Account(AccountStatement statement, AccountConsole accountConsole) {
        this.statement = statement;
        this.console = accountConsole;
    }

    public void deposit(int amount) {
        statement.deposit(amount);
    }

    public void withdraw(int amount) {
        statement.withdraw(amount);
    }

    public void printStatement() {
        statement.getTransactions();
        console.printLine("DATE | AMOUNT | BALANCE");
    }
}
