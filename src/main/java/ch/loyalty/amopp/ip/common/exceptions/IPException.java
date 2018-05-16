package ch.loyalty.amopp.ip.common.exceptions;


import ch.loyalty.amopp.ip.common.dto.IPStatus;
import lombok.Getter;

/**
 * IPException
 *
 * @author Denis Kuhta
 * @since JDK1.8
 */
@SuppressWarnings("serial")
public class IPException extends Exception {

    private static final long serialVersionUID = -1688997505715567981L;

    @Getter
    private IPStatus ipStatus;

    public IPException(final IPStatus ipStatus, final String message) {
        super(message);
        this.ipStatus = ipStatus;
    }
}
