package london;

import java.util.List;

/**
 * Created by Georgina on 03/03/2015.
 */
public class AccountConsole implements AccountDisplay {
    private Console console;

    public AccountConsole(Console console) {
        this.console = console;
    }

    @Override
    public void display(List<String> statements) {
        console.println("DATE | AMOUNT | BALANCE");
        for (String statement : statements) {
            System.out.println("statement: " + statement);
            console.println(statement);
        }
    }
}
