package screens;

import action.SwipeHelper;
import io.appium.java_client.AppiumDriver;
//import io.appium.java_client.android.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;



public class Screen {

    AppiumDriver<?> driver;
    SwipeHelper swipeHelper;

    Screen(AppiumDriver<?> driver) {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        this.driver = driver;
        swipeHelper = new SwipeHelper(driver);

    }
}
