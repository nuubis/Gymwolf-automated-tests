package tests;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestBase {

    protected static WebDriver driver;
    public String url = "https://www.gymwolf.com/staging/";
    protected final int waitForResposeTime = 5;


    @Before
    public void setUp(){

        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get(url);
    }

    protected void click(By by){
        driver.findElement(by).click();
    }

    protected void goToPage(String page){
        WebElement elem = driver.findElement(By.linkText(page));
        elem.click();
    }


    protected void register(String email){

        goToPage("Alusta tasuta");

        driver.findElement(By.name("signup_email")).sendKeys(email);
        driver.findElement(By.cssSelector("button.btn-primary")).click();

    }

    protected void logout(){
        driver.findElement(By.cssSelector("span.menu-name-label")).click();
        WebElement logout = driver.findElement(By.linkText("Logi Välja"));
        logout.click();
    }

    @After
    public void closeDriver(){
        driver.close();
    }


    // Tried to test login, but the tests said that the elements arent interactable

    /*
    protected void login(String email, String password){

        driver.get(url);

        driver.findElement(By.linkText("Logi sisse")).click();
        waitForElementByXpath("//input[@name='email']");
        WebElement emailElem = driver.findElement(By.name("email"));
        //WebElement emailElem = driver.findElement(By.xpath("//input[@placeholder='E-mail']"));
        emailElem.sendKeys(email);
        // driver.findElement(By.name("password")).sendKeys(password);
        driver.findElement(By.xpath("//input[@name='password']")).sendKeys(email);

        driver.findElement(By.cssSelector("button.btn-primary")).click();
    }

    Implementation of explicit wait
    protected void waitForElementByXpath(String path){
        new WebDriverWait(driver, waitForResposeTime).until(ExpectedConditions.presenceOfElementLocated(By.xpath(path)));
    }

    protected void waitForElementById(String id){
        new WebDriverWait(driver, waitForResposeTime).until(ExpectedConditions.presenceOfElementLocated(By.id(id)));
    }

    protected void waitForElementBytagName(String tagName){
        new WebDriverWait(driver, waitForResposeTime).until(ExpectedConditions.presenceOfElementLocated(By.tagName(tagName)));
    }

    protected void waitForElementByClassName(String className){
        new WebDriverWait(driver, waitForResposeTime).until(ExpectedConditions.presenceOfElementLocated(By.className(className)));
    }
    */
}
