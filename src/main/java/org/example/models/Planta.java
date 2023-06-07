package org.example.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "T_G_PLANTA")
public class Planta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_planta;

    private String planta;
    private String descricao;
    private String tipo;

    @OneToMany(mappedBy = "planta")
    private List<Plantacao> plantacoes;

    @OneToMany(mappedBy = "planta")
    private List<ClimaAdequado> climasAdequados;

}
