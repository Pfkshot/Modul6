package screens;

import io.appium.java_client.MobileElement;
import io.appium.java_client.AppiumDriver;
//import io.appium.java_client.android.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class MainScreen extends Screen {

    @AndroidFindBy( id = "activity_main_auto_scroll_scrollView_with_padding_button")
    MobileElement btnAutoScrollScrollViewWithPadding;

    @AndroidFindBy ( id = "activity_main_title")
    MobileElement mainScreenTitle;

    @AndroidFindBy ( id = "activity_main_device_button")
    MobileElement btnDeviceSample;


    public MainScreen(AppiumDriver<?> driver) {
        super(driver);
    }

    public boolean isAutoScrollScrollViewWithPaddingDisplayed(){
        return  btnAutoScrollScrollViewWithPadding.isDisplayed();
    }

    public boolean isAutoScrollScrollViewWithPaddingEnable(){
        return  btnAutoScrollScrollViewWithPadding.isEnabled();
    }

    public boolean isAutoScrollScrollViewWithPaddingSelected(){
        return  btnAutoScrollScrollViewWithPadding.isSelected();
    }

    public AutoScrollScrollViewWithPadding clickAutoScrollScrollViewWithPadding(){
        btnAutoScrollScrollViewWithPadding.click();
        return  new AutoScrollScrollViewWithPadding(driver);
    }

    public boolean isMainScreenDisplayed() {
        return mainScreenTitle.isDisplayed();
    }

    public boolean isDeviceSampleDisplayed() {
        return btnDeviceSample.isDisplayed();
    }

    public DeviceSample clickDeviceSample(){
        btnDeviceSample.click();
        return new DeviceSample(driver);
    }


}
