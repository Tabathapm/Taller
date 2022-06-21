package ar.edu.unlam.tallerweb1.controladores;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.servicios.ServicioTripulante;
import ar.edu.unlam.tallerweb1.servicios.ServicioVuelo;

@Controller
public class ControladorTripulante {
	
	private ServicioTripulante servicioTripulante;
	private ServicioVuelo servicioVuelo;
	
	@Autowired
	public ControladorTripulante(ServicioTripulante servicioTripulante,ServicioVuelo servicioVuelo) {
		this.servicioVuelo = servicioVuelo;
		this.servicioTripulante = servicioTripulante;
	}

	@RequestMapping("/asignarTripulante")
	public ModelAndView asignarTripulanteAVuelo(
			@RequestParam(value="tripulanteId") Long tripulanteId,
			HttpServletRequest request) {
		
		ModelMap modelo = new ModelMap();
		
		request.getSession().setAttribute("tripulante", tripulanteId);
		
		modelo.put("vuelos",servicioVuelo.obtenerTodosLosVuelos());
		
		
		return new ModelAndView(" ",modelo);
	}
	
	@RequestMapping("/asignarTripulante")
	public ModelAndView tripulanteAsignadoAVuelo() {
		
		
		
		return new ModelAndView("tripulanteAsignadoConExito");
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
