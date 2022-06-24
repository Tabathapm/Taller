package ar.edu.unlam.tallerweb1.servicios;

import ar.edu.unlam.tallerweb1.controladores.TripulanteInfo;
import ar.edu.unlam.tallerweb1.excepciones.FechaNoDisponibleException;
import ar.edu.unlam.tallerweb1.excepciones.TripulanteNoDisponibleParaEsaFechaException;
import ar.edu.unlam.tallerweb1.excepciones.TripulanteSinVueloException;
import ar.edu.unlam.tallerweb1.excepciones.VueloSinFechaException;
import ar.edu.unlam.tallerweb1.modelo.Tripulante;
import ar.edu.unlam.tallerweb1.modelo.Vuelo;
import ar.edu.unlam.tallerweb1.modelo.VueloDos;
import ar.edu.unlam.tallerweb1.modelo.VueloTripulante;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioTripulante;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioVuelo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
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
    public VueloTripulante asignarUnTripulanteAvuelo(Long vuelo, Long tripulante){
    	
    	Tripulante t = repositorioTripulante.traerTripulante(tripulante);
    	Vuelo v = repositorioVuelo.consultarVuelo(vuelo);
    	
    	List <VueloTripulante> vt = repositorioTripulante.obtenerVuelosDeTripulante(t);
    	
    	if(vt.isEmpty())
    		return repositorioTripulante.asignarUnTripulanteAvuelo(v,t);
    	
    	Vuelo encontrado=obtenerVueloMasCercano(vt,v);
    	
    	if(determinarSiDisponible(encontrado,v))
           return repositorioTripulante.asignarUnTripulanteAvuelo(v,t);
    	else
    		throw new TripulanteNoDisponibleParaEsaFechaException();
    }
    
	@Override
	public Boolean determinarSiDisponible(Vuelo encontrado, Vuelo entrante) { 
		
		Date salida = entrante.getSalida();
		Date llegadaRegistrado = encontrado.getLlegada();
		Date salidaRegistrado = encontrado.getSalida();
		
		if(salida==null) {
    		throw new VueloSinFechaException();
    	}
		
		if(salida.after(salidaRegistrado)&&salida.before(llegadaRegistrado)||salida.equals(salidaRegistrado)) 
			throw new FechaNoDisponibleException();
			
		if(checkActivo(encontrado,entrante))
			return true;			
			

		return false;
	}
	
	@Override
    public Vuelo obtenerVueloMasCercano(List<VueloTripulante> vt,Vuelo v) {
		
		if(v.getSalida()==null) {
    		throw new VueloSinFechaException();
    	}

		Date salida = v.getSalida();
		Date fechaEncontradaA = new Date();
		Date fechaEncontradaB = new Date();
    	Vuelo vueloEncontrado = new Vuelo();
    	
    	vueloEncontrado = vt.get(0).getVuelo();
	
    	for (int i = 0; i < vt.size(); i++) {
    		for (int j = 1; j < vt.size(); j++) {
				
    		fechaEncontradaA = vt.get(i).getVuelo().getSalida();	
    		fechaEncontradaB = vt.get(j).getVuelo().getSalida();
        		
    			if(salida.after(fechaEncontradaA)&&salida.before(fechaEncontradaB)) 
    			   vueloEncontrado = vt.get(i).getVuelo();			
    		}	
    	}
    		
	   return vueloEncontrado;  
    }
		
	 @Override
		public Boolean checkActivo(Vuelo vReg,Vuelo vEnt) {
		   	
	    	Date salidaVuelo = vReg.getSalida();
	    	Date llegadaVuelo = vReg.getLlegada();
	    	Date salidaEntrante = vEnt.getSalida();
	    	Boolean nocturno = false;

	    	
			Long horasActivo =   (((llegadaVuelo.getTime()-salidaVuelo.getTime()) /60000)/60);
			Long minutosActivo =   (((llegadaVuelo.getTime()-salidaVuelo.getTime()) /60000));
			Long minutosDescanso = ( ((salidaEntrante.getTime()-llegadaVuelo.getTime()) /60000));
			Long horasDescanso = ( ((salidaEntrante.getTime()-llegadaVuelo.getTime()) /60000)/60);
	    	
			if(salidaVuelo.getHours()>=23L||salidaVuelo.getHours()<=6L||
					llegadaVuelo.getHours()>=23L||llegadaVuelo.getHours()<=6L)
				nocturno = true;

			if(!nocturno)
			if(horasDescanso>=(2L+horasActivo)&&minutosDescanso>=(120L+minutosActivo)) 
				return true;	

			
			if(nocturno)
			if(horasDescanso>=(4L+horasActivo)&&minutosDescanso>=(240L+minutosActivo)) 
				return true;	
			
			return false;
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
	 
	 

	 @Override //To do
	    public void asignarTripulantesAlVuelo(Vuelo v, List<Tripulante> tripulantes) {
	        repositorioTripulante.asignarTripulantesAlVuelo(v,tripulantes);
	    }
	 
	 
	 // Deprecado
	 
	 @Override
	    public void fechaDisponibleParaTripulante(List<VueloTripulante> vt,Vuelo vuelo) { 
	    	//agregar calculo para saber si el tripulante esta en vuelo o en descanso para el vuelo al que se lo quiere agregar
	    	Date fecha = vuelo.getSalida();
	    	
	    	if(fecha==null) {
	    		throw new VueloSinFechaException();
	    	}
	    	
	    	
	    	for (int i = 0; i < vt.size(); i++) {

	    		if(vt.get(i).getVuelo().getSalida()!=(null))
	    		if(vt.get(i).getVuelo().getSalida().equals(fecha)) 
	    			throw new FechaNoDisponibleException();
		
			}
	    }
	 
	 @Override
		public Tripulante setHorasDeTripulante(Tripulante t) {
		   	
	    	Vuelo vueloObtenido = obtenerPrimerVueloDeTripulante(t);
	    	
	    	Date salidaVuelo = vueloObtenido.getSalida();
	    	Date llegadaVuelo = vueloObtenido.getLlegada();
	    	Boolean nocturno = false;
	    	Date hoy = new Date();
	    	hoy.getTime();
	    	

	    	Long horasDesdeSalida = ( ((hoy.getTime()-salidaVuelo.getTime()) /60000)/60);
			Long horasActivo =   (((llegadaVuelo.getTime()-salidaVuelo.getTime()) /60000)/60);
			Long minutosActivo =   (((llegadaVuelo.getTime()-salidaVuelo.getTime()) /60000));
			Long minutosDesdeLlegada = ( ((hoy.getTime()-llegadaVuelo.getTime()) /60000));
			Long horasDescanso = ( ((hoy.getTime()-llegadaVuelo.getTime()) /60000)/60);
	    	
			if(salidaVuelo.getHours()>=23L||salidaVuelo.getHours()<=6L||llegadaVuelo.getHours()>=23L||llegadaVuelo.getHours()<=6L)
				nocturno = true;
			
			if(hoy.after(salidaVuelo)&&hoy.before(llegadaVuelo)) 
			    horasActivo = horasDesdeSalida;
			
		
			if(hoy.after(llegadaVuelo)) 
			 t.setHorasDescanso(horasDescanso);
			else
			 t.setHorasDescanso(0L);
			
			
			if(!nocturno)
			if(minutosDesdeLlegada+120L>minutosActivo&&horasDescanso>=2L) 
				horasActivo=0L;	
			
			
			if(nocturno)
			if(minutosDesdeLlegada+240L>minutosActivo&&horasDescanso>=4L) 
				horasActivo=0L;	
			
	    	t.setHorasActivo(horasActivo);
	    	
	    	
			return t;
		} 
	 
	 @Override
		public Tripulante traerTripulante(Long id){
			return repositorioTripulante.traerTripulante(id);
		}
//	 
//	 @Override
//		public Boolean determinarSiDisponible(List<VueloTripulante> vt, Vuelo v) { 
//			
//			Date salida = v.getSalida();
//			Date llegadaRegistrado = new Date();
//			Date salidaRegistrado = new Date();
//			Date siguienteSalida = new Date();
//			
//			if(salida==null) {
//	    		throw new VueloSinFechaException();
//	    	}
//			
//			for (int i = 0; i < vt.size(); i++) {
//
//				llegadaRegistrado = vt.get(i).getVuelo().getLlegada();
//				salidaRegistrado = vt.get(i).getVuelo().getSalida();
//
//				if(salida.after(salidaRegistrado)&&salida.before(llegadaRegistrado)||salida.equals(salidaRegistrado)) 
//					throw new FechaNoDisponibleException();
//				
//				if(salida.after(llegadaRegistrado))
//				if(checkActivo(vt.get(i).getVuelo(),v))
//					return true;			
//				
//			}
//			
//			return false;
//		}

	
	

	@Override
	public List<Tripulante> mostrarTripulantesTipo(String titulo) {
		return repositorioTripulante.mostrarTripulacion(titulo);
	}

//	@Override
//	public Tripulante traerTripulante(Long id){
//		return repositorioTripulante.traerTalTripulante(id);
//	}

	@Override
	public VueloTripulante asignarUnTripulanteAvueloDos(VueloDos vuelo, Tripulante tripulante){
		return repositorioTripulante.asignarUnTripulanteAvueloDos(vuelo, tripulante);
	}

	@Override
	public void addPiloto(TripulanteInfo pilotoInfo) throws ParseException {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		Tripulante piloto = new Tripulante();
		piloto.setNombre(pilotoInfo.getNombre());
		piloto.setApellido(pilotoInfo.getApellido());
		piloto.setTitulo(pilotoInfo.getTitulo());
		piloto.setHorasDescanso(pilotoInfo.getHorasDescanso());
		piloto.setHorasActivo(pilotoInfo.getHorasActivo());
		piloto.setEstado(pilotoInfo.getEstado());
		piloto.setInicioActividad(formatter.parse(pilotoInfo.getInicioActividad()));
		repositorioTripulante.guardarPiloto(piloto);
	}
}