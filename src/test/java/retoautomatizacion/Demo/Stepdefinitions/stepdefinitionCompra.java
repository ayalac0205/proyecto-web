package retoautomatizacion.Demo.Stepdefinitions;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import retoautomatizacion.Demo.Tareas.Compra;
import retoautomatizacion.Demo.Interfaz.Interfaz;

import retoautomatizacion.Demo.Modelo.CompraDatos;
import retoautomatizacion.Demo.Questions.MensajeCompra;

import static net.serenitybdd.screenplay.GivenWhenThen.*;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.Matchers.*;
import net.serenitybdd.screenplay.questions.Text;
import net.serenitybdd.screenplay.actors.OnStage;
public class stepdefinitionCompra {



    @When("procedo a la compra con nombre {string} y tarjeta {string}")
    public void procedoALaCompraConNombreYTarjeta(String nombre, String tarjeta) {
        CompraDatos datos = CompraDatos.conDatos(nombre, tarjeta);
        when(theActorInTheSpotlight()).attemptsTo(Compra.con(datos));
    }


    @Then("debo validar el mensaje de compra exitosa {string}")
    public void deboValiadrElMensajeDeCompraExitosa(String mensaje) {
        try {
            Thread.sleep(5000); // 5 segundos
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        theActorInTheSpotlight().should(
                seeThat("El mensaje de compra", MensajeCompra.texto(), containsString(mensaje)));

    }
}
