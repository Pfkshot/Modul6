package screens;

import action.Direction;
import action.SwipeProperties;
import io.appium.java_client.MobileElement;
import io.appium.java_client.AppiumDriver;
//import io.appium.java_client.android.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class AutoScrollScrollViewWithPadding extends MainScreen{
    @AndroidFindBy(uiAutomator = "textContains(\"Simple Fragment\")" )
    MobileElement simpleFragment;

    @AndroidFindBy ( id = "hvText1")
    MobileElement btnHvText1;

    public MobileElement getBtnHvText1() {
        return btnHvText1;
    }

    @AndroidFindBy ( id = "hvText3")
    MobileElement btnHvText3;

    public MobileElement getBtnHvText3() {
        return btnHvText3;
    }

    @AndroidFindBy ( id = "hvText6")
    MobileElement btnHvText6;

    public MobileElement getBtnHvText6() {
        return btnHvText6;
    }

    @AndroidFindBy ( id = "hvText5")
    MobileElement btnHvText5;

    public MobileElement getBtnHvText5() {
        return btnHvText5;
    }

    @AndroidFindBy ( id = "hvText7")
    MobileElement btnHvText7;

    public MobileElement getBtnHvText7() {
        return btnHvText7;
    }

    @AndroidFindBy ( id = "tvText1")
    MobileElement btnTvText1;

    @AndroidFindBy ( id = "tvText20")
    MobileElement btnTvText20;

    public AutoScrollScrollViewWithPadding(AppiumDriver<?> driver) {
        super(driver);
    }

    public AutoScrollScrollViewWithPadding simpleFragmentDisplayed(){
        simpleFragment.isDisplayed();
        return this;
    }

    public AutoScrollScrollViewWithPadding btnHvText1Displayed(){
        btnHvText1.isDisplayed();
        return this;
    }

    public AutoScrollScrollViewWithPadding btnTvText1Displayed(){
        btnTvText1.isDisplayed();
        return this;
    }

    public AutoScrollScrollViewWithPadding btnTvText20Displayed(){
        btnTvText20.isDisplayed();
        return this;
    }

    public AutoScrollScrollViewWithPadding swipeSpecifyCategory(){
        swipeHelper.swipe(new SwipeProperties.Builder().direction(Direction.LEFT).element(btnHvText1).build());
        swipeHelper.swipe(new SwipeProperties.Builder().direction(Direction.LEFT).element(btnHvText3).build());
        swipeHelper.swipe(new SwipeProperties.Builder().direction(Direction.LEFT).element(btnHvText6).build());
        swipeHelper.swipe(new SwipeProperties.Builder().direction(Direction.RIGHT).element(btnHvText7).build());
        swipeHelper.swipe(new SwipeProperties.Builder().direction(Direction.RIGHT).element(btnHvText5).build());
        return this;
    }


}
