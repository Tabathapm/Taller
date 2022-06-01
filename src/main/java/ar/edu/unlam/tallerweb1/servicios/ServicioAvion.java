package ar.edu.unlam.tallerweb1.servicios;

import ar.edu.unlam.tallerweb1.modelo.Avion;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioAvion;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioHangar;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public interface ServicioAvion {

Avion traerAvionSinHangar(Long id);
List<Avion> traerAvionesSinHangar();




}
