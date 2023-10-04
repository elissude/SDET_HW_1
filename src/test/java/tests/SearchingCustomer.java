package tests;

import helpers.Fixture;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import org.junit.jupiter.api.Test;
import tabs.Customers;
public class SearchingCustomer extends Fixture {
    protected Customers customers;
    String customerName = "Hermoine";
    @BeforeEach
    public void before() {
        customers = new Customers(driver);
    }
    @Execution(ExecutionMode.CONCURRENT)
    @Story("Найти клиента по имени")
    @Test
    @Severity(SeverityLevel.NORMAL)
    public void searchingCustomerByFirstName() {
        customers.goToCustomers();
        customers.findCustomersByName();
        String getNameBy = customers.getNameBySearch();
        /** Проверка совпадения результата поиска по имени поисковому слову*/
        Assert.assertEquals(customerName, getNameBy);
    }
}
