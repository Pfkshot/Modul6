import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import static io.appium.java_client.remote.AndroidMobileCapabilityType.APP_ACTIVITY;
import static io.appium.java_client.remote.AndroidMobileCapabilityType.APP_PACKAGE;
import static io.appium.java_client.remote.MobileCapabilityType.DEVICE_NAME;
import static io.appium.java_client.remote.MobileCapabilityType.NO_RESET;

public class DriverFactory {
    AndroidDriver<?> driver;

    public AndroidDriver<?> setUp() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "ANDROID");
        capabilities.setCapability(DEVICE_NAME,"emulator-5554");
        capabilities.setCapability(APP_PACKAGE,"com.kaspersky.kaspressample");
        capabilities.setCapability(APP_ACTIVITY,"com.kaspersky.kaspressample.MainActivity");
        capabilities.setCapability(NO_RESET, true);

        URL remoteURL = new URL("http://localhost:4723/wd/hub");

        driver = new AndroidDriver(remoteURL, capabilities);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        return driver;
    }
}
