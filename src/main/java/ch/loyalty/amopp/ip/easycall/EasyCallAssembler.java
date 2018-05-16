package ch.loyalty.amopp.ip.easycall;

import ch.loyalty.amopp.ip.Config;
import ch.loyalty.amopp.ip.common.dto.IPReceipt;
import ch.loyalty.amopp.ip.common.dto.IPRequest;
import ch.loyalty.amopp.ip.common.dto.IPResponse;
import ch.loyalty.amopp.ip.common.dto.IPReward;
import ch.loyalty.amopp.ip.common.dto.IPStatus;
import ch.loyalty.amopp.ip.common.exceptions.IPException;
import ch.loyalty.amopp.ip.common.utils.MoneyUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created on 1.11.16.
 *
 * @author Denis Kuhta
 * @since JDK1.8
 */
@Component
public class EasyCallAssembler {

    @Qualifier("messageSource")
    @Autowired
    private MessageSource ms;

    public EasyCallRequestDto assemble(final IPRequest ipRequest) throws IPException {
        final EasyCallRequestDto requestDto = new EasyCallRequestDto();
        requestDto.setAuthkey(ipRequest.getIpConnection().getPassword());
        requestDto.setProductid(Integer.valueOf(ipRequest.getCard().getEan()));
        requestDto.setTerminalid(ipRequest.getTerminalExtId());
        requestDto.setReferenzid(ipRequest.getTransId().toString());
        return requestDto;
    }

    public IPResponse assemble(final EasyCallResponseDto responseDto, final IPRequest ipRequest) {
        final IPResponse ipResponse = new IPResponse();
        String statusMsg = getMessage("easy.call.status.msg." + responseDto.getStatus());
        if (EasyCallStatus.SUCCESS.code() != responseDto.getStatus()) {
            ipResponse.setIpStatus(IPStatus.FAILURE);
            ipResponse.setExceptionMessage(statusMsg);
        }

        ipResponse.setClientComment(responseDto.getDescription());
        ipResponse.setPosTransId(String.valueOf(responseDto.getTransactionid()));
        ipResponse.setPosStatusCode(responseDto.getStatus());
        ipResponse.setPosStatusMsg(statusMsg);

        IPReward ipReward = new IPReward();
        ipReward.setIsPinCredentials(true);
        ipReward.setPin(responseDto.getPin());
        ipReward.setSerial(responseDto.getSerialnumber());
        ipReward.setAmount(MoneyUtils.convertToCents(responseDto.getValue()));
        ipResponse.setReward(ipReward);

        ipResponse.setMaxBalance(MoneyUtils.convertToCents(responseDto.getValue()));

        IPReceipt ipReceipt = new IPReceipt();
        ipReceipt.setTimestapm(new Date());
        ipReceipt.setCharsperline(ipRequest.getStore().getChunkLength().intValue());
        ipReceipt.setLanguage(StringUtils.defaultString(ipRequest.getStore().getLang(), ipRequest.getLang()));
        ipReceipt.setLine(new ArrayList<>());
        if (responseDto.getCard().length() > ipRequest.getStore().getChunkLength()) {
            ipReceipt.setLine(ch.loyalty.amopp.ip.common.utils.StringUtils.divide(responseDto.getCard(), ipRequest.getStore().getChunkDivider(), ipRequest.getStore().getChunkLength()));
            ipReceipt.setLines(ipReceipt.getLine().size());
        } else {
            ipReceipt.getLine().add(responseDto.getCard());
            ipReceipt.setLines(1);
        }
        ipResponse.setReceipt(ipReceipt);
        ipResponse.setIpConnection(ipRequest.getIpConnection());
        return ipResponse;
    }

    private String getMessage(final String code) {
        return ms.getMessage(code, null, Config.DEFAULT_LOCALE);
    }
}
