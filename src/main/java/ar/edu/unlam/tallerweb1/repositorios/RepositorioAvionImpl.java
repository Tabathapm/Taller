package ar.edu.unlam.tallerweb1.repositorios;
import ar.edu.unlam.tallerweb1.modelo.Avion;
import ar.edu.unlam.tallerweb1.modelo.Hangar;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Transactional
@Repository("repositorioAvion")
public class RepositorioAvionImpl implements RepositorioAvion {

    @Autowired
    private SessionFactory sessionFactory;


//    @Override
//    public Avion verAvionSinHangar(Long id) {
//        return (Avion) sessionFactory.getCurrentSession().createCriteria(Avion.class)
//                .add(Restrictions.eq("Id",id))
//                .add(Restrictions.eq("hangar_Id",null))
//                .uniqueResult();
//    }

    @Override
    public List<Avion> verAvionesSinHangar() {
//        Todo lo que tengo que hacer tiene que ir dentro del try
        List<Avion> avionesSinAsignar = new ArrayList<>();

        try {
            Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/db?serverTimezone=UTC", "root", "666malakian");
            Statement sentencia = conexion.createStatement();
            String consulta = "select * from avion\n" +
                    "      where not exists(select 1 from hangar\n" +
                    "      where hangar.avion_Id = avion.id);";
            ResultSet rs = sentencia.executeQuery(consulta);
            while (rs.next()) {
                Avion avion = new Avion();
                avion.setId(rs.getLong("Id"));
                avion.setNombre(rs.getString("nombre"));
                avionesSinAsignar.add(avion);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return avionesSinAsignar;


//    select * from avion
//    where avion.hangar_Id is null;


    }
}
