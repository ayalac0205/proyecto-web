package retoautomatizacion.Demo.Tareas;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.waits.WaitUntil;
import retoautomatizacion.Demo.Interfaz.Interfaz;
//import net.serenitybdd.screenplay.actions.AcceptAlert;

import static net.serenitybdd.screenplay.actions.Click.on;
import static net.serenitybdd.screenplay.actions.Enter.theValue;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;


public class Compra implements Task {
    private final String nombre;
    private final String tarjeta;


    public Compra(String nombre, String tarjeta) {
        this.nombre = nombre;
        this.tarjeta = tarjeta;
    }


    public static Compra datosCompra(String nombre, String tarjeta ) {
        return Tasks.instrumented(Compra.class, nombre, tarjeta);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
            actor.attemptsTo(

// Espera a que el enlace del producto esté visible
                    WaitUntil.the(Interfaz.CARRITO, isVisible()).forNoMoreThan(5).seconds(),
                    on(Interfaz.CARRITO),
                    on(Interfaz.REALIZAR_PEDIDO),
                    WaitUntil.the(Interfaz.CAMPO_NOMBRE, isVisible()).forNoMoreThan(5).seconds(),
                    WaitUntil.the(Interfaz.CAMPO_TARJETA, isVisible()).forNoMoreThan(5).seconds(),
                    theValue(nombre).into(Interfaz.CAMPO_NOMBRE),
                    theValue(tarjeta).into(Interfaz.CAMPO_TARJETA),
                    on(Interfaz.BOTON_COMPRA)
            );



    }
}
