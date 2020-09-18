package br.com.inmetrics.teste.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class FuncionariosPage {
	
	public WebDriver driver;
	
	public FuncionariosPage (WebDriver driver) {
			this.driver = driver;
			PageFactory.initElements(new AjaxElementLocatorFactory(driver, 15), this);
	}
	@FindBy(xpath="//a[.='Funcionários']")
	@CacheLookup
	WebElement btnFuncionarios;
	
	@FindBy(xpath="//a[.='Novo Funcionário']")
	@CacheLookup
	WebElement btnNovoFuncionario;

	@FindBy(xpath="//a[.='Sair']")
	@CacheLookup
	WebElement btnSair;
	
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible fade show']")
	@CacheLookup
	WebElement alertaSucesso;

	@FindBy(xpath="//div[@id='tabela_filter']//input[1]")
	@CacheLookup
	WebElement txtPesquisa;
	
	@FindBy(xpath="//button[@class='btn btn-warning']")
	@CacheLookup
	WebElement btnEditar;
	
	@FindBy(xpath="//button[@id='delete-btn']")
	@CacheLookup
	WebElement btnExcluir;
	
	
	
	public boolean funcionariosPageValida() {

		return btnFuncionarios != null;
	}
	
	public void clickSair () {
		
		btnSair.click();
	}
	public void clickNovoFuncionario() {
		
		btnNovoFuncionario.click();
	}
	
	public boolean isAlertaSucesso() {
		
		return alertaSucesso != null;
	}
	public void setPesquisa(String chave) {
		
		txtPesquisa.clear();
		txtPesquisa.sendKeys(chave);
	}
	public void clickEditar() {
		
		btnEditar.click();
	}
	
	public void clickExcluir() {
		
		btnExcluir.click();
	}
}
