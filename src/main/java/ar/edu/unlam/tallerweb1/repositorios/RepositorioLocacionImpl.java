package ar.edu.unlam.tallerweb1.repositorios;

import ar.edu.unlam.tallerweb1.modelo.Locacion;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("repositorioLocacion")
public class RepositorioLocacionImpl implements RepositorioLocacion{

    private SessionFactory sessionFactory;

    @Autowired
    public RepositorioLocacionImpl(SessionFactory sessionFactory){
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<Locacion> mostrarLocacion() {
        List <Locacion> locaciones = sessionFactory.getCurrentSession().createCriteria(Locacion.class)
                .list();
        return locaciones;
    }

    @Override
    public Locacion buscarLocacionPorId(Long id){
        Locacion locacionEncontrada = (Locacion) sessionFactory.getCurrentSession().createCriteria(Locacion.class)
                .add(Restrictions.eq("Id", id))
                .uniqueResult();

        return locacionEncontrada;
    }
}
