package ch.loyalty.amopp.ip.common.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * Created at 20.11.2017.
 *
 * @author Kate Milashevskaya
 */
@Getter
@Setter
public class IpMailData {

    private String mailTo;
    private String mailFrom;
    private String mailCc;
    private boolean mailEnable;
}
