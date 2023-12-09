package testesdesoftware.teste;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import testesdesoftware.pageObject.ProdutoPO;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ProdutoTest extends BaseTest {
	
	private static ProdutoPO produtoPage;

	@BeforeClass
	public static void prepararTestes() {
		produtoPage = new ProdutoPO(driver);
	}
	
	
//	@Test
//	public void TC001_naoDeveCadastrarComTodosCamposVazios() {
//		produtoPage.abrirCadastro();
//		produtoPage.executarAcaoDeCadastroCodigo("");
//		
//		String mensagem = produtoPage.obterMensagem();
//		
//		assertEquals(mensagem, "Todos os campos são obrigatórios para o cadastro!");
//	}
	
	@Test
	public void TC001_naoDeveCadastrarComCodigo() {
		produtoPage.abrirCadastro();
		produtoPage.executarAcaoDeCadastroCodigo("01");
	
		String mensagem = produtoPage.obterMensagem();
		
		assertEquals(mensagem, "Todos os campos são obrigatórios para o cadastro!");
	}
	
	@Test
	public void TC002_fecharCadastro() {
		produtoPage.fecharCadastro();
	
		String texto = produtoPage.obterBotaoCriar();
		
		assertEquals(texto, "Criar");
	}
	
	@Test
	public void TC003_naoDeveCadastrarComNome() {
		produtoPage.executarAcaoDeCadastroNome("produto");
	
		String mensagem = produtoPage.obterMensagem();
		
		assertEquals(mensagem, "Todos os campos são obrigatórios para o cadastro!");
	}
	



}
