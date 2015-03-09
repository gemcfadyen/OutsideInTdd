package london;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class ConsoleTest {
    private PrintStream printStream;
    private ByteArrayOutputStream outputStream;

    @Before
    public void setup() {
        outputStream = new ByteArrayOutputStream();
        printStream = new PrintStream(outputStream);
        System.setOut(printStream);
    }

    @After
    public void teardown() {
        System.setOut(null);
    }

    @Test
    public void shouldPrintToTheScreen() {
        Console console = new Console();

        console.println("Hello World");

        assertThat(outputStream.toString(), is("Hello World\r\n"));
    }

}