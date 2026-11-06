package aqa.page;

import aqa.test.config.TestData;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.jspecify.annotations.NonNull;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;

public class LoginPage {
    private final SelenideElement mainTitle = $x("//div[@class='login_logo']");

    private final SelenideElement usernameInput = $x("//input[@id='user-name']");

    private final SelenideElement passwordInput = $x("//input[@id='password']");

    private final SelenideElement errorMessage = $x("//h3[@data-test='error']");

    private final SelenideElement loginButton = $x("//input[@data-test='login-button']");

    @NonNull
    @Step("Проверка элементов на странице 'Логин'")
    public LoginPage checkElements(){
        mainTitle.shouldHave(text("Swag Labs"));
        usernameInput.shouldBe(visible);
        passwordInput.shouldBe(visible);
        loginButton.shouldBe(visible);

        return this;
    }

    @NonNull
    @Step("Ввести логин: {username}")
    public LoginPage enterUsername(String username){
        usernameInput.setValue(username);
        return this;
    }

    @Step("Ввести пароль")
    public LoginPage enterPassword(String password) {
        passwordInput.setValue(password);
        return this;
    }

    @NonNull
    @Step("Нажать на кнопку 'Login'")
    public MainPage clickLoginButton(){
        loginButton.click();
        return new MainPage();
    }

    @NonNull
    @Step("Проверка ошибки поля пароля когда значение некорректно")
    public LoginPage checkIncorrectPasswordError(){
        passwordInput.setValue(TestData.INVALID_PASSWORD);
        loginButton.click();
        errorMessage.shouldHave(text("Epic sadface: Username and password do not match any user in this service"));

        return this;
    }

    @NonNull
    @Step("Проверка ошибки поля пароля когда значение некорректно")
    public LoginPage checkIncorrectUsernameError(){
        usernameInput.setValue(TestData.INVALID_USERNAME);
        passwordInput.setValue(TestData.VALID_PASSWORD);
        loginButton.click();
        errorMessage.shouldHave(text("Epic sadface: Username and password do not match any user in this service"));

        return this;
    }
}
