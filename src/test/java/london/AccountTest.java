package london;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Matchers.anyList;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class AccountTest {
    private Account account;
    @Mock
    private AccountStatement accountStatement;
    @Mock
    private AccountDisplay accountDisplay;
    @Mock
    private DateService dateService;

    @Before
    public void setup() throws Exception {
        account = new Account(accountStatement, accountDisplay, dateService);
    }

    @Test
    public void deposit_should_be_transferred_to_statement() {
        when(dateService.now()).thenReturn("10/08/2013");
        account.deposit(5000);
        verify(accountStatement).deposit(new Transaction("10/08/2013", 5000));
    }

    @Test
    public void withdraw_should_be_transferred_to_statement() {
        when(dateService.now()).thenReturn("11/09/2013");
        account.withdraw(1000);
        verify(accountStatement).withdraw(new Transaction("11/09/2013", -1000));
    }

    @Test
    public void print_statement_should_tell_console_to_print() {
        account.printStatement();
        verify(accountDisplay).display(anyList());
    }
}