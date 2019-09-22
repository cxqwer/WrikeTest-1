import Data.SocialNetsData;
import io.qameta.allure.Description;
import io.qameta.allure.Step;
import io.qameta.allure.Story;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import pages.MainPage;
import pages.ResendPage;
import utils.RandomEmailGenerator;

import static Data.FormData.*;
import static Data.PagesData.INDEX_HTML_URL;
import static Data.PagesData.TEXT_COMMENT;

public class WrikeTest {

    private MainPage mainPage;
    private ResendPage resendPage;
    private WebDriver driver;

    //Метод для степов
    @Step("{0}")
    public void step(String title, Runnable code) {
        code.run();
    }

    @Before
    public void beforeMethod() {
        System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        mainPage = PageFactory.initElements(driver, MainPage.class);
        resendPage = PageFactory.initElements(driver, ResendPage.class);
    }

    @After
    public void afterMethod() {
        driver.close();
    }

    @Description("Test on base functionality of wrike.com")
    @Test
    public void siteTest() {
        // TODO: 22.09.2019 Если бы ты степы не выносил в пейджу, тогда не нужны были бы комментарии
        //Open url: wrike.com
        mainPage.open(INDEX_HTML_URL);

        //Click "Get started for free" button near "Login" button
        mainPage.clickGesStartedForFree();

        //Fill in the email field with random generated value of email
        mainPage.fillEmail(RandomEmailGenerator.getRandomEmail());

        //Click on "Create my Wrike account" button + check that moved to the next page
        mainPage.clickCreateAccount();
        resendPage.checkThatMovedOnNextPage();

        //Fill in the Q&A section at the left part of page + check that answers are submitted
        resendPage.fillForm(VERY_INTERESTING, SIXTEEN_TWENTYFIVE, OTHER, TEXT_COMMENT);
        resendPage.submit();
        resendPage.isSubmitted();

        //Check that section "Follow us" at the site footer contains
        //the "Twitter" button that leads to the correct url and has the correct icon
        resendPage.checkCorrectUrlAndIcon(SocialNetsData.TWITTER);

    }

    @DisplayName("Wrike simple test")
    @Story("Wrike simple test")
    @Test
    public void testResend(){
        System.out.println("Запуск теста Wrike simple test");
        step("Открыть главную страницу", ()->mainPage.open(INDEX_HTML_URL));
        step("Нажать кнопку 'Get started for free'", ()->mainPage.clickGesStartedForFree());
        step("...", ()->mainPage.fillEmail(RandomEmailGenerator.getRandomEmail()));
        // TODO: 22.09.2019 И не нужны дурацкие комментарии
        System.out.println("Успешно");
    }

}
