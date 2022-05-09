package gov.uk.check.visa.pages;

import gov.uk.check.visa.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class WorkTypePage extends Utility {

    public WorkTypePage() {
        PageFactory.initElements(driver,this);
    }


    @FindBy(xpath = " //input[@type='radio']")
    List<WebElement> selectJobTypeList;

    @FindBy(xpath = "//button[contains(text(),'Continue')]")
    WebElement nextStepButton;

    public void selectJobType(String job){
        for(WebElement element : selectJobTypeList){
            if(element.getAttribute("value").equalsIgnoreCase(job)){
                element.click();
                break;
            }
        }
    }

    public void clickNextStepButton(){
        clickOnElement(nextStepButton);
    }



}
