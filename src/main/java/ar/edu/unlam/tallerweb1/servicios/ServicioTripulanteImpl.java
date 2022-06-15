package ar.edu.unlam.tallerweb1.servicios;

import ar.edu.unlam.tallerweb1.excepciones.FechaYaOcupadaException;
import ar.edu.unlam.tallerweb1.excepciones.TripulanteSinVueloException;
import ar.edu.unlam.tallerweb1.excepciones.VueloSinFechaException;
import ar.edu.unlam.tallerweb1.modelo.Tripulante;
import ar.edu.unlam.tallerweb1.modelo.Vuelo;
import ar.edu.unlam.tallerweb1.modelo.VueloTripulante;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioTripulante;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioVuelo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

import java.util.List;


@Service
public class ServicioTripulanteImpl implements ServicioTripulante {

    RepositorioTripulante repositorioTripulante;
    RepositorioVuelo repositorioVuelo;

    @Autowired
    public ServicioTripulanteImpl(RepositorioTripulante repositorioTripulante,RepositorioVuelo repositorioVuelo) {
        this.repositorioTripulante = repositorioTripulante;
        this.repositorioVuelo = repositorioVuelo;
        
    }
    
    @Override
    public List<Tripulante> listarTodosLosTripulantes() {
    	
    	return repositorioTripulante.listarTodosLosTripulantes();
    	
    	}

    @Override
    public List<Tripulante> listaTodosLosPilotos() {
    	return repositorioTripulante.listarTodosLosPilotos(); 
    	
    	}

    @Override
    public List<Tripulante> listaTodosLosCopilotos() { 
    	return repositorioTripulante.listaTodosLosCopilotos();
    	}

    @Override
    public List<Tripulante> listaTodosLosIngenieros() { 
    	return repositorioTripulante.listaTodosLosIngenieros();
    	}

    @Override
    public List<Tripulante> listarTodosLosTripulantesDeVuelo() {
        return repositorioTripulante.listarTodosLosTripulantesDeVuelo();
    }

    @Override
    public List<Tripulante> tripulacionAsignada(Vuelo vuelo) {
    	return repositorioTripulante.tripulacionAsignada(vuelo); 
    	}

    @Override
    public VueloTripulante asignarUnTripulanteAvuelo(Vuelo vuelo, Tripulante tripulante){
    	
    	List <VueloTripulante> vt = repositorioTripulante.obtenerVuelosDeTripulante(tripulante);
    	
    	Date fecha = vuelo.getSalida();
    	
    	if(fecha==null) {
    		throw new VueloSinFechaException();
    	}
    	
    	Date fechaObtenida;
    	
    	for (int i = 0; i < vt.size(); i++) {
    		
    		fechaObtenida = vt.get(i).getVuelo().getSalida();
    		
    		if(vt.get(i).getVuelo().getSalida().equals(fecha)) 
    			throw new FechaYaOcupadaException();
	
		}
  
       return repositorioTripulante.asignarUnTripulanteAvuelo(vuelo,tripulante);
    }
    
    @Override
    public Vuelo obtenerPrimerVueloDeTripulante(Tripulante tripulante) {

    	List<VueloTripulante> vt=repositorioTripulante.obtenerVuelosDeTripulante(tripulante);
    	Vuelo vueloEncontrado = new Vuelo();
    	
    	if(vt.size()==0) {
    		throw new TripulanteSinVueloException();
    	}
    	
    	vueloEncontrado = vt.get(0).getVuelo();
	
    	for (int i = 0; i < vt.size(); i++) {
    			if(vueloEncontrado.getSalida().after(vt.get(i).getVuelo().getSalida())) {
    				vueloEncontrado = vt.get(i).getVuelo();
    			}	
		}
    		
	   return vueloEncontrado;  
    }
    

    @Override
	public Tripulante setHorasActivoDeTripulante(Tripulante t) {
	   	
    	Vuelo vueloObtenido = obtenerPrimerVueloDeTripulante(t);
    	
    	Date salidaVuelo = vueloObtenido.getSalida();
    	Date llegadaVuelo = vueloObtenido.getLlegada();
    	Date hoy = new Date();
    	

    	Long horasDesdeSalida = ( ((hoy.getTime()-salidaVuelo.getTime()) /60000)/60);
    	Long horasDesdeLlegada = ( ((hoy.getTime()-llegadaVuelo.getTime()) /60000)/60);
    	Long horasActivo = 0L;
    	Long horasDescanso = 0L;
    	
    	
    	if(hoy.after(salidaVuelo)) 
    	    horasActivo = horasDesdeSalida;
    	
    	if(hoy.after(llegadaVuelo))
    		horasDescanso = horasDesdeLlegada;
    	
    	if(horasDescanso+2L>horasActivo)
    		horasActivo=0L;
    	
    	t.setHorasActivo(horasActivo);
    	t.setHorasDecanso(horasDescanso);

    	
		return t;
	}

	@Override
	public Tripulante setHorasDescansoDeTripulante(Tripulante t) {
		
		return t;
	}
    
 
	@Override
	public void calcularTripulanteDisponibleParaVuelo(Vuelo v, Tripulante t) {
		// TODO Auto-generated method stub
		
	}

	@Override //To do
    public void asignarTripulantesAlVuelo(Vuelo vuelo, List<Tripulante> tripulantes) {
        repositorioTripulante.asignarTripulantesAlVuelo(vuelo,tripulantes);
    }

}