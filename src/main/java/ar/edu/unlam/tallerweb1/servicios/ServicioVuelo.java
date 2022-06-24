package ar.edu.unlam.tallerweb1.servicios;

import java.util.List;
import java.util.Set;

import ar.edu.unlam.tallerweb1.modelo.Grafico;
import ar.edu.unlam.tallerweb1.modelo.Locacion;
import ar.edu.unlam.tallerweb1.modelo.Vuelo;
import ar.edu.unlam.tallerweb1.modelo.VueloDos;

public interface ServicioVuelo {
	
	List<Vuelo> obtenerTodosLosVuelos();

	Set<Vuelo> buscarVuelos(String valorBuscado);

	Vuelo consultarVuelo(Long idVuelo);

	List<Locacion> buscarLocacion(String valorBuscado);

	List<Vuelo> listarTodosLosVuelosSinTripulacion();

	void agregarVuelo(Vuelo vuelo);

	void validarFechasDelVuelo(Vuelo vuelo);

	void validarLocacionesDelVuelo(Vuelo vuelo);

	Vuelo setNombreDeVuelo(Vuelo vuelo);

	Vuelo setEstimadoDeVuelo(Vuelo vuelo);

	void addVuelo(VueloDos vuelo);
	Grafico destinoConMasVuelos();
}
