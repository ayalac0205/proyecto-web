package retoautomatizacion.Demo.Tareas;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.waits.WaitUntil;
import retoautomatizacion.Demo.Interfaz.Interfaz;
import retoautomatizacion.Demo.Modelo.CompraDatos;

import static net.serenitybdd.screenplay.actions.Click.on;
import static net.serenitybdd.screenplay.actions.Enter.theValue;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class Compra implements Task {

    private final CompraDatos datos;

    public Compra(CompraDatos datos) {
        this.datos = datos;
    }

    public static Compra con(CompraDatos datos) {
        return Tasks.instrumented(Compra.class, datos);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(

                WaitUntil.the(Interfaz.CARRITO, isVisible()).forNoMoreThan(5).seconds(),
                on(Interfaz.CARRITO),

                on(Interfaz.REALIZAR_PEDIDO),

                WaitUntil.the(Interfaz.CAMPO_NOMBRE, isVisible()).forNoMoreThan(5).seconds(),
                WaitUntil.the(Interfaz.CAMPO_TARJETA, isVisible()).forNoMoreThan(5).seconds(),

                theValue(datos.getNombre()).into(Interfaz.CAMPO_NOMBRE),
                theValue(datos.getTarjeta()).into(Interfaz.CAMPO_TARJETA),

                on(Interfaz.BOTON_COMPRA)
        );
    }
}