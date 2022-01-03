package com.solvd.gsmarena;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GetgsmarenaPage extends AbstractPage {

    private int randomNumber;

    @FindBy(xpath = "//i[@class = 'head-icon icon-user-plus']")
    private ExtendedWebElement signUpButton;

    @FindBy(xpath = "//h3[text() = 'Create account']")
    private ExtendedWebElement createAccountText;

    @FindBy(id = "uname")
    private ExtendedWebElement nickName;

    @FindBy(xpath = "(//input[@name = 'sEmail'])[2]")
    private ExtendedWebElement email;

    @FindBy(xpath = "(//input[@name = 'sPassword'])[2]")
    private ExtendedWebElement password;

    @FindBy(xpath = "//label[@for = 'iagree1']")
    private ExtendedWebElement conditionIAgree;

    @FindBy(xpath = "//label[@for = 'iagree2']")
    private ExtendedWebElement conditionAge;

    @FindBy(xpath = "//input[@id='nick-submit' and @class = 'button float-right']")
    private ExtendedWebElement submitButton;

    @FindBy(xpath = "//input[@id='nick-submit' and @class = 'button float-right' and @disabled = 'disabled']")
    private ExtendedWebElement submitButtonDisabled;

    @FindBy(xpath = "//h3[contains(text(), 'Your account was created. ')]")
    private ExtendedWebElement welcomeText;

    @FindBy(xpath = "//i[@class = 'head-icon icon-login']")
    private ExtendedWebElement loginButton;

    @FindBy(xpath = "(//input[@name = 'sEmail'])[1]")
    private ExtendedWebElement emailLogin;

    @FindBy(xpath = "(//input[@name = 'sPassword'])[1]")
    private ExtendedWebElement passwordLogin;

    @FindBy(xpath = "//input[@id='nick-submit' and @class = 'button']")
    private ExtendedWebElement loginUserPassButton;

    @FindBy(xpath = "//div[@class = 'normal-text res-error']//*[text() = 'Reason: User record not found.']")
    private ExtendedWebElement loginFailedText;

    @FindBy(id = "topsearch-text")
    private ExtendedWebElement searchField;

    @FindBy(xpath = "//h1[@class = 'article-info-name' and contains(text() , 'Search results for')]")
    private ExtendedWebElement resultText;

    @FindBy(xpath = "//span[ contains(text(), 'A72')]")
    private ExtendedWebElement menuSearch;

    @FindBy(xpath = "//h1[@class = 'specs-phone-name-title']")
    private ExtendedWebElement titleSpecificSearch;

    @FindBy(xpath = "//i[@class = 'head-icon icon-signout']")
    private ExtendedWebElement signOutButton;

    @FindBy(xpath = "//div[@class = 'normal-text res-error']//*[text() = 'Reason: Your nickname should have between 2 and 20 symbols.']")
    private ExtendedWebElement signUpEmptyNameMessage;

    public GetgsmarenaPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);

    }

    public void switchToQuoteWindow(String tabTitle){
        var windows = driver.getWindowHandles();

        for (String window : windows) {
            driver.switchTo().window(window);

            if (tabTitle.equals(driver.getTitle())){
                break;
            }
        }
    }

    public String getCreateAccountText(){
        return createAccountText.getText();
    }

    public void setNickName(String nickName){
        this.nickName.type(nickName);
    }

    public void setEmail(String email){
        this.email.type(email);
    }

    public void setPassword(String passWord){
        this.password.type(passWord);
    }

    public void clickConditionIAgree(){
        conditionIAgree.click();
    }

    public void clickConditionAge(){
        conditionAge.click();
    }

    public void clickSubmitButton(){
        submitButton.click();
    }

    public String getWelcomeText(){
        new WebDriverWait(driver, 7).until(ExpectedConditions.visibilityOf(welcomeText.getElement()));
        return welcomeText.getText();
    }

    public void clickLoginButton(){
        loginButton.click();
    }

    public void setEmailLogin(String email){
        emailLogin.type(email);
    }

    public void setPasswordLogin(String passWord){
        passwordLogin.type(passWord);
    }


    public int getRandomNumber() {
        return randomNumber;
    }

    public void setRandomNumber(int randomNumber) {
        this.randomNumber = randomNumber;
    }

    public void clickLoginUserPassButton(){
        loginUserPassButton.click();
    }

    public String getLoginFailedText(){
        new WebDriverWait(driver, 7).until(ExpectedConditions.visibilityOf(loginFailedText.getElement()));
        return loginFailedText.getText();
    }

    public void SearchGeneral(String search){
        searchField.type(search);
        searchField.sendKeys(Keys.ENTER);
    }

    public String getResultSearchText(){
        new WebDriverWait(driver, 7).until(ExpectedConditions.visibilityOf(resultText.getElement()));
        return resultText.getText();
    }

    public void searchSpecific(String search){
        searchField.type(search);
        new WebDriverWait(driver, 7).until(ExpectedConditions.visibilityOf(menuSearch.getElement()));
        menuSearch.click();
    }

    public String getResultSpecificSearch(){
        new WebDriverWait(driver, 7).until(ExpectedConditions.visibilityOf(titleSpecificSearch.getElement()));
        return titleSpecificSearch.getText();
    }

    public Boolean getSubmitButtonDisabled(){
        return isAnyElementPresent(submitButtonDisabled);
    }

    public Boolean getSignOutButtonNotVisible(){
        return isElementNotPresent(signOutButton,1);
    }

    public String getSignUpEmptyNameMessage(){
        return signUpEmptyNameMessage.getText();
    }

}
