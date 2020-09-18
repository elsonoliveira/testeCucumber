#Autor: elsonoliveira@gmail.com
Feature: Teste de Edicao de registro de Funcionario

  Background: 
    Given Que eu execute o browser Chrome
    When Eu acesso a pagina "http://www.inmrobo.tk/accounts/login/"
    Then Eu visualizo a pagina de login
    Then Eu informo login "T0000001" e senha "T0000001"
    And Eu visualizo o cadastro de funcionario

  Scenario: Edicao de funcionario com sucesso
    Given Que eu pesquise um funcionario pelo CPF "116.665.435-43"
    When Eu selecionar editar
    Then eu visualizo o registro pesquisado
    And altero o cargo para "Engenheiro de Teste"
    And Seleciono Enviar
    Then Eu visualizo o cadastro de funcionarios
    And Vejo mensagem de sucesso
    And Eu fecho o browser
