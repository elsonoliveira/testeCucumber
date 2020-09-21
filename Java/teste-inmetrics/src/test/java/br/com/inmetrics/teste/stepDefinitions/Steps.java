package br.com.inmetrics.teste.stepDefinitions;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import br.com.inmetrics.teste.managers.PageObjectManager;
import br.com.inmetrics.teste.managers.WebDriverManager;
import br.com.inmetrics.teste.pageObjects.CadastreSePage;
import br.com.inmetrics.teste.pageObjects.CadastroFuncionariosPage;
import br.com.inmetrics.teste.pageObjects.FuncionariosPage;
import br.com.inmetrics.teste.pageObjects.LoginPage;
import br.com.inmetrics.teste.support.ConfigFileReader;
import io.cucumber.java.en.*;

public class Steps {

	WebDriver driver;
	LoginPage loginPage;
	FuncionariosPage funcionariosPage;
	CadastreSePage cadastreSePage;
	CadastroFuncionariosPage cadastroFuncionariosPage;
	PageObjectManager pageObjectManager;
	WebDriverManager webDriverManager;
	
	// ********************************************
	// Steps relacionados ao manipulacao do browser
	// ********************************************

	
	@Given("Que eu execute o browser")
	public void que_eu_execute_o_browser() {
		webDriverManager = new WebDriverManager();
		driver = webDriverManager.getDriver();

		pageObjectManager = new PageObjectManager(driver);
		loginPage = pageObjectManager.getLoginPage();
		cadastreSePage = pageObjectManager.getCadastreSePage();
		funcionariosPage = pageObjectManager.getFuncionariosPage();
		cadastroFuncionariosPage = pageObjectManager.getCadastroFuncionariosPage();

	}

	@When("Eu acesso o login da aplicacao")
	public void eu_acesso_login() {
		

		 loginPage.abriPagina();
		
	}
	
	@Then("Eu fecho o browser")
	public void eu_fecho_o_browser() {

		driver.close();
	}

	
	// ************************************
	// Steps relacionados a tela de login
	// ************************************

	
	@Then("Eu visualizo a pagina de login")
	public void eu_visualizo_a_pagina_de_login() {
		if (!loginPage.loginPageValida()) {
			System.out.println("Atençaõ: pagina de login com problemas");	
		}

	}

	@Then("Eu informo login {string} e senha {string}")
	public void eu_informo_login_e_senha(String userName, String passWord) {
	   
	    loginPage.setUserName(userName);
	    loginPage.setPassword(passWord);
	    loginPage.clickLogin();
	}



	
	@Then("Eu visualizo a mensagem de erro")
	public void eu_visualizo_a_mensagem_de_erro() {

	    if (!loginPage.alertaLoginInvalido()) {
	    	System.out.println("Atenção, não mostrou o alerta de login invalido!");
	    }
	}

	@And("Eu seleciono cadastro")
	public void eu_seleciono_cadastro() {
	    loginPage.clickCadastreSe();
	}
	
	// *****************************************************
	// Steps relacionados ao cadastro de usuarios do sistema
	// *****************************************************
	
	@Then("Eu visualizo o formulario de cadastro de logins")
	public void eu_visualizo_o_formulario_de_cadastro_de_logins() {

		if (cadastreSePage.formularioValido()) {
			System.out.println("Visualizo pagina Cadastre-se.");
		}
	}

	@Then("Eu informo {string} e {string} e {string} e cadastro")
	public void eu_informo_e_cadastro(String uname, String pass, String confPass) {
		cadastreSePage .setUserName(uname);
		cadastreSePage .setPassword(pass);
		cadastreSePage .setConfirmPassword(confPass);
		cadastreSePage .clickCadastrar();
	
	}

	@Then("Eu visualizo mensagem de usuario ja cadastrado")
	public void eu_visualizo_mensagem_de_usuario_ja_cadastrado() {
	
		if (!cadastreSePage .exibeAlertaUsuarioJaCadastrado()) {
			System.out.println("Atenção: Alerta de usuario ja cadastrado não foi exibido!");
		}
		
	}



	// *****************************************************
	// Steps relacionados a tela de cadastro de funcionarios
	// ******************************************************
	
	@Then("Eu visualizo o cadastro de funcionarios")
	public void eu_visualizo_o_cadastro_de_funcionarios() {
		
		if (!cadastroFuncionariosPage.iscadastroFuncionarioPageValida()){
			System.out.println("Atencao: Pagina de cadastro de funcionario com problemas!");			
			
		}
	}

	
	@Then("^Informo o nome \"([^\"]*)\"$")
	public void informo_o_nome(String nome) {
		cadastroFuncionariosPage.setNome(nome);
	}

	@Then("^Informo o CPF \"([^\"]*)\"$")
	public void informo_o_CPF(String cpf) {
		cadastroFuncionariosPage.setCpf(cpf);
	}

	@Then("^Seleciono o Sexo \"([^\"]*)\"$")
	public void seleciono_o_Sexo(String sexo) {
		cadastroFuncionariosPage.setSexo(sexo);
		
	}

	@Then("^Informo a data de admissao \"([^\"]*)\"$")
	public void informo_a_data_de_admissao(String dtAdmissao) {
		cadastroFuncionariosPage.setAdmissao(dtAdmissao);
	
	}

	@Then("^Informo o Cargo \"([^\"]*)\"$")
	public void informo_o_Cargo(String cargo) {
		cadastroFuncionariosPage.setCargo(cargo);
	}

	@Then("^Informo o Salario \"([^\"]*)\"$")
	public void informo_o_Salario(String dinheiro) {
		cadastroFuncionariosPage.setDinheiro(dinheiro);
	
	}

	@Then("^Informo o tipo de contratacao \"([^\"]*)\"$")
	public void informo_o_tipo_de_contratacao(String regime) {
		if (regime.equals("CLT")) {
			cadastroFuncionariosPage.setClt();
		}else {
			cadastroFuncionariosPage.setPj();
		}
	
	}
	
	@Then("eu visualizo o registro pesquisado")
	public void eu_visualizo_o_registro_pesquisado() {
		if (cadastroFuncionariosPage.iscadastroFuncionarioPageValida()) {
			System.out.println("Estou no registro pesquisado.");
		}
	}

	@Then("altero o cargo para {string}")
	public void altero_o_cargo_para(String novoCargo) {
		cadastroFuncionariosPage.setCargo(novoCargo);

	}


	

	@Then("Seleciono Enviar")
	public void seleciono_Enviar() {
		cadastroFuncionariosPage.clickEnviar();
	
	}

	// *****************************************************
	// Steps relacionados a tela de funcionarios
	// ******************************************************

	@Then("Eu visualizo o cadastro de funcionario")
	public void eu_visualizo_o_cadastro_de_funcionario() {

	    if (!funcionariosPage.funcionariosPageValida()) {
	    	System.out.println("Atenção. Pagina de funcionarios com problemas!");
	    }
	}
	
	@And("Vejo mensagem de sucesso")
	public void vejo_mensagem_de_sucesso() {
		if (funcionariosPage.isAlertaSucesso()) {
			System.out.println("Cadastro funcionario realizado com sucesso.");
		}
	}


	


	@Then("Eu clico na opcao sair")
	public void eu_clico_na_opcao_sair() {
	
		funcionariosPage.clickSair();
	}	
	
	@When("Eu seleciono opcao Novo Funcionario")
	public void eu_seleciono_opcao_Novo_Funcionario() {

		funcionariosPage.clickNovoFuncionario();
	}	
	

	@Given("Que eu pesquise um funcionario pelo CPF {string}")
	public void que_eu_pesquise_um_funcionario_pelo_CPF(String cpf) {
			
		funcionariosPage.setPesquisa(cpf);
	}

	@When("Eu selecionar editar")
	public void eu_selecionar_editar() {

		funcionariosPage.clickEditar();
	}
	@When("Eu selecionar Excluir")
	public void eu_selecionar_Excluir() {
		funcionariosPage.clickExcluir();
	}

	
}
