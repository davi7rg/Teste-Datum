package davirodrigues;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * 
 * Classe reponsavel por mapeamento de objetos e implementacao dos metodos de
 * validacao dos steps dos testes
 * 
 * @author Davi Rodrigues - Analista de QA Senior 1
 * @since 09/03/2023
 * @version Teste Renner
 * 
 */

public class ProductPage extends GeralPage {

	HomePage homePage = new HomePage();

	/**
	 * Contrutor da classe inicializando a pagina acessada atraves do PageFactory
	 */
	public ProductPage() {
		PageFactory.initElements(ConfigTests.getDriver(), this);
	}

	// Mapeamento de Elementos

	@FindBy(xpath = "//*[@id='search_product']")
	protected WebElement inpuBusca;

	@FindBy(xpath = "//*[@id='submit_search']")
	protected WebElement botaoBusca;
	
	@FindBy(xpath = "//a[contains(text(), 'View Product')]")
	protected WebElement viewProduct;
	
	@FindBy(xpath = "//*[@id='quantity']")
	protected WebElement addProduct;
	
	@FindBy(xpath = "//span/button")
	protected WebElement buttonAddProduct;
	
	@FindBy(xpath = "//*[@id='cartModal']//button[contains(text(), 'Continue Shopping')]")
	protected WebElement buttonContinueBuy;
	
	@FindBy(xpath = "/html//div/div/div[2]/div/div[2]/div/div[1]/div[1]/a")
	protected WebElement buttonAddCart;


	// Metodos para validacao dos Steps(Passos dos cenarios)

	public void validateCampoBuscaElement() {

		try {
			highlightElement(inpuBusca, "Input 'Campo de Busca'");
			logPassed("Campo de busca encontrado com sucesso");
		} catch (IOException e) {
			logFailed("Campo de busca nao encontrado");
		}

	}
	
	public void validateBotaoBuscaElement() {

		try {
			highlightElement(botaoBusca, "Botao 'Botao busca'");
			logPassed("Botao 'Botao busca' encontrado com sucesso");
		} catch (IOException e) {
			logFailed("Botao 'Botao busca' nao encontrado");
		}

	}
	
	public void buscaElementStylishDress() throws InterruptedException {

		inpuBusca.click();
		inpuBusca.sendKeys("Stylish Dress");
		botaoBusca.click();
		scrollDown();
		scrollDown();
		viewProduct.click();
		Thread.sleep(3000);
		addProduct.click();
		addProduct.clear();
		addProduct.sendKeys("3");
		buttonAddProduct.click();
		
		Thread.sleep(3000);
		GeralPage.logPrint("Validando produto 1");
		buttonContinueBuy.click();
		
		homePage.products.click();

	}
	
	public void buscaElementBeautifulPeacockBlueCottonLinenSaree() throws InterruptedException {

		inpuBusca.click();
		inpuBusca.sendKeys("Beautiful Peacock Blue Cotton Linen Sare");
		botaoBusca.click();
		scrollDown();
		scrollDown();
		viewProduct.click();
		Thread.sleep(3000);
		addProduct.click();
		addProduct.clear();
		addProduct.sendKeys("2");
		buttonAddProduct.click();
		
		Thread.sleep(3000);
		GeralPage.logPrint("Validando produto 2");
		buttonContinueBuy.click();
		
		homePage.products.click();

	}
	
	public void buscaElementMenTshirt() {

		inpuBusca.click();
		inpuBusca.sendKeys("Men Tshirt");
		botaoBusca.click();
		scrollDown();
		scrollDown();
		buttonAddCart.click();
		
		homePage.cart.click();

	}
	
}