package ar.edu.unlam.tallerweb1.modelo;

import javax.persistence.*;
import java.util.List;

@Entity
public class Tripulante {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name ="vuelo_id")
    private Vuelo vuelo;

    private String nombre;

    public Vuelo getVuelo() {
        return vuelo;
    }

    public void setVuelo(Vuelo vuelo) {
        this.vuelo = vuelo;
    }

    private String apellido;
    private String titulo;
    private String inicioActividad; //pasar a date

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

	public String getInicioActividad() {
		return inicioActividad;
	}

	public void setInicioActividad(String inicioActividad) {
		this.inicioActividad = inicioActividad;
	}

}
