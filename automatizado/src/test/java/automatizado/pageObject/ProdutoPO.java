package automatizado.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProdutoPO extends BasePO{

	/*	PageFactory: injeta em tempo de execução (cria dinamicamente) uma lógica de teste
	da classe de teste que instancia GooglePO, no caso GoogleTestRefatorado2
	O elemento/código que cria a factory está em BasePO (PageFactory.initElements(driver, this))
	que é herdada por Google PO	*/

	@FindBy(id = "btn-adicionar")
	public WebElement buttonAdicionar;

	@FindBy(id = "codigo")
	public WebElement inputCodigo;

	@FindBy(id = "quantidade")
	public WebElement inputQuantidade;

	@FindBy(id = "valor")
	public WebElement inputValor;

	@FindBy(id = "data")
	public WebElement inputData;

	@FindBy(id = "btn-salvar")
	public WebElement buttonSalvar;

	@FindBy(id = "mensagem")
	public WebElement spanMensagem;

	@FindBy(className = "close")
	public WebElement buttonX;

	/**
	 * Construtor para criação da página no Login
	 * @param driver (Driver da página do Login)
	 */
	public ProdutoPO(WebDriver driver) {
		super(driver);
	}

	public void clicarDuasVezesBotaoCriar() {
		buttonAdicionar.click();
		buttonAdicionar.click();
	}

	public void clicarUmaVezBotaoCriar() {
		buttonAdicionar.click();
	}

	public void digitarCodigo(String texto) {
		inputCodigo.sendKeys(texto);
	}

	public void digitarQuantidade(String texto) {
		inputQuantidade.sendKeys(texto);
	}

	public void digitarValor(String texto) {
		inputValor.sendKeys(texto);
	}

	public void digitarData(String texto) {
		inputData.sendKeys(texto);
	}

	public String obterMensagem() {
		return this.spanMensagem.getText();
	}

	public void clicarBotaoX() {
		WebElement botaoFechar = driver.findElement(By.cssSelector(".modal-header .close"));
		botaoFechar.click();
	}

	public void clicarBotaoSalvar() {
		buttonSalvar.click();
	}

	public boolean isModalVisivel() {
		try {
			WebElement modal = driver.findElement(By.className("modal-content"));
			return modal.isDisplayed() && modal.getCssValue("display").equals("block");
		} catch (NoSuchElementException e) {
			return false;
		}
	}

}
