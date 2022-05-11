package ar.edu.unlam.tallerweb1.modelo;

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

    private String fecha; //Despues vemos si lo cambiamos a tipo Date
    private String hora;
    
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

	public CategoriaAvion getTipoAvion() {
		return tipoAvion;
	}

	public void setTipoAvion(CategoriaAvion tipoAvion) {
		this.tipoAvion = tipoAvion;
	}
}
