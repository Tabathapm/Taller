package ar.edu.unlam.tallerweb1.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Hangar {

	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long Id;
	    
	    @OneToOne
	    private Avion avion;
	    
	    private String Nombre;
	    
	    public Long getId() {
			return Id;
		}

		public void setId(Long id) {
			Id = id;
		}

		public String getNombre() {
			return Nombre;
		}

		public void setNombre(String nombre) {
			Nombre = nombre;
		}

		public Avion getAvion() {
			return avion;
		}

		public void setAvion(Avion avion) {
			this.avion = avion;
		}

		
}
