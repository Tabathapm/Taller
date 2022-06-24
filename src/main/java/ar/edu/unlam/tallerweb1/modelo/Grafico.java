package ar.edu.unlam.tallerweb1.modelo;

public class Grafico {

    private Long id;
    private String pais;

    public Grafico() {}

    public Grafico(Long id, String pais) {
        this.id = id;
        this.pais = pais;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }
}
