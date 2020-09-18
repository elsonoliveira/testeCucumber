#Author: elsonoliveira@ygmail.com
Feature: Teste de exclusao de registro de Funcionario

  Background: 
    Given Que eu execute o browser Chrome
    When Eu acesso a pagina "http://www.inmrobo.tk/accounts/login/"
    Then Eu visualizo a pagina de login
    Then Eu informo login "T0000001" e senha "T0000001"
    And Eu visualizo o cadastro de funcionario

  Scenario: Exclusao de funcionario com sucesso
    Given Que eu pesquise um funcionario pelo CPF "201.585.481-91"
    When Eu selecionar Excluir
    And Vejo mensagem de sucesso
    And Eu fecho o browser
