package ar.edu.unlam.tallerweb1.repositorios;

import ar.edu.unlam.tallerweb1.SpringTest;
import ar.edu.unlam.tallerweb1.modelo.Tripulante;
import ar.edu.unlam.tallerweb1.modelo.Vuelo;
import ar.edu.unlam.tallerweb1.modelo.VueloTripulante;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioTripulante;

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

public class RepositorioTripulanteTest extends SpringTest {

    @Autowired
    private RepositorioTripulante repositorioTripulante;
    
    private static final String nv1 = "v1";
    private static final String nv2 = "v2";
    private static final String nv3 = "v3";
    private static final String nt1 = "t1";
    private static final String nt2 = "t2";
    
    
    @Test
    @Transactional
    @Rollback
    public void queSePuedaAgregarUnTripulanteQueYaEstaEnUnVuelo() {
    	
    	Vuelo vueloA = new Vuelo();
    	Vuelo vueloC = new Vuelo();
    	
    	Tripulante tripA = new Tripulante();	

   	
    	VueloTripulante vtA = new VueloTripulante();
    	VueloTripulante vtC = new VueloTripulante();
    	
    	
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
    
    @Test
    @Transactional
    @Rollback
    public void queSePuedaAsignarUnTripulanteAUnVuelo() {
    	
    	Vuelo v1 = givenVuelo(nv1);
    	Tripulante t1 = givenTripulante(nt1);
    	
    	session().save(v1);
    	session().save(t1);
    	  	
    	VueloTripulante vt1 = repositorioTripulante.asignarUnTripulanteAvuelo(v1, t1);
    	
    	assertThat(vt1).isNotNull();
    	assertThat(vt1.getVuelo()).isNotNull();
    	assertThat(vt1.getVuelo().equals(v1));
    	assertThat(vt1.getTripulante().equals(t1));
    }
    
    @Test
    @Transactional
    @Rollback
    public void queSePuedanObtenerLasFechasDeUnTripulante() {
    	
    	Vuelo v1 = givenVuelo(nv1);
    	Tripulante t1 = givenTripulante(nt1);
    	Tripulante t2 = givenTripulante(nt2);
    	Vuelo v2 = givenVuelo(nv2);
    	Vuelo v3 = givenVuelo(nv3);
    	
    	SimpleDateFormat formato = new SimpleDateFormat ("dd-MM-yyyy HH:mm");
        Date f1= new Date();
        Date f2= new Date();
        Date f3= new Date();
        
        VueloTripulante vtA = new VueloTripulante();
        VueloTripulante vtB = new VueloTripulante();
    	VueloTripulante vtC = new VueloTripulante();
    	

        try {
			f1=formato.parse("05-05-2005 15:55");
			f2=formato.parse("05-07-2005 15:55");
			f3=formato.parse("05-06-2005 15:55");
			
		} catch (ParseException e) {
			
			e.printStackTrace();
		}

        v1.setSalida(f1);
        v2.setSalida(f2);
        v3.setSalida(f3);
        
        vtA.setTripulante(t1);
    	vtA.setVuelo(v1);
    	vtB.setTripulante(t1);
    	vtB.setVuelo(v2);
    	vtC.setTripulante(t2);
    	vtC.setVuelo(v3);

    	
    	session().save(t1);
    	session().save(t2);
    	session().save(v1);
    	session().save(v2);
    	session().save(v3);
    	session().save(vtA);
    	session().save(vtB);
    	session().save(vtC);
    	
    	  	
    	List <VueloTripulante> a = repositorioTripulante.obtenerVuelosDeTripulante(t1);
    	
    	 String nombre = a.get(0).getTripulante().getNombre();

    	assertThat(nombre.equals(nt1));
    	assertThat(a.size()).isEqualTo(2);
    	assertThat(a.get(0).getVuelo().getSalida().equals(f1));
    	assertThat(a.get(0).getVuelo().getSalida()).isNotEqualTo(f2);
    }
    
 
    @Test
    @Transactional
    @Rollback
    public void queNoSePuedaAgregarUnTripulanteQueYaEstaEnUnVueloAUnVueloEnLaMismaFecha() {
    	
    	Vuelo vueloA = new Vuelo();
    	Vuelo vueloC = new Vuelo();
    	
    	Tripulante tripA = new Tripulante();	

   	
    	VueloTripulante vtA = new VueloTripulante();
    	VueloTripulante vtC = new VueloTripulante();
    	
    	
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
}