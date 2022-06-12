package ar.edu.unlam.tallerweb1.servicios;

import ar.edu.unlam.tallerweb1.modelo.Tripulante;
import ar.edu.unlam.tallerweb1.modelo.Vuelo;
import ar.edu.unlam.tallerweb1.modelo.VueloTripulante;

import java.util.List;

public interface ServicioTripulante {
	
    List<Tripulante> listaTodosLosPilotos();
    
    List<Tripulante> listaTodosLosCopilotos();
    
    List<Tripulante> listaTodosLosIngenieros();
    
    List<Tripulante> listarTodosLosTripulantesDeVuelo();
    
    List<Tripulante> tripulacionAsignada(Vuelo vuelo);

    VueloTripulante asignarUnTripulanteAvuelo(Vuelo vuelo,Tripulante unTripulante);

    void asignarTripulantesAlVuelo(Vuelo vuelo1, List<Tripulante> tripulantes);

	List<Tripulante> listarTodosLosTripulantes();

	


}