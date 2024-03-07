package com.project.staragile.insureme;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.springframework.boot.test.context.SpringBootTest;

import io.github.bonigarcia.wdm.WebDriverManager;

@SpringBootTest
class InsureMeApplicationTests {

	@Test
	void contextLoads() {
	}
	
	@Test
	void testCreatePolicy() {
		Policy policy = new Policy(1, "Shubham", "Individual" , 10000, "10-Sep-2021", "10-Sep-2022");
		PolicyService pService = new PolicyService();
		//Policy outputPolicy = pService.CreatePolicy();
		assertEquals(policy.getPolicyId(), pService.generateDummyPolicy().getPolicyId());
		
	}
	
	@Test
	void testSearchPolicy() {
		PolicyService pService = new PolicyService();
		assertEquals(null,pService.searchPolicy());
	}
	
	@Test
	void testSelenium() throws InterruptedException {
		  
			WebDriverManager.chromedriver().setup();
 	
	        ChromeOptions chromeOptions = new ChromeOptions();
	        chromeOptions.addArguments("headless");
	        chromeOptions.addArguments("--remote-allow-origins=*");
	        WebDriver driver = new ChromeDriver(chromeOptions);
	        driver.get("http://18.188.219.55:8081/");
	        driver.findElement(By.linkText("Contact Us"));
	        driver.findElement(By.id("inputName")).sendKeys("Capstone Assignment");
	        driver.findElement(By.id("inputNumber")).sendKeys("1234567890");
	        driver.findElement(By.id("inputMail")).sendKeys("test@test.com");
	        driver.findElement(By.id("inputMessage")).sendKeys("This is my capstone assignment");
	        driver.findElement(By.cssSelector(".submit_btn")).click();
	        driver.quit();
	        System.out.println("Submitted contact us form successfull");
	}


	
}
