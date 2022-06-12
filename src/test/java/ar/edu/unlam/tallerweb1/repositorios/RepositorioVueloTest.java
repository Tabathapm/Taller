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

import java.util.List;

public class RepositorioVueloTest extends SpringTest {

    @Autowired
    private RepositorioVuelo repositorioVuelo;
    
    
    @Test
    @Transactional
    @Rollback
    public void sePuedenTraerVueloSinTripulacion() {
    	
    	Vuelo vueloA = new Vuelo();
    	Vuelo vueloB = new Vuelo();
    	Vuelo vueloC = new Vuelo();
    	
    	Tripulante tripA = new Tripulante();	
    	Tripulante tripC = new Tripulante();
    	
    	VueloTripulante vtA = new VueloTripulante();
    	VueloTripulante vtC = new VueloTripulante();
    	
    	
    	vueloA.setNombre("VueloA");
    	vueloB.setNombre("VueloB");
    	vueloC.setNombre("VueloC");
    	
    	vtA.setTripulante(tripA);
    	vtA.setVuelo(vueloA);
    	vtC.setTripulante(tripC);
    	vtC.setVuelo(vueloC);
    	

    	session().save(vueloA);
    	session().save(vueloB);
    	session().save(vueloC);
    	
    	session().save(tripA);
    	session().save(tripC);
    	
    	session().save(vtA);
    	session().save(vtC);
    	
    	List <Vuelo> vuelosEncontrados = repositorioVuelo.listarTodosLosVuelosSinTripulacion();
    	
    	//assertThat(vuelosEncontrados).isNotEmpty();
    	assertThat(vuelosEncontrados.size()).isEqualTo(1);
    	 	
    }

    
}