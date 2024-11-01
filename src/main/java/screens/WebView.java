package screens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WebView extends MainScreen{
    @AndroidFindBy(xpath = "//android.view.View[@content-desc=\"UI Automator\"]")
    MobileElement uiAutomator;

    @FindBy(xpath = "//android.view.View[@content-desc=\"Espresso\"]/android.widget.TextView")
    MobileElement espresso;

//    @AndroidFindBy(uiAutomator = "new UiScrollable(scrollable(true)).flingToEnd(int maxSwipes)")
//    MobileElement scroll;


    public WebView(AppiumDriver<?> driver) {
        super(driver);
    }

    public boolean isEspressoDisplayed(){
        return espresso.isDisplayed();
    }


    public boolean isUiAutomatorDisplayed(){
        return uiAutomator.isDisplayed();
    }

//    public boolean isScrollDisplayed(){
//        return scroll.isDisplayed();
//    }

    public WebView clickUiAutomator(){
        uiAutomator.click();
        return new WebView(driver);
    }

}
