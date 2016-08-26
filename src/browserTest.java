import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class browserTest {
	
	public static AndroidDriver<MobileElement> driver;

	public static void main(String[] args) throws MalformedURLException {
		

		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setBrowserName("browser");
		capabilities.setCapability("browserName", "browser");
		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability("platformVersion", "5.1.0");
		capabilities.setCapability("deviceName", "Android Emulator");
		capabilities.setCapability("appPackage", "com.android.browser");
		capabilities.setCapability("appActivity", "com.android.browser.BrowserActivity");
		
		driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"),capabilities);
		
		driver.get("http://www.timespoints.com");


	}

}
