package gov.uk.check.visa.testsuite;

import gov.uk.check.visa.pages.*;
import gov.uk.check.visa.testbase.TestBase;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Created by Jay Vaghani
 */

public class VisaConfirmationTest extends TestBase {

    StartPage startPage;
    SelectNationalityPage selectNationalityPage;
    ReasonForTravelPage reasonForTravelPage;
    ResultPage resultPage;
    DurationOfStayPage durationOfStayPage;
    WorkTypePage workTypePage;
    FamilyImmigrationStatusPage familyImmigrationStatusPage;

    @BeforeMethod(alwaysRun = true)
    public void inIt(){
        startPage = new StartPage();
        selectNationalityPage = new SelectNationalityPage();
        reasonForTravelPage = new ReasonForTravelPage();
        resultPage = new ResultPage();
        durationOfStayPage = new DurationOfStayPage();
        workTypePage = new WorkTypePage();
        familyImmigrationStatusPage = new FamilyImmigrationStatusPage();
    }

    @Test(groups = {"sanity","regression"})
    public void anAustralianCominToUKForTourism() {
        startPage.clickOnAcceptCookieButton();
        startPage.clickStartNow();
        selectNationalityPage.selectNationality("Australia");
        selectNationalityPage.clickNextStepButton();
        reasonForTravelPage.selectReasonForVisit("tourism");
        reasonForTravelPage.clickNextStepButton();
        String actualResultMessage = resultPage.getResultMessage();
        resultPage.confirmResultMessage("You will not need a visa to come to the UK");


    }

    @Test(groups = {"smoke","regression"})
    public void aChileanComingToTheUKForWorkAndPlansOnStayingForLongerThanSixMonths() {
        startPage.clickOnAcceptCookieButton();
        startPage.clickStartNow();
        selectNationalityPage.selectNationality("Chile");
        selectNationalityPage.clickNextStepButton();
        reasonForTravelPage.selectReasonForVisit("work");
        reasonForTravelPage.clickNextStepButton();
        durationOfStayPage.selectLengthOfStay("longer_than_six_months");
        durationOfStayPage.clickNextStepButton();
        workTypePage.selectJobType("health");
        workTypePage.clickNextStepButton();
        String actualResultMessage = resultPage.getResultMessage();
        resultPage.confirmResultMessage("You need a visa to work in health and care");
    }

    @Test(groups = {"sanity","regression"})
    public void aColumbianNationalComingToTheUKToJoinAPartnerForALongStayTheyDoHaveAnArticle10Or20Card(){
        startPage.clickOnAcceptCookieButton();
        startPage.clickStartNow();
        selectNationalityPage.selectNationality("Colombia");
        selectNationalityPage.clickNextStepButton();
        reasonForTravelPage.selectReasonForVisit("family");
        reasonForTravelPage.clickNextStepButton();
        familyImmigrationStatusPage.selectImmigrationStatus("yes");
        familyImmigrationStatusPage.clickNextStepButton();
        String actualResultMessage = resultPage.getResultMessage();
        resultPage.confirmResultMessage("You’ll need a visa to join your family or partner in the UK");

    }
}
