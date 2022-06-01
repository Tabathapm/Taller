package ar.edu.unlam.tallerweb1.repositorios;

import ar.edu.unlam.tallerweb1.modelo.Tripulante;

import java.util.List;

public interface RepositorioTripulacion {
    List<Tripulante> mostrarTripulacion(String titulo);
}
