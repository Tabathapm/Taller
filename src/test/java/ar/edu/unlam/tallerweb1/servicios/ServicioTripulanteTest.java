package ar.edu.unlam.tallerweb1.servicios;
import ar.edu.unlam.tallerweb1.excepciones.FechaNoDisponibleException;
import ar.edu.unlam.tallerweb1.excepciones.TripulanteNoDisponibleParaEsaFechaException;
import ar.edu.unlam.tallerweb1.excepciones.TripulanteSinVueloException;
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
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

public class ServicioTripulanteTest {

    private static final String nv1 = "v1";
    private static final String nt1 = "t1";
    private static final String nv2 = "v2";
    private static final String nv3 = "v3";
    private static final String nt2 = "t2";
    
    private RepositorioTripulante repositorioTripulante = mock(RepositorioTripulante.class);
    private RepositorioVuelo repositorioVuelo = mock(RepositorioVuelo.class);
    private ServicioTripulanteImpl servicioTripulante = new ServicioTripulanteImpl(repositorioTripulante,repositorioVuelo);
    
    
    @Test
    public void obtenerVueloMasCercanoTest() {
    	
    	Vuelo v1 = givenVueloCompletoConstructor("25-05-2022 18:00","25-05-2022 21:00");
    	
    	Vuelo v2 = givenVueloCompletoConstructor("22-02-2022 15:00","22-02-2022 16:00");
    	Vuelo v3 = givenVueloCompletoConstructor("23-06-2022 15:00","23-06-2022 16:00");
    	Vuelo v4 = givenVueloCompletoConstructor("24-05-2022 15:00","24-05-2022 16:00");
    	Vuelo v5 = givenVueloCompletoConstructor("25-06-2022 15:00","25-06-2022 16:00");
    	Vuelo v6 = givenVueloCompletoConstructor("26-07-2022 15:00","26-07-2022 16:00");
    	Vuelo v7 = givenVueloCompletoConstructor("27-06-2022 15:00","27-06-2022 16:00");
    	Vuelo v8 = givenVueloCompletoConstructor("30-08-2022 15:00","30-08-2022 16:00");
		Tripulante t1 = givenTripulante("t1");
		VueloTripulante vt1 = givenVT(v2,t1);
		VueloTripulante vt2 = givenVT(v3,t1);
		VueloTripulante vt3 = givenVT(v4,t1);
		VueloTripulante vt4 = givenVT(v5,t1);
		VueloTripulante vt5 = givenVT(v6,t1);
		VueloTripulante vt6 = givenVT(v7,t1);
		VueloTripulante vt7 = givenVT(v8,t1);
		List <VueloTripulante> vt = new ArrayList<>();
		vt.add(vt1);
		vt.add(vt2);
		vt.add(vt3);
		vt.add(vt4);
		vt.add(vt5);
		vt.add(vt6);
		vt.add(vt7);

    	Vuelo vE=whenObtengoElVuelo(vt,v1);
  	
    	thenSeObtuvoElVueloCorrecto(vE,v1);

    }
    
    
    private void thenSeObtuvoElVueloCorrecto(Vuelo vE,Vuelo v1) {
//    	System.out.println(v1.getSalida());
//    	System.out.println(vE.getSalida());
		assertThat(v1.getSalida().after(vE.getSalida())).isTrue();
		
	}


	private Vuelo whenObtengoElVuelo(List<VueloTripulante> vt,Vuelo v1) {

		return servicioTripulante.obtenerVueloMasCercano(vt, v1);
	}


	@Test
    public void queSePuedaAsignarUnTripulanteAUnVueloSinOtrosVuelos() {
    	
    	Vuelo v1 = givenVueloCompletoConstructor("20-06-2022 15:00","20-06-2022 16:00");
		Vuelo v2 = givenVueloCompletoConstructor("18-06-2022 13:00","18-06-2022 14:00");
		Tripulante t1 = givenTripulante("t1");

    	VueloTripulante vt=whenAsignoTripulanteAVuelo(v1,t1);
  	
    	thenSeAsignoCorrectamente(v1,t1,vt);

    }
    
    @Test(expected = FechaNoDisponibleException.class)
    public void queSeObtengaFechaNoDisponibleExceptionParaFechaRepetida() {
    	
    	Vuelo v1 = givenVueloCompletoConstructor("20-06-2022 15:00","20-06-2022 16:00");
		Tripulante t1 = givenTripulante("t1");
		VueloTripulante vt1 = givenVT(v1,t1);
		List <VueloTripulante> vt = new ArrayList<>();
		vt.add(vt1);

		when(repositorioTripulante.obtenerVuelosDeTripulante(t1)).thenReturn(vt);

    	VueloTripulante vtO=whenAsignoTripulanteAVuelo(v1,t1);
  	
    	thenSeAsignoCorrectamente(v1,t1,vtO);

    }
    
    @Test(expected = TripulanteNoDisponibleParaEsaFechaException.class)
    public void queNoSePuedaAsignarUnTripulanteAUnVueloConOtrosVuelos() {
    	
    	// +5 horas descanso
		// a partir de 21
    	Vuelo v1 = givenVueloCompletoConstructor("20-06-2022 13:00","20-06-2022 16:00");
		Vuelo v2 = givenVueloCompletoConstructor("18-06-2022 13:00","18-06-2022 16:00");
		Vuelo v3 = givenVueloCompletoConstructor("20-06-2022 20:00","20-06-2022 20:00"); 
		Tripulante t1 = givenTripulante("t1");
		VueloTripulante vt1 = givenVT(v1,t1);
		VueloTripulante vt2 = givenVT(v2,t1);
		List <VueloTripulante> vt = new ArrayList<>();
		vt.add(vt1);
		vt.add(vt2);
		
		when(repositorioTripulante.obtenerVuelosDeTripulante(t1)).thenReturn(vt);

    	VueloTripulante vtO=whenAsignoTripulanteAVuelo(v3,t1);
  	
    	thenNoSeAsignoCorrectamente(v3,t1,vtO);

    }

    
    private void thenNoSeAsignoCorrectamente(Vuelo v1, Tripulante t1, VueloTripulante vtO) {
    	assertThat(v1).isNotNull();
		assertThat(t1).isNotNull();
		
		verify(repositorioTripulante,times(0)).asignarUnTripulanteAvuelo(v1,t1);
		
	}

	private void thenSeAsignoCorrectamente(Vuelo v1, Tripulante t1,VueloTripulante vt) {
		assertThat(v1).isNotNull();
		assertThat(t1).isNotNull();
		
		verify(repositorioTripulante,times(1)).asignarUnTripulanteAvuelo(v1,t1);
	}

	private VueloTripulante whenAsignoTripulanteAVuelo(Vuelo v1, Tripulante t1) {
		return servicioTripulante.asignarUnTripulanteAvuelo(v1, t1);
		
	}

	@Test
	public void queSeObtengaElPrimerVueloDelTripulante() {
		
    	Vuelo v1 = givenVueloCompletoConstructor("20-06-2022 15:00","20-06-2022 16:00");
		Vuelo v2 = givenVueloCompletoConstructor("18-06-2022 13:00","18-06-2022 14:00");
		Tripulante t1 = givenTripulante("t1");
		VueloTripulante vt1 = givenVT(v1,t1);
		VueloTripulante vt2 = givenVT(v2,t1);
		List <VueloTripulante> vtl = new ArrayList<>();
		vtl.add(vt1);
		vtl.add(vt2);
		
		when(repositorioTripulante.obtenerVuelosDeTripulante(t1)).thenReturn(vtl);
		
		Vuelo obtenido = whenTengoVuelos(t1);
		
		thenSeObtieneElVuelo(obtenido,v2);
			
	}
    
    @Test(expected = TripulanteSinVueloException.class)
	public void queNoSeObtengaElPrimerVueloDelTripulante() {
		
		VueloTripulante a = givenVTVacio();
		Tripulante t = givenTripulante("t1");
		
		whenNoTengoVuelos(t);
		
		
	}
   /* 
    @Test
	 public void queNoSePuedaAsignarUnTripulanteAUnVueloEnLaMismaFecha() { //No se puede resolver, requiere repo funcional 
	    																	// usar when()
	    	Vuelo v1 = givenVueloConFecha(nv1);
	    	Vuelo v2 = givenVueloConFecha(nv2);

	    	Tripulante t1 = givenTripulante(nt1);
	    	
	    	whenAsignoTripulanteAVuelo(v1,t1);
	    	
	    	whenAsignoTripulanteAVuelo(v2,t1);
	    	
	    	
	    	thenNoSeAsigno(v1,v2,t1);
	    	
	
	    }
    */
    @Test
	public void queSeCalculenCorrectamenteLasHorasDeActivoYDescansoDeUnTripulante() { 
    	
	    	Vuelo v1 = givenVueloCompletoConstructor("20-06-2022 15:00","20-06-2022 16:00");
			Vuelo v2 = givenVueloCompletoConstructor("18-06-2022 13:00","18-06-2022 14:00");
			Tripulante t1 = givenTripulante("t1");
			VueloTripulante vt1 = givenVT(v1,t1);
			VueloTripulante vt2 = givenVT(v2,t1);
			List <VueloTripulante> vtl = new ArrayList<>();
			vtl.add(vt1);
			vtl.add(vt2);
			
			when(repositorioTripulante.obtenerVuelosDeTripulante(t1)).thenReturn(vtl);
			

	    	Tripulante t1B = whenCalculoLasHoras(t1);
	    	
	    	
	    	thenSeCalculo(t1B);
	    	
	
	    }
    
    
    @Test
	public void queCheckActivoRetorneTrueTest() { 
    	
	    	Vuelo vRegistrado = givenVueloCompletoConstructor("20-06-2022 15:00","20-06-2022 17:00");
			Vuelo vEntrante = givenVueloCompletoConstructor("21-06-2022 17:00","21-06-2022 20:00");
			
	    	Boolean resultado = whenCheckActivo(vRegistrado,vEntrante);
	    	
	    	thenSeObtuvoTrue(resultado);
	    	
	    }
    
    @Test
   	public void queCheckActivoRetorneFalseTest() { 
       	
   	    	Vuelo vRegistrado = givenVueloCompletoConstructor("20-06-2022 13:00","20-06-2022 16:00"); // +5 horas descanso
   			Vuelo vEntrante = givenVueloCompletoConstructor("20-06-2022 20:00","20-06-2022 24:00"); // a partir de 21
   			
   	    	Boolean resultado = whenCheckActivo(vRegistrado,vEntrante);
   	    	
   	    	thenSeObtuvoFalse(resultado);
   	    	
   	    }
    
	private void thenSeObtuvoFalse(Boolean resultado) {
    	assertThat(resultado).isFalse();
		
	}

	private void thenSeObtuvoTrue(Boolean resultado) {
		assertThat(resultado).isTrue();
		
	}

	private Boolean whenCheckActivo(Vuelo v1, Vuelo v2) {
		return servicioTripulante.checkActivo(v1,v2);
	}

	private void thenSeCalculo(Tripulante t) {
		assertThat(t.getHorasActivo()).isNotNull();
		assertThat(t.getHorasDescanso()).isNotNull();
		
		System.out.println(t.getHorasActivo() + "" + t.getHorasDescanso());
		
	}

	private Tripulante whenCalculoLasHoras(Tripulante t1) {
		return servicioTripulante.setHorasDeTripulante(t1);
		
	}

	private void thenSeObtieneElVuelo(Vuelo v1,Vuelo v2) {
		assertThat(v1).isNotNull();
		assertThat(v1.getSalida().before(v2.getSalida()));
		
	}

	private Vuelo whenTengoVuelos(Tripulante t) {
		return servicioTripulante.obtenerPrimerVueloDeTripulante(t);
		
	}
	
	private void whenNoTengoVuelos(Tripulante t) {
		servicioTripulante.obtenerPrimerVueloDeTripulante(t);
		
	}

	

	private void thenNoSeAsigno(Vuelo v1,Vuelo v2,Tripulante t) {
	
	 	verify(repositorioTripulante,times(1)).asignarUnTripulanteAvuelo(v1,t);
	  	verify(repositorioTripulante,times(1)).asignarUnTripulanteAvuelo(v2,t);
	    	
	    }


    private Tripulante givenTripulante(String nombre) {
    	Tripulante t = new Tripulante();
    	t.setId(new Random().nextLong());
    	t.setNombre(nombre);
   	
		return t;
	}

    private VueloTripulante givenVTVacio() {
		VueloTripulante vt = new VueloTripulante();
		return vt;
	}
	
	private VueloTripulante givenVT(Vuelo v,Tripulante t) {
		VueloTripulante vt = new VueloTripulante();
		vt.setVuelo(v);
		vt.setTripulante(t);
		
		return vt;
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
	
	private Tripulante givenTripulanteCompleto(String nombre,String titulo) {
		Tripulante t = new Tripulante();
		
		t.setNombre(nombre);
		t.setTitulo(titulo);
		
		return t;
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