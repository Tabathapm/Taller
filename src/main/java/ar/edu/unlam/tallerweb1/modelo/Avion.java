package ar.edu.unlam.tallerweb1.modelo;

import javax.persistence.*;

@Entity
public class Avion {

	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long Id;
	    
	    @ManyToOne
	    private TipoAvion tipoAvion;

		@OneToOne(mappedBy = "avion")
		//@JoinColumn(name = "hangar_Id",referencedColumnName = "Id")
		private Hangar hangar;


	    private String nombre; //Despues vemos si lo cambiamos a tipo Date
	    

		public Long getId() {
			return Id;
		}

		public void setId(Long id) {
			Id = id;
		}

		public String getNombre() {
			return nombre;
		}

		public void setNombre(String nombre) {
			this.nombre = nombre;
		}

		public TipoAvion getTipoAvion() {
			return tipoAvion;
		}

		public void setTipoAvion(TipoAvion tipoAvion) {
			this.tipoAvion = tipoAvion;
		}

	public Hangar getHangar() {
		return hangar;
	}

	public void setHangar(Hangar hangar) {
		this.hangar = hangar;
	}
}
