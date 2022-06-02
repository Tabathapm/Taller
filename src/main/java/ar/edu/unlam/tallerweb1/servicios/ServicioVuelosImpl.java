package ar.edu.unlam.tallerweb1.servicios;

import ar.edu.unlam.tallerweb1.modelo.Vuelo;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioVuelo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServicioVuelosImpl implements ServicioVuelos{

    @Autowired
    RepositorioVuelo repositorioVuelo;

    @Override
    public List<Vuelo> listarTodos() {
        return repositorioVuelo.traerTodos();
    }

    @Override
    public Vuelo traerVuelo(long id) {
        return repositorioVuelo.traerPorId(id);
    }
}
