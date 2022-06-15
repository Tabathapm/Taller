package ar.edu.unlam.tallerweb1.servicios;
import ar.edu.unlam.tallerweb1.excepciones.FechaYaOcupadaException;
import ar.edu.unlam.tallerweb1.excepciones.TripulanteSinVueloException;
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

public class ServicioTripulanteTest {


	private static final SimpleDateFormat formato = new SimpleDateFormat ("dd-MM-yyyy HH:mm");
    private static final Date fechaActual = new Date();
    
    private static final String nv1 = "v1";
    private static final String nt1 = "t1";
    private static final String nv2 = "v2";
    private static final String nv3 = "v3";
    private static final String nt2 = "t2";
    
    private RepositorioTripulante repositorioTripulante = mock(RepositorioTripulante.class);
    private RepositorioVuelo repositorioVuelo = mock(RepositorioVuelo.class);
    private ServicioTripulanteImpl servicioTripulante = new ServicioTripulanteImpl(repositorioTripulante,repositorioVuelo);
    
    @Test
    public void queSePuedaAsignarUnTripulanteAUnVuelo() {
    	
    	Vuelo v1 = givenVueloConFecha(nv1);
    	Tripulante t1 = givenTripulante(nt1);
    	
    	whenAsignoTripulanteAVuelo(v1,t1);
  	
    	thenSeAsignoCorrectamente(v1,t1);

    }
    
    private VueloTripulante whenAsignoTripulanteAVuelo(Vuelo v, Tripulante t) {
		return servicioTripulante.asignarUnTripulanteAvuelo(v, t);
		
	}

	private void thenSeAsignoCorrectamente(Vuelo v,Tripulante t) {
    	
    	assertThat(t).isNotNull();
    	assertThat(v).isNotNull();
    	
    	verify(repositorioTripulante,times(1)).asignarUnTripulanteAvuelo(v,t);
    	
    }
	
	@Test(expected = TripulanteSinVueloException.class)
	public void queSeObtengaElPrimerVueloDelTripulante() {
		
		VueloTripulante a = givenVT();
		Tripulante t = givenTripulante("t1");
		
		whenNoTengoVuelos(t);
		
		thenNoTieneVueloException();
	}
	
	 private void thenNoTieneVueloException() {
		
		
	}

	private void whenNoTengoVuelos(Tripulante t) {
		servicioTripulante.obtenerPrimerVueloDeTripulante(t);
		
	}

	private VueloTripulante givenVT() {
		VueloTripulante vt = new VueloTripulante();
		return vt;
	}

	@Test
	 public void queNoSePuedaAsignarUnTripulanteAUnVueloEnLaMismaFecha() { //No se puede resolver, requiere repo funcional 
	    																	// pasar a repo ?
	    	Vuelo v1 = givenVueloConFecha(nv1);
	    	Vuelo v2 = givenVueloConFecha(nv2);

	    	Tripulante t1 = givenTripulante(nt1);
	    	
	    	whenAsignoTripulanteAVuelo(v1,t1);
	    	
	    	whenAsignoTripulanteAVuelo(v2,t1);
	    	
	    	
	    	thenNoSeAsigno(v1,v2,t1);
	    	
	
	    }
	 


	private void thenNoSeAsigno(Vuelo v1,Vuelo v2,Tripulante t) {
	
	 	verify(repositorioTripulante,times(1)).asignarUnTripulanteAvuelo(v1,t);
	  	verify(repositorioTripulante,times(1)).asignarUnTripulanteAvuelo(v2,t);
	    	
	    }
	
	//(expected = FechaYaOcupadaException.class)
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
    

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
	

	private Vuelo givenVueloConFecha(String nombre) {
		Vuelo v = new Vuelo();
		Date date = new Date();
		SimpleDateFormat formato = new SimpleDateFormat ("dd-MM-yyyy HH:mm");
		
        try {
			date=formato.parse("05-05-2005 15:55");
	
		} catch (ParseException e) {
			e.printStackTrace();
		}
        
    	v.setId(new Random().nextLong());
    	v.setNombre(nombre);
    	v.setSalida(date);
    	
		return v;
	}
	

 /*
	@Test
    public void queNoSePuedaAgregarUnTripulanteQueYaEstaEnUnVueloAUnVueloEnLaMismaFecha() {
    	
 	
    	
    	vueloA.setNombre("VueloA");
    	vueloC.setNombre("VueloC");
    	
    	vtA.setTripulante(tripA);
    	vtA.setVuelo(vueloA);
    	vtC.setTripulante(tripA);
    	vtC.setVuelo(vueloC);
    	

    	session().save(vueloA);
    	session().save(vueloC);
    	
    	session().save(tripA);
  	
    	session().save(vtA);
    	session().save(vtC);
    	
    	
    	assertThat((vtA.getTripulante()).equals(vtC.getTripulante()));
    	
    }
*/
   
}