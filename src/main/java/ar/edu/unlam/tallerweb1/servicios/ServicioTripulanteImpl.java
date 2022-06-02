package ar.edu.unlam.tallerweb1.servicios;

import ar.edu.unlam.tallerweb1.modelo.Tripulante;
import ar.edu.unlam.tallerweb1.modelo.Vuelo;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioTripulante;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServicioTripulanteImpl implements ServicioTripulante {

    RepositorioTripulante repositorioTripulante;

    @Autowired
    public ServicioTripulanteImpl(RepositorioTripulante repositorioTripulante) {
        this.repositorioTripulante = repositorioTripulante;
    }

    @Override
    public List<Tripulante> listaTodosLosPilotos() {    return repositorioTripulante.listarTodosLosPilotos();   }

    @Override
    public List<Tripulante> listaTodosLosCopilotos() {  return repositorioTripulante.listaTodosLosCopilotos();  }

    @Override
    public List<Tripulante> listaTodosLosIngenieros() { return repositorioTripulante.listaTodosLosIngenieros(); }

    @Override
    public List<Tripulante> listarTodosLosTripulantesDeVuelo() {
        return repositorioTripulante.listarTodosLosTripulantesDeVuelo();
    }

    @Override
    public List<Tripulante> tripulacionAsignada(Vuelo vuelo) { return repositorioTripulante.tripulacionAsignada(vuelo); }

    @Override
    public void asignarUnTripulanteAvuelo(Vuelo vuelo, Tripulante unTripulante) {
        repositorioTripulante.asignarUnTripulanteAvuelo(vuelo,unTripulante);
    }

    @Override
    public void asignarTripulantesAlVuelo(Vuelo vuelo, List<Tripulante> tripulantes) {
        repositorioTripulante.asignarTripulantesAlVuelo(vuelo,tripulantes);
    }

}
