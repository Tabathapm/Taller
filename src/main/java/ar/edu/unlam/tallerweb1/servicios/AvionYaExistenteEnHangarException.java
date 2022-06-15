package ar.edu.unlam.tallerweb1.servicios;

public class AvionYaExistenteEnHangarException extends Exception {

    String mensaje = "error";

    public AvionYaExistenteEnHangarException(String mensaje) {
        super(mensaje);
    }


}
