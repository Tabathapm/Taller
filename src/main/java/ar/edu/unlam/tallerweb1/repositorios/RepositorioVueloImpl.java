package ar.edu.unlam.tallerweb1.repositorios;

import java.util.List;
import java.util.Locale;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ar.edu.unlam.tallerweb1.modelo.Locacion;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.modelo.Vuelo;

@Repository("repositorioVuelo")
public class RepositorioVueloImpl implements RepositorioVuelo {
	
	private SessionFactory sessionFactory;

	@Autowired
	public RepositorioVueloImpl(SessionFactory sessionFactory){
	this.sessionFactory = sessionFactory;
	}
	
	private Session getSession() {
        return sessionFactory.getCurrentSession();
    }
	
	@Override
	public Vuelo consultarVuelo(Long id) {
		
		Criterion crit1 = Restrictions.eq("vuelo.id", id);
		
		return (Vuelo)
		 getSession().createCriteria(Vuelo.class,"vuelo")
		.add(crit1)
		.uniqueResult();
							
	}
	
	@Override
	public List<Vuelo> obtenerTodosLosVuelos() {
		
		return getSession().createCriteria(Vuelo.class).list();
		
	}

	
	@SuppressWarnings("unchecked")
	@Override
	public List<Vuelo> buscarVueloPorNombre(String nombre) {
		
		return getSession().createCriteria(Vuelo.class,"vuelo")
	    .add(Restrictions.like("vuelo.nombre",nombre, MatchMode.ANYWHERE).ignoreCase())
	    .list();
		
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Vuelo> buscarVueloPorLocacion(String locacionBuscada) {
		
		Criterion crit1 =  Restrictions.like("locacionBuscada.ciudad", locacionBuscada, MatchMode.ANYWHERE).ignoreCase();
		
		Criterion crit2 =  Restrictions.like("locacionBuscada.pais", locacionBuscada, MatchMode.ANYWHERE).ignoreCase();
			
		List <Vuelo> vueloOrigen = getSession().createCriteria(Vuelo.class, "vuelo")
								  .createAlias("origen", "locacionBuscada")
								  .add(Restrictions.or(crit1,crit2))
								  .list();
		
		if(vueloOrigen.isEmpty()) {
		return getSession().createCriteria(Vuelo.class, "vuelo")
				  .createAlias("destino", "locacionBuscada")
				  .add(Restrictions.or(crit1,crit2))
				  .list();
		}
		
		return vueloOrigen;
		
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List <Locacion> buscarLocacion(String locacion) {
		
		return getSession().createCriteria(Locacion.class, "locacion")
				.add(Restrictions.like("pais",locacion, MatchMode.ANYWHERE).ignoreCase())
				.add(Restrictions.like("ciudad", locacion, MatchMode.ANYWHERE).ignoreCase())
				.list();
	}
	

	   
	
	
	
    /*
	@Override
	public List<Vuelo> buscarVueloPorLocacion(String locacion) {
		  var query = getSession().createQuery("select v.id,v.estimado,"
		  		  +"v.llegada,v.nombre,v.salida, from Vuelo as v " 
				  +"inner join Locacion as l on v.origen_Id = l.id "
				  +"where l.ciudad = :locacion or l.pais = :locacion");
		  
	        query.setParameter("locacion", locacion);

	            return query.getResultList();
	            		
	}
	*/
	
	
	

}
