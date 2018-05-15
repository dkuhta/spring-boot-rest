package ch.loyalty.amopp.ip;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;

import java.util.Locale;

/**
 * Created on 5/15/18.
 *
 * @author Denis Kuhta
 * @since JDK1.8
 */
@Configuration
public class Config {

    public final static Locale DEFAULT_LOCALE = new Locale("en");

    @Bean(name = "messageSource")
    public MessageSource setUpmessageSource() {
        ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
        messageSource.setBasename("/WEB-INF/messages");
        messageSource.setDefaultEncoding("UTF-8");
        messageSource.setUseCodeAsDefaultMessage(true);
        return messageSource;
    }

}
