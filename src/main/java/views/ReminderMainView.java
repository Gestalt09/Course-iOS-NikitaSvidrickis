package views;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import util.GlobalVariables;
import util.Helpers;

import java.time.Duration;

public class ReminderMainView extends Helpers {

    protected IOSDriver<MobileElement> driver;

    @iOSXCUITFindBy(accessibility = "Allow Once")
    private MobileElement allowPermissions;

    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeOther[@name=\"Horizontal scroll bar, 1 page\"])[2]")
    private MobileElement notNowButton;

    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeOther[@name=\"<x-apple-reminderkit://REMCDAccount/3B242529-8F5D-47A1-9351-444101218C30>\"])[2]")
    private MobileElement myListTextBox;

    @iOSXCUITFindBy(xpath = "\t\n" + "//XCUIElementTypeButton[@name=\"New Reminder\"]")
    private MobileElement newReminderButton;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Reminders\"]")
    private MobileElement reminderListButton;

    public ReminderMainView(IOSDriver<MobileElement> driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }
    public boolean reminderMainViewLoaded() {
        return new WebDriverWait(driver, GlobalVariables.globalTimeout).until(ExpectedConditions.visibilityOf(myListTextBox)).isDisplayed();
    }
    public void allowLocationPermissions() {
        new WebDriverWait(driver, GlobalVariables.globalTimeout).until(ExpectedConditions.visibilityOf(allowPermissions)).click();
    }
    public void clickNotNowButton(){notNowButton.click();}
    public void clickNewReminder(){newReminderButton.click();}
    public void clickReminderListButton(){reminderListButton.click();}
}

