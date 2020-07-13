package com.estudando.cursomc.services;

import com.estudando.cursomc.domain.Pedido;
import org.springframework.mail.SimpleMailMessage;

public interface EmailService {

    void sendOrderConfirmationEmail(Pedido obj);
    void sentEmail(SimpleMailMessage msg);
}
