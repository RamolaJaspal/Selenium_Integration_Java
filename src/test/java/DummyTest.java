
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import org.testng.Assert;


import com.qainfotech.ImageAccessibility.ImageWebdriver;



public class DummyTest {
	ImageWebdriver driver=new ImageWebdriver();	
	WebDriverWait wait;

	@BeforeSuite
	public void setUp() throws Exception {
		driver.get("http://127.0.0.1:8080");
		wait=new WebDriverWait(driver,10);
	}
	
	
	

	@Test
	public void test() throws Exception {
		By ImageLocator=By.xpath("/html/body/div/div/div[2]/div[1]/div[1]/img");
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(ImageLocator));
		WebElement element = driver.findElement(ImageLocator);
		
		Assert.assertTrue(driver.is_Alt_Text_Relvant(element));
		
		ImageLocator=By.xpath("/html/body/div/div/div[2]/div/div[2]/img[2]");
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(ImageLocator));
		element = driver.findElement(ImageLocator);
		
		Assert.assertTrue(driver.is_Alt_Text_Relvant(element));
		
		ImageLocator=By.xpath("//*[@id=\"phone\"]");
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(ImageLocator));
		element = driver.findElement(ImageLocator);
		
		Assert.assertTrue(driver.is_Alt_Text_Relvant(element));
		
		
	}


	@AfterSuite 
	public void tearDown() {
		driver.close();
		
	}

}
