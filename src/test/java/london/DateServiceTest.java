package london;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

@RunWith(MockitoJUnitRunner.class)
public class DateServiceTest {
    private DateService dateService = new CurrentDate();

    @Test
    public void should_provide_a_date() {
        String actualDate = dateService.now();

        assertThat(actualDate, is(equalTo(expectedDate())));
    }

    private String expectedDate() {
        Date now = new Date();
        DateFormat simpleFormat = new SimpleDateFormat("dd/mm/yyyy");
        return simpleFormat.format(now);
    }

}