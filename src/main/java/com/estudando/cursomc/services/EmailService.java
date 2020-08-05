package com.estudando.cursomc.services;

import com.estudando.cursomc.domain.Pedido;
import org.springframework.mail.SimpleMailMessage;

import javax.mail.internet.MimeMessage;

public interface EmailService {

    void sendOrderConfirmationEmail(Pedido obj);
    void sentEmail(SimpleMailMessage msg);
    //void sendOrderConfirmationHtmlEmail(Pedido obj);
    //void sendHtmlEmail(MimeMessage msg);
}
