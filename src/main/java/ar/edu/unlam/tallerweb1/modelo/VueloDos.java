package ar.edu.unlam.tallerweb1.modelo;

import java.sql.Time;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class VueloDos {

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

//  --- FECHAS ---
    private Date fechaSalida;
    private Date fechaLlegada;
    private Date fechaSalidaReal;
    private Date fechaLlegadaReal;
    private Date fechaEstimada;

//  --- HORAS ---
    private Time horaSalida;
    private Time horaLlegada;
    private Time horaLlegadaReal;
    private Time horaSalidaReal;
    private Time horaEstimada;

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

    public Avion getAvion() {
        return avion;
    }

    public void setAvion(Avion avion) {
        this.avion = avion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Date getFechaSalida() {
        return fechaSalida;
    }

    public void setFechaSalida(Date fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

    public Date getFechaLlegada() {
        return fechaLlegada;
    }

    public void setFechaLlegada(Date fechaLlegada) {
        this.fechaLlegada = fechaLlegada;
    }

    public Date getFechaSalidaReal() {
        return fechaSalidaReal;
    }

    public void setFechaSalidaReal(Date fechaSalidaReal) {
        this.fechaSalidaReal = fechaSalidaReal;
    }

    public Date getFechaLlegadaReal() {
        return fechaLlegadaReal;
    }

    public void setFechaLlegadaReal(Date fechaLlegadaReal) {
        this.fechaLlegadaReal = fechaLlegadaReal;
    }

    public Date getFechaEstimada() {
        return fechaEstimada;
    }

    public void setFechaEstimada(Date fechaEstimada) {
        this.fechaEstimada = fechaEstimada;
    }

    public Time getHoraSalida() {
        return horaSalida;
    }

    public void setHoraSalida(Time horaSalida) {
        this.horaSalida = horaSalida;
    }

    public Time getHoraLlegada() {
        return horaLlegada;
    }

    public void setHoraLlegada(Time horaLlegada) {
        this.horaLlegada = horaLlegada;
    }

    public Time getHoraLlegadaReal() {
        return horaLlegadaReal;
    }

    public void setHoraLlegadaReal(Time horaLlegadaReal) {
        this.horaLlegadaReal = horaLlegadaReal;
    }

    public Time getHoraSalidaReal() {
        return horaSalidaReal;
    }

    public void setHoraSalidaReal(Time horaSalidaReal) {
        this.horaSalidaReal = horaSalidaReal;
    }

    public Time getHoraEstimada() {
        return horaEstimada;
    }

    public void setHoraEstimada(Time horaEstimada) {
        this.horaEstimada = horaEstimada;
    }
}
