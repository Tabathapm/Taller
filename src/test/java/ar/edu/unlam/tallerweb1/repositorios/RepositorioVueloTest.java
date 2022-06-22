package ar.edu.unlam.tallerweb1.repositorios;

import ar.edu.unlam.tallerweb1.SpringTest;
import ar.edu.unlam.tallerweb1.modelo.Tripulante;
import ar.edu.unlam.tallerweb1.modelo.Vuelo;
import ar.edu.unlam.tallerweb1.modelo.VueloTripulante;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioVuelo;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;

public class RepositorioVueloTest extends SpringTest {

    @Autowired
    private RepositorioVuelo repositorioVuelo;
     
    @Test
    @Transactional
    @Rollback
    public void sePuedenTraerVueloSinTripulacion() { //resolver
    	
    	Vuelo vueloA = new Vuelo();
    	Vuelo vueloB = new Vuelo();
    	Vuelo vueloC = new Vuelo();
    	
    	Tripulante tripA = new Tripulante();	
    	Tripulante tripC = new Tripulante();
    	
    	VueloTripulante vtA = new VueloTripulante();
    	VueloTripulante vtB = new VueloTripulante();
    	VueloTripulante vtC = new VueloTripulante();
    	
    	
    	vueloA.setNombre("VueloA");
    	vueloB.setNombre("VueloB");
    	vueloC.setNombre("VueloC");
    	
    	vtA.setTripulante(tripA);
    	vtA.setVuelo(vueloA);
    	
    	vtC.setTripulante(tripC);
    	vtC.setVuelo(vueloC);
    	
    	vtB.setVuelo(vueloB);
    	
    	session().save(vueloA);
    	session().save(vueloB);
    	session().save(vueloC);
    	
    	session().save(tripA);
    	session().save(tripC);
    	
    	session().save(vtA);
    	session().save(vtB);
    	session().save(vtC);
    	
    	List <Vuelo> vuelosEncontrados = repositorioVuelo.listarTodosLosVuelosSinTripulacion();
    //	List <VueloTripulante> vuelosEncontrados2 = repositorioVuelo.obtenerVuelosSinTripulacion();
    	
      //assertThat(vuelosEncontrados).isNotEmpty();
      //assertThat(vuelosEncontrados2.size()).isEqualTo(1);
      assertThat(vuelosEncontrados.size()).isEqualTo(1);
    	
//    	assertThat(vuelosEncontrados2.get(0).getVuelo().getNombre()).isEqualTo("VueloA");
    	 	
    }
    
    @Test
    @Transactional
    @Rollback
    public void sePuedenCalcularCorrectamenteLosEstimadosDeUnVuelo() {
    	
    	Vuelo v1 = givenVueloConFecha("v1");
    	
    	whenCalcularEstimado(v1);
    	
    	thenValidarCalculadoDeEstimado(v1);
    	 	
    }
    

	private void thenValidarCalculadoDeEstimado(Vuelo v1) {
		// TODO Auto-generated method stub
		
	}

	private void whenCalcularEstimado(Vuelo v1) {
		// TODO Auto-generated method stub
		
	}

	private Vuelo givenVueloConFecha(String nombre) {
		Vuelo v = new Vuelo();
		Date salida = new Date();
		Date llegada = new Date();
		SimpleDateFormat formato = new SimpleDateFormat ("dd-MM-yyyy HH:mm");
		
        try {
			salida=formato.parse("05-05-2005 15:55");
			llegada=formato.parse("05-05-2005 16:00");
	
		} catch (ParseException e) {
			e.printStackTrace();
		}
        
    	v.setId(new Random().nextLong());
    	v.setNombre(nombre);
    	v.setSalida(salida);
    	v.setLlegada(llegada);
    	
		return v;
	}
	
	

    
}