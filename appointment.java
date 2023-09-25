package com.sh.FrontPage;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.UnexpectedTagNameException;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.sh.baseclass.CommonFunction;

public class appointment extends CommonFunction{
	@Test()
	public void userpage()
	{
		//navigate to appointment url
		WebElement appointments= driver.findElement(By.xpath("//nav[@class='navbar']/div/ul/li[2]/a"));
		appointments.click();
		Select dropdown=new Select(driver.findElement(By.xpath("//select[@name='specialist']")));
		dropdown.selectByValue("1");
		Select doctor=new Select(driver.findElement(By.xpath("//select[@name='doctor']")));
		doctor.selectByValue("2");
		Select shift=new Select(driver.findElement(By.xpath("//select[@name='global_shift']")));
		shift.selectByValue("3");
		WebElement date= driver.findElement(By.id("datetimepicker1"));
		date.click();
		String month=driver.findElement(By.xpath("(//th[@class='picker-switch'])[1]")).getText();
		while(!(month.equals("September 2023") ))
		{
			driver.findElement(By.xpath("(//th[@class='next'])[1]")).click();
			month=driver.findElement(By.xpath("(//th[@class='picker-switch'])[1]")).getText();
		}
		driver.findElement(By.xpath("//td[normalize-space()='26']")).click();
		WebElement message=driver.findElement(By.id("message"));
		message.sendKeys("viral fever");
		WebElement slot= driver.findElement(By.xpath("//div[@class='user-slot-container']/div"));
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(5));
		wait.until(ExpectedConditions.elementToBeClickable(slot));
		slot.click();
		WebElement timeslot=driver.findElement(By.xpath("//span[@id='slot_1']"));
		timeslot.click();
		WebElement patientname=driver.findElement(By.xpath("//input[@id='patient_name']"));
		patientname.sendKeys("thor");
		WebElement email=driver.findElement(By.xpath("//input[@id='email']"));
		email.sendKeys("steve973@gmail.com");
		WebElement phone=driver.findElement(By.xpath("//input[@id='phone']"));
		phone.sendKeys("9012345713");
		WebElement save=driver.findElement(By.xpath("//button[@id='submitbtn']"));
		save.click();
	}
	@Test(dependsOnMethods = "userpage")
	public void payment()
	{
		WebElement payment=driver.findElement(By.xpath("//table[@id='DataTables_Table_0']/tbody/tr/td[9]/a[1]"));
		payment.click();
		driver.findElement(By.xpath("//button[@type='submit']/span")).click();
		driver.switchTo().frame(0);
		//input[@id='email']
		WebElement emailid=driver.findElement(By.xpath("//div[@class='emailInput input']/input"));
		emailid.sendKeys("steve973@gmail.com");
		WebElement cardnumber=driver.findElement(By.xpath("//input[@id='card_number']"));
		//cardnumber.sendKeys("5555 5555 5555 4444"); We need to send a full card number use js 
		JavascriptExecutor executor=(JavascriptExecutor) driver;
		executor.executeScript("arguments[0].value='5555 5555 5555 4444'" ,cardnumber);
		WebElement cardvalidity=driver.findElement(By.xpath("//input[@id='cc-exp']"));
		//cardvalidity.sendKeys("10/25");
		JavascriptExecutor executors=(JavascriptExecutor) driver;
		executors.executeScript("arguments[0].value='10/25'" ,cardvalidity);
		WebElement cvv=driver.findElement(By.xpath("//input[@id='cc-csc']"));
		cvv.sendKeys("123");
		WebElement zipcod=driver.findElement(By.xpath("//input[@id='billing-zip']"));
		zipcod.sendKeys("626101");
		WebElement pay=driver.findElement(By.xpath("//div[@class='bodyView']/div/div[3]/div/div/div/button"));
		pay.click();	
	}
	@Test(dependsOnMethods = "payment")
	public void paymentsuccessfull() throws IOException, InterruptedException
	{
		TakesScreenshot screenshot=(TakesScreenshot) driver;
		File sourcefile=screenshot.getScreenshotAs(OutputType.FILE);
		File destinationfile=new File("G:\\payment.png");
		FileHandler.copy(sourcefile,destinationfile);
		WebDriverWait delay=new WebDriverWait(driver,Duration.ofSeconds(5));
		delay.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='successpayment']/a"))).click();
		
		
	}
	

}
