
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

import java.io.IOException;
import java.net.URL;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;


public class TestCalculator {


	public static AndroidDriver<MobileElement> driver;
	
	//Appium Server launch 
	public static Process process;
	
	//Calling the node.exe and appium.js
	public static String STARTSERVER = "C:\\Program Files (x86)\\Appium\\node.exe C:\\Program Files (x86)\\Appium\\node_modules\\appium\\bin\\appium.js";
	
	//Starting the Appium Server
	public static void StartAppiumServer() throws InterruptedException, IOException{
		Runtime runtime = Runtime.getRuntime();
		Thread.sleep(7000);
		
		process = runtime.exec(STARTSERVER);
		
		if(process!=null)
		{
			System.out.println("Appium Server Started Successfully");
		}
		
	}
	
	//Stopping the server
	public static void StopAppiumServer(){
		
		if(process!= null){
			process.destroy();
		}
		System.out.println("Appium Server Stopped Successfully");
	}
	
	public static void main(String[] args) throws InterruptedException, IOException {
		
		StopAppiumServer();
		StartAppiumServer();
		

		DesiredCapabilities capabilities = new DesiredCapabilities();

		capabilities.setCapability("deviceName", "Android");

		capabilities.setCapability("platformVersion", "4.4.2");
		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability("appPackage", "com.asus.calculator");
		capabilities.setCapability("appActivity", "com.asus.calculator.Calculator");
		driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"),capabilities);
		

		Thread.sleep(5000);

		
		//Addition of two numbers
		driver.findElement(By.xpath("//android.widget.Button[contains(@text,'C')]")).click();
		
		driver.findElement(By.xpath("//android.widget.Button[contains(@text,'6')]")).click();
		driver.findElement(By.xpath("//android.widget.Button[contains(@text,'5')]")).click();
		driver.findElement(By.xpath("(//android.widget.Button[contains(@text,'+')])[2]")).click();
		driver.findElement(By.xpath("//android.widget.Button[contains(@text,'2')]")).click();
		driver.findElement(By.xpath("//android.widget.Button[contains(@text,'5')]")).click();
		driver.findElement(By.xpath("//android.widget.Button[contains(@text,'=')]")).click();
		
	
		
		//Subtraction of two numbers
		driver.findElement(By.xpath("//android.widget.Button[contains(@text,'C')]")).click();
		
		driver.findElement(By.xpath("//android.widget.Button[contains(@text,'6')]")).click();
		driver.findElement(By.xpath("//android.widget.Button[contains(@text,'5')]")).click();
		driver.findElement(By.xpath("(//android.widget.Button[contains(@text,'−')])[1]")).click();
		driver.findElement(By.xpath("//android.widget.Button[contains(@text,'2')]")).click();
		driver.findElement(By.xpath("//android.widget.Button[contains(@text,'5')]")).click();
		driver.findElement(By.xpath("//android.widget.Button[contains(@text,'=')]")).click();
		
	
		
		//Multiplication of two numbers
		
		driver.findElement(By.xpath("//android.widget.Button[contains(@text,'C')]")).click();
		
		driver.findElement(By.xpath("//android.widget.Button[contains(@text,'6')]")).click();
		driver.findElement(By.xpath("//android.widget.Button[contains(@text,'5')]")).click();
		driver.findElement(By.xpath("//android.widget.Button[contains(@text,'×')]")).click();
		driver.findElement(By.xpath("//android.widget.Button[contains(@text,'2')]")).click();
		driver.findElement(By.xpath("//android.widget.Button[contains(@text,'5')]")).click();
		driver.findElement(By.xpath("//android.widget.Button[contains(@text,'=')]")).click();
		
	
		
		//Division of two numbers
		driver.findElement(By.xpath("//android.widget.Button[contains(@text,'C')]")).click();
		
		driver.findElement(By.xpath("//android.widget.Button[contains(@text,'6')]")).click();
		driver.findElement(By.xpath("//android.widget.Button[contains(@text,'5')]")).click();
		driver.findElement(By.xpath("//android.widget.Button[contains(@text,'÷')]")).click();
		driver.findElement(By.xpath("//android.widget.Button[contains(@text,'2')]")).click();
		driver.findElement(By.xpath("//android.widget.Button[contains(@text,'5')]")).click();
		driver.findElement(By.xpath("//android.widget.Button[contains(@text,'=')]")).click();
		
	
		driver.quit();
		
		Thread.sleep(5000);
		StopAppiumServer();

	}

}
