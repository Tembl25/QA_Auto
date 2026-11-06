package aqa.test.web;

import aqa.page.LoginPage;
import aqa.test.config.Config;
import aqa.test.config.TestData;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.Test;

class LoginTest extends BaseTest {
    @Test
    public void loginCorrectTest() {
        Selenide.open(Config.BASE_URL, LoginPage.class)
                .checkElements()
                .enterUsername(TestData.VALID_USERNAME)
                .enterPassword(TestData.VALID_PASSWORD)
                .clickLoginButton()
                .checkProductsTitle();
    }

    @Test
    public void incorrectPasswordTest() {
        Selenide.open(Config.BASE_URL, LoginPage.class)
                .checkElements()
                .enterUsername(TestData.VALID_USERNAME)
                .checkIncorrectPasswordError();
    }

    @Test void incorrectUsernameTest(){
        Selenide.open(Config.BASE_URL, LoginPage.class)
                .checkElements()
                .checkIncorrectUsernameError();
    }
}