package ar.edu.unlam.tallerweb1.servicios;

import java.util.List;
import java.util.Set;

import ar.edu.unlam.tallerweb1.modelo.Locacion;
import ar.edu.unlam.tallerweb1.modelo.Vuelo;

public interface ServicioVuelo {
	
	List<Vuelo> obtenerTodosLosVuelos();

	Set<Vuelo> buscarVuelos(String valorBuscado);

	Vuelo consultarVuelo(Long idVuelo);

	List<Locacion> buscarLocacion(String valorBuscado);

	List<Vuelo> listarTodosLosVuelosSinTripulacion();

	

}
