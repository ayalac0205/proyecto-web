package retoautomatizacion.Demo.Questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.serenitybdd.screenplay.questions.Text;
import retoautomatizacion.Demo.Interfaz.Interfaz;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class MensajeCompra implements Question<String>{

    public static MensajeCompra texto() {
        return new MensajeCompra();
    }

    @Override
    public String answeredBy(Actor actor) {

        // Espera inteligente: no necesitamos sleeps en Steps
        WaitUntil.the(Interfaz.VALOR_ID, isVisible())
                .forNoMoreThan(10).seconds()
                .performAs(actor);

        return Text.of(Interfaz.VALOR_ID).answeredBy(actor);
    }

}
