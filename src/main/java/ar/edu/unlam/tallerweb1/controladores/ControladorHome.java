package ar.edu.unlam.tallerweb1.controladores;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ControladorHome {

    @RequestMapping("/home")
    public ModelAndView irHome(){
        return new ModelAndView("homeDos");
    }

    @RequestMapping("/perfil")
    public ModelAndView miPerfil(){
        return new ModelAndView("miPerfil");
    }

    @RequestMapping("/hangares")
    public ModelAndView irHangares(){
        return new ModelAndView("hangares");
    }

    @RequestMapping("/vuelos")
    public ModelAndView irVuelos(){
        return new ModelAndView("vuelos");
    }

    @RequestMapping("/tripulacion")
    public ModelAndView irTripulacion(){
        return new ModelAndView("tripulacion");
    }

    @RequestMapping("/pasajes")
    public ModelAndView irPasajes(){
        return new ModelAndView("pasajes");
    }


}
