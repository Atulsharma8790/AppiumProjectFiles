
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

import java.io.IOException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;


public class TestCalcUISelector {


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


		driver.manage().timeouts().implicitlyWait(5L, TimeUnit.SECONDS);


		//Addition of two numbers
		driver.findElementByAndroidUIAutomator("UiSelector().className(\"android.widget.Button\").text(\"C\")").click();
		driver.findElementByAndroidUIAutomator("UiSelector().className(\"android.widget.Button\").text(\"6\")").click();
		driver.findElementByAndroidUIAutomator("UiSelector().className(\"android.widget.Button\").text(\"5\")").click();
		driver.findElementByAndroidUIAutomator("UiSelector().className(\"android.widget.Button\").text(\"+\")").click();
		driver.findElementByAndroidUIAutomator("UiSelector().className(\"android.widget.Button\").text(\"2\")").click();
		driver.findElementByAndroidUIAutomator("UiSelector().className(\"android.widget.Button\").text(\"5\")").click();
		driver.findElementByAndroidUIAutomator("UiSelector().className(\"android.widget.Button\").text(\"=\")").click();



		//Subtraction of two numbers
		driver.findElementByAndroidUIAutomator("UiSelector().className(\"android.widget.Button\").text(\"C\")").click();
		driver.findElementByAndroidUIAutomator("UiSelector().className(\"android.widget.Button\").text(\"6\")").click();
		driver.findElementByAndroidUIAutomator("UiSelector().className(\"android.widget.Button\").text(\"5\")").click();
		driver.findElementByAndroidUIAutomator("UiSelector().className(\"android.widget.Button\").text(\"−\")").click();
		driver.findElementByAndroidUIAutomator("UiSelector().className(\"android.widget.Button\").text(\"2\")").click();
		driver.findElementByAndroidUIAutomator("UiSelector().className(\"android.widget.Button\").text(\"5\")").click();
		driver.findElementByAndroidUIAutomator("UiSelector().className(\"android.widget.Button\").text(\"=\")").click();

		//Multiplication of two numbers


		driver.findElementByAndroidUIAutomator("UiSelector().className(\"android.widget.Button\").text(\"C\")").click();
		driver.findElementByAndroidUIAutomator("UiSelector().className(\"android.widget.Button\").text(\"6\")").click();
		driver.findElementByAndroidUIAutomator("UiSelector().className(\"android.widget.Button\").text(\"5\")").click();
		driver.findElementByAndroidUIAutomator("UiSelector().className(\"android.widget.Button\").text(\"×\")").click();
		driver.findElementByAndroidUIAutomator("UiSelector().className(\"android.widget.Button\").text(\"2\")").click();
		driver.findElementByAndroidUIAutomator("UiSelector().className(\"android.widget.Button\").text(\"5\")").click();
		driver.findElementByAndroidUIAutomator("UiSelector().className(\"android.widget.Button\").text(\"=\")").click();


		//Division of two numbers

		driver.findElementByAndroidUIAutomator("UiSelector().className(\"android.widget.Button\").text(\"C\")").click();
		driver.findElementByAndroidUIAutomator("UiSelector().className(\"android.widget.Button\").text(\"6\")").click();
		driver.findElementByAndroidUIAutomator("UiSelector().className(\"android.widget.Button\").text(\"5\")").click();
		driver.findElementByAndroidUIAutomator("UiSelector().className(\"android.widget.Button\").text(\"÷\")").click();
		driver.findElementByAndroidUIAutomator("UiSelector().className(\"android.widget.Button\").text(\"2\")").click();
		driver.findElementByAndroidUIAutomator("UiSelector().className(\"android.widget.Button\").text(\"5\")").click();
		driver.findElementByAndroidUIAutomator("UiSelector().className(\"android.widget.Button\").text(\"=\")").click();

		System.out.println(driver.findElementsByAndroidUIAutomator("UiSelector().className(\"android.widget.Button\")").size());

		driver.quit();

		StopAppiumServer();

	}

}
