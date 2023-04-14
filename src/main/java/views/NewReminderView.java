package views;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import util.GlobalVariables;

public class NewReminderView {

    protected IOSDriver<MobileElement> driver;

    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name=\"New Reminder\"])[2]")
    private MobileElement newReminderTextBox;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTextField[@name=\"Quick Entry Title Field\"]")
    private MobileElement newTitleTextField;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Date & time\"]")
    private MobileElement calendarButton;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Add\"]")
    private MobileElement addButton;

    public NewReminderView(IOSDriver<MobileElement> driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public boolean newReminderViewLoaded() {
        return new WebDriverWait(driver, GlobalVariables.globalTimeout).until(ExpectedConditions.visibilityOf(newReminderTextBox)).isDisplayed();
    }

    public void enterNewTitle(String title) {
        newTitleTextField.click();
        newTitleTextField.sendKeys(title);
    }

    public void clickCalendarButton() {
        calendarButton.click();
    }

    public void clickTimeAndData() {
        TouchAction touchAction = new TouchAction(driver);
        touchAction.tap(new PointOption().withCoordinates(370, 540)).perform();
    }

    public void clickAddButton(){addButton.click();}

}
