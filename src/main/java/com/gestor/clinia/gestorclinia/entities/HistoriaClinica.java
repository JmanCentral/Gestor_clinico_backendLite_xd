package com.gestor.clinia.gestorclinia.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "historia_clinica")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class HistoriaClinica {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String alergias;
    @Column(nullable = false)
    private String enfermedadesPrevias;
    @Column(nullable = false)
    private String observacionesGenerales;
    @Column(nullable = false)
    private LocalDate fechaCreacion;
    @Column(nullable = false)
    private String antecedentes;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_paciente", nullable = false)
    private Paciente paciente;

}
