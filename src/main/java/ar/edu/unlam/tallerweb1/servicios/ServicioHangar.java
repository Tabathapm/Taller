package ar.edu.unlam.tallerweb1.servicios;

import java.util.List;

import ar.edu.unlam.tallerweb1.modelo.Avion;
import ar.edu.unlam.tallerweb1.modelo.Hangar;

public interface ServicioHangar {
	
	Boolean alocarHangar (Avion avion,Hangar hangarVacio);
	
	Hangar traerHangarDeAvion(Avion avion);
	
	List<Hangar> traerHangaresVacios();

}
