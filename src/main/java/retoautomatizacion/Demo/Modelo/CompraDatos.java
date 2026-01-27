package retoautomatizacion.Demo.Modelo;

public class CompraDatos {

    private String nombre;
    private String tarjeta;

    public CompraDatos(String nombre, String tarjeta) {
        this.nombre = nombre;
        this.tarjeta = tarjeta;
    }

    public static CompraDatos conDatos(String nombre, String tarjeta) {
        return new CompraDatos(nombre, tarjeta);
    }

    public String getNombre() {
        return nombre;
    }

    public String getTarjeta() {
        return tarjeta;
    }

}
