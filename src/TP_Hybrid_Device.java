import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.MobileDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;

public class TP_Hybrid_Device {

	public static AndroidDriver<MobileElement> driver;
	public static void main(String[] args) throws MalformedURLException, InterruptedException {


		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability("platformVersion", "6.0.1");
		capabilities.setCapability("deviceName", "G5AXB730P3112UM");
		capabilities.setCapability("appPackage", "com.til.timespoints");
		capabilities.setCapability("appActivity", "com.til.timespoints.SplashActivity");
		capabilities.setCapability("newCommandTimeout", 60 * 5);




		driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"),capabilities);
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);

		System.out.println("Screen Size: "+driver.manage().window().getSize());

		try{
			driver.findElement(By.id("com.til.timespoints:id/tp_button_sign_in")).click();


			driver.findElement(By.className("android.widget.EditText")).sendKeys("times.newswire@gmail.com");

			driver.pressKeyCode(AndroidKeyCode.ENTER);

			Thread.sleep(2000);
			driver.findElements(By.className("android.widget.EditText")).get(1).sendKeys("Times@123");

			driver.pressKeyCode(AndroidKeyCode.ENTER);

			driver.findElements(By.id("com.til.timespoints:id/tp_gridview_each_item_rl")).get(0).click();

			driver.findElement(By.id("com.til.timespoints:id/tp_spinner_range")).click();

			driver.findElements(By.className("android.widget.CheckedTextView")).get(3).click();

			driver.pressKeyCode(AndroidKeyCode.BACK);
			driver.findElements(By.id("com.til.timespoints:id/tp_gridview_each_item_rl")).get(2).click();


			System.out.println(driver.findElements(By.id("com.til.timespoints:id/tp_shopping_catalogue_each_item_rl")).size());

			driver.findElement(By.id("com.til.timespoints:id/tp_button_redeem")).click();

			String str="50590 POINTS";
			driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\""+str+"\").instance(0))").click();

			driver.findElement(By.id("com.til.timespoints:id/tp_linear_notifications2")).click();

			System.out.println(driver.findElements(By.id("com.til.timespoints:id/tp_shopping_catalogue_each_item_rl")).size());

			driver.pressKeyCode(AndroidKeyCode.BACK);

			/*driver.swipe(565, 650, 100, 650, 2);
			Thread.sleep(1000);
			driver.swipe(565, 650, 100, 650, 2);
			 */

			TouchAction action = new TouchAction((MobileDriver)driver);
			action.longPress(565, 650).waitAction(2000).moveTo(100, 650).release().perform();
			Thread.sleep(1000);
			action.longPress(565, 650).waitAction(2000).moveTo(100, 650).release().perform();


			System.out.println(driver.findElements(By.id("com.til.timespoints:id/tp_shopping_catalogue_each_item_rl")).size());


		}

		catch(Exception e){

			Thread.sleep(1000);
			try{
				driver.findElement(By.id("com.til.timespoints:id/tp_image_settings")).click();
			}

			catch(Exception e1){
				System.out.println(e1.getMessage());
			}
			String str="Sign Out";
			driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\""+str+"\").instance(0))").click();



		}

	}

}
