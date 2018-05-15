package ch.loyalty.amopp.ip.common.dto;

import java.io.Serializable;

/**
 * Created on 5/14/18.
 *
 * @author Denis Kuhta
 * @since JDK1.8
 */
public class Version implements Serializable {

    private static final long serialVersionUID = 817666042685205434L;

    private String version;

    public Version(final String version) {
        this.version = version;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(final String version) {
        this.version = version;
    }
}
