package ar.edu.unlam.tallerweb1.controladores;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ControladorHangar {
	
	@RequestMapping("/hangares-vacios")
    public ModelAndView verVacios(){
        return new ModelAndView("hangares-vervacios");
    }
	
	@RequestMapping("/hangares-asignar")
    public ModelAndView asignar(){
        return new ModelAndView("hangares-asignar");
    }

}
