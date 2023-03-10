package davirodrigues;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;

public class GeralPage {
	
	protected WebDriverWait wait;
	
	public WebDriver driver = ConfigTests.getDriver();
	
	public static void logPrint(String strLog) {
		
		ExtentTest extentTest = ConfigTests.getExtentTest();
		try {
			efetuarPrintTela(strLog);
			extentTest.log(Status.INFO, strLog, 
					MediaEntityBuilder.createScreenCaptureFromPath(
							System.getProperty("user.dir") + "\\src\\test\\resources\\evidencias\\" + strLog + ".png").build());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void efetuarPrintTela(String strLog) {
		
		File scrFile = ((TakesScreenshot) ConfigTests.getDriver()).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(scrFile, new File(System.getProperty("user.dir") + "\\src\\test\\resources\\evidencias\\" + strLog + ".png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static void logPassed(String log) {
		
		ExtentTest extentTest = ConfigTests.getExtentTest();
		extentTest.log(Status.PASS, log);
		
	}
	
	public static void logFailed(String log) {
		
		ExtentTest extentTest = ConfigTests.getExtentTest();
		extentTest.log(Status.FAIL, log);
		
	}
	
	private void waitVisibility(WebElement element, String elementName) throws IOException {
		try {
			wait = new WebDriverWait(ConfigTests.getDriver(), 30);
			wait.until(ExpectedConditions.visibilityOf(element));
		} catch (TimeoutException e) {
			logFailed("Elemento \"" + elementName + "\" nao encontrado");
			Assert.fail();
		}
	}
	
	private void highlight(WebElement element, int waitSeconds) {
		String style = element.getAttribute("style");
		
		JavascriptExecutor js = (JavascriptExecutor) ConfigTests.getDriver();
		js.executeScript("arguments[0].setAttribute('style','border:2px solid red;')", element);
		
		try {
			Thread.sleep(waitSeconds*500);
			js.executeScript("arguments[0].setAttribute('style','"+style+"')", element);
		} catch (Exception e) {
			js.executeScript("arguments[0].setAttribute('style','"+style+"')", element);
		}
	}
	
	public void highlightElement(WebElement element, String elementName) throws IOException {
		waitVisibility(element, elementName);
		highlight(element, 1);
	}
	
	public void scrollDown() {
		
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("window.scrollBy(0,200)", "");
    }

}
