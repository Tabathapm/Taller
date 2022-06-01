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

}
