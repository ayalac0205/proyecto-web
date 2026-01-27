package retoautomatizacion.Demo.Tareas;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.conditions.Check;
import net.serenitybdd.screenplay.waits.WaitUntil;

import retoautomatizacion.Demo.Interfaz.Interfaz;
import retoautomatizacion.Demo.Modelo.Usuario;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class Login implements Task {

    private final Usuario usuario;

    public Login(Usuario usuario) {
        this.usuario = usuario;
    }

    public static Login con(Usuario usuario) {
        return Tasks.instrumented(Login.class, usuario);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(
                Click.on(Interfaz.BOTON_LOGIN),

                WaitUntil.the(Interfaz.CAMPO_USUARIO, isVisible())
                        .forNoMoreThan(10).seconds(),

                Enter.theValue(usuario.getUsuario()).into(Interfaz.CAMPO_USUARIO),
                Enter.theValue(usuario.getPassword()).into(Interfaz.CAMPO_PASSWORD),

                Click.on(Interfaz.BOTON_ENVIAR_LOGIN)
        );
    }
}