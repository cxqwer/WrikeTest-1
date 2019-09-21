import io.qameta.allure.Description;
import utils.RandomEmailGenerator;
import Data.SocialNetsData;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import pages.MainPage;
import pages.ResendPage;

import static Data.FormData.*;
import static Data.PagesData.*;
import static Data.PagesData.INDEX_HTML_URL;

public class WrikeTest {

    private MainPage mainPage;
    private ResendPage resendPage;
    private WebDriver driver;


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

}
