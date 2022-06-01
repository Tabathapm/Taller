package ar.edu.unlam.tallerweb1.servicios;

import ar.edu.unlam.tallerweb1.modelo.Locacion;
import ar.edu.unlam.tallerweb1.modelo.Vuelo;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioVuelo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("servicioLocacion")
@Transactional
public class ServicioVueloImpl implements ServicioVuelo {

    private RepositorioVuelo repoVuelo;

    @Autowired
    public ServicioVueloImpl(RepositorioVuelo repoVuelo){
        this.repoVuelo = repoVuelo;
    }

    @Override
    public List<Locacion> mostrarLocaciones() {
        return repoVuelo.mostrarLocacion();
    }

    @Override
    public void agregarVuelo(Vuelo vuelo) {
        repoVuelo.guardar(vuelo);
    }
}
