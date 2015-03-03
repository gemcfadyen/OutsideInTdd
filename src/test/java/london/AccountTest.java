package london;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class AccountTest {
    private Account account;
    @Mock
    private AccountStatement accountStatement;
    @Mock
    private AccountConsole accountConsole;
    @Mock
    private PrintManager printManager;

    @Before
    public void setUp() throws Exception {
        account = new Account(accountStatement, accountConsole);
    }

    @Test
    public void deposit_should_be_transferred_to_statement() {
        account.deposit(5000);
        verify(accountStatement).deposit(5000);
    }

    @Test
    public void withdraw_should_be_transferred_to_statement() {
        account.withdraw(1000);
        verify(accountStatement).withdraw(1000);
    }

    @Test
    public void print_statement_should_ask_the_statement() {
        account.printStatement();
        verify(accountStatement).getTransactions();
    }

    @Test
    public void print_statement_should_tell_console_to_print() {
        account.printStatement();
        verify(accountConsole).printLine(anyString());
    }
}