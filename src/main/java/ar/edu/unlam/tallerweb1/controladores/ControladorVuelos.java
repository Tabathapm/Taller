package ar.edu.unlam.tallerweb1.controladores;

import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import ar.edu.unlam.tallerweb1.modelo.*;
import ar.edu.unlam.tallerweb1.servicios.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ControladorVuelos {
	
	private ServicioVuelo servicioVuelo;
	private ServicioTripulante servicioTripulante;
    private ServicioLocacion servicioLocacion;
    private ServicioTipoAvion servicioTipoAvion;
    private ServicioAvion servicioAvion;
	
	@Autowired
	public ControladorVuelos(ServicioVuelo servicioVuelo,ServicioTripulante servicioTripulante,
                             ServicioLocacion servicioLocacion, ServicioTipoAvion servicioTipoAvion,
                             ServicioAvion servicioAvion) {
		this.servicioVuelo = servicioVuelo;
		this.servicioTripulante = servicioTripulante;
        this.servicioLocacion = servicioLocacion;
        this.servicioTipoAvion = servicioTipoAvion;
        this.servicioAvion = servicioAvion;
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
//        List <Avion> listaAvionesCarga = servicioAvion.traerAvionesDeCarga();
//        List <Avion> listaAvionesComerciales = servicioAvion.traerAvionesComerciales();
//      ------------------------------------------
        modelo.put("locaciones", listaLocaciones);
        modelo.put("pilotos", listaPilotos);
        modelo.put("copilotos", listaCopilotos);
        modelo.put("tripulantes", listaTripulantesDeCabina);
        modelo.put("ingsDeVuelo", listaIngDeVuelo);
//        modelo.put("avionesDeCarga", listaAvionesCarga);
//        modelo.put("avionesComerciales", listaAvionesComerciales);
//      ------------------------------------------
        return new ModelAndView("agregar_vuelo", modelo);
    }

    @RequestMapping(path = "/addVuelo", method = RequestMethod.POST)
    public ModelAndView agregarVuelo(@ModelAttribute("datosVuelo") DatosVuelo datosVuelo, HttpServletRequest request) throws ParseException {
//      -------------------------------------------------------------------------------------------------------------
        ModelMap model = new ModelMap();
        VueloDos vuelo    = new VueloDos();
//      -------------------------------------------------
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-mm-dd");
        SimpleDateFormat formatHora = new SimpleDateFormat("hh:mm");
//      -------------------------------------------------
        String tipoDeAvion = datosVuelo.getTipoDeAvion();
//        TipoAvion tipoAvion = servicioTipoAvion.tipoDeAvion(tipoDeAvion);

//      ------------------ Salida -----------------------
        Date fechaSalida = formatter.parse(datosVuelo.getFechaSalida());
        Long hSalida = formatHora.parse(datosVuelo.getHoraSalida()).getTime();
        Time horaSalida = new Time(hSalida);

//      ------------------ Llegada-----------------------
        Date fechaLlegada = formatter.parse(datosVuelo.getFechaLlegada());
        Long hLlegada = formatHora.parse(datosVuelo.getHoraLlegada()).getTime();
        Time horaLlegada = new Time(hLlegada);

//      ------------------ Locaciones ------------------------
        Long origenId  = Long.parseLong(datosVuelo.getOrigen());
        Long destinoId = Long.parseLong(datosVuelo.getDestino());

        Locacion origen  = servicioLocacion.buscarPorId(origenId);
        Locacion destino = servicioLocacion.buscarPorId(destinoId);

//      ------------------ Tripulantes ------------------------
        Long idPiloto;
        Long idCopiloto;
        Long idIngDeVuelo;

        Tripulante piloto;
        Tripulante copiloto;
        Tripulante ingDeVuelo;

//      --------------------------------------------
        switch (tipoDeAvion){
            case "comercial":

                idPiloto     = Long.parseLong(datosVuelo.getPiloto());
                idCopiloto   = Long.parseLong(datosVuelo.getCopiloto());
                idIngDeVuelo = Long.parseLong(datosVuelo.getIngDeVuelo());

                piloto     = servicioTripulante.traerTripulante(idPiloto);
                copiloto   = servicioTripulante.traerTripulante(idCopiloto);
                ingDeVuelo = servicioTripulante.traerTripulante(idIngDeVuelo);

                servicioTripulante.asignarUnTripulanteAvueloDos(vuelo, piloto);
                servicioTripulante.asignarUnTripulanteAvueloDos(vuelo, copiloto);
                servicioTripulante.asignarUnTripulanteAvueloDos(vuelo, ingDeVuelo);

                List <Long> idTripulante      = new ArrayList<>();
                List <Tripulante> tripulantes = new ArrayList<>();
                String tripulantesElegido;

                tripulantesElegido = datosVuelo.getTripulantes();
                String[] cadaIdTripulante = tripulantesElegido.split(",");

                for (String i: cadaIdTripulante) {
                    Long idParseados = Long.parseLong(i);
                    idTripulante.add(idParseados);

                    for (Long j: idTripulante) {
                        Tripulante tripulante = servicioTripulante.traerTripulante(j);
                        tripulantes.add(tripulante);

                        for (Tripulante t: tripulantes) {
//                            servicioTripulante.asignarTripulantesAlVuelo(vuelo, t);
                        }
                    }
                }

                vuelo.setOrigen(origen);

                break;

            case "carga":

                idPiloto = Long.parseLong(datosVuelo.getPiloto());
                idIngDeVuelo = Long.parseLong(datosVuelo.getIngDeVuelo());

                piloto     = servicioTripulante.traerTripulante(idPiloto);
                ingDeVuelo = servicioTripulante.traerTripulante(idIngDeVuelo);

//                servicioTripulante.asignarUnTripulanteAvueloDos(vuelo, piloto);
//                servicioTripulante.asignarUnTripulanteAvueloDos(vuelo, ingDeVuelo);

                vuelo.setOrigen(origen);
                vuelo.setDestino(destino);
                vuelo.setFechaSalida(fechaSalida);
                vuelo.setFechaLlegada(fechaLlegada);
                vuelo.setHoraSalida(horaSalida);
                vuelo.setHoraLlegada(horaLlegada);

                servicioVuelo.addVuelo(vuelo);

                break;
        }

//        model.put("verQueOnda", idTripulantes);

//        quiero ver que recibe 'datosVuelo'
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
