package ar.edu.unlam.tallerweb1.repositorios;


import ar.edu.unlam.tallerweb1.modelo.Avion;
import ar.edu.unlam.tallerweb1.modelo.Hangar;
import ar.edu.unlam.tallerweb1.modelo.TipoAvion;
import org.hibernate.FetchMode;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.*;
import org.hibernate.sql.JoinType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Transactional
@Repository("repositorioHangar")
public class RepositorioHangarImpl implements RepositorioHangar {
    // Maneja acciones de persistencia, normalmente estara inyectado el session factory de hibernate
    // el mismo esta difinido en el archivo hibernateContext.xml

    @Autowired
    private SessionFactory sessionFactory;


    @Override
    public Hangar verHangares(Hangar hangar) {
        return (Hangar) sessionFactory.getCurrentSession().createCriteria(Hangar.class)
                .uniqueResult();
    }

    @Override
    public List<Hangar> obtenerHangaresVacios() {
        List<Hangar> hangares = sessionFactory.getCurrentSession().createCriteria(Hangar.class)
                .add(Restrictions.eq("Ocupado", Boolean.FALSE))
                .list();
        return hangares;
    }

    @Override
    public Hangar consultarHangar(Long id){
        return (Hangar) sessionFactory.getCurrentSession().createCriteria(Hangar.class)
                .add(Restrictions.eq("Id",id))
//                .add(Restrictions.eq("Ocupado", Boolean.FALSE))
                .uniqueResult();
    }

//    @Override
//    public void guardar (Avion avion){
//        sessionFactory.getCurrentSession().save(avion);
//    }


    @Override
    public List<Hangar> obtenerTodosLosHangaresDisponibles(){
        List<Hangar> hangares = sessionFactory.getCurrentSession().createCriteria(Hangar.class)
                .add(Restrictions.eq("Ocupado", Boolean.FALSE))
                .list();
                return hangares;
    }

    @Override
    public List<Hangar> obtenerTodosLosHangares(){
        List<Hangar> hangares = sessionFactory.getCurrentSession().createCriteria(Hangar.class)
                .list();
        return hangares;
    }

    @Override
    public void asignarAvionAHangar(Long idAvion,Long idHangar){
        Hangar hangar =  (Hangar) sessionFactory.getCurrentSession().createCriteria(Hangar.class)
                .add(Restrictions.eq("Id",idHangar))
                .uniqueResult();


        Avion avion =  (Avion) sessionFactory.getCurrentSession().createCriteria(Avion.class)
                .add(Restrictions.eq("Id",idAvion))
                .uniqueResult();

        hangar.setAvion(avion);
        hangar.setOcupado(Boolean.TRUE);
        sessionFactory.getCurrentSession().save(hangar);

        //hacer hangar.setAvion piripipi pero con hangar

        avion.setHangar(hangar);
        sessionFactory.getCurrentSession().save(avion);

    }



}
