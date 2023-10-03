package tabs;

import io.qameta.allure.Step;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static helpers.Fixture.wait;


public class AddCustomer {
    private WebDriver driver;
    public AddCustomer(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath = "//button[@ng-click=\"addCust()\"]")
    public WebElement addCustomerTab;
    @FindBy(xpath = "//input[@placeholder=\"First Name\"]")
    public WebElement firstNameField;
    @FindBy(xpath = "//input[@placeholder=\"Last Name\"]")
    public WebElement lastNameField;
    @FindBy(xpath = "//input[@placeholder=\"Post Code\"]")
    public WebElement postCodeField;
    @FindBy(xpath = "//button[@class=\"btn btn-default\"]")
    public WebElement addCustomerButton;

    @Step("Создать клиента")
    public void goToAddingCustomer() {
        addCustomerTab.click();
        wait.until(ExpectedConditions.visibilityOf(firstNameField));
        firstNameField.sendKeys("Elis");
        lastNameField.sendKeys("Sude");
        postCodeField.sendKeys("S9999");
        addCustomerButton.click();
    }
    @Step("Работа с алерт-окном")
    public String alert() {
    Alert alert = wait.until(ExpectedConditions.alertIsPresent());
    String text = alert.getText();
    return text;
}

//    @Step("Алерт")
//    public void alert() {
//        try {
//            addCustomerButton.sendKeys(Keys.ENTER);
//        } catch (UnhandledAlertException f) {
//            try {
//                Alert alert = driver.switchTo().alert();
//                String alertText = alert.getText();
//                System.out.println("Alert data: " + alertText);
//                ((Alert) alert).accept();
//            } catch (NoAlertPresentException e) {
//                e.printStackTrace();
//            }
//        }
    }


