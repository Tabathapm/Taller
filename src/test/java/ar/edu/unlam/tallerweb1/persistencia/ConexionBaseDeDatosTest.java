package ar.edu.unlam.tallerweb1.persistencia;

import ar.edu.unlam.tallerweb1.SpringTest;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.modelo.Vuelo;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.junit.Test;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;
import static org.assertj.core.api.Assertions.*;

// Clase que prueba la conexion a la base de datos. Hereda de SpringTest por lo que corre dentro del contexto
// de spring
public class ConexionBaseDeDatosTest extends SpringTest{
	
	private SessionFactory sessionFactory;
	
    @Test
    @Transactional @Rollback
    public void pruebaConexion(){
        assertThat(session().isConnected()).isTrue();
    }

    @Test
    @Transactional @Rollback
    public void crearUsuario(){
        Usuario usuario = new Usuario();
        usuario.setCredencial("seba@gmail.com");
        usuario.setPassword("1234");
        session().save(usuario);
        assertThat(usuario.getId()).isNotNull();
    }
    
    @Test
    @Transactional @Rollback
    public void crearUsuarioYConsultarLaBD(){
        Usuario usuario = new Usuario();
        usuario.setCredencial("seba@gmail.com");
        usuario.setPassword("1234");
        
        
        session().save(usuario);
        
		Long ID = usuario.getId();
        
        System.out.println(ID);
        
        Usuario usuarioBD = session().get(Usuario.class,2L); // id mas tipo de dato L = Long
        
        assertNotNull(usuarioBD);
    }
    
    @Test
    @Transactional @Rollback
    public void crearUsuarioYConsultarLaBDSave(){
        Usuario usuario = new Usuario();
        usuario.setCredencial("seba@gmail.com");
        usuario.setPassword("1234");
        
        
        session().save(usuario);
        
        Long ID = usuario.getId();
        
        System.out.println(ID);
        
        Usuario usuarioBD = session().get(Usuario.class,ID); 
        
        assertNotNull(usuarioBD);
    }
  
    @Test
    @Transactional @Rollback
    public void verificacionScriptBD(){
        
        Long ID = (long) 1;
        
        Usuario usuarioBD = session().get(Usuario.class,ID); 
       
        System.out.println(usuarioBD);
//        System.out.println(usuarioBD.getId());
//        System.out.println(usuarioBD.getCredencial());
          
      //  assertEquals(usuarioBD.getCredencial(),"usuario");
      //  assertEquals(usuarioBD.getPassword(),"usuario");
      //  assertNotNull(usuarioBD);
    }
    
    @Test
    @Transactional @Rollback
    public void verificacionScriptBD2(){
        
        Long ID = (long) 2;
        
        Usuario usuarioBD = session().get(Usuario.class,ID); 
        
       
       
        assertNull(usuarioBD);
    }
    
//    @Test
//    @Transactional @Rollback
//    public void verificacionScriptBD3(){
//        
//       String usuarioS = "usuario";
//        
//       Usuario usuario = (Usuario) session().createCriteria(Usuario.class).
//        add(Restrictions.like("credencial", usuarioS))
//		.uniqueResult();
//        
//        
//        System.out.println(session().getIdentifier(usuario)); 
//       
//        
//    }
    
//    @Test
//    @Transactional @Rollback
//    public void verificacionScriptBD4(){
//    	
//    	String usuarioS = "usuario";
//        
//    	Session session = sessionFactory.getCurrentSession();
// 	    
//    	Usuario usuario = (Usuario) session.createCriteria(Vuelo.class)
// 		.add(Restrictions.like("credencial", usuarioS))
// 		.uniqueResult();
//    	
//    	System.out.println(usuario); 
//       
//        
//    }

}
