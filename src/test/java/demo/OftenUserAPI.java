package demo;

import io.appium.java_client.android.AndroidDriver;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by jiangxun.huang on 2016/2/29.
 */
public class OftenUserAPI {
    private AndroidDriver driver;
    private File file;

    @Before
    public void SetUp() throws MalformedURLException {
        // setting apk path
        File classpathRoot = new File(System.getProperty("user.dir"));
        File appDir = new File(classpathRoot, "apps");
        File app =  new File(appDir,"ContactManager.apk");
        //setting auto par
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("deviceName", "Android Emulator");
        //capabilities.setCapability("platformVersion", "6.0");
        capabilities.setCapability("app", app.getAbsolutePath());
        //seting apk package and activity
        capabilities.setCapability("appPackage", "com.example.android.contactmanager");
        capabilities.setCapability("appActivity", ".ContactManager");
//		driver = new AppiumDriver<>(new URL("http://127.0.0.1:4723/wd/hub"),
//				capabilities);
        //inital
        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
    }
    @After
    public void tearDown() {
       driver.quit();
    }
    @Test
    public void testAPI_01(){
        String name="name";
        // uiautomator desc
        driver.findElementByAndroidUIAutomator("new UiSelector().descriptionContains(\"name\")");
        // uiautomator text
        driver.findElementByAndroidUIAutomator("new UiSelector().textContain(\"name\")");

    }
}
