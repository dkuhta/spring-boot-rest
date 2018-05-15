package ch.loyalty.amopp.ip.common.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * Created on 20.10.16.
 *
 * @author Denis Kuhta
 * @since JDK1.8
 */
@Getter
@Setter
public class IPStore {

    private String externalId;
    private String name;
    private String name2;
    private String address;
    private String city;
    private String zip;
    private String description;
    private String lang;
    private Integer charsPerLine;
    private Short chunkLength;
    private String chunkDivider;
    private boolean useTextTin = false;
    private long sectionId;
}
