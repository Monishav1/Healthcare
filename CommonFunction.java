package com.sh.baseclass;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
public class CommonFunction {
	public ChromeOptions co;
	public WebDriver driver;
	public ExtentReports report;
	public ExtentSparkReporter sparkreport;
	public ExtentTest testcase;
	@BeforeSuite
	public void openbrowser()
	{
		report=new ExtentReports();
		sparkreport=new ExtentSparkReporter("index.html");
		report.attachReporter(sparkreport);
		co=new ChromeOptions();
		co.setBrowserVersion("116");
		driver=new ChromeDriver(co);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2000));
		testcase=report.createTest("hitting the url");
		//driver.get("https://demo.smart-hospital.in/site/login");
		driver.get("https://demo.smart-hospital.in/");
		//login as admin
		//driver.findElement(By.xpath("(//div[@class='btn-group btn-group-justified']/a[2])[1]")).click();
		//login as doctor
//		driver.findElement(By.xpath("(//div[@class='btn-group btn-group-justified']/a[3])[1]")).click();
//		driver.findElement(By.xpath("//button[@type='submit']")).click();
//		testcase.log(Status.INFO,"Login as admin");
		}
	@AfterSuite
	public void teardown()
	{
		report.flush();
	}

}
