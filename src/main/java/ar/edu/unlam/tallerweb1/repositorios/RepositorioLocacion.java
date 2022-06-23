package ar.edu.unlam.tallerweb1.repositorios;

import ar.edu.unlam.tallerweb1.modelo.Locacion;

import java.util.List;

public interface RepositorioLocacion {

    List<Locacion> mostrarLocacion();
    Locacion buscarLocacionPorId(Long id);
}
