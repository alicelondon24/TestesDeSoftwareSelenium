package testesdesoftware.pageObject;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProdutoPO extends BasePO{
	
	
	@FindBy(id = "btn-adicionar")
	public WebElement buttonCriar;
	
	@FindBy(id = "btn-salvar")
	public WebElement buttonSalvar;
	
	@FindBy(id = "btn-sair")
	public WebElement buttonFechar;
	
	@FindBy(id = "codigo")
	public WebElement inputCodigo;
	
	@FindBy(id = "nome")
	public WebElement inputNome;
	
	@FindBy(id = "quantidade")
	public WebElement inputQuantidade;
		
	@FindBy(css = "div.modal-body>div.alert>span")
	public WebElement spanMensagem;

	
	
	/**
	 * Construtor padrão para criação de uma nova instância da página de cadastro de produtos
	 * @param driver Driver da página de produtos
	 * */
	public ProdutoPO(WebDriver driver) {
		super(driver);
	}
	
	public String obterMensagem() {
		return this.spanMensagem.getText();
	}
	
	public String obterBotaoCriar() {
		return this.buttonCriar.getText();
	}


	
	public void escrever(WebElement input, String texto) {
		input.clear();
		input.sendKeys(texto + Keys.TAB);
	}
	
	
	public void abrirCadastro() {
		buttonCriar.click();
	}
	
	public void fecharCadastro() {
		buttonFechar.click();
	}
	

	/**
	 * Método que tenta executar a ação no sistema
	 * @param codigo Código para tentativa de cadastro
	 * */
	
	public void executarAcaoDeCadastroCodigo(String codigo) {
		buttonCriar.click();
		escrever(inputCodigo, codigo);
		buttonSalvar.click();
	}
	
	public void executarAcaoDeCadastroNome(String nome) {
		escrever(inputNome, nome);
		buttonSalvar.click();
	}

}
