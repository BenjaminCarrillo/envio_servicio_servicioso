package ecomarket.envio_servicio_servicioso.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ecomarket.envio_servicio_servicioso.model.Envio;
import ecomarket.envio_servicio_servicioso.repository.EnvioRepository;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class EnvioService {

    @Autowired
    private EnvioRepository envioRepository;

    public Envio save(Envio envio) {
        return envioRepository.save(envio);
    }

    public List<Envio> findAll() {
        return envioRepository.findAll();
    }

    public Envio findById(Long id) {
        return envioRepository.findById(id).get();
    }

    public void deleteById(Long id) {
        envioRepository.deleteById(id);
    }

    public Envio modificar(Long id, Envio envio) {

        Envio existente = envioRepository.findById(id).orElse(null);

        if (existente != null) {

            existente.setDireccionEnvio(envio.getDireccionEnvio());
            existente.setFechaEntrega(envio.getFechaEntrega());
            existente.setEstadoEnvio(envio.getEstadoEnvio());

            return envioRepository.save(existente);
        }

        return null;
    }
}
