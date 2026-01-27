package retoautomatizacion.Demo.Modelo;

public class Usuario {

    private String usuario;
    private String password;

    public Usuario(String usuario, String password) {
        this.usuario = usuario;
        this.password = password;
    }

    public static Usuario conDatos(String usuario, String password) {
        return new Usuario(usuario, password);
    }

    public String getUsuario() {
        return usuario;
    }

    public String getPassword() {
        return password;
    }

}
