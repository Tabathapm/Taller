package ar.edu.unlam.tallerweb1.servicios;

import ar.edu.unlam.tallerweb1.excepciones.FechaYaOcupadaException;
import ar.edu.unlam.tallerweb1.excepciones.VueloSinFechaException;
import ar.edu.unlam.tallerweb1.modelo.Tripulante;
import ar.edu.unlam.tallerweb1.modelo.Vuelo;
import ar.edu.unlam.tallerweb1.modelo.VueloTripulante;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioTripulante;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioVuelo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
    public void asignarTripulantesAlVuelo(Vuelo vuelo, List<Tripulante> tripulantes) {
        repositorioTripulante.asignarTripulantesAlVuelo(vuelo,tripulantes);
    }

}