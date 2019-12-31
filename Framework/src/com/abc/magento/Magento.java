package com.abc.magento;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Magento {

	public static void main(String[] args) throws IOException {
		FileInputStream fis = new FileInputStream("C:\\Users\\shiva\\eclipse-workspace\\Framework\\src\\com\\abc\\utilities\\DataDriven.properties");
		Properties p = new Properties();
		p.load(fis);
		String nurl = p.getProperty("url");
		String nemail = p.getProperty("email");
		String npass  = p.getProperty("pass");
		FirefoxDriver d = new FirefoxDriver();
		d.manage().window().maximize();
		d.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		d.get(nurl);
		d.findElement(By.linkText("My Account")).click();
		d.findElement(By.id("email")).sendKeys(nemail);
		d.findElement(By.id("pass")).sendKeys(npass);
		d.findElement(By.id("send2")).click();
		d.findElement(By.linkText("Log Out")).click();
		d.quit();			
	}

}
