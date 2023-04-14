package views;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import util.GlobalVariables;
import util.Helpers;

public class DateAndTimeView extends Helpers {

    protected IOSDriver<MobileElement> driver;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Date & Time\"]")
    private MobileElement dateAndTimeTextBox;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"26\"]")
    private MobileElement date26Button;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeSwitch[@name=\"Time\"]")
    private MobileElement timeSwitchButton;

    @iOSXCUITFindBy(xpath = "(//XCUIElementTypePickerWheel)[1]")
    private MobileElement hoursPickerWheelSelector;

    @iOSXCUITFindBy(xpath = "(//XCUIElementTypePickerWheel)[2]")
    private MobileElement minutesPickerWheelSelector;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Apply\"]")
    private MobileElement applyButton;

    public DateAndTimeView(IOSDriver<MobileElement> driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public boolean dateAndTimeViewLoaded() {
        return new WebDriverWait(driver, GlobalVariables.globalTimeout).until(ExpectedConditions.visibilityOf(dateAndTimeTextBox)).isDisplayed();
    }
    public void clickOnDate26(){date26Button.click();}
    public void clickOnTimeSwitchButton(){timeSwitchButton.click();}

    public void setHourMinuteDatePickerWheel(String hour, String min) {
        hoursPickerWheelSelector.sendKeys(hour);
        minutesPickerWheelSelector.sendKeys(min);
    }
    public void clickApplyButton(){applyButton.click();}


}
