package ch.loyalty.amopp.ip.common.utils;

import java.math.BigDecimal;
import java.util.Objects;

/**
 * Help convert amount
 * <p>
 *
 * @author Denis Kuhta
 * @since JDK1.8
 */
public final class MoneyUtils {

    private MoneyUtils() {
        /*Prevent creating instance of class!*/
    }

    /**
     * Convert amount from double to long
     *
     * @param amount the amount(double)
     * @return the amount(long)
     */
    public static Long convertToCents(final Double amount) {
        if (Objects.isNull(amount)) {
            return 0L;
        }

        return Math.round(amount * 100);
    }

    /**
     * Convert to cents long.
     *
     * @param amount the amount
     * @return the long
     */
    public static Long convertToCents(final String amount) {
        if (Objects.isNull(amount)) {
            return 0L;
        }

        if (amount.contains(".")) {
            return Math.round(Double.valueOf(amount) * 100);
        } else {
            return Long.valueOf(amount);
        }
    }

    /**
     * Convert to cents long.
     *
     * @param amount the amount
     * @return the long
     */
    public static Long convertToCents(final Long amount) {
        if (Objects.isNull(amount)) {
            return 0L;
        }

        return amount * 100;
    }

    /**
     * Convert to cents long.
     *
     * @param amount the amount
     * @return the long
     */
    public static Long convertToCents(final BigDecimal amount) {
        if (Objects.isNull(amount)) {
            return 0L;
        }

        return (amount.multiply(new BigDecimal(100))).longValue();
    }

    /**
     * Convert from cents double.
     *
     * @param amount the amount
     * @return the double
     */
    public static Double convertFromCents(final Long amount) {
        if (Objects.isNull(amount)) {
            return 0.0;
        }

        return (double) amount / 100;
    }
}
