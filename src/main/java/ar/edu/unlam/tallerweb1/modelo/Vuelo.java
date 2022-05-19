package ar.edu.unlam.tallerweb1.modelo;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Vuelo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    
    @Enumerated(EnumType.STRING)
    private CategoriaAvion tipoAvion;
    
    @ManyToOne
    private Locacion origen;
    
    @ManyToOne
    private Locacion destino;
    
    @OneToOne
    private Avion avion;
    
    private String nombre;

    private Date salida;
    private Date llegada;
    private Date estimado;
    
    
    
    public Avion getAvion() {
		return avion;
	}

	public void setAvion(Avion avion) {
		this.avion = avion;
	}

	public Date getSalida() {
		return salida;
	}

	public void setSalida(Date salida) {
		this.salida = salida;
	}

	public Date getLlegada() {
		return llegada;
	}

	public void setLlegada(Date llegada) {
		this.llegada = llegada;
	}

	public Date getEstimado() {
		return estimado;
	}

	public void setEstimado(Date estimado) {
		this.estimado = estimado;
	}

	public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public Locacion getOrigen() {
		return origen;
	}

	public void setOrigen(Locacion origen) {
		this.origen = origen;
	}

	public Locacion getDestino() {
		return destino;
	}

	public void setDestino(Locacion destino) {
		this.destino = destino;
	}


	public CategoriaAvion getTipoAvion() {
		return tipoAvion;
	}

	public void setTipoAvion(CategoriaAvion tipoAvion) {
		this.tipoAvion = tipoAvion;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
}
