	package POM;

	import java.time.Duration;
import java.util.List;

	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.interactions.Actions;
	import org.openqa.selenium.support.FindBy;
	import org.openqa.selenium.support.PageFactory;
	import org.openqa.selenium.support.ui.ExpectedConditions;
	import org.openqa.selenium.support.ui.WebDriverWait;

		public class Buyshare {
		
			 @FindBy(xpath="//input[@icon=\"search\"]")private WebElement Search;
			@FindBy(xpath="//span[text()='TATACOFFEE']")private WebElement share;
		    @FindBy(xpath="//button[@class='button-blue buy']")private WebElement buy;
		    @FindBy(xpath="//div[@class=\"vddl-list list-flat\"]//span//span//span[@class='nice-name']")private List<WebElement> stocks;
		   
		    
		    public Buyshare(WebDriver driver){
		    	PageFactory.initElements(driver, this);
		    }
		    
		    public void gotoshare(WebDriver driver) throws InterruptedException {
		    	
				WebDriverWait wait= new WebDriverWait(driver,Duration.ofMillis(3000));
		    	wait.until(ExpectedConditions.visibilityOf(share));
		    	Actions action = new Actions(driver);
		    	action.moveToElement(share);
		    	action.perform();
		    }
		    
		    public void selectstockfromlist(WebDriver driver,String shareName) throws InterruptedException {
		    	WebDriverWait wait= new WebDriverWait(driver, Duration.ofMillis(3000));
		wait.until(ExpectedConditions.visibilityOf(share));
		for(int a=0; a<stocks.size();a++) {
		    		String text= stocks.get(a).getText();
		    		if(text.equalsIgnoreCase(shareName)) {
		    			Actions action = new Actions(driver);
		    			action.moveToElement(stocks.get(a));
		    			action.perform();
		    		}
		            }
		           }
		    		
		     public void Searchpath(WebDriver driver , String ShareName)
		     {
		    	 WebDriverWait wait= new WebDriverWait(driver,3000);
		     	wait.until(ExpectedConditions.visibilityOf(share));
		    	Search.sendKeys(ShareName); 
             	Actions action =new Actions (driver);
		    	action.moveToElement(share);
		    	action.perform();
	     }
		    
		    public void clickonBuy(){
		    	
		    	buy.click();
		    	
		    }
	}
	

