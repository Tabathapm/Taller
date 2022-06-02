package ar.edu.unlam.tallerweb1.controladores;

import ar.edu.unlam.tallerweb1.modelo.Avion;
import ar.edu.unlam.tallerweb1.modelo.Locacion;
import ar.edu.unlam.tallerweb1.modelo.Tripulante;
import ar.edu.unlam.tallerweb1.modelo.Vuelo;
import ar.edu.unlam.tallerweb1.servicios.ServicioTripulante;
import ar.edu.unlam.tallerweb1.servicios.ServicioVuelos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.util.MimeTypeUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

@Controller
public class ControladorVuelos {

    ServicioTripulante servicioTripulante;
    ServicioVuelos servicioVuelos;
    private Vuelo vuelo2;

    @Autowired
    public ControladorVuelos(ServicioVuelos servicioVuelos,ServicioTripulante servicioTripulante) {

        this.servicioVuelos = servicioVuelos;
        this.servicioTripulante = servicioTripulante;
    }

    @RequestMapping("/agregar-vuelo")
    public ModelAndView irAgregarVuelo(){
        return new ModelAndView("agregar_vuelo");
    }

    @RequestMapping("/addVuelo")
    public ModelAndView agregarVuelo(){
//        Logica para agregar a la bdd
        return new ModelAndView("homeDos");
    }

    @RequestMapping(value = "/traerVuelo",method = RequestMethod.GET)
    public ModelAndView traerVuelo(){
        ModelMap modelo = new ModelMap();
        modelo.put("unVuelo",servicioVuelos.traerVuelo(888L));

        modelo.put("listaPilotos",servicioTripulante.listaTodosLosPilotos());
        modelo.put("listaCopilotos",servicioTripulante.listaTodosLosCopilotos());
        modelo.put("listaIngenieros",servicioTripulante.listaTodosLosIngenieros());
        modelo.put("listaTripulantes",servicioTripulante.listarTodosLosTripulantesDeVuelo());
        modelo.put("vuelo1",new Vuelo());
        return new ModelAndView("mostratVueloAsignarTrip",modelo);

    }

    @RequestMapping(value = "edit",method = RequestMethod.POST)
    public ModelAndView editTripulantes(@ModelAttribute("vuelo1") Vuelo vuelo1 ){
        ModelMap modelo = new ModelMap();
        List<Tripulante> tripulantes = vuelo1.getTripulacionVuelo();
        servicioTripulante.asignarTripulantesAlVuelo(vuelo1, tripulantes);
        modelo.put("tripulacionVuelo",servicioTripulante.tripulacionAsignada(vuelo1));
        modelo.put("unVuelo",vuelo1);
        return new ModelAndView("tripulantesAsignadosAlVuelo",modelo);
    }

}
