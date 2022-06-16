package ar.edu.unlam.tallerweb1.servicios;

import java.util.List;

import ar.edu.unlam.tallerweb1.repositorios.RepositorioHangar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unlam.tallerweb1.modelo.Avion;
import ar.edu.unlam.tallerweb1.modelo.Hangar;

@Service("ServicioHangar")
public class ServicioHangarImpl implements ServicioHangar {

	@Autowired
	private RepositorioHangar repositorioHangar;


	@Override
	public List<Hangar> traerTodosLosHangares() {
		// TODO Auto-generated method stub

		return repositorioHangar.obtenerTodosLosHangares();

	}

	@Override
	public List<Hangar> traerHangaresVacios() {
		return repositorioHangar.obtenerHangaresVacios();
	}

	@Override
	public Hangar traerHangaresSinAsignar(Long id){
		return repositorioHangar.consultarHangar(id);
	}

	@Override
	public List<Hangar> traerTodosLosHangaresDisponibles(){
		return repositorioHangar.obtenerTodosLosHangaresDisponibles();
	}

	@Override
	public void asigarAvionesAHangar(Long idAvion,Long idHangar){
		repositorioHangar.asignarAvionAHangar(idAvion,idHangar);
	}

}
