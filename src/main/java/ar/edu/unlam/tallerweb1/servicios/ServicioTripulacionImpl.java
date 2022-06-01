package ar.edu.unlam.tallerweb1.servicios;

import ar.edu.unlam.tallerweb1.modelo.Tripulante;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioTripulacion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("servicioTripulacion")
@Transactional
public class ServicioTripulacionImpl implements ServicioTripulacion{

    private RepositorioTripulacion repoTripulacion;

    @Autowired
    public ServicioTripulacionImpl(RepositorioTripulacion repoTripulacion){
        this.repoTripulacion = repoTripulacion;
    }

    @Override
    public List<Tripulante> mostrarTripulantesTipo(String titulo) {
        return repoTripulacion.mostrarTripulacion(titulo);
    }
}
