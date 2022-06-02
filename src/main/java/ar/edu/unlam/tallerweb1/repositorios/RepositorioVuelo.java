package ar.edu.unlam.tallerweb1.repositorios;

import ar.edu.unlam.tallerweb1.modelo.Vuelo;

import java.util.List;

public interface RepositorioVuelo {
    List<Vuelo> traerTodos();
    Vuelo traerPorId(Long id);
}
