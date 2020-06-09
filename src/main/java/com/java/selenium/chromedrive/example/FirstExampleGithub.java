package com.java.selenium.chromedrive.example;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FirstExampleGithub {

	public static void main(String[] args) {
		//download from here
		//https://chromedriver.storage.googleapis.com/index.html?path=83.0.4103.39/
		
		System.setProperty("webdriver.chrome.driver", "F:/Study/ZIP/chromedriver_win32/chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		
		//Provide URL
		driver.navigate().to("https://github.com/");

		driver.findElement(By.name("q")).sendKeys("spring");

		driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
		
		driver.findElement(By.linkText("mybatis/spring")).click();

		//window operation if needed
		driver.manage().window().maximize();
		
		JavascriptExecutor executor= (JavascriptExecutor) driver;
		//if need to run a script
		executor.executeScript("scrollBy(0,200)");
		
		//if you want to use xpath but it would be slow
		driver.findElement(By.xpath("//*[@class='btn btn-sm ml-2 btn-primary']")).click();
		
		driver.findElement(By.xpath("//*[@class='flex-1 btn btn-outline get-repo-btn']")).click();
		
		//driver.close();
	}

}
