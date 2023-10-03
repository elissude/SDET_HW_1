package tests;

import helpers.Fixture;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.junit.jupiter.api.BeforeEach;
import tabs.AddCustomer;

import static org.assertj.core.api.Assertions.assertThat;

public class CreatingCustomer extends Fixture {
    protected AddCustomer addCustomer;
    @BeforeEach
    public void before() {
        addCustomer = new AddCustomer(driver);
    }
    @Story("Создание клиента")
    @org.junit.jupiter.api.Test
    @Severity(SeverityLevel.CRITICAL)
    public void practiceForm() {
        addCustomer.goToAddingCustomer();
        addCustomer.alert();
        assertThat(addCustomer.alert()).contains("Customer added successfully with customer id :");
    }

}