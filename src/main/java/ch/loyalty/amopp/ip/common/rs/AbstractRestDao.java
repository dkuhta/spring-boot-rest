package ch.loyalty.amopp.ip.common.rs;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.MultiThreadedHttpConnectionManager;
import org.apache.commons.httpclient.protocol.Protocol;
import org.apache.commons.httpclient.protocol.ProtocolSocketFactory;

public abstract class AbstractRestDao {
    private static final int HTTP_PORT = 80;
    private static final int HTTPS_PORT = 443;
    private static final String HTTP_PROTOCOL = "http";
    private static final String HTTPS_PROTOCOL = "https";

    private HttpClient httpClient;

    protected abstract String getHost();

    protected int getPort() {
        if (getProtocol().equals(HTTP_PROTOCOL)) {
            return HTTP_PORT;
        }
        if (getProtocol().equals(HTTPS_PROTOCOL)) {
            return HTTPS_PORT;
        }
        throw new RuntimeException("Please reload this method.");
    }

    protected String getProtocol() {
        return HTTP_PROTOCOL;
    }

    protected boolean allowToUseSelfSignedCertificates() {
        return false;
    }

    protected final HttpClient getClient() {
        if (httpClient == null) {
            if (allowToUseSelfSignedCertificates()) {
                Protocol easyhttps = new Protocol(HTTPS_PROTOCOL, (ProtocolSocketFactory) new EasySSLProtocolSocketFactory(), HTTPS_PORT);
                Protocol.registerProtocol(HTTPS_PROTOCOL, easyhttps);
            }

            httpClient = new HttpClient(new MultiThreadedHttpConnectionManager());
            httpClient.getHostConfiguration().setHost(getHost(), getPort(), getProtocol());
            configureClient(httpClient);
        }

        return httpClient;
    }

    protected void configureClient(final HttpClient client) {
    }
}
