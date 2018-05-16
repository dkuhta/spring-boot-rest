package ch.loyalty.amopp.ip.common;

import ch.loyalty.amopp.ip.common.TransType;
import ch.loyalty.amopp.ip.common.dto.IPRequest;
import ch.loyalty.amopp.ip.common.dto.IPResponse;

import java.util.Set;

/**
 * @author Denis Kuhta
 * @since JDK1.8
 */
public interface IPProvider {

    IPResponse execute(IPRequest transaction);

    Set<TransType> getSupportedTransactionTypes();

    String buildReceipt(IPRequest ipRequest, IPResponse ipResponse, String textFromLibrary);
}
