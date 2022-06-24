package ar.edu.unlam.tallerweb1.repositorios;
import ar.edu.unlam.tallerweb1.modelo.Avion;
import ar.edu.unlam.tallerweb1.modelo.Hangar;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Repository("repositorioAvion")
public class RepositorioAvionImpl implements RepositorioAvion {

    @Autowired
    private SessionFactory sessionFactory;


    @Override
    public Avion verAvionSinHangar(Long id) {
        return (Avion) sessionFactory.getCurrentSession().createCriteria(Avion.class)
                .add(Restrictions.eq("Id",id))
                .add(Restrictions.eq("hangar_Id",null))
                .uniqueResult();
    }

    @Override
    public List<Avion> verAvionesSinHangar(){
        List<Avion> aviones = sessionFactory.getCurrentSession().createCriteria(Avion.class)
                .add(Restrictions.isNull("hangar.Id"))
                .list();
        return aviones;

    }

    @Override
    public List<Avion> avionesTipoCarga() {
        List<Avion> aviones = sessionFactory.getCurrentSession().createCriteria(Avion.class)
                .add(Restrictions.eq("tipoavion.id", 2))
                .list();

        return aviones;
    }

    @Override
    public List<Avion> avionesTipoComercial() {
        List<Avion> aviones = sessionFactory.getCurrentSession().createCriteria(Avion.class)
                .add(Restrictions.eq("tipoAvion_Id", 1))
                .list();

        return aviones;
    }


//    select * from avion
//    where avion.hangar_Id is null;



}
