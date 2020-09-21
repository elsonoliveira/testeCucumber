Feature: Feature para testar o login da Inmetrics

  Background: 
    Given Que eu execute o browser
    When Eu acesso o login da aplicacao
    Then Eu visualizo a pagina de login

  Scenario: Cenario para validar login com sucesso para usuario e senha validos
    Then Eu informo login "T0000001" e senha "T0000001"
    And Eu visualizo o cadastro de funcionario
    And Eu clico na opcao sair
    And Eu fecho o browser

  Scenario: Cenario validar a falha de login com credenciais incorretas
    Then Eu informo login "T0000001" e senha "T000000x"
    Then Eu visualizo a mensagem de erro
    And Eu fecho o browser
