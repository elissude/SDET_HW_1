package tests;

import helpers.Fixture;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import tabs.Customers;
public class SearchingCustomer extends Fixture {
    protected Customers customers;
    String customerName = "Hermoine";
    @BeforeEach
    public void before() {
        customers = new Customers(driver);
    }
    @Story("Поиск клиента по имени")
    @org.junit.jupiter.api.Test
    @Severity(SeverityLevel.NORMAL)
    public void searchingCustomerByFirstName() {
        customers.goToCustomers();
        customers.findCustomersByName();
        String getNameBy = customers.getNameBySearch();
        Assert.assertEquals(customerName, getNameBy);
    }

}
