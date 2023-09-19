package com.sh.FrontPage;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
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
		WebElement appointments= driver.findElement(By.xpath("//nav[@class='navbar']/div/ul/li[2]"));
		appointments.click();
		Select dropdown=new Select(driver.findElement(By.xpath("//select[@name='specialist']")));
		dropdown.selectByValue("2");
		Select doctor=new Select(driver.findElement(By.xpath("//select[@name='doctor']")));
		doctor.selectByValue("12");
		Select shift=new Select(driver.findElement(By.xpath("//select[@name='global_shift']")));
		shift.selectByValue("1");
		WebElement date= driver.findElement(By.id("datetimepicker1"));
		date.click();
		String month=driver.findElement(By.xpath("(//th[@class='picker-switch'])[1]")).getText();
		while(!(month.equals("September 2023") ))
		{
			driver.findElement(By.xpath("(//th[@class='next'])[1]")).click();
			month=driver.findElement(By.xpath("(//th[@class='picker-switch'])[1]")).getText();
		}
		driver.findElement(By.xpath("//td[normalize-space()='23']")).click();
		WebElement message=driver.findElement(By.id("message"));
		message.sendKeys("viral fever");
		WebElement slot= driver.findElement(By.xpath("//div[@class='user-slot-container']/div"));
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(5));
		wait.until(ExpectedConditions.elementToBeClickable(slot));
		slot.click();
		WebElement timeslot=driver.findElement(By.xpath("//span[@id='slot_16']"));
		timeslot.click();
		WebElement patientname=driver.findElement(By.xpath("//input[@id='patient_name']"));
		patientname.sendKeys("tony");
		WebElement email=driver.findElement(By.xpath("//input[@id='email']"));
		email.sendKeys("steve991@gmail.com");
		WebElement phone=driver.findElement(By.xpath("//input[@id='phone']"));
		phone.sendKeys("9012345607");
		WebElement save=driver.findElement(By.xpath("//button[@id='submitbtn']"));
		save.click();
	}

}
