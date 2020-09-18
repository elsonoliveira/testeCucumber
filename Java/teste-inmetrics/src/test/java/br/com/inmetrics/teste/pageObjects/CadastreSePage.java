package br.com.inmetrics.teste.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CadastreSePage {
	public WebDriver driver;
	
	public CadastreSePage (WebDriver driver) {
			this.driver = driver;
			PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//input[@name='username']")
	@CacheLookup
	WebElement txtUserName;

	@FindBy(xpath="//input[@name='pass']")
	@CacheLookup
	WebElement txtPassWord;

	@FindBy(xpath="//input[@name='confirmpass']")
	@CacheLookup
	WebElement txtConfirmPassWord;
	
	@FindBy(xpath="//button[@class='login100-form-btn']")
	@CacheLookup
	WebElement btnCadastrar;


	
	@FindBy(xpath="//span[@class='login100-form-title']")
	@CacheLookup
	WebElement tituloFormulario;

	@FindBy(xpath="//div[@class='p-t-10 p-b-1']//div[@class='container-login100-form-btn m-t-17 text-center']")
	@CacheLookup
	WebElement alertaUsuarioJaCadastrado;
	
	
	public void setUserName (String uname) {
		txtUserName.clear();
		txtUserName.sendKeys(uname);
	}

	public void setPassword (String pwd) {
		txtPassWord.clear();
		txtPassWord.sendKeys(pwd);
	}

	public void setConfirmPassword (String confPwd) {
		txtConfirmPassWord.clear();
		txtConfirmPassWord.sendKeys(confPwd);
	}
	public void clickCadastrar() {
		btnCadastrar.click();
	}
	public boolean formularioValido() {
		return tituloFormulario != null;
	}

	public boolean exibeAlertaUsuarioJaCadastrado() {

		return alertaUsuarioJaCadastrado != null;
	}
}
