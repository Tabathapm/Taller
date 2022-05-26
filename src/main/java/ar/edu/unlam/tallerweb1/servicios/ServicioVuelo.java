package ar.edu.unlam.tallerweb1.servicios;

import java.util.List;

import ar.edu.unlam.tallerweb1.modelo.Vuelo;

public interface ServicioVuelo {
	
	Vuelo consultarVuelo(String nombre);
	
	List<Vuelo> obtenerTodosLosVuelos();

	List<Vuelo> buscarVueloPorNombre(String valorBuscado);

}
