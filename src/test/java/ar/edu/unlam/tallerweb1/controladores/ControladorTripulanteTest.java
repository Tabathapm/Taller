package ar.edu.unlam.tallerweb1.controladores;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.modelo.Avion;
import ar.edu.unlam.tallerweb1.modelo.Locacion;
import ar.edu.unlam.tallerweb1.modelo.Tripulante;
import ar.edu.unlam.tallerweb1.modelo.Vuelo;
import ar.edu.unlam.tallerweb1.modelo.VueloTripulante;
import ar.edu.unlam.tallerweb1.servicios.ServicioTripulante;
import ar.edu.unlam.tallerweb1.servicios.ServicioVuelo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.*;



@RunWith(MockitoJUnitRunner.class)
@ContextConfiguration(locations= "classpath:applicationContext.xml")
public class ControladorTripulanteTest {


	private final ServicioTripulante servicioTripulante = mock(ServicioTripulante.class);
	private final ServicioVuelo servicioVuelo = mock(ServicioVuelo.class);
	
	@InjectMocks
	private ControladorHangar controladorHangar = new ControladorHangar();
	
	private final ControladorTripulante controladorTripulante = new ControladorTripulante(servicioTripulante, servicioVuelo);

	
	private ModelAndView mav = new ModelAndView();
	
	@Test
	public void asignarTripulanteAVueloExitosoTest(){
	
		Tripulante t1 = givenTripulante("numero1");
	 	Vuelo v1 = givenVueloCompletoConstructor("20-06-2022 15:00","20-06-2022 17:00");
		Vuelo v2 = givenVueloCompletoConstructor("21-06-2022 17:00","21-06-2022 20:00");
	    VueloTripulante vt = givenVT(v1,t1);
	    
	    whenSeAsignaElTripulanteExitosamente(v2,t1);
		
	    thenSeAsignoExitosamente();
	
	}
	
	private void thenSeAsignoExitosamente() {
		// TODO Auto-generated method stub
		
	}

	private void whenSeAsignaElTripulanteExitosamente(Vuelo v2, Tripulante t1) {
		// TODO Auto-generated method stub
		
	}

	private Tripulante givenTripulante(String nombre) {
    	Tripulante t = new Tripulante();
    	t.setId(new Random().nextLong());
    	t.setNombre(nombre);
   	
		return t;
	}
	
	private Vuelo givenVueloCompletoConstructor(String date1,String date2) {
		Vuelo v = new Vuelo();
		Date salida = new Date();
		Date llegada = new Date();
		Locacion destino = new Locacion();
		Locacion origen = new Locacion();
		Avion avion = new Avion();
		SimpleDateFormat formato = new SimpleDateFormat ("dd-MM-yyyy HH:mm");
		
		
		
        try {
			salida=formato.parse(date1);
			llegada=formato.parse(date2);
	
		} catch (ParseException e) {
			e.printStackTrace();
		}
        
        destino.setCoordenadas("iwiwo");
		origen.setCoordenadas("owowo");
    	v.setId(new Random().nextLong());
    	v.setSalida(salida);
    	v.setLlegada(llegada);
    	v.setDestino(destino);
    	v.setOrigen(origen);
    	v.setAvion(avion);

    	
		return v;
	}
	
	private VueloTripulante givenVT(Vuelo v,Tripulante t) {
		VueloTripulante vt = new VueloTripulante();
		vt.setVuelo(v);
		vt.setTripulante(t);
		
		return vt;
	}



}
