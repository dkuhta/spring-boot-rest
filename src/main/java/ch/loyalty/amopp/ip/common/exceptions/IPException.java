package ch.loyalty.amopp.ip.common.exceptions;


/**
 * IPException
 *
 * @author Denis Kuhta
 * @since JDK1.8
 */
@SuppressWarnings("serial")
public class IPException extends Exception {

    private static final long serialVersionUID = -1688997505715567981L;

    private IPError ipError;

    public IPException(final IPError ipError, final String message) {
        super(message);
        this.ipError = ipError;
    }
}
