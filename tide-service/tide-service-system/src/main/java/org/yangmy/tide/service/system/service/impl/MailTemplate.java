package org.yangmy.tide.service.system.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;
import org.yangmy.tide.service.system.service.MailOperations;

/**
 * @author YangMingYang
 * @since 2022-03-31
 */
@Component
public class MailTemplate implements MailOperations {

    @Value("spring.mail.username")
    private String from;
    @Autowired
    private JavaMailSender javaMailSender;

    @Override
    public void sendMessage(String to, String subject, String text) {
        //创建邮件内容
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(from);
        message.setTo(to);
        message.setSubject(subject);
        message.setText(text);
        //发送邮件
        javaMailSender.send(message);
    }

    @Override
    public void sendHtml() {

    }
}
