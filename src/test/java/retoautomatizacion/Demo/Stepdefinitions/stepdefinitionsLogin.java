package retoautomatizacion.Demo.Stepdefinitions;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.es.*;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.waits.WaitUntil;

import retoautomatizacion.Demo.Interfaz.Interfaz;
import retoautomatizacion.Demo.Tareas.Login;
import retoautomatizacion.Demo.Modelo.Usuario;
import retoautomatizacion.Demo.Questions.UsuarioLogueado;

import static net.serenitybdd.screenplay.GivenWhenThen.*;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;
import static org.hamcrest.Matchers.containsString;

public class stepdefinitionsLogin {

    @Before
    public void setStage() {
        OnStage.setTheStage(new OnlineCast());
    }

    @Given("que Brandon abre la página de Demoblaze")
    public void abrirDemoblaze() {
        OnStage.theActorCalled("Brandon")
                .wasAbleTo(Open.url(Interfaz.URL));
    }

    @When("él inicia sesión con usuario {string} y contraseña {string}")
    public void iniciaSesion(String user, String pass) {

        Usuario datos = Usuario.conDatos(user, pass);

        theActorInTheSpotlight()
                .attemptsTo(Login.con(datos));
    }

    @Then("debería ver el usuario logueado en la barra {string}")
    public void validaUsuario(String esperado) {

        theActorInTheSpotlight().attemptsTo(
                WaitUntil.the(Interfaz.USUARIO_LOGUEADO, isVisible())
                        .forNoMoreThan(10).seconds()
        );

        theActorInTheSpotlight().should(
                seeThat(UsuarioLogueado.texto(), containsString(esperado))
        );
    }
}