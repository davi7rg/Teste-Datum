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

public class HomePage extends GeralPage {

	/**
	 * Contrutor da classe inicializando a pagina acessada atraves do PageFactory
	 */
	public HomePage() {
		PageFactory.initElements(ConfigTests.getDriver(), this);
	}

	// Mapeamento de Elementos

//	@FindBy(id = "buttonOK")
//	protected WebElement buttonOKID;

	@FindBy(xpath = "//*[@id='header']//img")
	protected WebElement logoAutomationExercise;

	@FindBy(xpath = "//*[@id='header']//a[contains(text( ), 'Home')]")
	protected WebElement home;

	@FindBy(xpath = "//*[@id='header']//a[contains(text( ), 'Products')]")
	protected WebElement products;

	@FindBy(xpath = "//*[@id='header']//a[contains(text( ), 'Cart')]")
	protected WebElement cart;

	@FindBy(xpath = "//*[@id='header']//a[contains(text( ), 'Signup / Login')]")
	protected WebElement signupLogin;

	@FindBy(xpath = "//*[@id='header']//a[contains(text( ), 'Test Cases')]")
	protected WebElement testCases;

	@FindBy(xpath = "//*[@id='header']//a[contains(text( ), 'API Testing')]")
	protected WebElement apiTesting;

	@FindBy(xpath = "//*[@id='header']//a[contains(text( ), 'Video Tutorials')]")
	protected WebElement videoTutorials;

	@FindBy(xpath = "//*[@id='header']//a[contains(text( ), 'Contact us')]")
	protected WebElement contactUs;
	
	@FindBy(xpath = "//*[@id='header']//a[contains(text( ), 'Logout')]")
	protected WebElement logout;

	// Metodos para validacao dos Steps(Passos dos cenarios)

	public void validateLogoElement() {

		try {
			highlightElement(logoAutomationExercise, "Logo 'Automation Exercise'");
			logPassed("Logo 'Automation Exercise' encontrada com sucesso");
		} catch (IOException e) {
			logFailed("Logo 'Automation Exercise' não encontrada");
		}

	}

	public void validateHomeElement() {

		try {
			highlightElement(home, "Home 'Menu Home'");
			logPassed("Home 'Menu Home' encontrado com sucesso");
		} catch (IOException e) {
			logFailed("Home 'Menu Home' nao encontrado");
		}

	}

	public void validateProductsElement() {

		try {
			highlightElement(products, "Products 'Menu Products'");
			logPassed("Products 'Menu Products' encontrado com sucesso");
		} catch (IOException e) {
			logFailed("Products 'Menu Products' nao encontrado");
		}

	}

	public void validateCartElement() {

		try {
			highlightElement(cart, "Cart 'Menu Cart'");
			logPassed("Cart 'Menu Cart' encontrado com sucesso");
		} catch (IOException e) {
			logFailed("Cart 'Menu Cart' nao encontrado");
		}

	}

	public void validateSignupLoginElement() {

		try {
			highlightElement(signupLogin, "Signup / Login 'Cadastro e Login'");
			logPassed("Signup / Login 'Cadastro e Login' encontrado com sucesso");
		} catch (IOException e) {
			logFailed("Signup / Login 'Cadastro e Login' nao encontrado");
		}

	}

	public void validateTestCasesElement() {

		try {
			highlightElement(testCases, "Test Cases 'Casos de Testes'");
			logPassed("Test Cases 'Casos de Testes' encontrado com sucesso");
		} catch (IOException e) {
			logFailed("Test Cases 'Casos de Testes' nao encontrado");
		}

	}

	public void validateAPITestingElement() {

		try {
			highlightElement(apiTesting, "APITesting 'API de Teste'");
			logPassed("APITesting 'API de Teste' encontrado com sucesso");
		} catch (IOException e) {
			logFailed("APITesting 'API de Teste' encontrado");
		}

	}

	public void validateVideoTutorialsElement() {

		try {
			highlightElement(videoTutorials, "Video Tutorials 'Tutoriais de videos'");
			logPassed("Video Tutorials 'Tutoriais de videos' encontrado com sucesso");
		} catch (IOException e) {
			logFailed("Video Tutorials 'Tutoriais de videos' nao encontrado");
		}

	}

	public void validateContactUsElement() {

		try {
			highlightElement(contactUs, "Contact Us 'Contato'");
			logPassed("Contact Us 'Contato' encontrada com sucesso");
		} catch (IOException e) {
			logFailed("Contact Us 'Contato' nao encontrado");
		}

	}
	
	public void clicarLoginElement() {

		try {
			highlightElement(signupLogin, "Signup / Login 'Cadastro e Login'");
			signupLogin.click();
		} catch (IOException e) {
			logFailed("Signup / Login 'Cadastro e Login' nao encontrado");
		}

	}
	
	public void clicarProductElement() {

		try {
			highlightElement(products, "Signup / Login 'Cadastro e Login'");
			products.click();
		} catch (IOException e) {
			logFailed("Signup / Login 'Cadastro e Login' nao encontrado");
		}

	}
	
	

}