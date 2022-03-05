package variousConcepts_ImplicitWait_ExplicitWait;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LearnLocators {
	WebDriver driver;

	@Before
	public void init() {

		System.setProperty("webdriver.chrome.driver", "Driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://objectspy.space/");
	}
	
	@Test
	public void testLocators() throws InterruptedException {
		
		driver.findElement(By.name("firstname")).sendKeys("kosal");
		driver.findElement(By.name("lastname")).sendKeys("Im");
		driver.findElement(By.name("Password")).sendKeys("abc123");
		
		driver.findElement(By.id("sex-0")).click();
		driver.findElement(By.id("exp-5")).click();
		driver.findElement(By.id("datepicker")).click();
		
		//upload a file. sendKeys = only work with tagName <input> other use Robot Class
		driver.findElement(By.className("input-file")).sendKeys("C:\\Users\\sokoeurn chhay\\OneDrive\\Desktop\\JUNEQA2021\\selenium\\2021-09-12--Session 1.pptx");
		
		//link text
		driver.findElement(By.linkText("OS-API Product FrontEnd")).click();
		Thread.sleep(5000);
		driver.navigate().back();
//		driver.findElement(By.linkText("TF-API Product Backend")).click();
//		driver.switchTo().parentFrame();
//		driver.findElement(By.linkText("API Documentations")).click();
//		driver.wait(5000);
//		driver.navigate().back();
		
		//partial link text
		driver.findElement(By.partialLinkText("Backend")).click();
		Thread.sleep(3000);
		driver.navigate().back();
		
		//CSS selector syntax: 1.TagName#Value, 2.TagName.Value, 3.TagName[attribute='value'], 4.TagName.class[attribute='value']	//Note: #=id, .=class	//CSS select element you want to style.
		driver.findElement(By.cssSelector("input#exp-6")).click();
		driver.findElement(By.cssSelector("input#exp-1")).click();
		
		driver.findElement(By.cssSelector("input[value=\"Automation Tester\"]")).click();
		driver.findElement(By.cssSelector("input[type=\"checkbox\"][value=\"Selenium Webdriver\"]")).click();
//		driver.navigate().back();
		
		// absolute Xpath
		// /=root node, //=select current node, @= select attribute, *= match element node, @*= match any attribute node.
		driver.findElement(By.xpath("/html/body/div/div[2]/div[2]/form/input[1]")).sendKeys("Kosa Im");
		Thread.sleep(3000);
		
		//relative Xpath
		driver.findElement(By.xpath("//input[@id='confirmbtn']")).click();
		
		//Xpath for links:	//tag[text='value'] or //tag[contains(text(), 'value')]
		driver.findElement(By.xpath("//strong[text()='Link Test : New Page']")).click();
		driver.findElement(By.xpath("//strong[contains(text(), 'Link Test : Page Change')]")).click();
//		driver.navigate().back();
		
	}
	
//	@After
	public void tearDown() throws InterruptedException {
		Thread.sleep(3000);
		driver.close();
		driver.quit();
		
	}

}
