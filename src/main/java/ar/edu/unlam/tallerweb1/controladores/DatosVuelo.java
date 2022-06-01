package ar.edu.unlam.tallerweb1.controladores;

import java.lang.reflect.Array;

public class DatosVuelo {

    private String origen;
    private String destino;
    private String fecha;
    private String hora;
    private String tipoDeAvion;
    private String piloto;
    private String copiloto;
    private String tripulantes;
    private String ingDeVuelo;


    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
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

    public String getTipoDeAvion() {
        return tipoDeAvion;
    }

    public void setTipoDeAvion(String tipoDeAvion) {
        this.tipoDeAvion = tipoDeAvion;
    }

    public String getPiloto() {
        return piloto;
    }

    public void setPiloto(String piloto) {
        this.piloto = piloto;
    }

    public String getCopiloto() {
        return copiloto;
    }

    public void setCopiloto(String copiloto) {
        this.copiloto = copiloto;
    }

    public String getTripulantes() {
        return tripulantes;
    }

    public void setTripulantes(String tripulantes) {
        this.tripulantes = tripulantes;
    }

    public String getIngDeVuelo() {
        return ingDeVuelo;
    }

    public void setIngDeVuelo(String ingDeVuelo) {
        this.ingDeVuelo = ingDeVuelo;
    }
}
