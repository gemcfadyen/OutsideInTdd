package london;

import java.util.Objects;

/**
 * Created by Georgina on 03/03/2015.
 */
public class Transaction {
    private String date;
    private int amount;

    public Transaction(String date, int amount) {
        this.date = date;
        this.amount = amount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Transaction that = (Transaction) o;
        return Objects.equals(amount, that.amount) &&
                Objects.equals(date, that.date);

    }

    @Override
    public int hashCode() {
        return Objects.hash(date, amount);
    }
}
