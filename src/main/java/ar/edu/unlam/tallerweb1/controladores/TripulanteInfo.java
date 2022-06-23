package ar.edu.unlam.tallerweb1.controladores;

import java.util.Date;

public class TripulanteInfo {

    private String nombre;
    private String apellido;
    private String titulo;
    private String inicioActividad;

    private Long horasActivo;
    private Long horasDescanso;
    private boolean estado;

    public TripulanteInfo(String nombre, String apellido, String titulo, String inicioActividad, Long horasActivo, Long horasDescanso, boolean estado) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.titulo = titulo;
        this.inicioActividad = inicioActividad;
        this.horasActivo = horasActivo;
        this.horasDescanso = horasDescanso;
        this.estado = estado;
    }

    public TripulanteInfo() {
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

    public Long getHorasActivo() {
        return horasActivo;
    }

    public void setHorasActivo(Long horasActivo) {
        this.horasActivo = horasActivo;
    }

    public Long getHorasDescanso() {
        return horasDescanso;
    }

    public void setHorasDescanso(Long horasDescanso) {
        this.horasDescanso = horasDescanso;
    }

    public boolean getEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }
}
