package ar.edu.unlam.tallerweb1.servicios;
import ar.edu.unlam.tallerweb1.excepciones.*;
import ar.edu.unlam.tallerweb1.modelo.Avion;
import ar.edu.unlam.tallerweb1.modelo.Locacion;
import ar.edu.unlam.tallerweb1.modelo.Tripulante;
import ar.edu.unlam.tallerweb1.modelo.Vuelo;
import ar.edu.unlam.tallerweb1.modelo.VueloTripulante;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioTripulante;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioUsuario;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioVuelo;

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
    
    @Test(expected = VueloSinSalidaException.class)
    public void queSeNoPuedaGuardarUnVueloSinSalida() {
    	
    	Vuelo v1 = givenVueloSinSalida();
    	
    	whenGuardoVuelo(v1);
    	
    	thenSeGuardo(v1);
    	

    }
    
    @Test(expected = VueloSinLlegadaException.class)
    public void queSeNoPuedaGuardarUnVueloSinLllegada() {
    	
    	Vuelo v1 = givenVueloSinLlegada();
    	
    	whenGuardoVuelo(v1);
    	
    	thenSeGuardo(v1);

    }
    
    @Test(expected = ErrorEnFechasException.class)
    public void queNoSePuedaGuardarUnVueloConSalidaYLlegadaIguales() {
    	
    	Vuelo v1 = givenVueloConFechasIguales();
    	
    	whenGuardoVuelo(v1);
    	
    	thenSeGuardo(v1);

    }
    
    @Test(expected = DestinoOrigenIgualesException.class)
    public void queNoSePuedaTenerUnVueloConMismoOrigenYDestino() {
    	
    	Vuelo v1 = givenVueloConLugaresIguales();
    	
    	whenGuardoVuelo(v1);
    	
    	thenSeGuardo(v1);

    }
    
    @Test
    public void queSeCalculeBienElTiempoEstimado() {
    	
    	Vuelo v1 = givenVueloCompleto();
    	
    	v1 = whenCalculoEstimado(v1);
    	
    	thenSeCalculoBien(v1);

    }
    
    private void thenSeCalculoBien(Vuelo v1) {
    	assertThat(v1.getHorasEstimadas()).isEqualTo(0);
    	assertThat(v1.getMinutosEstimados()).isEqualTo(5);
		assertThat(v1.getHorasEstimadas()).isNotNull();
		assertThat(v1.getMinutosEstimados()).isNotNull();
	}

	private Vuelo whenCalculoEstimado(Vuelo v1) {
		return servicioVuelo.setEstimadoDeVuelo(v1);
		
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
    
    private Vuelo givenVueloConLugaresIguales() {
		Vuelo v = new Vuelo();
		Date salida = new Date();
		Date llegada = new Date();
		Locacion destino = new Locacion();
		Locacion origen = new Locacion();
		SimpleDateFormat formato = new SimpleDateFormat ("dd-MM-yyyy HH:mm");
		
        try {
			salida=formato.parse("05-05-2005 15:55");
			llegada=formato.parse("05-05-2005 16:00");
	
		} catch (ParseException e) {
			e.printStackTrace();
		}
        
        destino.setCoordenadas("owowo");
		origen.setCoordenadas("owowo");
    	v.setId(new Random().nextLong());
    	v.setSalida(salida);
    	v.setLlegada(llegada);
    	v.setDestino(destino);
    	v.setOrigen(origen);

		return v;
	}

	private Vuelo givenVueloConFechasIguales() {
		Vuelo v = new Vuelo();
		Date salida = new Date();
		Date llegada = new Date();

		SimpleDateFormat formato = new SimpleDateFormat ("dd-MM-yyyy HH:mm");
			
        try {
			salida=formato.parse("05-05-2005 16:00");
			llegada=formato.parse("05-05-2005 16:00");
	
		} catch (ParseException e) {
			e.printStackTrace();
		}

    	v.setId(new Random().nextLong());
    	v.setSalida(salida);
    	v.setLlegada(llegada);

		return v;
	}
	
	
	private Vuelo givenVueloSinLlegada() {
		Vuelo v = new Vuelo();
		Date salida = new Date();
		SimpleDateFormat formato = new SimpleDateFormat ("dd-MM-yyyy HH:mm");
	
		try {
			salida=formato.parse("05-05-2005 15:55");

		} catch (ParseException e) {
			e.printStackTrace();
		}

    	v.setId(new Random().nextLong());
    
    	v.setSalida(salida);
	
		return v;
	}
	
	private Vuelo givenVueloSinSalida() {
		Vuelo v = new Vuelo();


    	v.setId(new Random().nextLong());
  	
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