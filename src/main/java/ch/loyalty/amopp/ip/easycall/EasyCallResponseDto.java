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
public class EasyCallResponseDto implements Serializable {

    private static final long serialVersionUID = -2904547625842291523L;

    private Integer productid;
    private String description;
    private String card;
    private Integer transactionid;
    private String referenzid;
    private Short status;
    private Double buy;
    private Long value;
    private String pin;
    private String serialnumber;
    private String expiringdate;
    private String eancode;
}
