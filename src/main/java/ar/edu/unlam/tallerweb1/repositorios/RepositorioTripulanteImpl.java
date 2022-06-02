package ar.edu.unlam.tallerweb1.repositorios;

import ar.edu.unlam.tallerweb1.modelo.Tripulante;
import ar.edu.unlam.tallerweb1.modelo.Vuelo;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@SuppressWarnings("deprecated")
@Repository("RepositorioTripulante")
@Transactional
public class RepositorioTripulanteImpl implements RepositorioTripulante {

    private SessionFactory sessionFactory;

    @Autowired
    public RepositorioTripulanteImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public Tripulante traerTripulante(Long id) {
        return (Tripulante) sessionFactory.getCurrentSession().createCriteria(Tripulante.class)
                .add(Restrictions.eq("id",id)).uniqueResult();
    }

    @Override
    public List<Tripulante> listarTodosLosPilotos() {
        Criterion rest1 = Restrictions.and(Restrictions.like("titulo","Piloto"));
        Criterion rest2 = Restrictions.isNull("vuelo");
        List<Tripulante> result=sessionFactory.getCurrentSession().createCriteria(Tripulante.class)
                .add(Restrictions.and(rest1,rest2)).list();
        return result;
        /*return sessionFactory.getCurrentSession().createCriteria(Tripulante.class)
                .add(Restrictions.like("titulo","Piloto"))
                .addOrder(Order.asc("nombre"))
                .list();*/
    }


    @Override
    public List<Tripulante> listaTodosLosCopilotos() {

        Criterion rest1 = Restrictions.and(Restrictions.like("titulo","Copiloto"));
        Criterion rest2 = Restrictions.isNull("vuelo");
         List<Tripulante> result=sessionFactory.getCurrentSession().createCriteria(Tripulante.class)
                .add(Restrictions.and(rest1,rest2)).list();
         return result;
    }



    @Override
    public List<Tripulante> listaTodosLosIngenieros() {
        Criterion rest1 = Restrictions.and(Restrictions.like("titulo","Ingeniero de vuelo"));
        Criterion rest2 = Restrictions.isNull("vuelo");
        List<Tripulante> result=sessionFactory.getCurrentSession().createCriteria(Tripulante.class)
                .add(Restrictions.and(rest1,rest2)).list();
        return result;
        /*return sessionFactory.getCurrentSession().createCriteria(Tripulante.class)
                .add(Restrictions.like("titulo","Ingeniero de vuelo"))
                .addOrder(Order.asc("nombre"))
                .list();*/
    }

    @Override
    public List<Tripulante> listarTodosLosTripulantesDeVuelo() {
        return sessionFactory.getCurrentSession().createCriteria(Tripulante.class)
                .add(Restrictions.like("titulo","%Tripulante de Vuelo%"))
                .addOrder(Order.asc("nombre"))
                .list();
    }

    @Override
    public List<Tripulante> tripulacionAsignada(Vuelo vuelo) {
        return  sessionFactory.getCurrentSession().createCriteria(Tripulante.class)
                .add(Restrictions.eq("vuelo",vuelo)).list();
    }

   @Override
    public void asignarUnTripulanteAvuelo(Vuelo vuelo, Tripulante unTripulante) {
       Tripulante tr = (Tripulante) sessionFactory.getCurrentSession().createCriteria(Tripulante.class)
               .add(Restrictions.eq("id", unTripulante.getId())).uniqueResult();
        tr.setVuelo(vuelo);
        sessionFactory.getCurrentSession().update(tr);

    }

    @Override
    public void asignarTripulantesAlVuelo(Vuelo vuelo, List<Tripulante> tripulantes) {
        this.limpiarVueloDeTripulacion(vuelo,tripulantes);
        for (Tripulante tr : tripulantes ) {
            tr = traerTripulante(tr.getId());
            tr.setVuelo(vuelo);
            sessionFactory.getCurrentSession().update(tr);
        }
    }

    public void limpiarVueloDeTripulacion(Vuelo vuelo,List<Tripulante> tripulacion){
        List<Tripulante> trAsignada = tripulacionAsignada(vuelo);
        for (Tripulante tr : trAsignada ) {
            tr.setVuelo(null);
            sessionFactory.getCurrentSession().update(tr);
        }
    }
}
