
package retoautomatizacion.Demo.Tareas;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;

import net.serenitybdd.screenplay.waits.WaitUntil;
import retoautomatizacion.Demo.Interfaz.Interfaz;

import static net.serenitybdd.screenplay.actions.Click.on;
import static net.serenitybdd.screenplay.actions.Enter.theValue;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class Login implements Task {

    private final String user;
    private final String pass;

    public Login(String user, String pass) {
        this.user = user;
        this.pass = pass;
    }

    public static Login conCredenciales(String user, String pass) {
        return Tasks.instrumented(Login.class, user, pass);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                on(Interfaz.BOTON_LOGIN),
                // Espera a que el campo usuario esté visible (más robusto que un sleep)
                WaitUntil.the(Interfaz.CAMPO_USUARIO, isVisible()).forNoMoreThan(10).seconds(),
                theValue(user).into(Interfaz.CAMPO_USUARIO),
                theValue(pass).into(Interfaz.CAMPO_PASSWORD),
                on(Interfaz.BOTON_ENVIAR_LOGIN)
        );
    }
}