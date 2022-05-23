package ar.edu.unlam.tallerweb1.controladores;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.servicios.ServicioVuelo;

@Controller
public class ControladorVuelos {
	
	private ServicioVuelo servicioVuelo;

    @RequestMapping("/agregar-vuelo")
    public ModelAndView irAgregarVuelo(){
        return new ModelAndView("agregar_vuelo");
    }

    @RequestMapping("/addVuelo")
    public ModelAndView agregarVuelo(){
//        Logica para agregar a la bdd
        return new ModelAndView("homeDos");
    }
    
}
