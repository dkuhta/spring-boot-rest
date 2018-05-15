package ch.loyalty.amopp.ip.easycall;

/**
 * Created on 1.11.16.
 *
 * @author Denis Kuhta
 * @since JDK1.8
 */
public enum EasyCallStatus {

    /**
     * Success easy call status.
     */
    SUCCESS((short) 0),
    /**
     * No more pins available easy call status.
     */
    NO_MORE_PINS_AVAILABLE((short) 1),
    /**
     * No more credit easy call status.
     */
    NO_MORE_CREDIT((short) 2),
    /**
     * Max sell limit reached easy call status.
     */
    MAX_SELL_LIMIT_REACHED((short) 3);

    private short code;

    EasyCallStatus(final short code) {
        this.code = code;
    }

    /**
     * Code.
     *
     * @return the code
     */
    public short code() {
        return this.code;
    }
}
