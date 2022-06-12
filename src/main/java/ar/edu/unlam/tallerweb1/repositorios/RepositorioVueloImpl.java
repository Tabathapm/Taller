package ar.edu.unlam.tallerweb1.repositorios;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
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
import ar.edu.unlam.tallerweb1.modelo.VueloTripulante;



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

	@Override
	public List<Vuelo> listarTodosLosVuelosSinTripulacion() {
		
		 List <Vuelo> vuelos = getSession().createCriteria(Vuelo.class).list();
		 
		 List <VueloTripulante> vt = getSession().createCriteria(VueloTripulante.class).list();
		 
		 List <Vuelo> vuelosSinTripulacion = new ArrayList <>();
		 
		 if(vuelos.size()==0) {
			 
			 return vuelos;
			 
		 }
		 
		/* 
		 for (int i = 0 ; i < vuelos.size() ; i++) {
			 for (int j = 0 ; j < vt.size() ; j++) {
			 
			if(null!=vt.get(j).getVuelo())
			if(!(vuelosSinTripulacion.contains(vuelos.get(i)))
			   &&!((vt.get(j).getVuelo()).equals(vuelos.get(i)))) {
				vuelosSinTripulacion.add(vuelos.get(i));
				 
			
			}
		  }
		 } 
		 
	*/ 
		 
   
		 for (int i = 0 ; i < vuelos.size() ; i++) {
			 for (int j = 0 ; j < vt.size() ; j++) {
	
		  if(null!=vt.get(j).getVuelo()) 	 
			if(!(vuelosSinTripulacion.contains(vuelos.get(i)))
			   &&(vuelos.get(i).getId().equals(vt.get(j).getVuelo().getId()))) 
				vuelosSinTripulacion.add(vuelos.get(i));
			  		
			 }
		  } 
		 
		 return vuelosSinTripulacion;
		 
	
	}
	


	/*
	 * @Override
	public List<Vuelo> listarTodosLosVuelosSinTripulacion() {
		
		 Criterion crit1 = Restrictions.eq("vt.vuelo", 1);
		
		
		 return getSession().createCriteria(VueloTripulante.class,"vt")
		 .createAlias("vuelo","vuelo")
		 .add(crit1)
		 .list();
						
		
	}


    @Override
	public List<Vuelo> listarTodosLosVuelosSinTripulacion() {
	

                      List<Vuelo> vueloSinTripulacion= new ArrayList<>();

                       try {
                          Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/db?serverTimezone=UTC","root","11037");
                           Statement sentencia = conexion.createStatement();
                           String consulta = "select * from vuelo as v "
                        		   			+"inner join vuelotripulante vt on v.id=vt.vuelo_Id "
                                   			+"where vt.vuelo_Id = 1 );";
                           ResultSet rs = sentencia.executeQuery(consulta);
                           while(rs.next()) {
                               Vuelo vuelo= new Vuelo();
                               vuelo.setId(rs.getLong("Id"));
                               vuelo.setNombre(rs.getString("nombre"));

                               vueloSinTripulacion.add(vuelo);
                           }
                           
                      } catch (SQLException e) {
                          e.printStackTrace();
                      }

                      return vueloSinTripulacion;

	}
    
    

     *  var query = getSession()
		              .createQuery("from Vuelo as v "
                      +"inner join Vuelotripulante vt on v.id=vt.vuelo_Id "
                      +"where vt.vuelo_Id = null");
                      
                       .createQuery("select * from vuelo as v "
                      +"inner join vuelotripulante vt on v.id=vt.vuelo_Id "
                      +"where vt.vuelo_Id = null);";
               
                      
                      return query.getResultList();
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
