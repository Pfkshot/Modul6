package screens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WebView extends MainScreen{
//    @AndroidFindBy(xpath = "//android.widget.Image[@text = 'Android Arsenal']")
//    MobileElement androidArsenal;

//    @AndroidFindBy(uiAutomator = "textContains(\"Android Arsenal\")")
//    MobileElement androidArsenal;

//    @FindBy(xpath = "a[@href = \"https://android-arsenal.com/details/1/7896\"]")
//    WebElement androidArsenal;

//    @FindBy(xpath = "//img[@alt = \"Android Arsenal\"]")
//    WebElement androidArsenal;

    @FindBy(linkText = "Android Arsenal")
    WebElement androidArsenal;

    public WebView(AppiumDriver<?> driver) {
        super(driver);
    }

    public boolean isAndroidArsenal(){
        return androidArsenal.isDisplayed();
    }

//    public WebView clickWebView(){
//        webView.click();
//        return new WebView(driver);
//
//    }

}
