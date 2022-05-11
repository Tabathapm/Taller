package ar.edu.unlam.tallerweb1.servicios;

import java.util.List;

import org.springframework.stereotype.Service;

import ar.edu.unlam.tallerweb1.modelo.Avion;
import ar.edu.unlam.tallerweb1.modelo.Hangar;

@Service("ServicioHangar")
public class ServicioHangarImpl implements ServicioHangar {

	@Override
	public Boolean alocarHangar(Avion avion, Hangar hangarVacio) {
		if(hangarVacio.getOcupado()!=true) {
			hangarVacio.setAvion(avion);
			hangarVacio.setOcupado(true);
		}
		return hangarVacio.getOcupado();
	}


	@Override
	public Hangar traerHangarDeAvion(Avion avion) {
		
		// Esto necesita repos Hangar hangarAvion = hangares.getAvion(avion);
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public List<Hangar> traerHangaresVacios() {
		// TODO Auto-generated method stub
		return null;
	}

}
