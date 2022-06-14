package ar.edu.unlam.tallerweb1.servicios;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unlam.tallerweb1.modelo.Locacion;
import ar.edu.unlam.tallerweb1.modelo.Vuelo;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioVuelo;
import excepciones.ErrorEnFechasException;
import excepciones.VueloSinAvionException;
import excepciones.VueloSinDestinoException;
import excepciones.VueloSinLlegadaException;
import excepciones.VueloSinOrigenException;
import excepciones.VueloSinSalidaException;

@Service("servicioVuelo")
@Transactional
public class ServicioVueloImpl implements ServicioVuelo {
	
	private RepositorioVuelo repositorioVuelo;
	
	@Autowired
	public ServicioVueloImpl(RepositorioVuelo repositorioVuelo){
		this.repositorioVuelo = repositorioVuelo;
	}
	
	@Override
	public void agregarVuelo(Vuelo vuelo) {
		
		if(vuelo.getAvion().equals(null))
			throw new VueloSinAvionException();
		if(vuelo.getDestino().equals(null))
			throw new VueloSinDestinoException();
		if(vuelo.getOrigen().equals(null))
			throw new VueloSinOrigenException();
		if(vuelo.getSalida().equals(null))
			throw new VueloSinSalidaException();
		if(vuelo.getLlegada().equals(null))
			throw new VueloSinLlegadaException();
		
		repositorioVuelo.guardar(vuelo);
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
	public Boolean validarFechasDelVuelo(Vuelo vuelo) {
		
		Date salida = vuelo.getSalida();
		Date llegada = vuelo.getLlegada();
		
		
		if(salida.equals(null)||llegada.equals(null)) {
			throw new ErrorEnFechasException();
		}
		if(salida.after(llegada)||salida.equals(llegada)) {
			throw new ErrorEnFechasException();
		}
		
		return true;
			
	}
	
	@Override
	public Vuelo calcularEstimadoDeVuelo(Vuelo vuelo) {
		
		Date salida = vuelo.getSalida();
		Date llegada = vuelo.getLlegada();
		Long horasEstimadas = vuelo.getHorasEstimadas();
		
		if(horasEstimadas.equals(null)) {
			throw new ErrorEnFechasException();
		}
		
		Long horasEstimadasCalc;
		Long minutosEstimadosCalc; 
		
		long calculo = llegada.getTime() - salida.getTime();
		
		horasEstimadasCalc = (calculo/60000)/60;
		
		minutosEstimadosCalc = (calculo/60000)-(horasEstimadasCalc*60);
		
		vuelo.setHorasEstimadas(horasEstimadasCalc);
		
		vuelo.setMinutosEstimados(minutosEstimadosCalc);
		
		
		return vuelo;
			
	}

}
