package ar.edu.unlam.tallerweb1.repositorios;

import ar.edu.unlam.tallerweb1.modelo.Tripulante;
import ar.edu.unlam.tallerweb1.modelo.Vuelo;
import ar.edu.unlam.tallerweb1.modelo.VueloTripulante;

import java.util.Date;
import java.util.List;

public interface RepositorioTripulante {
	
	    Tripulante traerTripulante(Long id);
	    
	    List<Tripulante> listarTodosLosPilotos();
	    
	    List<Tripulante> listaTodosLosCopilotos();
	    
	    List<Tripulante> listaTodosLosIngenieros();
	    
	    List<Tripulante> listarTodosLosTripulantesDeVuelo();

	    List<Tripulante> tripulacionAsignada(Vuelo vuelo);

	    VueloTripulante asignarUnTripulanteAvuelo(Vuelo vuelo, Tripulante unTripulante);

	    void asignarTripulantesAlVuelo(Vuelo vuelo, List<Tripulante> tripulantes);

		List<Tripulante> listarTodosLosTripulantes();

		List<VueloTripulante> obtenerVuelosDeTripulante(Tripulante tripulante);


	}


