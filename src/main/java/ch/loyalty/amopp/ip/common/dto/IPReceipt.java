package ch.loyalty.amopp.ip.common.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

/**
 * Created on 20.10.16.
 *
 * @author Denis Kuhta
 * @since JDK1.8
 */
@Getter
@Setter
public class IPReceipt {

    public String language;
    public Integer charsperline;
    public Integer lines;
    public List<String> line;
    public Date timestapm;
}
