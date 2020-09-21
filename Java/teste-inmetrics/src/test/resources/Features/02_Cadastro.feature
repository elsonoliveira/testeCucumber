#Autor: elsonoliveira@gmail.com
#Pre-condicoes: no cenario para validar cadastro logins, incrementar o valor
#Exemplo: T0000006 para T0000007

Feature: Feature para testar o cadastro de logins

  Background: 
    Given Que eu execute o browser
    When Eu acesso o login da aplicacao
    Then Eu visualizo a pagina de login
    And Eu seleciono cadastro
    And Eu visualizo o formulario de cadastro de logins

  Scenario: Cenario para validar cadastro de logins com sucesso
    And Eu informo "T0000006" e "T0000006" e "T0000006" e cadastro
    Then Eu visualizo a pagina de login
    And Eu fecho o browser

  Scenario: Cenario para validar usuario ja cadastrado
    And Eu informo "T0000001" e "T0000001" e "T0000001" e cadastro
    Then Eu visualizo mensagem de usuario ja cadastrado
    And Eu fecho o browser
