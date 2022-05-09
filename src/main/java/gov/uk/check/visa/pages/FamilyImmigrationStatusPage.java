package gov.uk.check.visa.pages;

import gov.uk.check.visa.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FamilyImmigrationStatusPage extends Utility {

    public FamilyImmigrationStatusPage() {
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//input[@value=\"yes\"]")
    WebElement yes;

    @FindBy(xpath = "//input[@value=\"no\"]")
    WebElement no;

    @FindBy(xpath = "//button[contains(text(),'Continue')]")
    WebElement continueButton;

    public void selectImmigrationStatus(String status){
        switch (status){
            case "yes":
                clickOnElement(yes);
                break;
            case "no":
                clickOnElement(no);
                break;
            default:
                System.out.println("not select any immigration status");

        }
    }

    public void clickNextStepButton(){
        clickOnElement(continueButton);
    }
}
