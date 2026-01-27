
package retoautomatizacion.Demo.Interfaz;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class Interfaz {

    public static final String URL = "https://www.demoblaze.com";

    // =========================
    // Login (prioridad: ID)
    // =========================
    public static final Target BOTON_LOGIN =
            Target.the("botón login").located(By.id("login2"));

    public static final Target CAMPO_USUARIO =
            Target.the("usuario").located(By.id("loginusername"));

    public static final Target CAMPO_PASSWORD =
            Target.the("password").located(By.id("loginpassword"));

    // En Demoblaze este botón suele NO tener id -> XPath robusto
    public static final Target BOTON_ENVIAR_LOGIN =
            Target.the("enviar login")
                    .locatedBy("//button[contains(normalize-space(.),'Log in')]");

    public static final Target USUARIO_LOGUEADO =
            Target.the("usuario en barra").located(By.id("nameofuser"));

    // =========================
    // Productos
    // =========================

    // ⚠️ Corregido: antes tenías &gt; (escape HTML). Debe ser ">"
    // Aun así, este selector puede ser frágil por el nth-child. Lo mantengo pero corregido.
    public static final Target TITULO_PRODUCTO =
            Target.the("titulo producto")
                    .locatedBy("#tbodyid > tr:nth-child(1) > td:nth-child(2)");

    // Producto por nombre (parametrizable). Mejorado para tolerar espacios.
    public static final Target PRODUCTO_POR_NOMBRE =
            Target.the("producto por nombre")
                    .locatedBy("//a[contains(@class,'hrefch') and contains(normalize-space(.),'{0}')]");

    // En Demoblaze normalmente no hay id -> XPath robusto
    public static final Target AÑADIR_AL_CARRITO =
            Target.the("añadir al carrito")
                    .locatedBy("//a[contains(normalize-space(.),'Add to cart')]");

    // =========================
    // Carrito
    // =========================
    public static final Target CARRITO =
            Target.the("carrito").located(By.id("cartur"));

    // Alerta SweetAlert (CSS ok)
    public static final Target VALOR_ID =
            Target.the("ID")
                    .locatedBy("div.sweet-alert.showSweetAlert.visible h2");

    // =========================
    // Checkout
    // =========================

    // En Demoblaze normalmente no hay id -> XPath robusto
    public static final Target REALIZAR_PEDIDO =
            Target.the("Place Order")
                    .locatedBy("//button[contains(normalize-space(.),'Place Order')]");

    public static final Target CAMPO_NOMBRE =
            Target.the("nombre").located(By.id("name"));

    public static final Target CAMPO_TARJETA =
            Target.the("tarjeta").located(By.id("card"));

    // En Demoblaze normalmente no hay id -> XPath robusto
    public static final Target BOTON_COMPRA =
            Target.the("Purchase")
                    .locatedBy("//button[contains(normalize-space(.),'Purchase')]");
}
