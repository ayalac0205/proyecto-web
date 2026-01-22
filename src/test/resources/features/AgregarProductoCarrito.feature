Feature: Compra de un producto en Demoblaze
  Como usuario
  Quiero agregar un producto al carrito y comprarlo
  Para completar una orden

  Background:
    Given que Brandon abre la página de Demoblaze
    And él inicia sesión con usuario "qabrandon123" y contraseña "qabrandon123"
    And debería ver el usuario logueado en la barra "Welcome qabrandon123"

  @prueba @carrito
  Scenario: Compra exitosa de un teléfono
    When él agrega el producto "Samsung galaxy s6" al carrito
    Then valido que se haya agregado el producto "Samsung galaxy s6"

