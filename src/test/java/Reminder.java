import org.apache.groovy.parser.antlr4.GroovyParser;
import org.testng.Assert;
import org.testng.annotations.Test;
import util.DriverSetup;
import util.Helpers;

public class Reminder extends DriverSetup {

    @Test(testName = "iOS Tasks")
    public void reminder(){

        reminderMainView.allowLocationPermissions();
        reminderMainView.clickNotNowButton();

        Assert.assertTrue(reminderMainView.reminderMainViewLoaded(),"Reminder main view isn't loaded");
        reminderMainView.clickNewReminder();

        Assert.assertTrue(newReminderView.newReminderViewLoaded(),"New Reminder view isn't loaded");
        newReminderView.enterNewTitle("iOSTest");
        newReminderView.clickCalendarButton();
        newReminderView.clickTimeAndData();

        Assert.assertTrue(dateAndTimeView.dateAndTimeViewLoaded(),"Date and time view isn't loaded");
        dateAndTimeView.clickOnDate26();
        dateAndTimeView.clickOnTimeSwitchButton();
        dateAndTimeView.setHourMinuteDatePickerWheel("2","05");
        dateAndTimeView.clickApplyButton();

        Assert.assertTrue(newReminderView.newReminderViewLoaded(),"New Reminder view isn't loaded");
        newReminderView.clickAddButton();
        Assert.assertTrue(reminderMainView.reminderMainViewLoaded(),"Reminder main view isn't loaded");
        reminderMainView.clickReminderListButton();

        Assert.assertTrue(reminderListView.reminderListViewLoaded(),"Reminder list view isn't loaded");
        reminderListView.clickOnTitle();
        reminderListView.clickOnEditButton();
        Assert.assertTrue(detailsView.detailsViewLoaded(),"Details view isn't loaded");
        Assert.assertTrue(detailsView.dateAndTimeLoaded(),"Date and TIme is not loaded correctly");
        detailsView.clickDoneButton();

        Assert.assertTrue(reminderListView.reminderListViewLoaded(),"Reminder list view isn't loaded");
        reminderListView.clickFirstReminderCheckButton();
        Assert.assertTrue(reminderListView.noRemindersLeftCheck(),"Not all reminders completed");













    }
}
