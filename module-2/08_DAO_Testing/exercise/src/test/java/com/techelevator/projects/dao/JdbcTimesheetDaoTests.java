package com.techelevator.projects.dao;

import com.techelevator.projects.model.Timesheet;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.util.List;

public class JdbcTimesheetDaoTests extends BaseDaoTests {

    private static final Timesheet TIMESHEET_1 = new Timesheet(1L, 1L, 1L, 
            LocalDate.parse("2021-01-01"), 1.0, true, "Timesheet 1");
    private static final Timesheet TIMESHEET_2 = new Timesheet(2L, 1L, 1L,
            LocalDate.parse("2021-01-02"), 1.5, true, "Timesheet 2");
    private static final Timesheet TIMESHEET_3 = new Timesheet(3L, 2L, 1L,
            LocalDate.parse("2021-01-01"), 0.25, true, "Timesheet 3");
    private static final Timesheet TIMESHEET_4 = new Timesheet(4L, 2L, 2L,
            LocalDate.parse("2021-02-01"), 2.0, false, "Timesheet 4");
    
    private JdbcTimesheetDao sut;
    private Timesheet testTimesheet;

    @Before
    public void setup() {
        sut = new JdbcTimesheetDao(dataSource);
        testTimesheet = new Timesheet(99L, 1L, 2L, LocalDate.now(), 4.0, true, "Test Timesheet");
    }

    @Test
    public void getTimesheet_returns_correct_timesheet_for_id() {
        Timesheet timesheet = sut.getTimesheet(4L);
        assertTimesheetsMatch("getTimesheet returns incorrect timesheet for timesheet id", TIMESHEET_4, timesheet);
    }

    @Test
    public void getTimesheet_returns_null_when_id_not_found() {
        Timesheet timesheet = sut.getTimesheet(8L);
        Assert.assertNull("getTimesheet did not return null when id not found", timesheet);
    }

    @Test
    public void getTimesheetsByEmployeeId_returns_list_of_all_timesheets_for_employee() {
        List<Timesheet> timesheets = sut.getTimesheetsByEmployeeId(1L);
        Assert.assertEquals("getTimesheetsByEmployeeId returned wrong number of timesheets", 2, timesheets.size());

        timesheets = sut.getTimesheetsByEmployeeId(3L);
        Assert.assertEquals("getTimesheetsByEmployeeId returned timesheet(s) for employee id not in database", 0, timesheets.size());
    }

    @Test
    public void getTimesheetsByProjectId_returns_list_of_all_timesheets_for_project() {
        List<Timesheet> timesheets = sut.getTimesheetsByProjectId(1L);
        Assert.assertEquals("getTimesheetsByProjectId returned wrong number of timesheets", 3, timesheets.size());

        timesheets = sut.getTimesheetsByProjectId(3L);
        Assert.assertEquals("getTimesheetsByProjectId returned timesheet(s) for project id not in database", 0, timesheets.size());
    }

    @Test
    public void createTimesheet_returns_timesheet_with_id_and_expected_values() {
        Timesheet createdTimesheet = sut.createTimesheet(testTimesheet);

        Assert.assertNotNull("createTimesheet returned null", createdTimesheet);

        long newId = createdTimesheet.getTimesheetId();
        Assert.assertTrue("createTimesheet failed to return a timesheet with an id", newId > 0);

        testTimesheet.setTimesheetId(newId);
        assertTimesheetsMatch("createTimesheet did not return timesheet with id and expected values", testTimesheet, createdTimesheet);
    }

    @Test
    public void created_timesheet_has_expected_values_when_retrieved() {
        Timesheet createdTimesheet = sut.createTimesheet(testTimesheet);

        Assert.assertNotNull("createTimesheet must work before tests can be done to retrieve correct values", createdTimesheet);

        long newId = createdTimesheet.getTimesheetId();
        Timesheet retrievedTimesheet = sut.getTimesheet(newId);

        assertTimesheetsMatch("createTimesheet did not create timesheet",createdTimesheet, retrievedTimesheet);
    }

    @Test
    public void updated_timesheet_has_expected_values_when_retrieved() {
        Timesheet timesheet = sut.getTimesheet(1L);

        Assert.assertNotNull("getTimesheet must work before tests can be done to retrieve correct values from updateTimesheet", timesheet);

        timesheet.setEmployeeId(2L);
        sut.updateTimesheet(timesheet);
        Timesheet updatedTimesheet = sut.getTimesheet(1L);
        Assert.assertEquals("updateTimesheet did not update employee id in database", Long.valueOf(2), updatedTimesheet.getEmployeeId());

        timesheet.setProjectId(2L);
        sut.updateTimesheet(timesheet);
        updatedTimesheet = sut.getTimesheet(1L);
        Assert.assertEquals("updateTimesheet did not update project id in database", Long.valueOf(2), updatedTimesheet.getProjectId());

        timesheet.setDateWorked(LocalDate.parse("2010-01-10"));
        sut.updateTimesheet(timesheet);
        updatedTimesheet = sut.getTimesheet(1L);
        Assert.assertEquals("updateTimesheet did not update date worked in database", LocalDate.parse("2010-01-10"), updatedTimesheet.getDateWorked());

        timesheet.setHoursWorked(3.0);
        sut.updateTimesheet(timesheet);
        updatedTimesheet = sut.getTimesheet(1L);
        Assert.assertEquals("updateTimesheet did not update hours worked in database", Double.valueOf(3.0), Double.valueOf(updatedTimesheet.getHoursWorked()));

        timesheet.setBillable(!timesheet.isBillable());
        sut.updateTimesheet(timesheet);
        updatedTimesheet = sut.getTimesheet(1L);
        Assert.assertFalse("updateTimesheet did not update is billable in database", updatedTimesheet.isBillable());

        timesheet.setDescription("Test Timesheet");
        sut.updateTimesheet(timesheet);
        updatedTimesheet = sut.getTimesheet(1L);
        Assert.assertEquals("updateTimesheet did not update description in database", "Test Timesheet", updatedTimesheet.getDescription());
    }

    @Test
    public void deleted_timesheet_cant_be_retrieved() {
        sut.deleteTimesheet(1L);

        Timesheet timesheet = sut.getTimesheet(1L);
        Assert.assertNull("deleteTimesheet did not remove timesheet from database", timesheet);
    }

    @Test
    public void getBillableHours_returns_correct_total() {
        double billableHours = sut.getBillableHours(1L,1L);
        Assert.assertEquals("getBillableHours did not return correct total for employee id and project id", Double.valueOf(2.5), Double.valueOf(billableHours));

        billableHours = sut.getBillableHours(2L,2L);
        Assert.assertEquals("getBillableHours did not return correct total for employee id and project id", Double.valueOf(0), Double.valueOf(billableHours));
    }

    private void assertTimesheetsMatch(String message, Timesheet expected, Timesheet actual) {
        Assert.assertEquals(message, expected.getTimesheetId(), actual.getTimesheetId());
        Assert.assertEquals(message, expected.getEmployeeId(), actual.getEmployeeId());
        Assert.assertEquals(message, expected.getProjectId(), actual.getProjectId());
        Assert.assertEquals(message, expected.getDateWorked(), actual.getDateWorked());
        Assert.assertEquals(message, expected.getHoursWorked(), actual.getHoursWorked(), 0.001);
        Assert.assertEquals(message, expected.isBillable(), actual.isBillable());
        Assert.assertEquals(message, expected.getDescription(), actual.getDescription());
    }
}
