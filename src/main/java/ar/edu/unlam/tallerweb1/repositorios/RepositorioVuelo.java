package ar.edu.unlam.tallerweb1.repositorios;

import java.util.List;

import ar.edu.unlam.tallerweb1.modelo.*;


public interface RepositorioVuelo {

	List<Vuelo> obtenerTodosLosVuelos();

	List<Vuelo> buscarVueloPorNombre(String nombre);
	
	List<Vuelo> buscarVueloPorLocacion(String locacion);
	
	Vuelo consultarVuelo(Long id);
	
	List<Locacion> buscarLocacion(String locacion);

	List<Vuelo> listarTodosLosVuelosSinTripulacion();
	
	void guardar(Vuelo vuelo);


	void addVuelo(VueloDos vuelo);
	Grafico destinoConMasVuelos();



	List<VueloTripulante> obtenerVuelosSinTripulacion();

}
