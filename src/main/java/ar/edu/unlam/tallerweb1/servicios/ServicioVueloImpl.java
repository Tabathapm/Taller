package ar.edu.unlam.tallerweb1.servicios;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
	public Vuelo consultarVuelo(String nombre) {
		
		return repositorioVuelo.consultarVuelo(nombre);
	}

	@Override
	public List<Vuelo> obtenerTodosLosVuelos() {
		
		return repositorioVuelo.obtenerTodosLosVuelos();
	}

	@Override
	public List<Vuelo> buscarVueloPorNombre(String valorBuscado) {
		
		return repositorioVuelo.buscarVueloPorNombre(valorBuscado);
	}

}
