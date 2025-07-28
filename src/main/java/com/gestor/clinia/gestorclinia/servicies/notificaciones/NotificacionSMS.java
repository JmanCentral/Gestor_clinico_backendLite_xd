package com.gestor.clinia.gestorclinia.servicies.notificaciones;

import com.twilio.Twilio;
import com.twilio.exception.ApiException;
import com.twilio.rest.api.v2010.account.Message;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component("SMS")
@RequiredArgsConstructor
@Slf4j
public class NotificacionSMS implements Notificacion  {

    @Value("${twilio.account.sid}")
    private String accountSid;

    @Value("${twilio.auth.token}")
    private String authToken;

    @Value("${twilio.phone.number}")
    private String fromNumber;

    @PostConstruct
    public void init() {
        Twilio.init(accountSid, authToken);
        log.info("Twilio inicializado correctamente.");
    }

    @Async
    public void enviar(String mensaje, String destinatario) {
        try {
            Message message = Message.creator(
                    new com.twilio.type.PhoneNumber(destinatario),
                    new com.twilio.type.PhoneNumber(fromNumber),
                    mensaje
            ).create();

            log.info("Mensaje enviado correctamente. SID: {}", message.getSid());

        } catch (ApiException e) {
            log.error("Error al enviar el SMS: Código {} - {}", e.getCode(), e.getMessage());
        } catch (Exception e) {
            log.error("Error inesperado al enviar SMS: ", e);
        }
    }


}

