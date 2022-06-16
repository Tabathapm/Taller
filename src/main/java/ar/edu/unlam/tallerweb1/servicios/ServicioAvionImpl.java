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
    private RepositorioAvion servicioAvion;


    @Override
    public List<Avion> traerAvionesSinHangar() {
        return servicioAvion.verAvionesSinHangar();
    }



}
