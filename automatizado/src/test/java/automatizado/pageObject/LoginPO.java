package automatizado.pageObject;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPO extends BasePO{

	/*	PageFactory: injeta em tempo de execução (cria dinamicamente) uma lógica de teste
	da classe de teste que instancia GooglePO, no caso GoogleTestRefatorado2
	O elemento/código que cria a factory está em BasePO (PageFactory.initElements(driver, this))
	que é herdada por Google PO	*/

	@FindBy(id = "email")
	public WebElement inputEmail; //padrão do nome da variavel: nome do elemento html + o que ele representa(id ou nome);

	@FindBy(id = "senha")
	public WebElement inputSenha;

	@FindBy(id = "btn-entrar")
	public WebElement buttonEntrar;

	@FindBy(id = "mensagem")
	public WebElement spanMensagem;


	/**
	 * Construtor para criação da página no Login
	 * @param driver (Driver da página do Login)
	 */
	public LoginPO(WebDriver driver) {
		super(driver);
	}

	public void digitarEmail(String texto) {
		inputEmail.sendKeys(texto + Keys.TAB);
	}

	public void digitarSenhaEEnter(String texto) {
		inputSenha.sendKeys(texto + Keys.ENTER);
	}

	public void digitarSenha(String texto) {
		inputSenha.sendKeys(texto);
	}

	public String obterMensagem() {
		return this.spanMensagem.getText();
	}
}
