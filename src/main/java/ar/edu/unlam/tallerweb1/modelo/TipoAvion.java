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
	 private Double carga;
	
	public Double getCarga() {
		return carga;
	}

	public void setCarga(Double carga) {
		this.carga = carga;
	}
	
	public Integer getCapacidad() {
		return capacidad;
	}

	public void setCapacidad(Integer capacidad) {
		this.capacidad = capacidad;
	}

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public CategoriaAvion getCategoriaAvion() {
		return categoriaAvion;
	}

	public void setCategoriaAvion(CategoriaAvion categoriaAvion) {
		this.categoriaAvion = categoriaAvion;
	}
	
	

}
