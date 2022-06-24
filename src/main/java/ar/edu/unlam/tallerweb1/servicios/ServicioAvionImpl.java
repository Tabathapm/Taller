package ar.edu.unlam.tallerweb1.servicios;

import ar.edu.unlam.tallerweb1.modelo.Avion;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioAvion;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioHangar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("ServicioAvion")
public class ServicioAvionImpl implements ServicioAvion {

    @Autowired
    private RepositorioAvion repositorioAvion;



    @Override
    public Avion traerAvionSinHangar(Long id) {
        return repositorioAvion.verAvionSinHangar(id);
    }

    @Override
    public List<Avion> traerAvionesSinHangar() {
        return repositorioAvion.verAvionesSinHangar();
    }

    @Override
    public List<Avion> traerAvionesDeCarga() {
        return repositorioAvion.avionesTipoCarga();
    }

    @Override
    public List<Avion> traerAvionesComerciales() {
        return repositorioAvion.avionesTipoComercial();
    }


}
