Feature: Compra de un producto en Demoblaze
  Como usuario
  Quiero agregar un producto al carrito y comprarlo
  Para completar una orden

Background:
  Given que Brandon abre la página de Demoblaze
  And él inicia sesión con usuario "qabrandon123" y contraseña "qabrandon123"
  And debería ver el usuario logueado en la barra "Welcome qabrandon123"
#@prueba2
#  Scenario: Compra exitosa de un teléfono
#  When procedo a la compra con nombre "Brandon" y tarjeta "1234 5678 9999"
#  Then debo validar el mensaje de compra exitosa "Thank you for your purchase!"

  @prueba @compra
  Scenario Outline: Compra realizada satisfactoriamente
    When procedo a la compra con nombre "<nombre>" y tarjeta "<tarjeta>"
    Then debo validar el mensaje de compra exitosa "Thank you for your purchase!"

    Examples:
      | nombre        | tarjeta     |
      | brandon       | 987654321   |

