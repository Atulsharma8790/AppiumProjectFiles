import java.net.MalformedURLException;
import java.net.URL;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.MobileDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;

public class Timespoints_Hybrid_Emulator {

	public static AndroidDriver<MobileElement> driver;
	public static void main(String[] args) throws MalformedURLException, InterruptedException {

		
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability("platformVersion", "6.0.1");
		capabilities.setCapability("deviceName", "G5AXB730P3112UM");
		capabilities.setCapability("appPackage", "com.til.timespoints");
		capabilities.setCapability("appActivity", "com.til.timespoints.SplashActivity");

		
		driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"),capabilities);
		driver.manage().timeouts().implicitlyWait(20L, TimeUnit.SECONDS);
		try{
		driver.findElement(By.id("com.til.timespoints:id/tp_button_sign_in")).click();
				
		
		  Set<String> contextNames = driver.getContextHandles();
		for(String context : contextNames)
		{
			System.out.println(context);
			if(context.contains("WEBVIEW")){
				driver.context(context);
			}
		}
		
		System.out.println(driver.getPageSource());
		Thread.sleep(10000);
		
		driver.findElement(By.name("emailId")).sendKeys("times.newswire@gmail.com");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@type='button'][@value='Sign In']")).click();
		Thread.sleep(2000);
		
		driver.findElement(By.id("password")).sendKeys("Times@123");
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//input[@type='button'][@value='Sign In']")).click();
		Thread.sleep(2000);
		
		//MobileElement grid = driver.findElement(By.className("android.widget.GridView"));
		/*List<MobileElement> gridItems= driver.findElements(By.id("com.til.timespoints:id/tp_gridview_each_item_rl"));
				Thread.sleep(2000);
		System.out.println(gridItems.size());
		
		
		driver.findElement(By.id(gridItems.get(0).toString())).click();
		*/
		
		TouchAction action = new TouchAction((MobileDriver)driver);
		action.tap(400, 1500).release().perform();
		
		
		
		
		}
		
		catch(Exception e){
			
			Thread.sleep(5000);
			driver.findElement(By.id("com.til.timespoints:id/tp_image_settings")).click();
			String str="Sign Out";
			driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\""+str+"\").instance(0))").click();
			
		}
	}

}
