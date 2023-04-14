package views;

import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import util.GlobalVariables;

public class ReminderListView {

    protected IOSDriver<MobileElement> driver;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Reminders\"]")
    private MobileElement remindersTexBox;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"CompleteOff\"][1]")
    private MobileElement firstReminderCheckButton;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"All Reminders Completed\"]")
    private MobileElement allReminderCompletedTextBox;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTextField[@name=\"Title\"]")
    private MobileElement titleTextBox;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Edit Details\"]")
    private MobileElement detailsButton;

    public ReminderListView(IOSDriver<MobileElement> driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }
    public boolean reminderListViewLoaded() {
        return new WebDriverWait(driver, GlobalVariables.globalTimeout).until(ExpectedConditions.visibilityOf(remindersTexBox)).isDisplayed();
    }
    public void clickFirstReminderCheckButton(){firstReminderCheckButton.click();}
    public boolean noRemindersLeftCheck() {
        return new WebDriverWait(driver, GlobalVariables.globalTimeout).until(ExpectedConditions.visibilityOf(allReminderCompletedTextBox)).isDisplayed();
    }
    public void clickOnTitle(){titleTextBox.click();}
    public void clickOnEditButton(){detailsButton.click();}
}
