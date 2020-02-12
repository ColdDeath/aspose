package ru.gbuac;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import java.util.Properties;

@Configuration
public class MailConfig {

    @Value("${email.login}")
    private String EMAIL_LOGIN;

    @Value("${email.password}")
    private String EMAIL_PASSWORD;

    @Value("${email.server.smtp}")
    private String EMAIL_SERVER_SMTP;

    @Value("${email.server.port}")
    private String EMAIL_SERVER_PORT;

    @Bean
    public JavaMailSender getJavaMailSender() {
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        mailSender.setHost(EMAIL_SERVER_SMTP);
        mailSender.setPort(Integer.parseInt(EMAIL_SERVER_PORT));

        mailSender.setUsername(EMAIL_LOGIN);
        mailSender.setPassword(EMAIL_PASSWORD);

        Properties props = mailSender.getJavaMailProperties();
        props.put("mail.transport.protocol", "smtp");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.debug", "true");
        props.put("mail.smtp.ssl.trust", EMAIL_SERVER_SMTP);

        return mailSender;
    }
}
