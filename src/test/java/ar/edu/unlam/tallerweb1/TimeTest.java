package ar.edu.unlam.tallerweb1;

import static org.junit.Assert.*;

import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.junit.Test;


public class TimeTest {
/*
	@Test
	public void queSePuedaCrearUnClienteDeTelefonia() {
		ClienteTelefonia nuevo = new ClienteTelefonia(1000, "Camila", "11", "63598237");

		assertEquals(nuevo.getCodigoDeArea(), "11");
		assertEquals(nuevo.getTelefono(), "63598237");
		
	}
	
	@Test
	public void queSePuedaCrearUnClienteDeCable() {
		ClienteCable nuevo = new ClienteCable(1000, "Camila", "46546546504637");
		
		assertEquals(nuevo.getCodigoDecodificador(), "46546546504637");
		
	}
	*/ /*
	@Test
	public void datetest() {
		Date date = new Date();
		
		Date date2 = new Date( );
		
	    SimpleDateFormat formato = new SimpleDateFormat ("E dd-MM-yyyy 'a' HH:mm zzz");

	    System.out.println("Current Date: " + formato.format(date2));
	      
		System.out.println(date);
	} */
	/*
	@Test
	public void compareFechas() throws ParseException {
			
		SimpleDateFormat formato = new SimpleDateFormat ("dd-MM-yyyy HH:mm");

		Date date1 = new Date();
		Date date2 = new Date();
		
		date2.getTime();
		
		Long a = (date2.getTime()/60000)/60;
		
		System.out.println(date2);
		
		System.out.println(a);
		
		
		
		String a = "a";
		
		String b = "b";
		
		Long ab =1L; 

		System.out.println(ab+a + " - " + b);
		
		  try {
		    	 date1=formato.parse("05-05-2005 15:55");
		    	 date2=formato.parse("05-05-2005 20:30");

		    	 if(date1.after(date2)) {
		    		 System.out.println("fecha 1 despues de 2");
		    	 }
		    	 else
		    		 System.out.println("fecha 2 despues de 1");
		    }
		    
		    catch (ParseException e){
		    	System.out.println("Oh nyo");
		    }
		
   
	}
	*/
	@Test
	public void diffEnHorasLimpio() throws ParseException {
			
		SimpleDateFormat formato = new SimpleDateFormat ("dd-MM-yyyy HH:mm");

		Date date1 = new Date();
		Date date2 = new Date();

		
		  try {
		    	 date1=formato.parse("05-05-2005 15:55");
		    	 date2=formato.parse("05-05-2005 20:30");
		    
		    	 long diffInMillies = date2.getTime() - date1.getTime();
		    	 System.out.println(diffInMillies/60000 + " " + (diffInMillies/60000)/60); //primer valor en minutos, segundo en horas
	    	
		    }
		    
		    catch (ParseException e){
		    	System.out.println("Oh nyo");
		    }
		
		
	   
	   
	}
	/*	
	@Test
	public void diferenciaEntreFechasEnMinutos() throws ParseException {
			
		SimpleDateFormat formato = new SimpleDateFormat ("dd-MM-yyyy HH:mm");
		Time time = new Time(1);
		Date date1 = new Date();
		Date date2 = new Date();
		TimeUnit timeUnit = TimeUnit.MINUTES;
		TimeUnit timeUnit2 = TimeUnit.HOURS;
		
		time.getTime();
		
		  try {
		    	 date1=formato.parse("05-05-2005 15:55");
		    	 date2=formato.parse("05-05-2005 17:55");
		    	 
		    
//		    	 long diffInMillies = date2.getTime() - date1.getTime();
//		    	 System.out.println(diffInMillies/60000 + " " + (diffInMillies/60000)/60); //primer valor en minutos, segundo en horas
//		    	 System.out.println(timeUnit.convert(diffInMillies,TimeUnit.MILLISECONDS)
//		    			           +" "
//		    			           + timeUnit.convert(diffInMillies,TimeUnit.HOURS));
//		    	
		    	
		    	
		    }
		    
		    catch (ParseException e){
		    	System.out.println("Oh nyo");
		    }
		
		
	   
	   
	}

	@Test
	public void datetime2() {
	      try {
	         long start = System.currentTimeMillis( );
	      //   System.out.println(new Date( ) + "\n");
	         
	         Thread.sleep(5*60*10);
	      //   System.out.println(new Date( ) + "\n");
	         
	         long end = System.currentTimeMillis( );
	         long diff = end - start;
	      //   System.out.println("Difference is : " + diff);
	         
	      } catch (Exception e) {
	      //   System.out.println("Got an exception!");
	      }
	   }
	
	@Test
	public void dateparse() {
		Date date;
		
	    SimpleDateFormat formato = new SimpleDateFormat ("dd-MM-yyyy HH:mm");

	    try {
	    	 date=formato.parse("05-05-2005 15:55");
	 	//    System.out.println(date);
	    }
	    
	    catch (ParseException e){
	    //	System.out.println("Oh nyo");
	    }
	   	
	}
	
	@Test
	public void sleep() {
	      try {
	         long start = System.currentTimeMillis( );
	     //    System.out.println(new Date( ) + "\n");
	         
	         Thread.sleep(5*60*10);
	     //    System.out.println(new Date( ) + "\n");
	         
	         long end = System.currentTimeMillis( );
	         long diff = end - start;
	     //    System.out.println("Difference is : " + diff);
	         
	      } catch (Exception e) {
	     //    System.out.println("Got an exception!");
	      }
	   }
	/*
	@Test
	public void  queSePuedaCrearUnClienteDeBandaAncha() {
		ClienteBandaAncha nuevo = new ClienteBandaAncha(1000, "Camila", "camila@telecomunications.com");

		
		assertEquals(nuevo.getEMail(), "camila@telecomunications.com");
		
	}

	@Test
	public void  queSePuedaCrearUnClienteTri() {
		ClienteTri nuevo = new ClienteTri(1000, "Camila", "11", "63598237", "46546546504637", "camila@telecomunications.com");
		
		assertEquals(nuevo.getCodigoDeArea(), "11");
		assertEquals(nuevo.getCodigoDecodificador(), "46546546504637");
		assertEquals(nuevo.getEMail(), "camila@telecomunications.com");
		
	}
	
	@Test
	public void  queSePuedanIncorporarDistintosClientes() {		
		Empresa actual = new Empresa("Telecomunications");
		
		actual.agregarCliente(new ClienteTelefonia(1000, "Camila", "11", "63544437"));
		actual.agregarCliente(new ClienteTelefonia(1001, "Natalia", "11", "7777237"));
		actual.agregarCliente(new ClienteCable(1002, "Jorge", "46546546777788"));
		actual.agregarCliente(new ClienteTelefonia(1003, "Lucrecia", "23", "63888837"));
		actual.agregarCliente(new ClienteTri(1004, "Tamara", "11", "63598967", "46540099804637", "tamara@telecomunications.com"));
		actual.agregarCliente(new ClienteTelefonia(1005, "Alberto", "11", "63598887"));
		actual.agregarCliente(new ClienteTelefonia(1006, "Domingo", "11", "6300007"));
		actual.agregarCliente(new ClienteBandaAncha(1007, "Luciana", "luciana@telecomunications.com"));
		actual.agregarCliente(new ClienteBandaAncha(1008, "Luna", "luna@telecomunications.com"));
		actual.agregarCliente(new ClienteTri(1009, "Victor", "11", "63588887", "46543333324637", "victor@telecomunications.com"));
		actual.agregarCliente(new ClienteTelefonia(1004, "Tamara", "11", "63598967"));
		
		
		assertEquals((Integer) 10, actual.getCantidadAbonados());		
	}
	
	@Test
	public void  queUnClienteDeCablePuedaHabilitarElCodificado() throws NoEsClienteConCableException{		
		Cliente celeste = new ClienteCable(999, "Celeste", "4666666777788");
		Empresa actual = new Empresa("Telecomunications");
		
//		Cliente natalia=new ClienteTelefonia(1001, "Natalia", "11", "7777237");
//		
//		actual.agregarCliente(natalia);
//		
		actual.agregarCliente(new ClienteTelefonia(1000, "Camila", "11", "63544437"));
		actual.agregarCliente(new ClienteTelefonia(1001, "Natalia", "11", "7777237"));
		actual.agregarCliente(new ClienteCable(1002, "Jorge", "46546546777788"));
		actual.agregarCliente(new ClienteTelefonia(1003, "Lucrecia", "23", "63888837"));
		actual.agregarCliente(new ClienteTri(1004, "Tamara", "11", "63598967", "46540099804637", "tamara@telecomunications.com"));
		actual.agregarCliente(new ClienteTelefonia(1005, "Alberto", "11", "63598887"));
		actual.agregarCliente(new ClienteTelefonia(1006, "Domingo", "11", "6300007"));
		actual.agregarCliente(new ClienteBandaAncha(1007, "Luciana", "luciana@telecomunications.com"));
		actual.agregarCliente(new ClienteBandaAncha(1008, "Luna", "luna@telecomunications.com"));
		actual.agregarCliente(new ClienteTri(1009, "Victor", "11", "63588887", "46543333324637", "victor@telecomunications.com"));
		actual.agregarCliente(new ClienteTelefonia(1004, "Tamara", "11", "63598967"));
		
	    actual.agregarCliente(celeste);
		
	   //assertTrue(actual.habilitarPremium(Premium.FUTBOL, natalia));	
		
		assertTrue(actual.habilitarPremium(Premium.FUTBOL, celeste));
	}
	
	@Test (expected = NoEsClienteConCableException.class)
	public void  queUnClienteDeTelefoniaNoPuedaHabilitar () throws NoEsClienteConCableException{		
		Cliente celeste = new ClienteTelefonia(1000, "Camila", "11", "63544437");
		Empresa actual = new Empresa("Telecomunications");
		
		actual.agregarCliente(celeste);
		
		assertFalse(actual.habilitarPremium(Premium.FUTBOL, celeste));		
	} */

}
