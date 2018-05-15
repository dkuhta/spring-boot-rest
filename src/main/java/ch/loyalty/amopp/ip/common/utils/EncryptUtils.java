package ch.loyalty.amopp.ip.common.utils;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Objects;

/**
 * Created on 6.9.16.
 *
 * @author Denis Kuhta
 * @since JDK1.8
 */
public class EncryptUtils {

    /**
     * The constant DEFAULT_ENCODING.
     */
    public static final String DEFAULT_ENCODING = "UTF-8";
    /**
     * The Enc.
     */
    static BASE64Encoder enc = new BASE64Encoder();
    /**
     * The Dec.
     */
    static BASE64Decoder dec = new BASE64Decoder();

    /**
     * Base 64 encode string.
     *
     * @param text the text
     * @return the string
     */
    public static String base64encode(String text) {
        if (org.apache.commons.lang3.StringUtils.isEmpty(text)) {
            return null;
        }

        try {
            return enc.encode(text.getBytes(DEFAULT_ENCODING));
        } catch (UnsupportedEncodingException e) {
            return null;
        }
    }

    /**
     * Base 64 decode string.
     *
     * @param text the text
     * @return the string
     */
    public static String base64decode(String text) {
        if (org.apache.commons.lang3.StringUtils.isEmpty(text)) {
            return null;
        }

        try {
            return new String(dec.decodeBuffer(text), DEFAULT_ENCODING);
        } catch (IOException e) {
            return null;
        }
    }

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        String txt = "some text to be encrypted";
        String key = "key phrase used for XOR-ing";
        System.out.println(txt + " XOR-ed to: " + (txt = xorMessage(txt, key)));

        String encoded = base64encode(txt);
        System.out.println(" is encoded to: " + encoded + " and that is decoding to: " + (txt = base64decode(encoded)));
        System.out.print("XOR-ing back to original: " + xorMessage(txt, key));
    }

    /**
     * Xor message string.
     *
     * @param message the message
     * @param key     the key
     * @return the string
     */
    public static String xorMessage(String message, String key) {
        try {
            if (Objects.isNull(message) || Objects.isNull(key)) return null;

            char[] keys = key.toCharArray();
            char[] mesg = message.toCharArray();

            int ml = mesg.length;
            int kl = keys.length;
            char[] newmsg = new char[ml];

            for (int i = 0; i < ml; i++) {
                newmsg[i] = (char) (mesg[i] ^ keys[i % kl]);
            }

            return new String(newmsg);
        } catch (Exception e) {
            return null;
        }
    }
}
