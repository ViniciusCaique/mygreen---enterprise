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
@Table(name = "T_PLANTACAO")
public class Plantacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_plantacao;

    private LocalDate dataPlantacao;
    private int quantidadeAgua;
    private Boolean fertilizante; 
}
