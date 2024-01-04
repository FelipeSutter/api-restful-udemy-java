package com.api.gestaodeprojetos.service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

import com.api.gestaodeprojetos.model.Email;

public class EmailService {

    @Autowired
    JavaMailSender javaMailSender;

    public void enviar(Email email) throws MessagingException {

        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, "utf-8");

        helper.setFrom(email.getRemetente());
        helper.setSubject(email.getAssunto());
        helper.setText(email.getMensagem(), true);
        helper.setTo(email.getDestinatarios()
                .toArray(new String[email.getDestinatarios().size()]));

        javaMailSender.send(mimeMessage);

    }

}
