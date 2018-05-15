package ch.loyalty.amopp.ip.easycall;

import ch.loyalty.amopp.ip.common.IPProvider;
import ch.loyalty.amopp.ip.common.TransType;
import ch.loyalty.amopp.ip.common.dto.IPRequest;
import ch.loyalty.amopp.ip.common.dto.IPResponse;
import ch.loyalty.amopp.ip.common.exceptions.IPException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.EnumSet;
import java.util.Set;

/**
 * Created on 18.10.16.
 *
 * @author Denis Kuhta
 * @since JDK1.8
 */
@Service
public class EasyCallServiceBean extends AbstractEasyCallService implements IPProvider {

    private final static Set<TransType> SUPPORTED_TRANSACTION = EnumSet.of(TransType.ACTIVATION);

    @Value("${easy.call.protocol}")
    private String protocol;

    @Value("${easy.call.host}")
    private String host;

    @Value("${easy.call.context}")
    private String context;

    @Autowired
    private EasyCallAssembler assembler;

    @Override
    protected String getHost() {
        return host;
    }

    @Override
    protected String getContext() {
        return context;
    }

    @Override
    protected String getProtocol() {
        return protocol;
    }

    @Override
    public IPResponse execute(final IPRequest ipRequest, final Integer timeout) {
        try {
            return assembler.assemble(execute(assembler.assemble(ipRequest), timeout), ipRequest);
        } catch (IPException e) {
            //TODO handle error and build response
            return null;
        }
    }

    @Override
    public Set<TransType> getSupportedTransactionTypes() {
        return SUPPORTED_TRANSACTION;
    }

    @Override
    public String buildReceipt(IPRequest ipRequest, IPResponse ipResponse, String textFromLibrary) {
        return textFromLibrary;
    }
}
