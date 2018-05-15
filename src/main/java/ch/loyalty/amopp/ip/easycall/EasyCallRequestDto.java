package ch.loyalty.amopp.ip.easycall;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * Created on 1.11.16.
 *
 * @author Denis Kuhta
 * @since JDK1.8
 */
@Getter
@Setter
public class EasyCallRequestDto implements Serializable {

    private static final long serialVersionUID = -7875748552532553471L;

    private String authkey;
    private String terminalid;
    private Integer productid;
    private String referenzid;
}
