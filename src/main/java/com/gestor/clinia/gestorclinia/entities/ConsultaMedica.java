package com.gestor.clinia.gestorclinia.entities;

import com.gestor.clinia.gestorclinia.entities.enums.TipoNotificacion;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalTime;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "consultamedica")
public class ConsultaMedica {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private LocalDate fechaConsulta;
    @Column(nullable = false)
    private LocalTime horaConsulta;
    @Column(nullable = false)
    private String motivo;
    @Column(nullable = false)
    private String diagnostico;
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private TipoNotificacion tipoNotificacion;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_paciente", nullable = false)
    private Paciente paciente;

}
