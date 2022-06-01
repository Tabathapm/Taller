package ar.edu.unlam.tallerweb1.repositorios;

import ar.edu.unlam.tallerweb1.modelo.Locacion;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.modelo.Vuelo;

import java.util.List;

public interface RepositorioVuelo {
    List<Locacion> mostrarLocacion();
    void guardar(Vuelo vuelo);
}
