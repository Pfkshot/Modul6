import action.Direction;
import action.SwipeHelper;
import io.appium.java_client.MobileBy;
import io.appium.java_client.AppiumDriver;
//import io.appium.java_client.android.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.qameta.allure.Description;
import io.qameta.allure.Step;
import io.qameta.allure.Story;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import screens.AutoScrollScrollViewWithPadding;
import screens.DeviceSample;
import screens.MainScreen;

import java.net.MalformedURLException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class Module6 {

    private final DriverFactory driverFactory = new DriverFactory();
    private AppiumDriver<?> driver;

    @Before
    @Step("Настройка драйвера")
    public void setDriver() throws MalformedURLException {
        driver = SingletonAppiumDriver.getDriver();

    }

    @Description("тестирование функционала приложения Kasspresso")
    @Story("Kasspresso тест")
    @Test
    public void sampleTests() throws InterruptedException {

        MainScreen mainScreen = new MainScreen(driver) ;

        AutoScrollScrollViewWithPadding assvwp = new AutoScrollScrollViewWithPadding(driver);

        SwipeHelper swipeHelper = new SwipeHelper(driver);

        DeviceSample deviceSample = new DeviceSample(driver);

        Assert.assertTrue(mainScreen.isAutoScrollScrollViewWithPaddingDisplayed());
        Assert.assertTrue(mainScreen.isAutoScrollScrollViewWithPaddingEnable());
        Assert.assertFalse(mainScreen.isAutoScrollScrollViewWithPaddingSelected());

        mainScreen.clickAutoScrollScrollViewWithPadding().simpleFragmentDisplayed().btnHvText1Displayed().swipeSpecifyCategory().btnTvText1Displayed();

        swipeHelper.swipe(Direction.UP);

        assvwp.btnTvText20Displayed();
        wait3secTvText20(MobileBy.id("tvText20"));

        swipeHelper.swipe(Direction.DOWN);

        Assert.assertTrue(rotateToLandscape());
        driver.rotate(ScreenOrientation.PORTRAIT);

        driver.navigate().back();

        mainScreen.isMainScreenDisplayed();

        mainScreen.isDeviceSampleDisplayed();
        mainScreen.clickDeviceSample().isFieldInputDisplayed();

        String text = "абракадабра";
        deviceSample.search(text);

        String fieldInputText = deviceSample.getFieldInputText();

        ((AndroidDriver<?>)driver).lockDevice(Duration.ofSeconds(3));
        Assert.assertEquals(text, fieldInputText);

        driver.navigate().back();
    }

    @After
    @Step("Закрытие драйвера")
    public void tearDown() {
        driver.quit();
    }

    @Step ("Явное ожидание")
    private void wait2secTvText1(By by){
        driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);

        WebDriverWait wait = new WebDriverWait(driver, 2);
        wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.id("tvText1")));

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Step ("Явное ожидание")
    private void wait3secTvText20(By by){
        driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);

        WebDriverWait wait = new WebDriverWait(driver, 3);
        wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.id("tvText20")));

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Step ("Явное ожидание")
    private void wait5secMessage(By by){
        driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);

        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.id("message")));

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Step("Проверка поворота в ландскейп")
    private  boolean rotateToLandscape(){
        try {
            driver.rotate(ScreenOrientation.LANDSCAPE);
            return true;
        }catch (Exception e){
            return false;
        }
    }




}
