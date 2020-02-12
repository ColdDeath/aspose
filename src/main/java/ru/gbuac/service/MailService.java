package ru.gbuac.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Arrays;
import java.util.List;

@Service
public class MailService {
    protected final Logger LOG = LoggerFactory.getLogger(getClass());

    @Autowired
    public JavaMailSender emailSender;

    private static List<String> SPRING_PROFILES_ACTIVE;

    @Autowired
    public MailService(@Value("${spring.profiles.active}") String[] actProfiles) {
        SPRING_PROFILES_ACTIVE = Arrays.asList(actProfiles);
    }

    @Value("${email.uri}")
    private String uri;

    @Value("${email.sender.name}")
    private String senderName;

    @Value("${email.sender.addr}")
    private String senderAddr;

    @Value("${email.login}")
    private String login;

    public void sendAgreementEmail(String email, int docId, String projectRegNum) {
        try {
            MimeMessage message = emailSender.createMimeMessage();
            message.setFrom(new InternetAddress(senderName + "<" + senderAddr + ">"));

            boolean multipart = true;

            MimeMessageHelper helper = new MimeMessageHelper(message, multipart, "utf-8");

            String htmlMsg = "На согласование/подпись в ИАС 'Тариф' поступил документ №" +
                    "<a href='" + uri + "/agree-document?id=" + docId +
                    "'>" + projectRegNum + "</a>";

            message.setContent(htmlMsg, "text/html; charset=UTF-8");

            if (SPRING_PROFILES_ACTIVE.contains("dev")) {
                helper.setTo("MakhrovSS1@develop.mos.ru");
            } else {
                helper.setTo(email);
            }

            helper.setSubject("Уведомление");

            this.emailSender.send(message);
        }
        catch (Exception e) {
            LOG.error(e.getMessage());
        }
    }

    public void sendDistributionEmail(String email, int docId, String regNum) {
        try {
            MimeMessage message = emailSender.createMimeMessage();
            message.setFrom(new InternetAddress(senderName + "<" + senderAddr + ">"));

            boolean multipart = true;

            MimeMessageHelper helper = new MimeMessageHelper(message, multipart, "utf-8");

            String htmlMsg = "На распределение в ИАС 'Тариф' поступил документ №" +
                    "<a href='" + uri + "/agree-document?id=" + docId +
                    "'>" + regNum + "</a>";

            message.setContent(htmlMsg, "text/html; charset=UTF-8");

            if (SPRING_PROFILES_ACTIVE.contains("dev")) {
                helper.setTo("MakhrovSS1@develop.mos.ru");
            } else {
                helper.setTo(email);
            }

            helper.setSubject("Уведомление");

            this.emailSender.send(message);
        }
        catch (Exception e) {
            LOG.error(e.getMessage());
        }
    }

    public void sendExecutionEmail(String email, int docId, String regNum) {
        try {
            MimeMessage message = emailSender.createMimeMessage();
            message.setFrom(new InternetAddress(senderName + "<" + senderAddr + ">"));

            boolean multipart = true;

            MimeMessageHelper helper = new MimeMessageHelper(message, multipart, "utf-8");

            String htmlMsg = "На исполнение в ИАС 'Тариф' поступил документ №" +
                    "<a href='" + uri + "/agree-document?id=" + docId +
                    "'>" + regNum + "</a>";

            message.setContent(htmlMsg, "text/html; charset=UTF-8");

            if (SPRING_PROFILES_ACTIVE.contains("dev")) {
                helper.setTo("MakhrovSS1@develop.mos.ru");
            } else {
                helper.setTo(email);
            }

            helper.setSubject("Уведомление");

            this.emailSender.send(message);
        }
        catch (Exception e) {
            LOG.error(e.getMessage());
        }
    }

    public void sendRegisteredEmail(String email, int docId, String projRegNum, String regNum) {
        try {
            MimeMessage message = emailSender.createMimeMessage();
            message.setFrom(new InternetAddress(senderName + "<" + senderAddr + ">"));

            boolean multipart = true;

            MimeMessageHelper helper = new MimeMessageHelper(message, multipart, "utf-8");

            String htmlMsg = "Инициированный Вами в ИАС 'Тариф' документ №" +
                    "<a href='" + uri + "/agree-document?id=" + docId +
                    "'>" + projRegNum + "</a> подписан и зарегистрирован под номером №" +
                    "<a href='" + uri + "/agree-document?id=" + docId +
                    "'>" + regNum + "</a>";

            message.setContent(htmlMsg, "text/html; charset=UTF-8");

            if (SPRING_PROFILES_ACTIVE.contains("dev")) {
                helper.setTo("MakhrovSS1@develop.mos.ru");
            } else {
                helper.setTo(email);
            }

            helper.setSubject("Уведомление");

            this.emailSender.send(message);
        }
        catch (Exception e) {
            LOG.error(e.getMessage());
        }
    }
}
