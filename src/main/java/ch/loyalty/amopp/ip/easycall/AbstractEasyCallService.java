package ch.loyalty.amopp.ip.easycall;

import ch.loyalty.amopp.ip.common.dto.IPStatus;
import ch.loyalty.amopp.ip.common.exceptions.IPException;
import ch.loyalty.amopp.ip.common.rs.AbstractRestDao;
import ch.loyalty.amopp.ip.common.rs.Header;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.StringRequestEntity;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.net.SocketTimeoutException;
import java.text.MessageFormat;
import java.util.Objects;

/**
 * Created on 1.11.16.
 *
 * @author Denis Kuhta
 * @since JDK1.8
 */
public abstract class AbstractEasyCallService extends AbstractRestDao {

    private final static Logger LOGGER = LogManager.getLogger(AbstractEasyCallService.class.getName());

    private final static String CONTENT_TYPE = "application/json";
    private final static String CHARSET = "utf-8";

    private final static String MSG_TIMEOUT_ERROR = "IP service timeout exception.";
    private final static String MSG_GENERIC_ERROR = "IP processing error.";

    private final ObjectMapper objectMapper = new ObjectMapper();

    protected abstract String getHost();

    protected abstract String getContext();

    public EasyCallResponseDto execute(final EasyCallRequestDto requestDto, final Integer timeout) throws IPException {
        PostMethod postMethod = null;

        EasyCallResponseDto responseDto;
        try {
            String requestStr = this.objectMapper.writeValueAsString(requestDto);
            postMethod = new PostMethod(getContext());
            postMethod.addRequestHeader(Header.CONTENT_TYPE.getName(), CONTENT_TYPE);
            postMethod.addRequestHeader(Header.ACCEPT.getName(), CONTENT_TYPE);
            postMethod.setRequestEntity(new StringRequestEntity(requestStr, CONTENT_TYPE, CHARSET));

            LOGGER.info(MessageFormat.format("\nEasyCall request TRANS_ID={0}: \n {1}", requestDto.getReferenzid(), requestStr));

            if (Objects.nonNull(timeout)) {
                this.getClient().getParams().setSoTimeout(timeout * 1000);
            }

            this.getClient().executeMethod(postMethod);
            String responseStr = postMethod.getResponseBodyAsString();

            LOGGER.info(MessageFormat.format("\nEasyCall response TRANS_ID={0}: \n {1}", requestDto.getReferenzid(), responseStr));

            responseDto = this.objectMapper.readValue(responseStr, EasyCallResponseDto.class);
        } catch (SocketTimeoutException var10) {
            LOGGER.error(var10);
            throw new IPException(IPStatus.TIMEOUT, MSG_TIMEOUT_ERROR);
        } catch (IOException var9) {
            LOGGER.error(var9);
            throw new IPException(IPStatus.FAILURE, MSG_GENERIC_ERROR);
        } finally {
            if (Objects.nonNull(postMethod)) {
                postMethod.releaseConnection();
            }
        }

        return responseDto;
    }
}
