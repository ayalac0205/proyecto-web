
package retoautomatizacion.Demo.Stepdefinitions;

import retoautomatizacion.Demo.Tareas.Login;
import retoautomatizacion.Demo.Interfaz.Interfaz;

import io.cucumber.java.es.*;
import net.serenitybdd.screenplay.questions.Text;
import net.serenitybdd.screenplay.actors.OnStage;

import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static net.serenitybdd.screenplay.GivenWhenThen.*;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;
import static org.hamcrest.Matchers.containsString;

public class stepdefinitionsLogin {

    @Dado("que Brandon abre la página de Demoblaze")
    public void abrirDemoblaze() {
        // SRP: abrir la página es responsabilidad del Given (no de la Task de login)
        givenThat(OnStage.theActorCalled("Brandon"))
                .wasAbleTo(Open.url(Interfaz.URL));
    }

    @Cuando("él inicia sesión con usuario {string} y contraseña {string}")
    public void iniciaSesion(String user, String pass) {
        when(OnStage.theActorInTheSpotlight())
                .attemptsTo(Login.conCredenciales(user, pass));
    }

    @Entonces("debería ver el usuario logueado en la barra {string}")
    public void validaUsuario(String esperado) {
        // Espera explícita a que el label sea visible antes de validar el texto
        when(OnStage.theActorInTheSpotlight())
                .attemptsTo(WaitUntil.the(Interfaz.USUARIO_LOGUEADO, isVisible())
                        .forNoMoreThan(10).seconds());

        then(OnStage.theActorInTheSpotlight()).should(
                seeThat(Text.of(Interfaz.USUARIO_LOGUEADO), containsString(esperado))
        );
    }
}
