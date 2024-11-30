package automatizado.testes;

import automatizado.pageObject.GooglePO;
import automatizado.pageObject.LoginPO;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.Keys;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class LoginTest extends BaseTest{
	
	private static LoginPO loginPage;
	
	@BeforeClass
	public static void prepararTestes() {
//		driver.get("file:///C:/Users/36129382023.1n/Downloads/autoautomatizado/sistema/login.html");
		loginPage = new LoginPO(driver);
	}
	
	@Test
	//public void pesquisarNoGoogle() {
	public void TC001_naoDeveLogarNoSistemaComEmailESenhaVazios() {

		loginPage.inputEmail.sendKeys("");
		loginPage.inputSenha.sendKeys("");
		loginPage.buttonEntrar.click();

		loginPage.obterMensagem();

		String resultado = loginPage.obterMensagem();

		assertEquals(resultado, "Informe usuário e senha, os campos não podem ser brancos.");
	}
	
	@Test
	//public void pesquisarNoGoogle2() {
	public void TC002_naoDeveLogarNoSistemaComEmailIncorretoESenhaVazia() {
//		googlePage.inputPesquisa.sendKeys("Receita de bolo de laranja" + Keys.ENTER);
//
//		String resultado = googlePage.divResultadoPesquisa.getText();
//
//		assertTrue(resultado, resultado.contains("bolo de laranja"));
//		assertTrue(resultado.toLowerCase(), resultado.contains("Bolo de Laranja".toLowerCase()));
	}
	
	
	//Método que utiliza todos os isolamentos que implementamos em GooglePO
	//Nível máximo de isolamento
	@Test
	//public void pesquisarNoGoogle3() {
	public void TC003_deveSerPossivelPesquisarNoGoogleTextoReceitaDeBoloDeLaranja() {
//		//googlePage.inputPesquisa.sendKeys("Receita de bolo de laranja" + Keys.ENTER);
//		googlePage.pesquisar("Receita de bolo de laranja");
//
//		//String resultado = googlePage.divResultadoPesquisa.getText();
//		String resultado = googlePage.getResultadoDaPesquisa();
//
//		assertTrue(resultado, resultado.contains("bolo de laranja"));
//		assertTrue(resultado.toLowerCase(), resultado.contains("Bolo de Laranja".toLowerCase()));
	}
	
	
	
}




