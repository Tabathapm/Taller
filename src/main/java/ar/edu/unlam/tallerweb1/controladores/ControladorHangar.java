package ar.edu.unlam.tallerweb1.controladores;

import ar.edu.unlam.tallerweb1.modelo.Avion;
import ar.edu.unlam.tallerweb1.modelo.Hangar;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.servicios.ServicioAvion;
import ar.edu.unlam.tallerweb1.servicios.ServicioHangar;
import ar.edu.unlam.tallerweb1.servicios.ServicioLogin;
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
public class ControladorHangar {

    @Autowired
    private ServicioHangar servicioHangar;

    @Autowired
    private ServicioAvion servicioAvion;

    @RequestMapping("/hangares")
    public ModelAndView irHangares(){
        ModelMap model = new ModelMap();
        List<Hangar> hangares = servicioHangar.traerTodosLosHangares();
        model.put("listaDeHangares", hangares);


        return new ModelAndView("hangares", model);
    }


	
	@RequestMapping("/hangares-vacios")
    public ModelAndView verVacios(){

        ModelMap model = new ModelMap();
//        Usuario usuarioBuscado = servicioLogin.consultarUsuario(datosLogin.getEmail(), datosLogin.getPassword());
          List<Hangar> hangares = servicioHangar.traerTodosLosHangaresDisponibles();
          List<Avion> aviones = servicioAvion.traerAvionesSinHangar();
          model.put("hangaresVacios",hangares);
          model.put("avionesVacios",aviones);
        return new ModelAndView("hangares-vervacios",model);
    }
	
	@RequestMapping("/hangares-asignar")
    public ModelAndView asignar(){
        ModelMap model = new ModelMap();
        List<Avion> aviones = servicioHangar.traerAvionesSinAsignar();
        model.put("avionesSinAsignar",aviones);
        return new ModelAndView("hangares-asignar",model);

    }

    @RequestMapping(path = "/homeDos", method = RequestMethod.POST)
    public ModelAndView asignarHangaresVacios(@ModelAttribute("asignarAvionAHangar") AsignarAvionAHangar asignarAvionAHangar, HttpServletRequest request) {
        ModelMap model = new ModelMap();
        servicioHangar.asigarAvionesAHangar(asignarAvionAHangar.getIdAvion(),asignarAvionAHangar.getIdHangar());
        return new ModelAndView("homeDos",model);

    }



}
