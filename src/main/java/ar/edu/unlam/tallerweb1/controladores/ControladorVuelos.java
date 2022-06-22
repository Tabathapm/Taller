package ar.edu.unlam.tallerweb1.controladores;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import ar.edu.unlam.tallerweb1.modelo.Locacion;
import ar.edu.unlam.tallerweb1.servicios.ServicioLocacion;
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
    private ServicioLocacion servicioLocacion;
	
	@Autowired
	public ControladorVuelos(ServicioVuelo servicioVuelo,ServicioTripulante servicioTripulante, ServicioLocacion servicioLocacion) {
		this.servicioVuelo = servicioVuelo;
		this.servicioTripulante = servicioTripulante;
        this.servicioLocacion = servicioLocacion;
	}

    @RequestMapping("/agregar-vuelo")
    public ModelAndView irAgregarVuelo(){
//      --------------------------------
        ModelMap modelo = new ModelMap();
//      --------------------------------
        List <Locacion> listaLocaciones = servicioLocacion.mostrarLocaciones();
        List <Tripulante> listaPilotos  = servicioTripulante.mostrarTripulantesTipo("Piloto");
        List <Tripulante> listaCopilotos  = servicioTripulante.mostrarTripulantesTipo("Copiloto");
        List <Tripulante> listaTripulantesDeCabina  = servicioTripulante.mostrarTripulantesTipo("tripulante de cabina");
        List <Tripulante> listaIngDeVuelo  = servicioTripulante.mostrarTripulantesTipo("Ingeniero de Vuelo");
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
//      -------------------------------------------------------------------------------------------------------------
        ModelMap model = new ModelMap();
        Vuelo vuelo = new Vuelo();

        Long origenId = Long.parseLong(datosVuelo.getOrigen());
        Long destinoId = Long.parseLong(datosVuelo.getDestino());

        Long idPiloto = Long.parseLong(datosVuelo.getPiloto());
        Long idCopiloto = Long.parseLong(datosVuelo.getCopiloto());

        String tripulantesElegido = datosVuelo.getTripulantes();
        String[] cadaIdTripulante = tripulantesElegido.split(",");

        List <Long> idTripulante = new ArrayList<>();

        for (String i: cadaIdTripulante) {
            Long idParseados = Long.parseLong(i);
            idTripulante.add(idParseados);
        }



        Locacion origen = servicioLocacion.buscarPorId(origenId);

//        model.put("verQueOnda", idTripulantes);

//        quiero ver que recibe 'datosVuelo'
        return new ModelAndView("verDatosVuelos");
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
    
    @RequestMapping("/tripulantes")
    public ModelAndView traerVuelo(){
        ModelMap modelo = new ModelMap();

        modelo.put("tripulantes",servicioTripulante.listarTodosLosTripulantes());
        
        return new ModelAndView("tripulantes",modelo);

    }
    
    @RequestMapping("/asignarTripulacion")
    public ModelAndView asignarTripulacionAVuelo() {
    	
    	ModelMap modelo = new ModelMap();
    	
    	modelo.put("vuelosSinTripulacion",servicioVuelo.listarTodosLosVuelosSinTripulacion());
    	
    	
    	return new ModelAndView("asignarTripulacion",modelo);
    	
    	
    	
    }
    /*
     * 
	    @RequestMapping(value = "/traerVuelo",method = RequestMethod.GET)
	    public ModelAndView traerVuelo(){
        ModelMap modelo = new ModelMap();
        modelo.put("unVuelo",servicioVuelo.consultarVuelo(1L));

        modelo.put("listaPilotos",servicioTripulante.listaTodosLosPilotos());
        modelo.put("listaCopilotos",servicioTripulante.listaTodosLosCopilotos());
        modelo.put("listaIngenieros",servicioTripulante.listaTodosLosIngenieros());
        modelo.put("listaTripulantes",servicioTripulante.listarTodosLosTripulantesDeVuelo());
        modelo.put("vuelo1",new Vuelo());
        return new ModelAndView("mostrarVueloAsignarTrip",modelo);

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
    */
   
    
}
