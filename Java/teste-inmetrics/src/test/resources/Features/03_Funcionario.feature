#Autor: elsonoliveira@gmail.com
Feature: Teste do Cadastro de Funcionario

    
  Background: 
    Given Que eu execute o browser Chrome
    When Eu acesso a pagina "http://www.inmrobo.tk/accounts/login/"
    Then Eu visualizo a pagina de login
    Then Eu informo login "T0000001" e senha "T0000001"
    And Eu visualizo o cadastro de funcionario
    When Eu seleciono opcao Novo Funcionario
    Then Eu visualizo o cadastro de funcionarios

  Scenario Outline: Cadastro de funcionario com sucesso
    Then Informo o nome "<nome>"
    And Informo o CPF "<cpf>"
    And Seleciono o Sexo "<sexo>"
    And Informo a data de admissao "<admissao>"
    And Informo o Cargo "<cargo>"
    And Informo o Salario "<dinheiro>"
    And Informo o tipo de contratacao "<regime>"
    And Seleciono Enviar
    Then Eu visualizo o cadastro de funcionarios
    And Vejo mensagem de sucesso
    And Eu fecho o browser

    Examples: 
      | nome            | cpf            | sexo      | admissao   | cargo       | dinheiro | regime |
      | Pitoco Oliveira | 116.665.435-43 | Masculino | 25/09/2019 | Programador | 4.500,00 | CLT    |
      | Perola Vidal    | 478.610.299-72 | Feminino    | 12/03/2018 | Testador    | 7.250,00 | PJ     |
      | Tobias Cajueiro | 201.585.481-91 | Indiferente | 10/11/2017 | Gerente     | 8.200,00 | CLT    |
      