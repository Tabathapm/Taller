package ar.edu.unlam.tallerweb1.repositorios;

import ar.edu.unlam.tallerweb1.modelo.TipoAvion;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Repository("repositorioTipoAvion")
public class RepositorioTipoAvionImpl implements RepositorioTipoAvion{

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public TipoAvion traerTipoDeAvion(String categoriaAvion) {
        TipoAvion tipoAvion = (TipoAvion) sessionFactory.getCurrentSession().createCriteria(TipoAvion.class)
                .add(Restrictions.eq("categoriaAvion", categoriaAvion))
                .uniqueResult();

        return tipoAvion;
    }
}
