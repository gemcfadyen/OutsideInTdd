package london;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by Georgina on 27/02/2015.
 */
@RunWith(MockitoJUnitRunner.class)
public class AccountAcceptanceTest {
    private Account account;
    private AccountDisplay display;

    @Mock private Console console;
    @Mock private AccountStatement accountStatement;
    @Mock private DateService dateService;

    @Before
    public void setup() {
        display = new AccountConsole(console);
        account = new Account(accountStatement, display, dateService);
    }

    @Test
    public void should_print_statement_containing_all_transactions() {
        List<Transaction> mockedTransactions = new ArrayList<>();
        mockedTransactions.add(new Transaction("10/04/2014", 500.00));
        mockedTransactions.add(new Transaction("02/04/2014", -100.00));
        mockedTransactions.add(new Transaction("01/04/2014", 1000.00));
        when(accountStatement.getTransactions()).thenReturn(mockedTransactions);

        account.deposit(1000);
        account.withdraw(100);
        account.deposit(500);

        account.printStatement();

        verify(console).println("DATE | AMOUNT | BALANCE");
        verify(console).println("10/04/2014 | 500.0 | 1400.0");
        verify(console).println("02/04/2014 | -100.0 | 900.0");
        verify(console).println("01/04/2014 | 1000.0 | 1000.0");
    }
}
