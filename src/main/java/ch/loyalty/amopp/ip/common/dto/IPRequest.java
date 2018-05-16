package ch.loyalty.amopp.ip.common.dto;

import ch.loyalty.amopp.ip.common.TransType;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * Created on 20.10.16.
 *
 * @author Denis Kuhta
 * @since JDK1.8
 */
@Getter
@Setter
public class IPRequest {

    private Long id;
    private Long transId;
    private String lang;
    private Long amount;
    private IPStore store;
    private String terminalExtId;
    private Integer currencyNum;
    private String currencyCode;
    private TransType type;
    private IPCard card;
    private IPConnection ipConnection;
    private IPSPartner partner;
    private Date timestamp;

    private Long origId;
    private Long origTransId;
    private String origPosTransId;
    private TransType origTransType;
    private Date origTransTimestamp;

    private IpMailData partnerMail;
    private Long correctedAmount;
    private String originalTransBusinessType;

    private Integer timeout;
}
