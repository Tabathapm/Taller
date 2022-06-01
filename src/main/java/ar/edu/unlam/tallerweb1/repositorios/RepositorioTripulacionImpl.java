package ar.edu.unlam.tallerweb1.repositorios;

import ar.edu.unlam.tallerweb1.modelo.Tripulante;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("repositorioTripulacion")
public class RepositorioTripulacionImpl implements RepositorioTripulacion{

    private SessionFactory sessionFactory;

    @Autowired
    public RepositorioTripulacionImpl(SessionFactory sessionFactory){
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<Tripulante> mostrarTripulacion(String titulo) {
        List <Tripulante> tripulantes = sessionFactory.getCurrentSession().createCriteria(Tripulante.class)
                .add(Restrictions.eq("titulo",titulo ))
                .list();
        return tripulantes;
    }
}
