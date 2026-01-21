package retoautomatizacion.Demo.Stepdefinitions;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import retoautomatizacion.Demo.Tareas.Compra;
import retoautomatizacion.Demo.Tareas.Login;
import retoautomatizacion.Demo.Tareas.AgregarCarrito;
import retoautomatizacion.Demo.Interfaz.Interfaz;
import io.cucumber.java.es.*;
import static net.serenitybdd.screenplay.GivenWhenThen.*;
import static org.hamcrest.Matchers.*;
import net.serenitybdd.screenplay.questions.Text;
import net.serenitybdd.screenplay.actors.OnStage;
public class stepdefinitionCarrito {

    @Cuando("él agrega el producto {string} al carrito")
    public void agregaProducto(String producto) {
        when(OnStage.theActorInTheSpotlight()).attemptsTo(AgregarCarrito.tituloProducto(producto));

    }
    @When("valido que se haya agregado el producto {string}")
    public void validoQueSeHayaAgregadoElProducto(String esperado) {
        try {
            Thread.sleep(5000); // 5 segundos
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        then(OnStage.theActorInTheSpotlight()).should(
                seeThat(Text.of(Interfaz.TITLE_PRODUCTO), containsString(esperado))
        );
    }
}
