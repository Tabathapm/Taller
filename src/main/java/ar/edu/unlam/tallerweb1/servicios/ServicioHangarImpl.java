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
	private RepositorioHangar servicioHangar;



//	@Override
//	public Boolean alocarHangar(Avion avion, Hangar hangarVacio) {
//		if(hangarVacio.getOcupado()!=true) {
//			hangarVacio.setAvion(avion);
//			hangarVacio.setOcupado(true);
//		}
//		return hangarVacio.getOcupado();
//	}




//	@Override
//	public Hangar traerHangarDeAvion(Avion avion) {
//
//		// Esto necesita repos Hangar hangarAvion = hangares.getAvion(avion);
//		// TODO Auto-generated method stub
//		return null;
//	}


	@Override
	public List<Hangar> traerTodosLosHangares() {
		// TODO Auto-generated method stub

		return servicioHangar.obtenerTodosLosHangares();

	}

	@Override
	public List<Hangar> traerHangaresVacios() {
		return servicioHangar.obtenerHangaresVacios();
	}

	@Override
	public List<Avion> traerAvionesSinAsignar() {
		return servicioHangar.obtenerAvionesSinAsignar();
	}

//	@Override
//	public Hangar traerHangaresSinAsignar() {
//		return servicioHangar.consultarHangar(id);
//	}

//	@Override
//	public List<Avion> traerAvionesSinAsignar(){
//		return servicioHangar.obtenerAvionesSinAsignar();
//	}

	@Override
	public Hangar traerHangaresSinAsignar(Long id){
		return servicioHangar.consultarHangar(id);
	}

	@Override
	public List<Hangar> traerTodosLosHangaresDisponibles(){
		return servicioHangar.obtenerTodosLosHangaresDisponibles();
	}

	@Override
	public void asigarAvionesAHangar(Long idAvion,Long idHangar){
		 servicioHangar.asignarAvionAHangar(idAvion,idHangar);
	}

}