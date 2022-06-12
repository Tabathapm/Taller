package ar.edu.unlam.tallerweb1.repositorios;

import ar.edu.unlam.tallerweb1.modelo.Tripulante;
import ar.edu.unlam.tallerweb1.modelo.Vuelo;
import ar.edu.unlam.tallerweb1.modelo.VueloTripulante;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;



@SuppressWarnings("deprecation")
@Repository("RepositorioTripulante")
@Transactional
public class RepositorioTripulanteImpl implements RepositorioTripulante {

    private SessionFactory sessionFactory;

    @Autowired
    public RepositorioTripulanteImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    
    private Session getSession() {
        return sessionFactory.getCurrentSession();
    }
    
    @Override
	public List<Tripulante> listarTodosLosTripulantes() {
		
		return getSession().createCriteria(Tripulante.class).list();
	}
	

    @Override
    public Tripulante traerTripulante(Long id) {
        return (Tripulante) getSession().createCriteria(Tripulante.class)
                .add(Restrictions.eq("id",id)).uniqueResult();
    }
    

    @Override
    public List<Tripulante> listarTodosLosPilotos() {
        Criterion rest1 = Restrictions.and(Restrictions.like("titulo","Piloto"));
  
        List<Tripulante> result=sessionFactory.getCurrentSession().createCriteria(Tripulante.class)
                .add(rest1).list();
        return result;
        /*return sessionFactory.getCurrentSession().createCriteria(Tripulante.class)
                .add(Restrictions.like("titulo","Piloto"))
                .addOrder(Order.asc("nombre"))
                .list();*/
    }


    @Override
    public List<Tripulante> listaTodosLosCopilotos() {

        Criterion rest1 = Restrictions.and(Restrictions.like("titulo","Copiloto"));
        
         List<Tripulante> result=
        		 sessionFactory.getCurrentSession().createCriteria(Tripulante.class)
        		 .createAlias("tripulante", "vt")
        		 .createAlias("vuelo", "vuelo")
                 .add(rest1).list();
         
         return result;
    }



    @Override
    public List<Tripulante> listaTodosLosIngenieros() {
        Criterion rest1 = Restrictions.and(Restrictions.like("titulo","Ingeniero de vuelo"));
        List<Tripulante> result=sessionFactory.getCurrentSession().createCriteria(Tripulante.class)
                .add(rest1).list();
        
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

    /*
    @Override
    public List<Tripulante> tripulacionAsignada(Vuelo vuelo) {
        return  sessionFactory.getCurrentSession().createCriteria(Tripulante.class)
        		.createAlias("vueloTripulante","vt")
                .add(Restrictions.eq("vt.vuelo",vuelo)).list();
    }
 */
   @Override
    public VueloTripulante asignarUnTripulanteAvuelo(Vuelo vuelo, Tripulante unTripulante) {
            
        VueloTripulante vt = new VueloTripulante ();
        
        vt.setVuelo(vuelo);
        vt.setTripulante(unTripulante);
        
        getSession().save(vt);
        
        return vt;

    }
   
   @Override
	public List<VueloTripulante> obtenerFechasDeVuelos(Tripulante tripulante) {
	   
	   Long id = tripulante.getId();
	   
       Criterion rest1 = Restrictions.and(Restrictions.like("t.Id",id));
       
       List<VueloTripulante> result=getSession().createCriteria(VueloTripulante.class,"vt")
    		   				 .createAlias("tripulante", "t")
    		   				 .createAlias("vuelo", "v")
                             .add(rest1).list();
       
       return result;
	}
   
    /*
     * 
     *   @Override
	public List<Vuelo> obtenerFechasDeVuelos(Tripulante tripulante) {
	   
	   Long id = tripulante.getId();
	   
	   List<Vuelo> r = new ArrayList<>(); 
       
       Query<Vuelo> query = getSession().createSQLQuery("CALL obtenerFechasDeTripulante(:idTripulante)")
    		   .addEntity(Vuelo.class)
    		   .setParameter("idTripulante",id);
       
       r = query.list();
     
       return r;
	}
    @Override
    public void asignarUnTripulanteAvuelo(Vuelo vuelo, Tripulante unTripulante) {
    	
    	
       Tripulante tr = (Tripulante) sessionFactory.getCurrentSession().createCriteria(Tripulante.class)
               .add(Restrictions.eq("id", unTripulante.getId())).uniqueResult();
        tr.setVuelo(vuelo);
        sessionFactory.getCurrentSession().update(tr);
        
		Criterion crit1 = Restrictions.eq("vuelo.id", unTripulante.getId());
				
				
	  VueloTripulante vt = (VueloTripulante) getSession().createCriteria(VueloTripulante.class)
				 .createAlias("tripulante", "Tripulante")
				 .createAlias("vuelo","Vuelo")
				 .add(crit1).uniqueResult();
				 
				 getSession().save(vt);
        
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
     
        List<Tripulante> tripulantesAsignados = tripulacionAsignada(vuelo);
        for (Tripulante tr : trAsignada ) {
            tr.setVuelo(null);
            sessionFactory.getCurrentSession().update(tr);
        }
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
    */

@Override
public void asignarTripulantesAlVuelo(Vuelo vuelo, List<Tripulante> tripulantes) {
	// TODO Auto-generated method stub
	
}

	@Override
	public List<Tripulante> tripulacionAsignada(Vuelo vuelo) {
		// TODO Auto-generated method stub
		return null;
	}

	

	

	
}