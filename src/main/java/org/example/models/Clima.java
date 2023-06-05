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
@Table(name = "T_G_CLIMA")
public class Clima {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_clima;

    private String clima;
    private String descricao;
    private int temperatura;

    @OneToMany(mappedBy = "clima")
    private List<ClimaAdequado> climasAdequados;

}
