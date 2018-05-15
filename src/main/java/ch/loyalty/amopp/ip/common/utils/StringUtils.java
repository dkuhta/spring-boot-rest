package ch.loyalty.amopp.ip.common.utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created on 4.11.16.
 *
 * @author Denis Kuhta
 * @since JDK1.8
 */
public final class StringUtils {

    private StringUtils() {
    }

    /**
     * Divide string.
     *
     * @param str        the string
     * @param separator  the separator
     * @param lineLength the line length
     * @return the list
     */
    public static List<String> divide(final String str, final String separator, final int lineLength) {
        if (org.apache.commons.lang3.StringUtils.isEmpty(str)) {
            return Collections.EMPTY_LIST;
        }

        String[] temporalArray = str.split(separator);
        List<String> result = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for (String word : temporalArray) {
            if (sb.length() + word.length() > lineLength) {
                result.add(String.valueOf(sb));
                sb = new StringBuilder(word).append(org.apache.commons.lang3.StringUtils.SPACE);
            } else {
                sb.append(word);
                if (sb.length() + 1 <= lineLength) {
                    sb.append(org.apache.commons.lang3.StringUtils.SPACE);
                }
            }
        }

        return result;
    }
}
