package views;

import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import util.GlobalVariables;

public class DetailsView {
    protected IOSDriver<MobileElement> driver;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Details\"]")
    private MobileElement detailsTextBox;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"trešdiena, 2023. gada 26. aprīlis\"]")
    private MobileElement dateAndTimeTextField;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Done\"]")
    private MobileElement doneButton;

    public DetailsView(IOSDriver<MobileElement> driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }
    public boolean detailsViewLoaded() {
        return new WebDriverWait(driver, GlobalVariables.globalTimeout).until(ExpectedConditions.visibilityOf(detailsTextBox)).isDisplayed();
    }
    public boolean dateAndTimeLoaded() {
        return new WebDriverWait(driver, GlobalVariables.globalTimeout).until(ExpectedConditions.visibilityOf(dateAndTimeTextField)).isDisplayed();
    }
    public void clickDoneButton(){doneButton.click();}
}
