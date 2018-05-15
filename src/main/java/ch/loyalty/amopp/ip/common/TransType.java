package ch.loyalty.amopp.ip.common;

import java.util.HashMap;
import java.util.Map;

/**
 * Transaction Types
 *
 * @author Denis Kuhta
 * @since JDK1.8
 */
public enum TransType {
    /**
     * Undefined transaction type.
     */
    UNDEFINED((short) 0), /**
     * Get trans id transaction type.
     */
    GET_TRANS_ID((short) 1), /**
     * Get domain ip transaction type.
     */
    GET_DOMAIN_IP((short) 2), /**
     * Get balance transaction type.
     */
    GET_BALANCE((short) 3), /**
     * Activation transaction type.
     */
    ACTIVATION((short) 4), /**
     * Reload transaction type.
     */
    RELOAD((short) 5),
    /**
     * Redemption transaction type.
     */
    REDEMPTION((short) 6), /**
     * Refund transaction type.
     */
    REFUND((short) 7), /**
     * Authorize transaction type.
     */
    AUTHORIZE((short) 8), /**
     * Void transaction type.
     */
    VOID((short) 9), /**
     * Transfer transaction type.
     */
    TRANSFER((short) 10),
    /**
     * Block transaction type.
     */
    BLOCK((short) 11), /**
     * Undo block transaction type.
     */
    UNDO_BLOCK((short) 12), /**
     * Expire transaction type.
     */
    EXPIRE((short) 13), /**
     * Undo expire transaction type.
     */
    UNDO_EXPIRE((short) 14), /**
     * Adjustment transaction type.
     */
    ADJUSTMENT((short) 15),
    /**
     * Earning transaction type.
     */
    EARNING((short) 16), /**
     * Fee transaction type.
     */
    FEE((short) 17), /**
     * Deactivate transaction type.
     */
    DEACTIVATE((short) 18), /**
     * Set card pin transaction type.
     */
    SET_CARD_PIN((short) 19), /**
     * Get info transaction type.
     */
    GET_INFO((short) 20),
    /**
     * Get card id transaction type.
     */
    GET_CARD_ID((short) 21), /**
     * Get reward transaction type.
     */
    GET_REWARD((short) 22), /**
     * Ping transaction type.
     */
    PING((short) 23), /**
     * Get ext card id transaction type.
     */
    GET_EXT_CARD_ID((short) 24), /**
     * Get version transaction type.
     */
    GET_VERSION((short) 25),
    /**
     * Deactivate to zero transaction type.
     */
    DEACTIVATE_TO_ZERO((short) 26), /**
     * Void earning transaction type.
     */
    VOID_EARNING((short) 27), /**
     * Void activation transaction type.
     */
    VOID_ACTIVATION((short) 28), /**
     * Void reload transaction type.
     */
    VOID_RELOAD((short) 29), /**
     * Void redemption transaction type.
     */
    VOID_REDEMPTION((short) 30),
    /**
     * Void refund transaction type.
     */
    VOID_REFUND((short) 31), /**
     * Adjustment positive transaction type.
     */
    ADJUSTMENT_POSITIVE((short) 32), /**
     * Adjustment negative transaction type.
     */
    ADJUSTMENT_NEGATIVE((short) 33), /**
     * Transfer positive transaction type.
     */
    TRANSFER_POSITIVE((short) 34), /**
     * Transfer negative transaction type.
     */
    TRANSFER_NEGATIVE((short) 35),
    /**
     * Prepare transaction type.
     */
    PREPARE((short) 36), /**
     * Release transaction type.
     */
    RELEASE((short) 37), /**
     * Void prepare transaction type.
     */
    VOID_PREPARE((short) 38), /**
     * Void release transaction type.
     */
    VOID_RELEASE((short) 39), /**
     * Get receipt transaction type.
     */
    GET_RECEIPT((short) 40),
    /**
     * Prepare load trans type.
     */
    PREPARE_LOAD((short) 41),
    /**
     * Release load trans type.
     */
    RELEASE_LOAD((short) 42),
    /**
     * Void prepare load trans type.
     */
    VOID_PREPARE_LOAD((short) 43),
    /**
     * Void release load trans type.
     */
    VOID_RELEASE_LOAD((short) 44),
    /**
     * Ignore trans id trans type.
     */
    IGNORE_TRANS_ID((short) 45),
    /**
     * Ping sc trans type.
     */
    PING_SC((short) 46),

    PING_BHN((short) 47),

    VOID_RELEASE_FORCE((short)48),

    VOID_RELEASE_LOAD_FORCE((short)49);


    private short code;

    private static final Map<Short, TransType> MAP;

    static {
        MAP = new HashMap<>();
        for (TransType field : TransType.values()) {
            MAP.put(field.code(), field);
        }
    }

    /**
     * Instantiates a new Transaction type.
     *
     * @param code the code
     */
    TransType(short code) {
        this.code = code;
    }

    /**
     * Code short.
     *
     * @return the short
     */
    public short code() {
        return this.code;
    }

    /**
     * Value of trans type.
     *
     * @param code the code
     * @return the trans type
     */
    public static TransType valueOf(final Short code) {
        return MAP.get(code);
    }
}
