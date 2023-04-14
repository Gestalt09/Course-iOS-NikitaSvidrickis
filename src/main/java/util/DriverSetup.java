package util;

import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeMethod;
import views.*;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class DriverSetup {

    public static IOSDriver<MobileElement> driver;

    public DesiredCapabilities capabilities = new DesiredCapabilities();

    protected Helpers helpers;
    protected ReminderMainView reminderMainView;
    protected NewReminderView newReminderView;
    protected DateAndTimeView dateAndTimeView;
    protected ReminderListView reminderListView;
    protected DetailsView detailsView;


    @BeforeMethod
    public void setUp() throws MalformedURLException {

        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "iPhone 14 Pro Max");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "16.2");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "iOS");
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "XCUITest");
        capabilities.setCapability(MobileCapabilityType.NO_RESET, false);
        capabilities.setCapability(MobileCapabilityType.APP, "com.apple.reminders");


        driver = new IOSDriver<MobileElement>(new URL(GlobalVariables.localAppiumServerUrl), capabilities);
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

        helpers = new Helpers();
        reminderMainView = new ReminderMainView(driver);
        newReminderView = new NewReminderView(driver);
        dateAndTimeView = new DateAndTimeView(driver);
        reminderListView = new ReminderListView(driver);
        detailsView = new DetailsView(driver);
    }
}
