package tests;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static junit.framework.TestCase.assertEquals;

public class Tests extends TestBase {


    protected String correctEmail = "test@test.ee";

    //protected String email = "marttikakk@gmail.com";
    //protected String password = "test";


    @Test
    public void registerIncorrectEmail() {
        register("ok");
        WebElement alert = driver.findElement(By.cssSelector("div.alert.alert-danger"));
        // assert that alert notification has appeared
        assertEquals("×\n" +
                "Vigane e-maili aadress", alert.getText());
    }

    @Test
    public void registerCorrectEmail() {
        register(correctEmail);
        WebElement progressTab = driver.findElement(By.linkText("Progress"));
        // assert that Progress tab is visible
        assertEquals("Progress", progressTab.getText());

        logout();
    }


    //These tests don't work because for some reason in login the test can't interact with certain elements

    /*@Test
    public void loginLogout(){

        login(email, password);

        WebElement progressTab = driver.findElement(By.linkText("Progress"));
        // assert that Progress tab is visible
        assertEquals("Progress", progressTab.getText());

        logout();
    }

    @Test
    public void loginEmptyInput() {
        goToPage("Logi sisse");

        waitForElementByXpath("//button[@class='btn btn-primary btn-block']");
        driver.findElement(By.cssSelector("button.btn.btn-primary.btn-block")).click();

        waitForElementByXpath("//div[@class=alert alert-danger]");
        WebElement alert = driver.findElement(By.cssSelector("div.alert-danger"));

        assertEquals("\n" +
                "\t\t      Vale parool või e-maili aadress, palun proovige uuesti.", alert.getText());

    }*/







}
