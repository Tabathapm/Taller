package ar.edu.unlam.tallerweb1.controladores;

public class DatosUsuario {


    private Long id;
    private String credencial;
    private String password;
    
    private Boolean activo = false;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return credencial;
    }

    public void setEmail(String email) {
        this.credencial = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getActivo() {
        return activo;
    }

    public void setActivo(Boolean activo) {
        this.activo = activo;
    }
}
