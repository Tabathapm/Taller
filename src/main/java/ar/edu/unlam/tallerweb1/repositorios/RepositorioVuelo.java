package ar.edu.unlam.tallerweb1.repositorios;

import java.util.List;

import ar.edu.unlam.tallerweb1.modelo.Vuelo;

public interface RepositorioVuelo {

	Vuelo consultarVuelo(String nombre);
	
	List<Vuelo> obtenerTodosLosVuelos();
	

}
