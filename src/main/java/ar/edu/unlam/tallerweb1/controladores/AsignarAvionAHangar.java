package ar.edu.unlam.tallerweb1.controladores;

public class AsignarAvionAHangar {
    private String Nombre;
    private Boolean Ocupado;
    private Long idHangar;
    private Long idAvion;

    public AsignarAvionAHangar(String nombre, Boolean ocupado, Long idHangar, Long idAvion) {
        Nombre = nombre;
        Ocupado = ocupado;
        this.idHangar = idHangar;
        this.idAvion = idAvion;
    }

    public AsignarAvionAHangar(Long idHangar,Long idAvion){
        this.idHangar = idHangar;
        this.idAvion = idAvion;
    }


    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public Boolean getOcupado() {
        return Ocupado;
    }

    public void setOcupado(Boolean ocupado) {
        Ocupado = ocupado;
    }

    public Long getIdHangar() {
        return idHangar;
    }

    public void setIdHangar(Long idHangar) {
        this.idHangar = idHangar;
    }

    public Long getIdAvion() {
        return idAvion;
    }

    public void setIdAvion(Long idAvion) {
        this.idAvion = idAvion;
    }
}
