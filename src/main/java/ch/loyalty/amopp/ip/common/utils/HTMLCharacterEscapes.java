package ch.loyalty.amopp.ip.common.utils;

import com.fasterxml.jackson.core.SerializableString;
import com.fasterxml.jackson.core.io.CharacterEscapes;

/**
 * Created at 06.12.2017.
 *
 * @author Kate Milashevskaya
 */
public class HTMLCharacterEscapes extends CharacterEscapes {
    private static final long serialVersionUID = -3609965527085347666L;
    private final int[] asciiEscapes;

    public HTMLCharacterEscapes() {
        int[] esc = CharacterEscapes.standardAsciiEscapesForJSON();
        esc['\n'] = CharacterEscapes.ESCAPE_NONE;
        asciiEscapes = esc;
    }

    @Override
    public int[] getEscapeCodesForAscii() {
        return asciiEscapes;
    }

    @Override
    public SerializableString getEscapeSequence(int ch) {
        return null;
    }
}
