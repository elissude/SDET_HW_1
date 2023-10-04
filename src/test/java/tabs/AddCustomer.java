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
    @Step("Получить текст из алерт-окна")
    public String alert() {
    Alert alert = wait.until(ExpectedConditions.alertIsPresent());
    String text = alert.getText();
    return text;
}
    }


