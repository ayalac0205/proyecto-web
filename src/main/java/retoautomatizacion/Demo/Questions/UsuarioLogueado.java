package retoautomatizacion.Demo.Questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;
import net.serenitybdd.screenplay.Question;
import retoautomatizacion.Demo.Interfaz.Interfaz;

public class UsuarioLogueado implements Question<String> {

    public static UsuarioLogueado  texto() {
        return new UsuarioLogueado();
    }

    @Override
    public String answeredBy(Actor actor) {
        return Text.of(Interfaz.USUARIO_LOGUEADO).answeredBy(actor);
    }

}
