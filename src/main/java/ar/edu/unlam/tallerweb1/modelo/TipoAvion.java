package ar.edu.unlam.tallerweb1.modelo;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class TipoAvion {
	
	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 private Long Id;
	 
	 @Enumerated(EnumType.STRING)
	 private CategoriaAvion categoriaAvion;
	 
	 private Integer capacidad;
	 private Double Carga;
	
	public Double getCarga() {
		return Carga;
	}

	public void setCarga(Double carga) {
		Carga = carga;
	}

	public Integer getCapacidad() {
		return capacidad;
	}

	public void setCapacidad(Integer capacidad) {
		this.capacidad = capacidad;
	}

}
