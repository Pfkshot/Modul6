package action;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.AppiumDriver;
//import io.appium.java_client.android.AppiumDriver;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.Dimension;


import java.time.Duration;

public class SwipeHelper {

    AppiumDriver<?> driver;

    public SwipeHelper (AppiumDriver<?> driver){
        this.driver = driver;
    }

    public void swipe(Direction direction) { // swipe across the screen
        Dimension dims = driver.manage().window().getSize();
        int width = dims.width / 2;
        int height = dims.height / 2;
        swipeExecution(direction, width, height);
    }

    public void swipe(SwipeProperties swipeProperties) { // swipe on a specific element
        int width = swipeProperties.getElement().getCenter().x;
        int height = swipeProperties.getElement().getCenter().y;
        swipeExecution(swipeProperties.getDirection(), width, height);
    }

    public void swipeExecution(Direction direction, int width, int height) {
        int border = 5;
        int press = 300;
        Dimension dims = driver.manage().window().getSize();
        PointOption<?> pointOptionStart = PointOption.point(width, height);
        PointOption<?> pointOptionEnd;
        switch (direction) {
            case RIGHT:
                pointOptionEnd = PointOption.point(dims.width - border, height);
                break;
            case LEFT:
                pointOptionEnd = PointOption.point(border, height);
                break;
            case UP:
                pointOptionEnd = PointOption.point(width, border);
                break;
            case DOWN:
                pointOptionEnd = PointOption.point(width, dims.height - border);
                break;
            default:
                throw new IllegalArgumentException("swipe is NOT supported");
        }

        new TouchAction<>(driver)
                .press(pointOptionStart)
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(press)))
                .moveTo(pointOptionEnd)
                .release()
                .perform();
    }

}
