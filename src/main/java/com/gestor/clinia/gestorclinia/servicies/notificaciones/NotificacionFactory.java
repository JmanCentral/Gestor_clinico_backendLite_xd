package com.gestor.clinia.gestorclinia.servicies.notificaciones;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import java.util.Map;

@Component
@RequiredArgsConstructor
public class NotificacionFactory {

    private final Map<String, Notificacion> estrategias;

    public Notificacion obtenerEstrategia(String tipo) {
        Notificacion estrategia = estrategias.get(tipo.toUpperCase());
        if (estrategia == null) {
            throw new IllegalArgumentException("Tipo de notificación no soportado: " + tipo);
        }
        return estrategia;
    }
}

