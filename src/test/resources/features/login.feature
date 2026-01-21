#Feature: Login en Demoblaze
#  Como usuario de Demoblaze
#  Quiero iniciar sesión
#  Para ver mi nombre en la barra superior
#
#  Background:
#    Given que Brandon abre la página de Demoblaze
#@prueba
#  Scenario: Login correcto
#    When él inicia sesión con usuario "qabrandon123" y contraseña "qabrandon123"
#    Then debería ver el usuario logueado en la barra "Welcome qabrandon123"


Feature: Login en Demoblaze
  Como usuario de Demoblaze
  Quiero iniciar sesión
  Para ver mi nombre en la barra superior

  Background:
    Given que Brandon abre la página de Demoblaze

  @prueba @login
  Scenario Outline: Login correcto con credenciales válidas
    When él inicia sesión con usuario "<usuario>" y contraseña "<contraseña>"
    Then debería ver el usuario logueado en la barra "Welcome <usuario>"

    Examples:
      | usuario        | contraseña     |
      | qabrandon123   | qabrandon123   |
      # | qauserdemo     | qauserdemo     |

