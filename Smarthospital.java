package demo;

import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
  
public class Smarthospital {
	WebDriver driver;
	@BeforeSuite
	
    public void browser() {
    	WebDriverManager.chromedriver().setup();
    	ChromeOptions Hospital=new ChromeOptions();
    	Hospital.addArguments("--remote-allow-origins=*");
    	 driver=new ChromeDriver(Hospital);
    	 
    }@Test (priority = 1)
	public void login() {
		driver.get("https://demo.smart-hospital.in/site/login#");
		WebElement Admin=driver.findElement(By.xpath("//form[@action='https://demo.smart-hospital.in/site/login']/following::a[2]"));
		Admin.click();
		WebElement signin=driver.findElement(By.xpath("//button[@type='submit']"));
		signin.click();
	}@Test (priority = 2)
    public void pharmacy() {
    	WebElement pharmacyclick=driver.findElement(By.xpath("//i[@class='fas fa-mortar-pestle']/following::span"));
		pharmacyclick.click();
    }@Test(priority = 3)
	public void Bill() throws InterruptedException {
	 Thread.sleep(3000);
		WebElement Billgenerate =driver.findElement(By.xpath("//button[@id='load1']"));
	Billgenerate.click();
    }
 @Test(priority = 4)
    public void medicine() throws InterruptedException {
	 Thread.sleep(3000);
    	WebElement MedicineCategory=driver.findElement(By.xpath("//input[@name='total_rows[]']/following::span[4]"));
       MedicineCategory.click();
       WebElement Syrup=driver.findElement(By.xpath("//ul[@class='select2-results__options']//following::li[1]"));
       Syrup.click();
   	WebElement Medicinename=driver.findElement(By.xpath("//input[@id='action_type']/following::span[8]"));
    Medicinename.click();
    WebElement Syrup2=driver.findElement(By.xpath("//div[@id='activelicmodal']/following::li[3]"));
    Syrup2.click();
    WebElement Batch=driver.findElement(By.xpath("//select[@id='batch_no0']/following::span[3]"));
    Batch.click();
    WebElement select678=driver.findElement(By.xpath("//div[@id='bed']/following::li[2]"));
    select678.click();
    WebElement Quantity=driver.findElement(By.xpath("//input[@id='quantity0']"));
    Quantity.sendKeys("10");
    WebElement Doctor=driver.findElement(By.xpath("//select[@name='consultant_doctor']/following::span[3]"));
    Doctor.click();
    WebElement Doctorname=driver.findElement(By.xpath("//input[@tabindex='0']//following::li[2]"));
    Doctorname.click();
    WebElement Note=driver.findElement(By.xpath("//textarea[@id='note']"));
    Note.sendKeys("Thank you");
 
    }@Test(priority = 5)
 public void newp() throws InterruptedException {
    	WebElement addpatient=driver.findElement(By.xpath("//a[@id='add']"));
        addpatient.click();
      Thread.sleep(3000);
        WebElement name=driver.findElement(By.xpath("//input[@id='name']"));
        name.sendKeys("rolax");
        WebElement calenderclick=driver.findElement(By.xpath("//input[@id='birth_date']"));
        calenderclick.click();
      
        Actions act = new Actions(driver);
        WebElement year=driver.findElement(By.xpath("//th[@class='datepicker-switch']"));
        act.doubleClick(year).perform();
        
        WebElement pre=driver.findElement(By.xpath("/html/body/div[7]/div[3]/table/thead/tr/th[1]"));
        act.doubleClick(pre).perform();
        WebElement click1999=driver.findElement(By.xpath("//span[@class='year old']"));
        click1999.click();
       WebElement mar=driver.findElement(By.xpath("//td[@colspan='7']/child::span[3]"));
        mar.click();
      
        WebElement date10=driver.findElement(By.xpath("//td[@class='old day']/following::td[10]"));
        date10.click();
         Thread.sleep(3000);
        WebElement upload=driver.findElement(By.xpath("//div[@class='dropify-errors-container']/following::input[8]"));
        upload.sendKeys("C:\\Users\\Admin\\Pictures\\tamil photo\\IMG_20210704_154915.jpg");
     
        WebElement save=driver.findElement(By.xpath(" //button[@id='formaddpabtn']"));
        save.click(); 
        Thread.sleep(6000);
        WebElement saveandprint=driver.findElement(By.xpath("//button[@id='saveprint']"));
        saveandprint.click();
   
 }
    @AfterSuite
    public void close() {
   //	driver.close();
    }
}
