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
    private Long Id;
        
    @ManyToOne
    private Locacion origen;
    
    @ManyToOne
    private Locacion destino;
    
    @OneToOne
    private Avion avion;
    
    private String nombre;

    private Date salida;
    private Date llegada;
    
    private Date llegadaReal;
    private Long horasReales;
    private Long minutosReales;
    private Long horasEstimadas;
    private Long minutosEstimados;
    
    
    
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

    public Long getHorasReales() {
		return horasReales;
	}

	public void setHorasReales(Long horasReales) {
		this.horasReales = horasReales;
	}

	public Long getHorasEstimadas() {
		return horasEstimadas;
	}

	public void setHorasEstimadas(Long horasEstimadas) {
		this.horasEstimadas = horasEstimadas;
	}

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		this.Id = id;
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

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Date getLlegadaReal() {
		return llegadaReal;
	}

	public void setLlegadaReal(Date llegadaReal) {
		this.llegadaReal = llegadaReal;
	}

	public Long getMinutosReales() {
		return minutosReales;
	}

	public void setMinutosReales(Long minutosReales) {
		this.minutosReales = minutosReales;
	}

	public Long getMinutosEstimados() {
		return minutosEstimados;
	}

	public void setMinutosEstimados(Long minutosEstimados) {
		this.minutosEstimados = minutosEstimados;
	}
	
	
	
}
