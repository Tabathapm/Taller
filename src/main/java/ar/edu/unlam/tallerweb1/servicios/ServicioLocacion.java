package ar.edu.unlam.tallerweb1.servicios;

import ar.edu.unlam.tallerweb1.modelo.Locacion;

import java.util.List;

public interface ServicioLocacion {

    List<Locacion> mostrarLocaciones();
    Locacion buscarPorId(Long id);
}
