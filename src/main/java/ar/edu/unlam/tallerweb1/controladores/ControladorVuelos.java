package ar.edu.unlam.tallerweb1.controladores;

import ar.edu.unlam.tallerweb1.modelo.Locacion;
import ar.edu.unlam.tallerweb1.modelo.Tripulante;
import ar.edu.unlam.tallerweb1.modelo.Vuelo;
import ar.edu.unlam.tallerweb1.servicios.ServicioVuelo;
import ar.edu.unlam.tallerweb1.servicios.ServicioTripulacion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class ControladorVuelos {

    private ServicioVuelo servicioVuelo;
    private ServicioTripulacion servicioTripulacion;

    @Autowired
    public ControladorVuelos(ServicioVuelo servicioVuelo, ServicioTripulacion servicioTripulacion){
        this.servicioVuelo = servicioVuelo;
        this.servicioTripulacion = servicioTripulacion;
    }

    @RequestMapping("/addVuelo")
    public ModelAndView agregarVuelo(){
        return new ModelAndView("homeDos");
    }

    @RequestMapping("/agregar-vuelo")
    public ModelAndView irAgregarVuelo(){
//      --------------------------------
        ModelMap modelo = new ModelMap();
//      --------------------------------
        List <Locacion> listaLocaciones = servicioVuelo.mostrarLocaciones();
        List <Tripulante> listaPilotos  = servicioTripulacion.mostrarTripulantesTipo("piloto");
        List <Tripulante> listaCopilotos  = servicioTripulacion.mostrarTripulantesTipo("copiloto");
        List <Tripulante> listaTripulantesDeCabina  = servicioTripulacion.mostrarTripulantesTipo("tripulante de cabina");
        List <Tripulante> listaIngDeVuelo  = servicioTripulacion.mostrarTripulantesTipo("ing de vuelo");
//      ------------------------------------------
        modelo.put("locaciones", listaLocaciones);
        modelo.put("pilotos", listaPilotos);
        modelo.put("copilotos", listaCopilotos);
        modelo.put("tripulantes", listaTripulantesDeCabina);
        modelo.put("ingsDeVuelo", listaIngDeVuelo);
//      ------------------------------------------
        return new ModelAndView("agregar_vuelo", modelo);
    }

    @RequestMapping(path = "/addVuelo", method = RequestMethod.POST)
    public ModelAndView agregarVuelo(@ModelAttribute("datosVuelo") DatosVuelo datosVuelo, HttpServletRequest request){
        ModelMap model = new ModelMap();
        Vuelo vuelo = new Vuelo();

        servicioVuelo.agregarVuelo(vuelo);

        return new ModelAndView("/homeDos");
    }
}
