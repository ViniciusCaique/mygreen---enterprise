package org.example.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "T_CLIMA_ADEQUADO")
public class ClimaAdequado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_climaAdequado;

    private String turma;
    private LocalDate duracao;
}
