package aqa.page;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.jspecify.annotations.NonNull;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;

public class MainPage {
    private final SelenideElement productsTitle = $x("//span[@data-test='title']");

    @NonNull
    @Step("Проверка элементов на странице 'Products'")
    public MainPage checkProductsTitle(){
        productsTitle.shouldBe(visible);
        return this;
    }
}
