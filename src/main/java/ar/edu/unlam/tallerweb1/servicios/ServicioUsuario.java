package ar.edu.unlam.tallerweb1.servicios;

import ar.edu.unlam.tallerweb1.modelo.Usuario;

public interface ServicioUsuario {

    Usuario consultarUsuario(String email, String password);
}
