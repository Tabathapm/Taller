package ar.edu.unlam.tallerweb1.controladores;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.servicios.ServicioVuelo;

@Controller
public class ControladorVuelos {
	
	private ServicioVuelo servicioVuelo;
	
	@Autowired
	public ControladorVuelos(ServicioVuelo servicioVuelo) {
		this.servicioVuelo = servicioVuelo;
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
    
    @RequestMapping("buscarVuelos")
    public ModelAndView buscarVuelos
    (HttpServletRequest request,
    @RequestParam(value = "busqueda", required = false) String valorBuscado){

		ModelMap modelo = new ModelMap();

		modelo.put("vuelo",  servicioVuelo.buscarVueloPorNombre(valorBuscado));


    	return new ModelAndView("vuelos",modelo);
    }
   
    
}
