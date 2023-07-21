package com.miu.waa.aluminimanagement.helper;

import jakarta.mail.internet.MimeMessage;
import lombok.RequiredArgsConstructor;

import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

@RequiredArgsConstructor
public class EmailService {
    private JavaMailSender javaMailSender;
    public EmailService(JavaMailSender javaMailSender){
        this.javaMailSender = javaMailSender;
    }
    private String sender = "miu.alumni.management@gmail.com";
    public String sendEmail(String recipient, String subject, String message){
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        try {
            MimeMessageHelper mimeMessageHelper
                    = new MimeMessageHelper(mimeMessage,"UTF-8");
            mimeMessageHelper.setFrom(sender);
            mimeMessageHelper.setTo(recipient);
            mimeMessageHelper.setText(message);
            mimeMessageHelper.setSubject(subject);
            javaMailSender.send(mimeMessage);
            return "Mail Sent Successfully";
        }
        catch (Exception e) {
            return e.getMessage();
        }
    }
}
