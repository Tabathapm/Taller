package ar.edu.unlam.tallerweb1.servicios;

import ar.edu.unlam.tallerweb1.modelo.Vuelo;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

public interface ServicioVuelos {
    List<Vuelo> listarTodos();


    Vuelo traerVuelo(long l);
}
