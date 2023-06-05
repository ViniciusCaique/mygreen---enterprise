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

public class Main {
    public static void main(String[] args) {
        try {
            EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
            EntityManager entityManager = entityManagerFactory.createEntityManager();

            var climaAdequado = new ClimaAdequado();
            var clima = new Clima();
            var plantacao = new Plantacao();
            var planta = new Planta();
            var usuario = new Usuario();

            var climaAdequadoRepository = new ClimaAdequadoRepository(entityManager);
            var climaRepository = new ClimaRepository(entityManager);
            var plantacaoRepository = new PlantacaoRepository(entityManager);
            var plantaRepository = new PlantaRepository(entityManager);
            var usuarioRepository = new UsuarioRepository(entityManager);

            // climaAdequadoRepository.findAll();
            // climaAdequadoRepository.findById(1L);
            // climaAdequadoRepository.createClimaAdequado(climaAdequado);
            // climaAdequadoRepository.updateClimaAdequado(climaAdequado);
            // climaAdequadoRepository.deleteById(1L);

            // climaRepository.findAll();
            // climaRepository.findById(1L);
            // climaRepository.createClima(clima);
            // climaRepository.updateClima(clima);
            // climaRepository.deleteById(1L);

            // plantacaoRepository.findAll();
            // plantacaoRepository.findById(1L);
            // plantacaoRepository.createPlantacao(plantacao);
            // plantacaoRepository.updatePlantacao(plantacao);
            // plantacaoRepository.deleteById(1L);

            // plantaRepository.findAll();
            // plantaRepository.findById(1L);
            // plantaRepository.createPlanta(planta);
            // plantaRepository.updatePlanta(planta);
            // plantaRepository.deleteById(1L);

            // usuarioRepository.findAll();
            // usuarioRepository.findById(1L);
            // usuarioRepository.createUsuario(usuario);
            // usuarioRepository.updateUsuario(usuario);
            // usuarioRepository.deleteById(1L);

            entityManager.close();
            entityManagerFactory.close();
        } catch (Exception e) {
            throw e;
        }
    }
}