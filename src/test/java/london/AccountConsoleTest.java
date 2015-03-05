package london;

import com.google.common.collect.ImmutableList;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Collections;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;

@RunWith(MockitoJUnitRunner.class)
public class AccountConsoleTest {
    @Mock private Console console;
    @InjectMocks private AccountConsole accountConsole = new AccountConsole(console);

    @Test
    public void shouldOnlyDisplayHeaderWhenNoTransactionsExist() {
        accountConsole.display(Collections.<Transaction>emptyList());
        verify(console).println("DATE | AMOUNT | BALANCE");
        verifyNoMoreInteractions(console);
    }

    @Test
    public void shouldPrintOutSingleStatementEntry() {
        accountConsole.display(ImmutableList.of(new Transaction("20/01/2014", 100)));
        verify(console).println("DATE | AMOUNT | BALANCE");
        verify(console).println("20/01/2014 | 100.0 | 100.0");
    }
}