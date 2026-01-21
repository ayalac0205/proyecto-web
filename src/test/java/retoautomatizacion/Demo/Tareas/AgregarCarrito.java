package retoautomatizacion.Demo.Tareas;
import io.appium.java_client.ios.options.wda.SupportsAutoAcceptAlertsOption;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.waits.WaitUntil;
import retoautomatizacion.Demo.Interfaz.Interfaz;
//import net.serenitybdd.screenplay.actions.AcceptAlert;
import retoautomatizacion.Demo.Alertas.Alerta;

import javax.swing.*;

import static net.serenitybdd.screenplay.actions.Click.on;
import static net.serenitybdd.screenplay.actions.Enter.theValue;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isClickable;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;
public class AgregarCarrito implements Task {

    private final String tituloProducto;

    public AgregarCarrito(String tituloProducto) {
        this.tituloProducto = tituloProducto;
    }

    public static AgregarCarrito tituloProducto(String tituloProducto) {
        return Tasks.instrumented(AgregarCarrito.class, tituloProducto);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(Interfaz.PRODUCTO_POR_NOMBRE.of(tituloProducto), isVisible())
                .forNoMoreThan(5).seconds(),
                on(Interfaz.PRODUCTO_POR_NOMBRE.of(tituloProducto)),
                on(Interfaz.ADD_TO_CART),
                Alerta.forSeconds(5),
                WaitUntil.the(Interfaz.CART_LINK, isVisible()).forNoMoreThan(5).seconds(),
                on(Interfaz.CART_LINK)
        );
    }
}
