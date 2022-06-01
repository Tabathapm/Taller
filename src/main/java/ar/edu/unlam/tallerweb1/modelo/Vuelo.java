package ar.edu.unlam.tallerweb1.modelo;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Vuelo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne
    private Locacion origen;
    
    @ManyToOne
    private Locacion destino;
    
    @OneToOne
    private Avion avion;

    private String fecha;
	private String hora;
    private Date llegada;
    private Date estimado;


	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public String getHora() {
		return hora;
	}

	public void setHora(String hora) {
		this.hora = hora;
	}

	public Avion getAvion() {
		return avion;
	}

	public void setAvion(Avion avion) {
		this.avion = avion;
	}

//	public String getSalida() {
//		return salida;
//	}
//
//	public void setSalida(String salida) {
//		this.salida = salida;
//	}

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
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

}
