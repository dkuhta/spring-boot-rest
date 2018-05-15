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
public class IPReward {

    public String pin;
    public String serial;
    public Long amount;
    public Boolean isPinCredentials;
}
