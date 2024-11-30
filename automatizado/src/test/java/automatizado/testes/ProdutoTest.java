package automatizado.testes;

import automatizado.pageObject.ProdutoPO;
import org.junit.*;
import org.junit.runners.MethodSorters;

import static org.junit.Assert.assertEquals;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ProdutoTest extends BaseTest{
	
	private static ProdutoPO produtoPage;
	
	@BeforeClass
	public static void prepararTestes() {
		driver.get("file:///C:/Users/36129382023.1n/Downloads/autoautomatizado/sistema/produtos.html");
		produtoPage = new ProdutoPO(driver);
	}
	
	@Test
	public void TC001_DeveSairMensagemDeErroAoEnviarNomeVazio() {

		produtoPage.clicarDuasVezesBotaoCriar();
		produtoPage.digitarCodigo("0001");
		produtoPage.digitarData("01012000");
		produtoPage.digitarQuantidade("1");
		produtoPage.digitarValor("3");
		produtoPage.clicarBotaoSalvar();

		String resultado = produtoPage.obterMensagem();

		produtoPage.clicarBotaoX();

		assertEquals(resultado, "Todos os campos são obrigatórios para o cadastro!");
	}
	
	@Test
	public void TC002_DeveFecharTelaDeCadastroAoClicarNoBotaoXSemSalvarMesmoPreenchendoOCampoCodigo() {
		produtoPage.clicarUmaVezBotaoCriar();

		produtoPage.digitarCodigo("123");

		produtoPage.clicarBotaoX();

		Assert.assertFalse("O modal deveria estar fechado após clicar no botão X.", produtoPage.isModalVisivel());
	}

	@Test
	public void TC002_DeveSairMensagemDeErroAoEnviarTodosOsCamposVazios() {

		produtoPage.clicarUmaVezBotaoCriar();
		produtoPage.clicarBotaoSalvar();

		String resultado = produtoPage.obterMensagem();

		produtoPage.clicarBotaoX();

		assertEquals(resultado, "Todos os campos são obrigatórios para o cadastro!");
	}

}




