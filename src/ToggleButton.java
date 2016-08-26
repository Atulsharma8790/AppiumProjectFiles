import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class ToggleButton {

	public static AndroidDriver<MobileElement> driver;
	public static void main(String[] args) throws MalformedURLException, InterruptedException {

		
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability("platformVersion", "5.1.0");
		capabilities.setCapability("deviceName", "Android Emulator");
		capabilities.setCapability("appPackage", "com.android.development");
		capabilities.setCapability("appActivity", "com.android.development.Development");

		driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"),capabilities);
		
		WebElement list = (WebElement) driver.findElements(By.className("android.widget.TextView")).get(1);
		list.click();
		
		Thread.sleep(3000);
		WebElement ele = (WebElement) driver.findElements(By.id("android:id/switchWidget")).get(2);
		ele.click();
	}

}
