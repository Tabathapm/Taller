package ar.edu.unlam.tallerweb1.repositorios;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.modelo.Vuelo;

@Repository("repositorioVuelo")
public class RepositorioVueloImpl implements RepositorioVuelo {
	
	private SessionFactory sessionFactory;

	@Autowired
	public RepositorioVueloImpl(SessionFactory sessionFactory){
	this.sessionFactory = sessionFactory;
	}
	
	@Override
	public Vuelo consultarVuelo(String nombre) {
		
	final Session session = sessionFactory.getCurrentSession();
		return (Vuelo) session.createCriteria(Vuelo.class)
		.add(Restrictions.like("nombre", nombre))
		.uniqueResult();
	}

}
