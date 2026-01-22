//package retoautomatizacion.Demo.Alertas;
//
//
//import net.serenitybdd.screenplay.Actor;
//import net.serenitybdd.screenplay.Interaction;
//import net.serenitybdd.screenplay.Tasks;
//import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
//import org.openqa.selenium.Alert;
//import org.openqa.selenium.NoAlertPresentException;
//
//
//public class Alerta implements Interaction {
//
//    private final int timeoutInSeconds;
//
//    public Alerta(int timeoutInSeconds) {
//        this.timeoutInSeconds = timeoutInSeconds;
//    }
//
//    @Override
//    public <T extends Actor> void performAs(T actor) {
//        long end = System.currentTimeMillis() + (timeoutInSeconds * 1000);
//
//        while (System.currentTimeMillis() < end) {
//            try {
//                Alert alert = BrowseTheWeb.as(actor).getDriver().switchTo().alert();
//
//                // ✅ Si no falla, el alert ya apareció: leer y aceptar
//                String texto = alert.getText();   // opcional
//                alert.accept();                   // ✅ ACEPTAR EL ALERT
//                actor.remember("alert_text", texto); // opcional, por si quieres validar luego
//
//                return; // salir después de aceptar
//            } catch (NoAlertPresentException e) {
//                // seguimos esperando
//            }
//
//            try {
//                Thread.sleep(200);
//            } catch (InterruptedException ignored) {}
//        }
//
//        throw new AssertionError("El alert no apareció en " + timeoutInSeconds + " segundos");
//    }
//
//    // Factory: si quieres mantener el nombre anterior
//    public static Alerta forSeconds(int seconds) {
//        return Tasks.instrumented(Alerta.class, seconds);
//    }
//
//}


