package org.example;

import org.example.models.Clima;
import org.example.models.ClimaAdequado;
import org.example.models.Planta;
import org.example.models.Plantacao;
import org.example.models.Usuario;
import org.example.repositories.ClimaAdequadoRepository;
import org.example.repositories.ClimaRepository;
import org.example.repositories.PlantaRepository;
import org.example.repositories.PlantacaoRepository;
import org.example.repositories.UsuarioRepository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        try {
            EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
            EntityManager entityManager = entityManagerFactory.createEntityManager();

            var testClimaAdequado = new ClimaAdequadoRepository(entityManager);
            var testClima = new ClimaRepository(entityManager);
            var testPlantacao = new PlantacaoRepository(entityManager);
            var testPlanta = new PlantaRepository(entityManager);
            var testUsuario = new UsuarioRepository(entityManager);

            testUsuario.findAll();
            testPlanta.findAll();
            testPlantacao.findAll();
            testClima.findAll();
            testClimaAdequado.findAll();

            testUsuario.findById(1);
            testPlanta.findById(1);
            testPlantacao.findById(1);
            testClima.findById(1);
            testClimaAdequado.findById(1);

//            Plantacao pl = new Plantacao();
//            pl.setId_plantacao(4);
//            pl.setDataPlantacao(LocalDate.now());
//            pl.setQuantidadeAgua(120);
//            pl.setFertilizante(true);
//            testPlantacao.createPlantacao(pl);
//
//            Usuario usuario = new Usuario();
//            usuario.setId_usuario(4);
//            usuario.setNome("sukuna");
//            usuario.setSenha("123");
//            testUsuario.createUsuario(usuario);
//            testPlanta.createPlanta(new Planta(4, "Babosa", " é um planta medicinal que possui diversos benefícios para a saúde, como favorecer a cicatrização de feridas e queimaduras, aliviar a prisão de ventre e prevenir a cáries dentárias.", "medicinal", null, null));
//            testClima.createClima(new Clima(4, "nublado", "aberto", 15, null));
//            testClimaAdequado.createClimaAdequado(new ClimaAdequado(4, "noturno", LocalDate.now(), null, null));

            var atualizarUsuario = new Usuario();
            atualizarUsuario.setId_usuario(1);
            atualizarUsuario.setNome("sukuna");
            atualizarUsuario.setEmail("sukuna@gmail.com");
            atualizarUsuario.setSenha("123");
            testUsuario.updateUsuario(atualizarUsuario);




//            testPlanta.deletePlantaById(1);
//            testUsuario.deleteUsuarioById(1);
            testPlantacao.deletePlantacaoById(1);
            testClimaAdequado.deleteClimaAdequadoById(2);

            entityManager.close();
            entityManagerFactory.close();
        } catch (Exception e) {
            throw e;
        }
    }
}