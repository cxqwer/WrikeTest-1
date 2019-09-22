package pages;

import Data.PagesData;
import io.qameta.allure.Feature;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

@Feature("Test for 'Get started for free' button on main page")
public class MainPage {
    // TODO: 22.09.2019 У локаторов нет комментов
    @FindBy(xpath = "//div[@class='wg-header__sticky-mainmenu']//button")
    private WebElement getStartedButton;

    @FindBy(xpath = "//*[@id='modal-pro']/form//button")
    private WebElement createAccountButton;

    private WebDriver driver;

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Open wrike.com")
    // TODO: 22.09.2019  Нахуя делать метод который делает только одну строчку кода?)
    public void open(PagesData url) {
        driver.get(url.toString());
    }

    @Step("Click \"Get started for free\" button near \"Login\" button")
    // TODO: 22.09.2019  Аналогично
    public void clickGesStartedForFree() {
        getStartedButton.click();
    }

    @Step("Fill in the email field with random generated value of email")
    public void fillEmail(String email) {
        WebElement enterEmailField = (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.visibilityOfElementLocated
                        (By.xpath("//input[@class='wg-input modal-form-trial__input']")));
        enterEmailField.sendKeys(email);
    }

    // TODO: 22.09.2019  аналогично
    @Step("Click on \"Create my Wrike account\" button")
    public void clickCreateAccount() {
        createAccountButton.click();
    }

}
