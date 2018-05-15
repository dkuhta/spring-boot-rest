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
public class IPResponse {

    private String posTransId;
    private IPStatus ipStatus = IPStatus.SUCCESS;
    private String posErrorCode;
    private String posErrorMsg;
    private Short posStatusCode;
    private String posStatusMsg;
    private String orderStatus;
    private Integer orderErrorCode;
    private String orderErrorMsg;
    private String clientComment;
    private IPReceipt receipt;
    private IPReward reward;
    private String exceptionMessage;
    private IPConnection ipConnection;
    private Long maxBalance;
}
