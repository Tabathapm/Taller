package ar.edu.unlam.tallerweb1.modelo;

import org.hibernate.mapping.Join;

import javax.persistence.*;

@Entity
public class Hangar {

	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long Id;
	    
	    @OneToOne(cascade = {CascadeType.ALL})
		@JoinColumn(name = "avion_Id",referencedColumnName = "Id")
	    private Avion avion;

	    private String Nombre;
	    private Boolean Ocupado;

	public Hangar() {
	}

	public Hangar(Long id, Avion avion, String nombre, Boolean ocupado) {
		Id = id;
		this.avion = avion;
		Nombre = nombre;
		Ocupado = ocupado;
	}

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

		public Boolean getOcupado() {
			return Ocupado;
		}

		public void setOcupado(Boolean ocupado) {
			Ocupado = ocupado;
		}

		
}
