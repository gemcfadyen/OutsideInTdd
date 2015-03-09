package london;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Created by Georgina on 09/03/2015.
 */
public class CurrentDate implements DateService {
    private static final String DATE_FORMAT = "dd/mm/yyyy";
    private Calendar calendar = Calendar.getInstance();

    public CurrentDate() {
    }

    @Override
    public String now() {
        DateFormat dateFormat = new SimpleDateFormat(DATE_FORMAT);
        return dateFormat.format(calendar.getTime());
    }
}
