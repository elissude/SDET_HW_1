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

public class SortingCustomers extends Fixture {
    protected Customers customers;
    @BeforeEach
    public void before() {
        customers = new Customers(driver);
    }
    @Execution(ExecutionMode.CONCURRENT)
    @Story("Сортировка клиентов по имени (First Name)")
    @Test
    @Severity(SeverityLevel.NORMAL)
    public void sortingCustomersByFirstName() {
        customers.goToCustomers();
        /** Проверка совпадения отсортированного на UI списка списку, полученному путем сортировки массива*/
        Assert.assertEquals(customers.createAfterSort(),customers.createBeforeSort());
        }
    }


