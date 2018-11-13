
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
		driver.get("https://www.stuartweitzman.com/womens-shoes/new-arrivals/");
		wait=new WebDriverWait(driver,10);
	}
	
	@Test
	public void test_1() {
		By Imaglocator=By.xpath("//*[@id=\"itemContainer\"]/div[3]/div[3]/div[2]/ul/li[2]/a/img");
		Assert.assertTrue(driver.is_Alt_Text_Relvant(driver.findElement(Imaglocator)));
	}
	@Test
	public void test_2() {
		By Imaglocator=By.xpath("//*[@id=\"itemContainer\"]/div[2]/div[1]/ul/div/div/li[1]/a/img");
		Assert.assertTrue(driver.is_Alt_Text_Relvant(driver.findElement(Imaglocator)));
	}


	@AfterSuite 
	public void tearDown() {
		driver.close();
		
	}

}
