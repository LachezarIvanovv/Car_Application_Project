package softuni.Mobilele.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import java.util.Properties;


@Configuration
public class MailConfig {

    @Bean
    public JavaMailSender javamailSender(
            @Value("${mail.host}") String mailHost,
            @Value("${mail.port}") Integer mailPort,
            @Value("${mail.username}") String mailUsername,
            @Value("${mail.password}") String mailPassword
    ){
        JavaMailSenderImpl javamailSenderImpl = new JavaMailSenderImpl();
        javamailSenderImpl.setHost(mailHost);
        javamailSenderImpl.setPort(mailPort);
        javamailSenderImpl.setUsername(mailUsername);
        javamailSenderImpl.setPassword(mailPassword);
        javamailSenderImpl.setJavaMailProperties(mailProperties());
        javamailSenderImpl.setDefaultEncoding("UTF-8");

        return javamailSenderImpl;
    }

    private Properties mailProperties(){
        Properties properties = new Properties();
        properties.setProperty("mail.smtp.auth", "true");
        properties.setProperty("mail.transport.protocol", "smtp");

        return properties;
    }
}
