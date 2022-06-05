package ar.edu.unlam.tallerweb1.controladores;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.modelo.Tripulante;
import ar.edu.unlam.tallerweb1.modelo.Vuelo;
import ar.edu.unlam.tallerweb1.servicios.ServicioTripulante;
import ar.edu.unlam.tallerweb1.servicios.ServicioVuelo;

@Controller
public class ControladorVuelos {
	
	private ServicioVuelo servicioVuelo;
	private ServicioTripulante servicioTripulante;
	
	@Autowired
	public ControladorVuelos(ServicioVuelo servicioVuelo,ServicioTripulante servicioTripulante) {
		this.servicioVuelo = servicioVuelo;
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
    
    @RequestMapping("/buscarVuelos")
    public ModelAndView buscarVuelos
    (@RequestParam(value = "busqueda", required = false) String valorBuscado){

		ModelMap modelo = new ModelMap();

		modelo.put("vuelo",  servicioVuelo.buscarVuelos(valorBuscado));


    	return new ModelAndView("vuelos",modelo);
    }
    
    @RequestMapping("/vueloDescripcion")
    public ModelAndView consultarVuelo
    (@RequestParam(value="idVuelo",required = false)Long idVuelo,
    HttpServletRequest request) {
    	
    	ModelMap modelo= new ModelMap();
    	request.getSession().setAttribute("idVuelo", idVuelo);
    	
    	modelo.put("vuelo", servicioVuelo.consultarVuelo(idVuelo));
    	
    	
    	return new ModelAndView("vueloDescripcion",modelo);
    }
    
    @RequestMapping(value = "/traerVuelo",method = RequestMethod.GET)
    public ModelAndView traerVuelo(){
        ModelMap modelo = new ModelMap();
        modelo.put("unVuelo",servicioVuelo.consultarVuelo(888L));

        modelo.put("listaPilotos",servicioTripulante.listaTodosLosPilotos());
        modelo.put("listaCopilotos",servicioTripulante.listaTodosLosCopilotos());
        modelo.put("listaIngenieros",servicioTripulante.listaTodosLosIngenieros());
        modelo.put("listaTripulantes",servicioTripulante.listarTodosLosTripulantesDeVuelo());
        modelo.put("vuelo1",new Vuelo());
        return new ModelAndView("mostrarVueloAsignarTrip",modelo);

    }
    /*
    @RequestMapping(value = "edit",method = RequestMethod.POST)
    public ModelAndView editTripulantes(@ModelAttribute("vuelo1") Vuelo vuelo1 ){
        ModelMap modelo = new ModelMap();
        List<Tripulante> tripulantes = vuelo1.getTripulacionVuelo();
        servicioTripulante.asignarTripulantesAlVuelo(vuelo1, tripulantes);
        modelo.put("tripulacionVuelo",servicioTripulante.tripulacionAsignada(vuelo1));
        modelo.put("unVuelo",vuelo1);
        return new ModelAndView("tripulantesAsignadosAlVuelo",modelo);
    }
    */
   
    
}
