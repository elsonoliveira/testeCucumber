package br.com.inmetrics.teste.managers;


import org.openqa.selenium.WebDriver;

import br.com.inmetrics.teste.pageObjects.CadastreSePage;
import br.com.inmetrics.teste.pageObjects.CadastroFuncionariosPage;
import br.com.inmetrics.teste.pageObjects.FuncionariosPage;
import br.com.inmetrics.teste.pageObjects.LoginPage;


public class PageObjectManager {

	private WebDriver driver;
	private LoginPage loginPage;
	private CadastreSePage cadastreSePage;
	private FuncionariosPage funcionariosPage;
	private CadastroFuncionariosPage cadastroFuncionariosPage;
	
	public PageObjectManager(WebDriver driver) {

		this.driver = driver;

	}
	
	public LoginPage getLoginPage() {
		return (loginPage == null)? loginPage = new LoginPage(driver):loginPage;
		
	}
	
	public CadastreSePage getCadastreSePage() {
		return (cadastreSePage == null)? cadastreSePage = new CadastreSePage (driver): cadastreSePage;
		
	}

	public FuncionariosPage getFuncionariosPage() {
		return (funcionariosPage == null)? funcionariosPage = new FuncionariosPage (driver): funcionariosPage;
		
	}

	public CadastroFuncionariosPage getCadastroFuncionariosPage() {
		return (cadastroFuncionariosPage == null)? cadastroFuncionariosPage = new CadastroFuncionariosPage (driver): cadastroFuncionariosPage;
		
	}
	

}
