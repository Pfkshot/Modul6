package screens;

import io.appium.java_client.MobileElement;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
//import io.appium.java_client.android.AppiumDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class DeviceSample extends MainScreen{
    @AndroidFindBy( id = "input")
    MobileElement fieldInput;


    public DeviceSample(AppiumDriver<?> driver) {
        super(driver);
    }

    public boolean isFieldInputDisplayed() {
        return fieldInput.isDisplayed();
    }

    public DeviceSample search(String text) {
        fieldInput.click();
        fieldInput.sendKeys(text);
        ((AndroidDriver<?>)driver).pressKey(new KeyEvent(AndroidKey.ENTER));
        return this;
    }

    public String getFieldInputText(){
        return fieldInput.getText();
    }

}
