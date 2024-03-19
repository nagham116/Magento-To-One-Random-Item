import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


	import java.util.List;
	import java.util.Random;

	import org.openqa.selenium.By;

	import org.openqa.selenium.WebElement;





	public class AddOneRandomItem {

		WebDriver driver = new ChromeDriver();
		String URL = "https://magento.softwaretestingboard.com/";

		

		@BeforeTest

		public void mySetup() {
			driver.manage().window().maximize();
		}
		

		@Test(invocationCount = 1, priority = 1, description = "this is my 1st test")
		public void addOneRandomItemToThecart() throws InterruptedException {
			Random rand = new Random();
			driver.get(URL);

			WebElement Container = driver.findElement(By.className("product-items"));
			List<WebElement> myList = Container.findElements(By.tagName("li"));
			int RandomIndex = rand.nextInt(myList.size());

			myList.get(RandomIndex).click();
			Thread.sleep(2000);
			if (driver.getCurrentUrl().contains("fusion") || driver.getCurrentUrl().contains("push")) {
				WebElement addtoCartButton = driver.findElement(By.id("product-addtocart-button"));
				addtoCartButton.click();
			} else {

				WebElement sizeContainer = driver
						.findElement(By.cssSelector("div[class='swatch-attribute size'] div[role='listbox']"));
				List<WebElement> theListOfSizes = sizeContainer.findElements(By.tagName("div"));
				int RandomSize = rand.nextInt(theListOfSizes.size());

				theListOfSizes.get(RandomSize).click();

				WebElement colorsContainer = driver
						.findElement(By.xpath("//div[@class='swatch-attribute color']//div[@role='listbox']"));

				List<WebElement> theListOfColors = colorsContainer.findElements(By.tagName("div"));
				int randomColor = rand.nextInt(theListOfColors.size());

				theListOfColors.get(randomColor).click();
				WebElement addtoCartButton = driver.findElement(By.id("product-addtocart-button"));
				addtoCartButton.click();
				Thread.sleep(5000);
				
			}
			 
			}
	

		}
