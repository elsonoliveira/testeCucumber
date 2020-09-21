package br.com.inmetrics.teste.support;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {

	
	@Before
	public void beforeScenario() {
		System.out.println("Execucao antes dos scenarios. Definindo propriedades...");

	}
	@After
	public void afterScenario() {
		System.out.println("Execucao depois dos scenarios");
	}
	

}
