package tests;

import helpers.Fixture;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import tabs.Customers;

public class SortingCustomers extends Fixture {
    protected Customers customers;
    @BeforeEach
    public void before() {
        customers = new Customers(driver);
    }
    @Story("Сортировка клиентов по имени (First Name)")
    @org.junit.jupiter.api.Test
    @Severity(SeverityLevel.NORMAL)
    public void sortingCustomersByFirstName() {
        customers.goToCustomers();
        customers.sortingCustomers();

            Assert.assertEquals(customers.createAfterSort(),customers.createBeforeSort());
        }

    }


