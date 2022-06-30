package ar.edu.unlam.tallerweb1.repositorios;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

import ar.edu.unlam.tallerweb1.modelo.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@SuppressWarnings({ "unchecked", "deprecation" })
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
	public void guardar(Vuelo vuelo) {
		sessionFactory.getCurrentSession().save(vuelo);
	}

	@Override
	public void addVuelo(VueloDos vuelo) {
		sessionFactory.getCurrentSession().save(vuelo);
	}

	@Override
	public List destinoConMasVuelos(){
//		List<Vuelo> listaDeVuelosConMasDestinos = new ArrayList<>();
		Grafico graficoDestinos = new Grafico();
//		List<Grafico> listaDeDatos = new ArrayList<>();

		List datos = sessionFactory.getCurrentSession().createCriteria(Vuelo.class)
				.setProjection( Projections.projectionList()
								.add(Projections.rowCount(), "destino_Id" )
								.add( Projections.groupProperty("destino_Id"), "destino" )
				).list();

//		List<Grafico> listaDeDatos = sessionFactory.getCurrentSession().createCriteria(Vuelo.class)
//				.add(Restrictions.sqlRestriction("SELECT COUNT(vuelo.destino_Id) AS 'destino', vuelo.destino_Id"))
//				.add(Restrictions.sqlRestriction("GROUP BY vuelo.destino_Id"))
//				.list();

		return datos;


//		try {
//			Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/db?serverTimezone=UTC","root","");
//			Statement sentencia = conexion.createStatement();
//			String consulta = "SELECT COUNT(vuelo.destino_Id) AS 'destino', vuelo.destino_Id\n" +
//							  "FROM vuelo \n" +
//							  "GROUP BY vuelo.destino_Id;";
//			ResultSet rs = sentencia.executeQuery(consulta);
//			while(rs.next()) {
//				Long cantidadDeVuelos = rs.getLong("destino");
//				String pais = rs.getString("pais");
//				graficoDestinos.setId(cantidadDeVuelos);
//				graficoDestinos.setPais(pais);
//				listaDeDatos.add(graficoDestinos);
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}

//		return listaDeDatos;
//		return graficoDestinos;
//		return listaDeVuelosConMasDestinos;
	}

	@Override
	public Vuelo consultarVuelo(Long id) {
		
		Criterion crit1 = Restrictions.eq("vuelo.Id", id);
		
		return (Vuelo)
		 getSession().createCriteria(Vuelo.class,"vuelo")
		.add(crit1)
		.uniqueResult();
							
	}
	
	@Override
	public List<Vuelo> obtenerTodosLosVuelos() {
		
		return getSession().createCriteria(Vuelo.class).list();
		
	}

	
	
	@Override
	public List<Vuelo> buscarVueloPorNombre(String nombre) {
		
		return getSession().createCriteria(Vuelo.class,"vuelo")
	    .add(Restrictions.like("vuelo.nombre",nombre, MatchMode.ANYWHERE).ignoreCase())
	    .list();
		
		
	}


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
	

	@Override
	public List <Locacion> buscarLocacion(String locacion) {
		
		return getSession().createCriteria(Locacion.class, "locacion")
				.add(Restrictions.like("pais",locacion, MatchMode.ANYWHERE).ignoreCase())
				.add(Restrictions.like("ciudad", locacion, MatchMode.ANYWHERE).ignoreCase())
				.list();
	}
	

	@Override
	public List<Vuelo> listarTodosLosVuelosSinTripulacion() { //arreglar junto al test revisar
		
		 List <Vuelo> vuelos = getSession().createCriteria(Vuelo.class).list();
		 
		 List <VueloTripulante> vt = getSession().createCriteria(VueloTripulante.class).list();
		 
		 Vuelo encontrado = new Vuelo();
		 
		 Vuelo vtVuelo = new Vuelo();
		 
		 List <Vuelo> vuelosSinTripulacion = new ArrayList <>();
		 
		 if(vuelos.size()==0||vt.size()==0) {
			 
			 return vuelos; 
			 
		 }
		 
		 for (int i = 0 ; i < vuelos.size() ; i++) {
			 for (int j = 0 ; j < vt.size() ; j++) {
			 
			 encontrado = vuelos.get(i);
			 vtVuelo = vt.get(j).getVuelo();
			 
			 if(!(encontrado.equals(vtVuelo)))
					vuelosSinTripulacion.add(encontrado);
		 		  		
		   }
		 }

//		 for (int i = 0 ; i < vuelos.size() ; i++) {
//			 for (int j = 0 ; j < vt.size() ; j++) {
//	
//		  if(null!=vt.get(j).getVuelo()) 	 
//			if(!(vuelosSinTripulacion.contains(vuelos.get(i)))
//			   &&(vuelos.get(i).getId().equals(vt.get(j).getVuelo().getId()))) 
//				vuelosSinTripulacion.add(vuelos.get(i));
//			  		
//			 }
//		  } 
		 
	 
		 return vuelosSinTripulacion;
		 
	}
	
	 @Override
	  	public List<VueloTripulante> obtenerVuelosSinTripulacion() { //revisar
	  	   
	         Criterion rest1 = Restrictions.like("vt.tripulante",null);
	         
	         List<VueloTripulante> result=getSession().createCriteria(VueloTripulante.class,"vt")
	                               .add(rest1).list();
	         
	         return result;
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
