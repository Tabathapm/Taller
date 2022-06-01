package ar.edu.unlam.tallerweb1.repositorios;

import ar.edu.unlam.tallerweb1.modelo.Locacion;
import ar.edu.unlam.tallerweb1.modelo.Vuelo;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("repositorioVuelo")
public class RepositorioVueloImpl implements RepositorioVuelo{

    private SessionFactory sessionFactory;

    @Autowired
    public RepositorioVueloImpl(SessionFactory sessionFactory){
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<Locacion> mostrarLocacion() {
        List <Locacion> locaciones = sessionFactory.getCurrentSession().createCriteria(Locacion.class)
                .list();
        return locaciones;
    }

    @Override
    public void guardar(Vuelo vuelo) {
        sessionFactory.getCurrentSession().save(vuelo);
    }

}
