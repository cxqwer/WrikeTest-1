package pages;

import Data.FormData;
import Data.PagesData;
import Data.SocialNetsData;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import static Data.PagesData.RESEND_TITLE;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ResendPage {

    @FindBy(xpath = "//div[@class='wg-cell wg-cell--md-6 wg-cell--lg-7']")
    private WebElement helpUs;

    @FindBy(xpath = "//div[@data-code='interest_in_solution']//button")
    private List<WebElement> interested;

    @FindBy(xpath = "//div[@data-code='team_members']//button")
    private List<WebElement> membersCount;

    @FindBy(xpath = "//div[@data-code='primary_business']//button")
    private List<WebElement> managingWork;

    @FindBy(xpath = "//label[@class='switch switch--text switch--fullwidth']//button")
    private WebElement comment;

    @FindBy(xpath = "//button[@class='submit wg-btn wg-btn--navy js-survey-submit']")
    private WebElement submitButton;

    @FindBy(xpath = "//a[@class='wg-footer__social-link']")
    private List<WebElement> socialNetworkUrls;

    @FindBy(xpath = "//*[name()='use'][contains(@*, 'v2')]")
    private List<WebElement> getSocialNetworkIcons;

    private WebDriver driver;

    public ResendPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("check that moved to the next page")
    public void checkThatMovedOnNextPage() {
        WebElement element = (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.visibilityOfElementLocated
                        (By.xpath("//div[@class='wg-cell wg-cell--md-6 wg-cell--lg-7']")));
        assertEquals(RESEND_TITLE.toString(), driver.getTitle());
        assertTrue(helpUs.isDisplayed());
    }

    @Step("Fill in the Q&A section at the left part of page in case where answers for 'Managing work' question" +
            "will be 'Yes' or 'No'")
    public void fillForm(FormData interest, FormData members, FormData managing) {
        interested.get(interest.value).click();
        membersCount.get(members.value).click();
        managingWork.get(managing.value).click();
    }

    @Step("Fill in the Q&A section at the left part of page in case where answer for 'Managing work' question " +
            "will be 'Other'")
    public void fillForm(FormData interest, FormData members, FormData managing, PagesData text) {
        fillForm(interest, members, managing);
        comment.sendKeys(text.toString());
    }

    @Step("Submit asnwers")
    public void submit() {
        submitButton.click();
    }

    @Step("Check that anwers are submitted")
    public void isSubmitted() {
        WebElement element = (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.visibilityOfElementLocated
                        (By.xpath("//div[@class='survey-success']")));
        assertTrue(element.isDisplayed());
    }

    @Step("Check that section 'Follow us' at the site footer contains" +
            "a button that leads to the correct url and has the correct icon")
    public void checkCorrectUrlAndIcon(SocialNetsData socialNetsData) {
        int indexOfUrl = -1;
        int indexOfIcon = -1;
        for (int i = 0; i < socialNetworkUrls.size(); i++) {
            if (socialNetworkUrls.get(i).getAttribute("href").equals(socialNetsData.url)) {
                indexOfUrl = i;
                break;
            }
        }
        for (int i = 0; i < getSocialNetworkIcons.size(); i++) {
            if (getSocialNetworkIcons.get(i).getAttribute("xlink:href").contains(socialNetsData.icon)) {
                indexOfIcon = i;
                break;
            }
        }
        assertTrue(indexOfIcon > -1);
        assertEquals(indexOfIcon, indexOfUrl);
        assertTrue(indexOfUrl > -1);
    }

}
