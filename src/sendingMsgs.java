import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.MobileDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;

public class sendingMsgs {

	public static AndroidDriver<MobileElement> driver;
	public static void main(String[] args) throws MalformedURLException {


		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability("platformVersion", "5.1.0");
		capabilities.setCapability("deviceName", "Android Emulator");
		capabilities.setCapability("appPackage", "com.android.mms");
		capabilities.setCapability("appActivity", "com.android.mms.ui.ConversationList");



		try {
			driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		//RemoteWebDriver driver = new RemoteWebDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);

		//driver.quit();

		driver.findElement(By.id("com.android.mms:id/action_compose_new")).click();

		driver.findElement(By.id("com.android.mms:id/recipients_editor")).sendKeys("9876542122");

		driver.findElement(By.id("com.android.mms:id/embedded_text_editor")).sendKeys("My Text Msg");

		driver.findElement(By.id("com.android.mms:id/send_button_sms")).click();

		//driver.findElement(By.className("android.widget.LinearLayout")).click();

		TouchAction action = new TouchAction((MobileDriver)driver);
		//		action.tap(driver.findElement(By.className("android.widget.LinearLayout")));


		List<MobileElement> msgList = driver.findElements(By.id("com.android.mms:id/msg_list_item_send"));
		String str="2:32 PM";
		driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\""+str+"\").instance(0))").click();
		
		driver.pressKeyCode(AndroidKeyCode.BACK);
		action.longPress(msgList.get(4)).release().perform();

		//WebElement frame = driver.findElement(By.id("android:id/select_dialog_listview"));
		//driver.switchTo().frame(frame);

		/*List<WebElement> list = driver.findElements(By.id("android.widget.LinearLayout"));
		
		System.out.println(list.size());
		*/
		driver.pressKeyCode(AndroidKeyCode.BACK);
//		driver.pressKeyCode(AndroidKeyCode.HOME);
		
		driver.swipe(510, 2300, 510, 1300, 2);

	}

}
