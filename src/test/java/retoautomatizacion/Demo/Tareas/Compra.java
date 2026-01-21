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
                    WaitUntil.the(Interfaz.CART_LINK, isVisible()).forNoMoreThan(5).seconds(),
                    on(Interfaz.CART_LINK),
                    on(Interfaz.PLACE_ORDER),
                    WaitUntil.the(Interfaz.NAME_FIELD, isVisible()).forNoMoreThan(5).seconds(),
                    WaitUntil.the(Interfaz.CARD_FIELD, isVisible()).forNoMoreThan(5).seconds(),
                    theValue(nombre).into(Interfaz.NAME_FIELD),
                    theValue(tarjeta).into(Interfaz.CARD_FIELD),
                    on(Interfaz.PURCHASE_BUTTON)
            );



    }
}
