package ar.edu.unlam.tallerweb1.servicios;

import ar.edu.unlam.tallerweb1.modelo.Locacion;
import ar.edu.unlam.tallerweb1.modelo.Vuelo;

import java.util.List;

public interface ServicioVuelo {
    List<Locacion> mostrarLocaciones();
    void agregarVuelo(Vuelo vuelo);
}
