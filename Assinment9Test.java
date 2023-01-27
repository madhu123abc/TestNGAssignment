package com.assignment;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Reporter;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;



public class Assinment9Test {
	WebDriver driver;

	@BeforeMethod
	public void setUp() {
		Reporter.log("Setting up browser", true);
		driver = new ChromeDriver();
		driver.get("https://ineuron-courses.vercel.app/signup");
		Reporter.log("Application is up and Running", true);
	}
	
    @Parameters("Browser")
	@Test
	public void signUp(String browserName) {

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		boolean value = driver.findElement(By.xpath("//h2[contains(text(), 'Sign Up')]")).isDisplayed();
		System.out.println(value);
		driver.findElement(By.xpath("//input[@id='name']")).sendKeys("Madhavi");
		driver.findElement(By.xpath("//input[@id='email']")).sendKeys("Madhavi@yahoo.com");
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("Madhavi");
		driver.findElement(By.xpath("//label[text()='Testing']")).click();
		driver.findElement(By.xpath("//input[@value='Female']")).click();
		Select dropdown = new Select(driver.findElement(By.xpath("//select[@name='state']")));
		dropdown.selectByValue("Goa");
		boolean data = driver.findElement(By.xpath("//button[contains(text(),'Sign up')]")).isEnabled();
		System.out.println(data);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("document.getElementsByTagName(\"button\")[1].click()");

	}
}
