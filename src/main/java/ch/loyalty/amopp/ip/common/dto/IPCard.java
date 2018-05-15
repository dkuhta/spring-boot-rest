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
public class IPCard {

    private String ean;
    private String externalCardNumber;
}
