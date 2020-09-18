 package br.com.inmetrics.teste.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	public WebDriver driver;
	
	public LoginPage (WebDriver driver) {
			this.driver = driver;
			PageFactory.initElements(driver, this);
	}
	

	
	@FindBy(name="username")
	@CacheLookup
	WebElement txtUserName;
	
	@FindBy(name="pass")
	@CacheLookup
	WebElement txtPassWord;
	
	@FindBy(xpath="//button[@class='login100-form-btn']")
	@CacheLookup
	WebElement btnLogin;
	
	@FindBy(xpath="//span[@class='login100-form-title p-b-1']")
	@CacheLookup
	WebElement formLogin;
	
	@FindBy(xpath="//div[@class='alert alert-danger alert-dismissible fade show']")
	@CacheLookup
	WebElement alertaErro;
	
	@FindBy(xpath="//div[@class='w-full text-center p-t-30']/a[contains(.,'Cadastre-se')]")
	@CacheLookup
	WebElement linkCadastreSe;
	
	
	public void setUserName (String uname) {
			txtUserName.clear();
			txtUserName.sendKeys(uname);
	}

	public void setPassword (String pwd) {
			txtPassWord.clear();
			txtPassWord.sendKeys(pwd);
	}

	public void clickLogin () {
			btnLogin.click();
	}

	public boolean loginPageValida() {
			
		return formLogin != null;
	}
	
	public boolean alertaLoginInvalido() {
		return alertaErro != null;
		
	}
	
	public void clickCadastreSe() {
		linkCadastreSe.click();
	}
}
