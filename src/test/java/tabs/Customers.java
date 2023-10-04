package tabs;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.Arrays;
import java.util.List;

import static helpers.Fixture.wait;
public class Customers {
    private static WebDriver driver;

    public Customers(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath = "//button[@ng-click=\"showCust()\"]")
    public WebElement customersTab;
    @FindBy(xpath = "//table/thead/tr/td[1]/a")
    public WebElement firstNameSortingButton;
    @FindBy(xpath = "//input[@type=\"text\"]")
    public WebElement searchCustomersField;
    @FindBy(xpath = " //table/tbody/tr/td[1]")
    public WebElement resultSearchingCustomersByName;

    @Step("Перейти в раздел Customers")
    public void goToCustomers() {
        customersTab.click();
    }
    @Step("Найти клиента по имени")
    public void findCustomersByName() {
        wait.until(ExpectedConditions.visibilityOf(searchCustomersField));
        searchCustomersField.click();
        searchCustomersField.sendKeys("Hermoine");
    }
    @Step("Получить имя клиента из результата поиска")
    public String getNameBySearch() {
        return resultSearchingCustomersByName.getText();
    }
    public List <WebElement> createCustomerSortName() {
        List <WebElement> customersTableSortingName = driver.findElements(By.xpath("//table/tbody/tr/td[1]"));
        return customersTableSortingName;
    }
    @Step("Получить список клиентов перед сортировкой")
    public String[] createBeforeSort() {
        List <WebElement> customersTableSortingName = createCustomerSortName();
        String[] beforeSort = new String[customersTableSortingName.size()];

        for(int i=0;i<customersTableSortingName.size();i++){
            beforeSort[i] = customersTableSortingName.get(i).getText().trim();
        }
        return beforeSort;
    }
    @Step("Сортировать клиентов по имени \"А-Я\"")
    public void sortingCustomers() {
        wait.until(ExpectedConditions.visibilityOf(firstNameSortingButton));
        firstNameSortingButton.click();
        firstNameSortingButton.click();
    }
    @Step("Получить список клиентов после сортировки")
    public String[] createAfterSort() {
            sortingCustomers();
            List <WebElement> customersTableSortingName = createCustomerSortName();
            String[] afterSort = new String[customersTableSortingName.size()];

            for(int i=0;i<customersTableSortingName.size();i++) {
                afterSort[i] = customersTableSortingName.get(i).getText().trim();
            }
        Arrays.sort(afterSort);
            return afterSort;
    }
}

