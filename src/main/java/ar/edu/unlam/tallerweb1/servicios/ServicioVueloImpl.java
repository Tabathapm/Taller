package ar.edu.unlam.tallerweb1.servicios;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unlam.tallerweb1.excepciones.DestinoOrigenIgualesException;
import ar.edu.unlam.tallerweb1.excepciones.ErrorEnFechasException;
import ar.edu.unlam.tallerweb1.excepciones.VueloSinAvionException;
import ar.edu.unlam.tallerweb1.excepciones.VueloSinDestinoException;
import ar.edu.unlam.tallerweb1.excepciones.VueloSinLlegadaException;
import ar.edu.unlam.tallerweb1.excepciones.VueloSinOrigenException;
import ar.edu.unlam.tallerweb1.excepciones.VueloSinSalidaException;
import ar.edu.unlam.tallerweb1.modelo.Locacion;
import ar.edu.unlam.tallerweb1.modelo.Vuelo;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioVuelo;

@Service("servicioVuelo")
@Transactional
public class ServicioVueloImpl implements ServicioVuelo {
	
	private RepositorioVuelo repositorioVuelo;
	
	@Autowired
	public ServicioVueloImpl(RepositorioVuelo repositorioVuelo){
		this.repositorioVuelo = repositorioVuelo;
	}
	
	

	@Override
	public Vuelo consultarVuelo(Long id) {
		
		Vuelo vuelo = repositorioVuelo.consultarVuelo(id);
			
		vuelo.getLlegada();
		
		Date salida = vuelo.getSalida();
		Date llegada = vuelo.getLlegada();	
		
		
		//Date estimado = salida.compareTo(llegada);
		
		//vuelo.setEstimado(estimado);
		
		
		return repositorioVuelo.consultarVuelo(id);
	}

	@Override
	public List<Vuelo> obtenerTodosLosVuelos() {
		
		return repositorioVuelo.obtenerTodosLosVuelos();
	}

	@Override
	public Set<Vuelo> buscarVuelos(String valorBuscado) {
		
	
		List <Vuelo> listaNombres= repositorioVuelo.buscarVueloPorNombre(valorBuscado);
		
		List <Vuelo> listaLocacion = repositorioVuelo.buscarVueloPorLocacion(valorBuscado);
		
		
		Set <Vuelo> lista = new HashSet<>();
		
		lista.addAll(listaNombres);
		lista.addAll(listaLocacion);
		
		
		return lista;
		
		
	}
	
	@Override
	public List<Locacion> buscarLocacion(String valorBuscado) {
		
	//	List <Vuelo> listaNombres= repositorioVuelo.buscarVueloPorNombre(valorBuscado);
		
		List <Locacion> listaLocacion = repositorioVuelo.buscarLocacion(valorBuscado);
		
		
	//	listaNombres.addAll(listaLocacion);
		
		
		return listaLocacion;
		
	}

	@Override
	public List<Vuelo> listarTodosLosVuelosSinTripulacion() {

		
		return  repositorioVuelo.listarTodosLosVuelosSinTripulacion();
	}
	
	@Override
	public void agregarVuelo(Vuelo vuelo) {
		
		validarFechasDelVuelo(vuelo);
		validarLocacionesDelVuelo(vuelo);
		
		vuelo = setNombreDeVuelo(vuelo);
		
		vuelo = setEstimadoDeVuelo(vuelo);
		
		repositorioVuelo.guardar(vuelo);
	}
	
	@Override
	public Vuelo setEstimadoDeVuelo(Vuelo vuelo) {
		
		Date salida = vuelo.getSalida();
		Date llegada = vuelo.getLlegada();
		
		Long horasEstimadasCalc;
		Long minutosEstimadosCalc; 
		
		long calculo = llegada.getTime() - salida.getTime();
		
		horasEstimadasCalc = (calculo/60000)/60;
		
		minutosEstimadosCalc = (calculo/60000)-(horasEstimadasCalc*60);
		
		vuelo.setHorasEstimadas(horasEstimadasCalc);
		
		vuelo.setMinutosEstimados(minutosEstimadosCalc);
		
		
		return vuelo;
			
	}
	
	@Override
	public Vuelo setNombreDeVuelo(Vuelo vuelo) {
		
		String origen = vuelo.getOrigen().getCiudad();
		String destino = vuelo.getDestino().getCiudad();
		Long Id = vuelo.getId();
		
		String nombreGen = Id+"|"+origen+" - "+destino+". ";
		
		vuelo.setNombre(nombreGen);
		
		return vuelo;
	
	}
	
	@Override
	public void validarFechasDelVuelo(Vuelo vuelo) {
		
		Date salida = vuelo.getSalida();
		Date llegada = vuelo.getLlegada();
		
		if(salida==(null))
			throw new VueloSinSalidaException();
		
		if(llegada==(null))
			throw new VueloSinLlegadaException();
		
		if(salida.after(llegada)||salida.equals(llegada)) 
			throw new ErrorEnFechasException();
	
	}
	
	@Override
	public void validarLocacionesDelVuelo(Vuelo vuelo) {
		
		String origen = vuelo.getOrigen().getCoordenadas();
		String destino = vuelo.getDestino().getCoordenadas();
		
		if(vuelo.getDestino()==(null))
			throw new VueloSinDestinoException();
		
		if(vuelo.getOrigen()==(null))
			throw new VueloSinOrigenException();
		
		if(destino.equals(origen)) 
			throw new DestinoOrigenIgualesException();
	
	}
	
	
	
	

}
