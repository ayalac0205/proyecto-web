
package retoautomatizacion.Demo.Interfaz;

import net.serenitybdd.screenplay.targets.Target;

public class Interfaz {

    public static final String URL = "https://www.demoblaze.com";

    public static final Target BOTON_LOGIN = Target.the("botón login").locatedBy("#login2");
    public static final Target CAMPO_USUARIO = Target.the("usuario").locatedBy("#loginusername");
    public static final Target CAMPO_PASSWORD = Target.the("password").locatedBy("#loginpassword");
    public static final Target BOTON_ENVIAR_LOGIN = Target.the("enviar login").locatedBy("//button[text()='Log in']");
    public static final Target USUARIO_LOGUEADO = Target.the("usuario en barra").locatedBy("#nameofuser");
    public static final Target TITULO_PRODUCTO = Target.the("titulo producto").locatedBy("#tbodyid > tr:nth-child(1) > td:nth-child(2)");

    // Productos y carrito
    public static final Target PRODUCTO_POR_NOMBRE =
            Target.the("producto por nombre").locatedBy("//a[contains(@class,'hrefch') and text()='{0}']");
    public static final Target AÑADIR_AL_CARRITO = Target.the("añadir al carrito").locatedBy("//a[text()='Add to cart']");
    public static final Target CARRITO = Target.the("carrito").locatedBy("#cartur");
    public static final Target VALOR_ID = Target.the("ID").locatedBy("div.sweet-alert.showSweetAlert.visible h2");

    // Checkout
    public static final Target REALIZAR_PEDIDO = Target.the("Place Order").locatedBy("//button[text()='Place Order']");
    public static final Target CAMPO_NOMBRE = Target.the("nombre").locatedBy("#name");
    public static final Target CAMPO_TARJETA = Target.the("tarjeta").locatedBy("#card");
    public static final Target BOTON_COMPRA = Target.the("Purchase").locatedBy("//button[text()='Purchase']");

}



