package ch.loyalty.amopp.ip;

import ch.loyalty.amopp.ip.common.IPProvider;
import ch.loyalty.amopp.ip.common.TransType;
import ch.loyalty.amopp.ip.common.dto.IPRequest;
import ch.loyalty.amopp.ip.common.dto.IPResponse;
import ch.loyalty.amopp.ip.common.dto.Version;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Locale;
import java.util.Set;

@RestController
public class MainController {

    @Value("${version}")
    private String version;

    @Autowired
    private IPProvider ipProvider;

    @RequestMapping(value = "/version", method = RequestMethod.GET)
    public Version version() {
        return new Version(version);
    }

    @RequestMapping(value = "/transactiontypes", method = RequestMethod.GET)
    public Set<TransType> getSupportedTransactionTypes() {
        return ipProvider.getSupportedTransactionTypes();
    }

    @RequestMapping(value = "/execute", method = RequestMethod.POST)
    public IPResponse greeting(@RequestBody IPRequest ipRequest) {
        return ipProvider.execute(ipRequest);
    }
}
