package com.solvd.gsmarena.tests;

import com.qaprosoft.carina.core.foundation.AbstractTest;
import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.core.foundation.dataprovider.annotations.XlsDataSourceParameters;
import com.qaprosoft.carina.core.foundation.utils.ownership.MethodOwner;
import com.solvd.gsmarena.GetgsmarenaPage;
import com.solvd.gsmarena.services.IGetAgsmarenaUser;
import org.testng.Assert;

import org.testng.annotations.Test;


import java.util.HashMap;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class gsmarenaTests extends AbstractTest implements IAbstractTest, IGetAgsmarenaUser {

    @Test
    public void verifyHomePageWorkflow(){
        GetgsmarenaPage getgsmarenaPage = goToSignUp(getDriver());
        assertEquals(getgsmarenaPage.getCreateAccountText(), "Create account", "FATAL!, Not same");
    }//

    @Test(dataProvider = "DataProvider")
    @MethodOwner(owner = "qpsdemo")
    @XlsDataSourceParameters(path = "users.xlsx", sheet = "Data", dsUid = "row")
    public void signUpUser(HashMap<String, String> args){
        GetgsmarenaPage getgsmarenaPage = goToCreateAccount(getDriver(), args);
        assertEquals(getgsmarenaPage.getWelcomeText(), "Your account was created.", "FATAL!, Not same");

    }

    @Test
    public void signUpUserInvalidEmails(){
        GetgsmarenaPage getgsmarenaPage = goToCreateAccountInvalidEmail(getDriver());
        assertTrue(getgsmarenaPage.getSubmitButtonDisabled());

    }

    @Test
    public void signUpUserEmptyName(){
        GetgsmarenaPage getgsmarenaPage = goToCreateAccountEmptyName(getDriver());
        assertEquals(getgsmarenaPage.getSignUpEmptyNameMessage(), "Reason: Your nickname should have between 2 and 20 symbols.", "FATAL!, Not same");

    }

    @Test
    public void signUpUserEmptyEmail(){
        GetgsmarenaPage getgsmarenaPage = goToCreateAccountEmptyEmail(getDriver());
        assertTrue(getgsmarenaPage.getSubmitButtonDisabled());

    }

    @Test
    public void signUpUserValidateConditions(){
        GetgsmarenaPage getgsmarenaPage = goToCreateAccountValidateConditions(getDriver());
        assertTrue(getgsmarenaPage.getSubmitButtonDisabled());

    }
    @Test(dataProvider = "DataProvider")
    @MethodOwner(owner = "qpsdemo")
    @XlsDataSourceParameters(path = "users.xlsx", sheet = "Data", dsUid = "row")
    public void loginUser(HashMap<String, String> args){
        GetgsmarenaPage getgsmarenaPage = goToLoginUser(getDriver(), args);
        assertEquals(getgsmarenaPage.getLoginFailedText(), "Reason: User record not found.", "FATAL!, Not same");

    }

    @Test
    public void loginUserEmptyEmail(){
        GetgsmarenaPage getgsmarenaPage = goToLoginUserEmptyEmail(getDriver());
        Assert.assertTrue(getgsmarenaPage.getSignOutButtonNotVisible());

    }

    @Test
    public void loginUserEmptyPass(){
        GetgsmarenaPage getgsmarenaPage = goToLoginUserEmptyPass(getDriver());
        Assert.assertTrue(getgsmarenaPage.getSignOutButtonNotVisible());

    }

    @Test(dataProvider = "DataProvider")
    @MethodOwner(owner = "qpsdemo")
    @XlsDataSourceParameters(path = "users.xlsx", sheet = "Data", dsUid = "row")
    public void loginUserInvalidEmailPassCombination(HashMap<String, String> args){
        GetgsmarenaPage getgsmarenaPage = goToLoginUserInvalidEmailPassCombination(getDriver(), args);
        assertEquals(getgsmarenaPage.getLoginFailedText(), "Reason: User record not found.", "FATAL!, Not same");

    }

    @Test
    public void searchGeneral(){
        GetgsmarenaPage getgsmarenaPage = goToSearchGeneral(getDriver());
        assertEquals(getgsmarenaPage.getResultSearchText(), "Search results for \"samsung\"", "FATAL!, Not same");
    }

    @Test
    public void searchSpecific(){
        GetgsmarenaPage getgsmarenaPage = goToSearchSpecific(getDriver());
        assertEquals(getgsmarenaPage.getResultSpecificSearch(), "Samsung Galaxy A72", "FATAL!, Not same");
    }

}
