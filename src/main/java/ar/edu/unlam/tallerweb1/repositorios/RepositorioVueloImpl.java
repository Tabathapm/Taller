package ar.edu.unlam.tallerweb1.repositorios;

import ar.edu.unlam.tallerweb1.modelo.Vuelo;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Repository("repositorioVuelo")
@Transactional
public class RepositorioVueloImpl implements RepositorioVuelo {

    private SessionFactory sessionFactory;

    @Autowired
    public RepositorioVueloImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<Vuelo> traerTodos() {
         return (List<Vuelo>) sessionFactory.getCurrentSession().createCriteria(Vuelo.class).list();
    }

    @Override
    public Vuelo traerPorId(Long id) {
        return (Vuelo) sessionFactory.getCurrentSession().createCriteria(Vuelo.class)
                .add(Restrictions.eq("id",id)).uniqueResult();
    }


}
