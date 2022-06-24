package ar.edu.unlam.tallerweb1.servicios;

import ar.edu.unlam.tallerweb1.modelo.TipoAvion;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioTipoAvion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServicioTipoAvionImpl implements ServicioTipoAvion{

    RepositorioTipoAvion repoTipoAvion;

    @Autowired
    public ServicioTipoAvionImpl(RepositorioTipoAvion repoTipoAvion){
        this.repoTipoAvion = repoTipoAvion;
    }

    @Override
    public TipoAvion tipoDeAvion(String categoriaAvion) {
        return repoTipoAvion.traerTipoDeAvion(categoriaAvion);
    }
}
