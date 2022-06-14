package ar.edu.unlam.tallerweb1.servicios;
import ar.edu.unlam.tallerweb1.modelo.Avion;
import ar.edu.unlam.tallerweb1.modelo.Locacion;
import ar.edu.unlam.tallerweb1.modelo.Tripulante;
import ar.edu.unlam.tallerweb1.modelo.Vuelo;
import ar.edu.unlam.tallerweb1.modelo.VueloTripulante;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioTripulante;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioUsuario;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioVuelo;
import excepciones.FechaYaOcupadaException;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class ServicioVueloTest {


	private static final SimpleDateFormat formato = new SimpleDateFormat ("dd-MM-yyyy HH:mm");
    private static final Date fechaActual = new Date();
    
    private static final String nv1 = "v1";
    private static final String nt1 = "t1";
    private static final String nv2 = "v2";
    private static final String nv3 = "v3";
    private static final String nt2 = "t2";
    

    private RepositorioVuelo repositorioVuelo = mock(RepositorioVuelo.class);
    private ServicioVueloImpl servicioVuelo = new ServicioVueloImpl(repositorioVuelo);
    
    @Test
    public void queSePuedaGuardarUnVuelo() {
    	
    	Vuelo v1 = givenVueloCompleto();
    	
    	whenGuardoVuelo(v1);
    	
    	thenSeGuardo(v1);
    	

    }
    
    private void whenGuardoVuelo(Vuelo v) {
		servicioVuelo.agregarVuelo(v);
	
	}

	private void thenSeGuardo(Vuelo v) {
    	
		verify(repositorioVuelo,times(1)).guardar(v);
    	
    }
	

    private Tripulante givenTripulante(String nombre) {
    	Tripulante t = new Tripulante();
    	t.setId(new Random().nextLong());
    	t.setNombre(nombre);
   	
		return t;
	}


	private Vuelo givenVuelo(String nombre) {
		Vuelo v = new Vuelo();
    	v.setId(new Random().nextLong());
    	v.setNombre(nombre);
    	
		return v;
	}
	

	private Vuelo givenVueloCompleto() {
		Vuelo v = new Vuelo();
		Date salida = new Date();
		Date llegada = new Date();
		Locacion destino = new Locacion();
		Locacion origen = new Locacion();
		Avion avion = new Avion();
		SimpleDateFormat formato = new SimpleDateFormat ("dd-MM-yyyy HH:mm");
		
		
		
        try {
			salida=formato.parse("05-05-2005 15:55");
			llegada=formato.parse("05-05-2005 16:00");
	
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

   
}