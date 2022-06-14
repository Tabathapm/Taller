package ar.edu.unlam.tallerweb1.modelo;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Tripulante {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    
	private String nombre;
    private String apellido;
    private String titulo;
    
    private Date inicioActividad;
    
    private Long horasActivo;
    private Long horasDecanso;
    private Boolean estado;
    
    
    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        this.Id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

	public Date getInicioActividad() {
		return inicioActividad;
	}

	public void setInicioActividad(Date inicioActividad) {
		this.inicioActividad = inicioActividad;
	}

	public Long getHorasActivo() {
		return horasActivo;
	}

	public void setHorasActivo(Long horasActivo) {
		this.horasActivo = horasActivo;
	}

	public Boolean getEstado() {
		return estado;
	}

	public void setEstado(Boolean estado) {
		this.estado = estado;
	}

	public Long getHorasDecanso() {
		return horasDecanso;
	}

	public void setHorasDecanso(Long horasDecanso) {
		this.horasDecanso = horasDecanso;
	}
	
    

}
