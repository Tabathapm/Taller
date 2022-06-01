package ar.edu.unlam.tallerweb1.controladores;

public class DatosLogin {
    private String credencial;
    private String password;

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
}
