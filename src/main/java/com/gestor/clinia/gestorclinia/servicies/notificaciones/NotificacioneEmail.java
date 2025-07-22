package com.gestor.clinia.gestorclinia.servicies.notificaciones;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component("EMAIL")
@RequiredArgsConstructor
public class NotificacioneEmail implements Notificacion {

    private final JavaMailSender mailSender;

    @Value("${spring.mail.username}")
    private String remitente;

    @Async
    public void enviar(String mensaje, String destinatario) {
        SimpleMailMessage correo = new SimpleMailMessage();
        correo.setTo(destinatario);
        correo.setSubject("Confirmación de Consulta Médica");
        correo.setText(mensaje);
        correo.setFrom(remitente);
        mailSender.send(correo);
    }

}
