package gov.uk.check.visa.pages;

import gov.uk.check.visa.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ReasonForTravelPage extends Utility {

    public ReasonForTravelPage() {
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//input[@type='radio']")
    List<WebElement> reasonForVisitList;

    @FindBy(xpath = "//button[contains(text(),'Continue')]")
    WebElement nextStepButton;

    public void selectReasonForVisit(String reason){
        for(WebElement element : reasonForVisitList){
            if(element.getAttribute("value").equalsIgnoreCase(reason)){
                element.click();
                break;
            }
        }
    }

    public void clickNextStepButton(){
        clickOnElement(nextStepButton);
    }

}
