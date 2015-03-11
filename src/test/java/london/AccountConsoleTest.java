package london;

import com.google.common.collect.ImmutableList;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;

@RunWith(MockitoJUnitRunner.class)
public class AccountConsoleTest {
    @Mock
    private Console console;
    @InjectMocks
    private AccountConsole accountConsole = new AccountConsole(console);

    @Test
    public void should_only_display_header_when_no_transactions_exist() {
        accountConsole.display(Collections.<Transaction>emptyList());
        verify(console).println("DATE | AMOUNT | BALANCE");
        verifyNoMoreInteractions(console);
    }

    @Test
    public void should_printout_single_statement_entry() {
        accountConsole.display(ImmutableList.of(new Transaction("20/01/2014", 100)));
        verify(console).println("DATE | AMOUNT | BALANCE");
        verify(console).println("20/01/2014 | 100.0 | 100.0");
    }

    @Test
    public void should_order_statement_entries() {
        List<Transaction> statements = new ArrayList<>();
        statements.add(new Transaction("19/01/2014", -100));
        statements.add(new Transaction("20/01/2014", 100));

        accountConsole.display(statements);

        verify(console).println("DATE | AMOUNT | BALANCE");
        verify(console).println("20/01/2014 | 100.0 | 0.0");
        verify(console).println("19/01/2014 | -100.0 | -100.0");
    }
}