package ar.edu.unlam.tallerweb1.servicios;

import ar.edu.unlam.tallerweb1.modelo.Locacion;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioLocacion;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioVuelo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("servicioLocacion")
@Transactional
public class ServicioLocacionImpl implements ServicioLocacion{

    private RepositorioLocacion repoLocacion;

    @Autowired
    public ServicioLocacionImpl(RepositorioLocacion repoLocacion){
        this.repoLocacion = repoLocacion;
    }
    @Override
    public List<Locacion> mostrarLocaciones() {
        return repoLocacion.mostrarLocacion();
    }

    @Override
    public Locacion buscarPorId(Long id) {
        return repoLocacion.buscarLocacionPorId(id);
    }


}
