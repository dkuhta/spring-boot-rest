package ch.loyalty.amopp.ip.common.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Objects;

/**
 * Created on 28.10.16.
 *
 * @author Denis Kuhta
 * @since JDK1.8
 */
public final class JsonUtil {

    private static ObjectMapper objectMapper;

    private JsonUtil() {}

    /**
     * Gets json string.
     *
     * @param o the o
     * @return the json string
     * @throws JsonProcessingException the json processing exception
     */
    public static String getJsonString(final Object o) throws JsonProcessingException {
        return getMapper().writerWithDefaultPrettyPrinter().writeValueAsString(o);//.replaceAll("\\\\n", "\n\t\t");
    }

    private static ObjectMapper getMapper() {
        if (Objects.isNull(objectMapper)) {
            objectMapper = new ObjectMapper();
            objectMapper.getFactory().setCharacterEscapes(new HTMLCharacterEscapes());
        }
        return objectMapper;
    }
}
