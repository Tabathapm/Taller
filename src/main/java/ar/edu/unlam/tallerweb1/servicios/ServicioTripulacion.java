package ar.edu.unlam.tallerweb1.servicios;

import ar.edu.unlam.tallerweb1.modelo.Tripulante;

import java.util.List;

public interface ServicioTripulacion {
    List<Tripulante> mostrarTripulantesTipo(String titulo);
}
