package davirodrigues;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class ConfigTests {
	
	private static WebDriver driver;
	private static ExtentSparkReporter htmlReporter;
	private static ExtentReports extentReport;
	private static ExtentTest extentTest;
	
	@Before
	public void beforeCenario(Scenario cenario) {
		
		if(extentReport == null) {
			
			extentReport = new ExtentReports();
			htmlReporter = new ExtentSparkReporter("src/test/resources/evidencias/faleconosco.html");
			extentReport.attachReporter(htmlReporter);
		}
		
		extentTest = extentReport.createTest(cenario.getId());
		
		System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.navigate().to("https://automationexercise.com/");
	}
	
	@After
	public void afterCenario(Scenario cenario) {
		
		extentTest.log(Status.PASS, "Cenario " + cenario.getName() + " executado com sucesso!");
		extentReport.flush();
		
		driver.close();
	}
	
	public static WebDriver getDriver() {
		
		return driver;
	}
	
	public static ExtentTest getExtentTest() {
		
		return extentTest;
	}

}
