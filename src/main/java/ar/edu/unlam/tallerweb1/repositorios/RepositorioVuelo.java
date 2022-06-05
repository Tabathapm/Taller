package ar.edu.unlam.tallerweb1.repositorios;

import java.util.List;

import ar.edu.unlam.tallerweb1.modelo.Locacion;
import ar.edu.unlam.tallerweb1.modelo.Vuelo;

public interface RepositorioVuelo {

	List<Vuelo> obtenerTodosLosVuelos();

	List<Vuelo> buscarVueloPorNombre(String nombre);
	
	List<Vuelo> buscarVueloPorLocacion(String locacion);
	
	Vuelo consultarVuelo(Long id);

	List<Locacion> buscarLocacion(String locacion);
	
 
}
