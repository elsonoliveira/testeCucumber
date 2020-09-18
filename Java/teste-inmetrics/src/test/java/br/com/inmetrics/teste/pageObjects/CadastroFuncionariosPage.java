package br.com.inmetrics.teste.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.Select;

public class CadastroFuncionariosPage {
	
	public WebDriver driver;
	
	public CadastroFuncionariosPage (WebDriver driver) {
			this.driver = driver;
			PageFactory.initElements(new AjaxElementLocatorFactory(driver, 10), this);
	}
	@FindBy(xpath="//input[@id='inputNome']")
	@CacheLookup
	WebElement txtNome;
	
	@FindBy(xpath="//input[@id='cpf']")
	@CacheLookup
	WebElement txtCpf;
	
	@FindBy(xpath="//select[@id='slctSexo']")
	@CacheLookup
	WebElement selSexo;
	
	@FindBy(xpath="//input[@id='inputAdmissao']")
	@CacheLookup
	WebElement txtAdmissao;
	
	@FindBy(xpath="//input[@id='inputCargo']")
	@CacheLookup
	WebElement txtCargo;	
	
	@FindBy(xpath="//input[@id='dinheiro']")
	@CacheLookup
	WebElement txtDinheiro;
	
	@FindBy(xpath="//input[@id='clt']")
	@CacheLookup
	WebElement optClt;
	
	@FindBy(xpath="//input[@id='pj']")
	@CacheLookup
	WebElement optPj;	
	
	
	@FindBy(xpath="//input[@class='cadastrar-form-btn']")
	@CacheLookup
	WebElement btnEnviar;	

	@FindBy(xpath="//input[@class='cancelar-form-btn']")
	@CacheLookup
	WebElement btnCancelar;


	
	public boolean iscadastroFuncionarioPageValida() {
		return btnEnviar != null;
	}
	
	public void setNome (String nome) {
		txtNome.clear();
		txtNome.sendKeys(nome);
	}

	public void setCpf (String cpf) {
		txtCpf.clear();
		txtCpf.sendKeys(cpf);
	}

	public void setSexo (String sexo) {
		Select  select = new Select(selSexo);
		select.selectByVisibleText(sexo);
	}

	public void setAdmissao (String dataAdmissao) {
		txtAdmissao.clear();
		txtAdmissao.sendKeys(dataAdmissao);
	}

	public void setCargo (String cargo) {
		txtCargo.clear();
		txtCargo.sendKeys(cargo);
	}

	public void setDinheiro (String dinheiro) {
		txtDinheiro.clear();
		txtDinheiro.sendKeys(dinheiro);
	}

	public void setClt () {
		optClt.click();
	}

	public void setPj () {
		optPj.click();
	}
	public void clickEnviar() {
		btnEnviar.click();
	}
	public void clickCancelar() {
		btnCancelar.click();
	}	
	

}
