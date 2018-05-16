package ch.loyalty.amopp.ip.common.rs;

/**
 * Created on 5/16/18.
 *
 * @author Denis Kuhta
 * @since JDK1.8
 */
public enum Header {

    CONTENT_TYPE("Content-Type"),
    ACCEPT("Accept");

    private String name;

    Header(final String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
