package com.solvd.gsmarena;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends AbstractPage {

    @FindBy(xpath = "//i[@class = 'head-icon icon-user-plus']")
    private ExtendedWebElement signUpButton;

    @FindBy(id = "topsearch-text")
    private ExtendedWebElement searchField;

    @FindBy(xpath = "//i[@class = 'head-icon icon-login']")
    private ExtendedWebElement loginButton;

    public HomePage(WebDriver driver) {
        super(driver);
        open();
    }

    public GetgsmarenaPage clickSignUpButton(){
        new WebDriverWait(driver, 7).until(ExpectedConditions.elementToBeClickable(signUpButton.getElement()));
        signUpButton.click();
        return new GetgsmarenaPage(driver);
    }

    public GetgsmarenaPage clickSearchField(){
        searchField.click();
        return new GetgsmarenaPage(driver);
    }

    public GetgsmarenaPage clickLoginButton(){
        loginButton.click();
        return new GetgsmarenaPage(driver);
    }



}
