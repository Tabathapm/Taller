package ar.edu.unlam.tallerweb1.repositorios;

import ar.edu.unlam.tallerweb1.modelo.Avion;
import ar.edu.unlam.tallerweb1.modelo.Hangar;

import java.util.List;

public interface RepositorioHangar {
    Hangar verHangares(Hangar hangar);
    List<Hangar> obtenerHangaresVacios();
    List<Avion> obtenerAvionesSinAsignar();
    Hangar consultarHangar(Long id);
    List<Hangar> obtenerTodosLosHangares();
    List<Hangar> obtenerTodosLosHangaresDisponibles();
    void asignarAvionAHangar(Long idAvion,Long idHangar);


}
