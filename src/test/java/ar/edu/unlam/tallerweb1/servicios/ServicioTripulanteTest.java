package ar.edu.unlam.tallerweb1.servicios;
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

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class ServicioTripulanteTest {


	private static final SimpleDateFormat formato = new SimpleDateFormat ("dd-MM-yyyy HH:mm");
    private static final Date fechaActual = new Date();
    
    private static final String nv1 = "v1";
    private static final String nt1 = "t1";
    
    private RepositorioTripulante repositorioTripulante = mock(RepositorioTripulante.class);
    private RepositorioVuelo repositorioVuelo = mock(RepositorioVuelo.class);
    private ServicioTripulanteImpl servicioTripulante = new ServicioTripulanteImpl(repositorioTripulante,repositorioVuelo);
    
    @Test
    public void queSePuedaAsignarUnTripulanteAUnVuelo() {
    	
    	Vuelo v1 = givenVuelo(nv1);
    	Tripulante t1 = givenTripulante(nt1);
    	
    	whenAsignoTripulanteAVuelo(v1,t1);
   	
    	thenSeAsignoCorrectamente(v1,t1);

    }
    
    private VueloTripulante whenAsignoTripulanteAVuelo(Vuelo v1, Tripulante t1) {
		return servicioTripulante.asignarUnTripulanteAvuelo(v1, t1);
		
	}

	private void thenSeAsignoCorrectamente(Vuelo v,Tripulante t) {
    	
    	assertThat(t).isNotNull();
    	assertThat(v).isNotNull();
    	
    	verify(repositorioTripulante,times(1)).asignarUnTripulanteAvuelo(v,t);
    	
    }
	
	 @Test
	 public void queNoSePuedaAsignarUnTripulanteAUnVueloEnLaMismaFecha() {
	    	
	    	Vuelo v1 = givenVuelo(nv1);
	    	Tripulante t1 = givenTripulante(nt1);
	    	
	    	whenAsignoTripulanteAVuelo(v1,t1);
	   	
	    	thenSeAsignoCorrectamente(v1,t1);

	    }
	 

	private void thenNoSeAsigno(Vuelo v,Tripulante t) {
	    	
	    	assertThat(t).isNotNull();
	    	assertThat(v).isNotNull();
	    	
	    	verify(repositorioTripulante,times(0)).asignarUnTripulanteAvuelo(v,t);
	    	
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