package ar.edu.unlam.tallerweb1.servicios;

import ar.edu.unlam.tallerweb1.controladores.TripulanteInfo;
import ar.edu.unlam.tallerweb1.modelo.Tripulante;
import ar.edu.unlam.tallerweb1.modelo.Vuelo;
import ar.edu.unlam.tallerweb1.modelo.VueloDos;
import ar.edu.unlam.tallerweb1.modelo.VueloTripulante;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

public interface ServicioTripulante {
	
    List<Tripulante> listaTodosLosPilotos();
    
    List<Tripulante> listaTodosLosCopilotos();
    
    List<Tripulante> listaTodosLosIngenieros();
    
    List<Tripulante> listarTodosLosTripulantesDeVuelo();
    
    List<Tripulante> tripulacionAsignada(Vuelo vuelo);

    VueloTripulante asignarUnTripulanteAvuelo(Long vuelo,Long unTripulante);

    void asignarTripulantesAlVuelo(Vuelo vuelo1, List<Tripulante> tripulantes);

	List<Tripulante> listarTodosLosTripulantes();

	Tripulante setHorasDeTripulante(Tripulante t);
	
	Vuelo obtenerPrimerVueloDeTripulante(Tripulante tripulante);

	void fechaDisponibleParaTripulante(List<VueloTripulante> vt, Vuelo vuelo);
	
	Boolean determinarSiDisponible(Vuelo encontrado,Vuelo entrante);

	Boolean checkActivo(Vuelo vReg,Vuelo vEnt);


    List<Tripulante> mostrarTripulantesTipo(String titulo);

    Tripulante traerTripulante(Long id);

    VueloTripulante asignarUnTripulanteAvueloDos(VueloDos vuelo, Tripulante unTripulante);


	Vuelo obtenerVueloMasCercano(List<VueloTripulante> vt,Vuelo v);


//	Tripulante traerTripulante(Long id);

    void addPiloto(TripulanteInfo piloto) throws ParseException;


}