package retoautomatizacion.Demo.Stepdefinitions;
import io.cucumber.java.en.When;
import retoautomatizacion.Demo.Tareas.Compra;
import retoautomatizacion.Demo.Interfaz.Interfaz;
import io.cucumber.java.es.*;
import static net.serenitybdd.screenplay.GivenWhenThen.*;
import static org.hamcrest.Matchers.*;
import net.serenitybdd.screenplay.questions.Text;
import net.serenitybdd.screenplay.actors.OnStage;
public class stepdefinitionCompra {



    @When("procedo a la compra con nombre {string} y tarjeta {string}")
    public void procedoALaCompraConNombreYTarjeta(String nombre, String tarjeta) {

//        System.out.println(">> Step procedeCompra - nombre=[" + nombre + "], tarjeta=[" + tarjeta + "]");
//
//        if (nombre == null || tarjeta == null) {
//            throw new IllegalArgumentException("Nombre o tarjeta llegaron nulos desde el step.");
//        }

        when(OnStage.theActorInTheSpotlight()).attemptsTo(Compra.datosCompra(nombre,tarjeta));
    }


    @Entonces("debo validar el mensaje de compra exitosa {string}")
    public void deboValiadrElMensajeDeCompraExitosa(String mensaje) {
        try {
            Thread.sleep(5000); // 5 segundos
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        then(OnStage.theActorInTheSpotlight()).should(
                seeThat(Text.of(Interfaz.VALOR_ID), containsString(mensaje))
        );
    }
}
