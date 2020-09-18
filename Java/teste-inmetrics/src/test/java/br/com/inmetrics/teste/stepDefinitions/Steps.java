package br.com.inmetrics.teste.stepDefinitions;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import br.com.inmetrics.teste.pageObjects.CadastreSePage;
import br.com.inmetrics.teste.pageObjects.CadastroFuncionariosPage;
import br.com.inmetrics.teste.pageObjects.FuncionariosPage;
import br.com.inmetrics.teste.pageObjects.LoginPage;
import io.cucumber.java.en.*;

public class Steps {

	public WebDriver driver;
	public LoginPage lp;
	public FuncionariosPage fp;
	public CadastreSePage csp;
	public CadastroFuncionariosPage cfp;

	// ********************************************
	// Steps relacionados ao manipulacao do browser
	// ********************************************

	
	@Given("Que eu execute o browser Chrome")
	public void que_eu_execute_o_browser_Chrome() {

		System.setProperty("webdriver.chrome.driver", "/home/elson/devtools/chromedriver_linux64/chromedriver");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		lp=new LoginPage(driver);
		fp=new FuncionariosPage(driver);
		csp=new CadastreSePage(driver);
		cfp=new CadastroFuncionariosPage(driver);
	

	}

	@When("Eu acesso a pagina {string}")
	public void eu_acesso_a_pagina(String url) {

		driver.get(url);
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
		if (lp.loginPageValida()) {
			System.out.println("Pagina de login carregada");	
		}

	}

	@Then("Eu informo login {string} e senha {string}")
	public void eu_informo_login_e_senha(String userName, String passWord) {
	   
	    lp.setUserName(userName);
	    lp.setPassword(passWord);
	    lp.clickLogin();
	}



	
	@Then("Eu visualizo a mensagem de erro")
	public void eu_visualizo_a_mensagem_de_erro() {
	    // Write code here that turns the phrase above into concrete actions
	    if (lp.alertaLoginInvalido()) {
	    	System.out.println("Alerta de login invalido Ok");
	    }
	}

	@And("Eu seleciono cadastro")
	public void eu_seleciono_cadastro() {
	    lp.clickCadastreSe();
	}
	
	// *****************************************************
	// Steps relacionados ao cadastro de usuarios do sistema
	// *****************************************************
	
	@Then("Eu visualizo o formulario de cadastro de logins")
	public void eu_visualizo_o_formulario_de_cadastro_de_logins() {
		if (csp.formularioValido()) {
			System.out.println("Visualizo pagina Cadastre-se.");
		}
	}

	@Then("Eu informo {string} e {string} e {string} e cadastro")
	public void eu_informo_e_cadastro(String uname, String pass, String confPass) {
		csp.setUserName(uname);
		csp.setPassword(pass);
		csp.setConfirmPassword(confPass);
		csp.clickCadastrar();
	
	}

	@Then("Eu visualizo mensagem de usuario ja cadastrado")
	public void eu_visualizo_mensagem_de_usuario_ja_cadastrado() {
	
		if (csp.exibeAlertaUsuarioJaCadastrado()) {
			System.out.println("Alerta de usuario ja cadastrado exibido");
		}
		
	}



	// *****************************************************
	// Steps relacionados a tela de cadastro de funcionarios
	// ******************************************************
	
	@Then("Eu visualizo o cadastro de funcionarios")
	public void eu_visualizo_o_cadastro_de_funcionarios() {
		if (cfp.iscadastroFuncionarioPageValida()){
			System.out.println("Pagina de cadastro de funcionario ok.");			
			
		}
	}

	
	@Then("^Informo o nome \"([^\"]*)\"$")
	public void informo_o_nome(String nome) {
		cfp.setNome(nome);
	}

	@Then("^Informo o CPF \"([^\"]*)\"$")
	public void informo_o_CPF(String cpf) {
		cfp.setCpf(cpf);
	}

	@Then("^Seleciono o Sexo \"([^\"]*)\"$")
	public void seleciono_o_Sexo(String sexo) {
		cfp.setSexo(sexo);
		
	}

	@Then("^Informo a data de admissao \"([^\"]*)\"$")
	public void informo_a_data_de_admissao(String dtAdmissao) {
		cfp.setAdmissao(dtAdmissao);
	
	}

	@Then("^Informo o Cargo \"([^\"]*)\"$")
	public void informo_o_Cargo(String cargo) {
		cfp.setCargo(cargo);
	}

	@Then("^Informo o Salario \"([^\"]*)\"$")
	public void informo_o_Salario(String dinheiro) {
		cfp.setDinheiro(dinheiro);
	
	}

	@Then("^Informo o tipo de contratacao \"([^\"]*)\"$")
	public void informo_o_tipo_de_contratacao(String regime) {
		if (regime.equals("CLT")) {
			cfp.setClt();
		}else {
			cfp.setPj();
		}
	
	}
	
	@Then("eu visualizo o registro pesquisado")
	public void eu_visualizo_o_registro_pesquisado() {
		if (cfp.iscadastroFuncionarioPageValida()) {
			System.out.println("Estou no registro pesquisado.");
		}
	}

	@Then("altero o cargo para {string}")
	public void altero_o_cargo_para(String novoCargo) {
		cfp.setCargo(novoCargo);

	}


	

	@Then("Seleciono Enviar")
	public void seleciono_Enviar() {
		cfp.clickEnviar();
	
	}

	// *****************************************************
	// Steps relacionados a tela de funcionarios
	// ******************************************************

	@And("Vejo mensagem de sucesso")
	public void vejo_mensagem_de_sucesso() {
		if (fp.isAlertaSucesso()) {
			System.out.println("Cadastro funcionario realizado com sucesso.");
		}
	}


	
	@Then("Eu visualizo o cadastro de funcionario")
	public void eu_visualizo_o_cadastro_de_funcionario() {

	    if (fp.funcionariosPageValida()) {
	    	System.out.println("Visualizo a pagina de funcionarios");
	    }
	}

	@Then("Eu clico na opcao sair")
	public void eu_clico_na_opcao_sair() {
	
	    fp.clickSair();
	}	
	
	@When("Eu seleciono opcao Novo Funcionario")
	public void eu_seleciono_opcao_Novo_Funcionario() {

		fp.clickNovoFuncionario();
	}	
	

	@Given("Que eu pesquise um funcionario pelo CPF {string}")
	public void que_eu_pesquise_um_funcionario_pelo_CPF(String cpf) {
			
		fp.setPesquisa(cpf);
	}

	@When("Eu selecionar editar")
	public void eu_selecionar_editar() {

		fp.clickEditar();
	}
	@When("Eu selecionar Excluir")
	public void eu_selecionar_Excluir() {
		fp.clickExcluir();
	}

	
}
