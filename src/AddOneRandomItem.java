import static org.testng.AssertJUnit.assertEquals;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import dev.failsafe.internal.util.Assert;

import java.time.Duration;
import java.util.List;
	import java.util.Random;

	import org.openqa.selenium.By;

	import org.openqa.selenium.WebElement;





	public class AddOneRandomItem {

		WebDriver driver = new ChromeDriver();
		String URL = "https://magento.softwaretestingboard.com/";

		String Password = "ASDasd123!@";

		@BeforeTest

		public void mySetup() {
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));
		}
		

		@Test
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
	      @Test
		public void CheckoutProcess() {
			
		
		}

		@Test
		public void checkoutProcess() throws InterruptedException {
			String CheckoutPage = "https://magento.softwaretestingboard.com/checkout/cart/";
			driver.get(CheckoutPage);
			Thread.sleep(3000);
			WebElement proceedButton = driver.findElement(By.xpath("//button[@data-role='proceed-to-checkout']"));
			proceedButton.click();

		}

		@Test
		public void SignupProcess() throws InterruptedException {
			
			Thread.sleep(4000);
			WebElement email = driver.findElement(By.id("customer-email"));
			WebElement firstName = driver.findElement(By.name("firstname"));
			WebElement lastName = driver.findElement(By.name("lastname"));
			WebElement StreetAddress = driver.findElement(By.name("street[0]"));
			WebElement city = driver.findElement(By.name("city"));
			WebElement state = driver.findElement(By.name("region_id"));
			WebElement postalCode = driver.findElement(By.name("postcode"));
			WebElement Country = driver.findElement(By.name("country_id"));
			WebElement phoneNumber = driver.findElement(By.name("telephone"));
			WebElement nextButton = driver.findElement(By.cssSelector(".button.action.continue.primary"));

			email.sendKeys("asaqa0133@gmail.com");
			firstName.sendKeys("abed");
			lastName.sendKeys("alraheem");
	 
			StreetAddress.sendKeys("amman tlaa alali");

			city.sendKeys("amman");

			state.sendKeys("tlaa alali");

			postalCode.sendKeys("19933");

			Country.sendKeys("Jordan");

			phoneNumber.sendKeys("962797700235");

			nextButton.click();

			Select select = new Select(Country);

//			select.selectByValue("CN");
//			select.selectByIndex(1);
			select.selectByVisibleText("Jordan");
			
		}
	}
	    	  
	    	  
	    	  
	    	  
	    	  
	    	  
	    	  
	    	  
	      
	      

		
