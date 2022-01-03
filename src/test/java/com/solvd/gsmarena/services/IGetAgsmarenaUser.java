package com.solvd.gsmarena.services;

import com.solvd.gsmarena.GetgsmarenaPage;
import com.solvd.gsmarena.HomePage;
import org.openqa.selenium.WebDriver;

import java.util.HashMap;
import java.util.Random;

public interface IGetAgsmarenaUser {


    default GetgsmarenaPage goToSignUp(WebDriver driver) {
        HomePage homePage = new HomePage(driver);
        GetgsmarenaPage getgsmarenaPage = homePage.clickSignUpButton();

        return new GetgsmarenaPage(driver);
    }

  /*  default GetgsmarenaPage goToCreateAccount(WebDriver driver){
        GetgsmarenaPage getgsmarenaPage = goToSignUp(driver);
        Random random = new Random();
        getgsmarenaPage.setRandomNumber(random.nextInt(9999));
        getgsmarenaPage.setNickName("pepe" + getgsmarenaPage.getRandomNumber() );
        getgsmarenaPage.setEmail("pepe" +  getgsmarenaPage.getRandomNumber() + "@gmail.com");
        getgsmarenaPage.setPassword("aaa" + getgsmarenaPage.getRandomNumber());
        getgsmarenaPage.clickConditionIAgree();
        getgsmarenaPage.clickConditionAge();
        getgsmarenaPage.clickSubmitButton();
        return getgsmarenaPage;
    }
*/
    default GetgsmarenaPage goToCreateAccount(WebDriver driver, HashMap<String, String> args){
        GetgsmarenaPage getgsmarenaPage = goToSignUp(driver);
        Random random = new Random();
        getgsmarenaPage.setRandomNumber(random.nextInt(9999999));
        getgsmarenaPage.setNickName(args.get("user") + getgsmarenaPage.getRandomNumber() );
        getgsmarenaPage.setEmail(args.get("email"));
        getgsmarenaPage.setPassword(args.get("pass"));
        getgsmarenaPage.clickConditionIAgree();
        getgsmarenaPage.clickConditionAge();
        getgsmarenaPage.clickSubmitButton();
        return getgsmarenaPage;
    }


    default GetgsmarenaPage goToCreateAccountInvalidEmail(WebDriver driver){
        GetgsmarenaPage getgsmarenaPage = goToSignUp(driver);
        Random random = new Random();
        getgsmarenaPage.setRandomNumber(random.nextInt(9999999));
        getgsmarenaPage.setNickName("pepe" + getgsmarenaPage.getRandomNumber() );
        getgsmarenaPage.setEmail("pepe" +  getgsmarenaPage.getRandomNumber() );
        getgsmarenaPage.setPassword("aaa" + getgsmarenaPage.getRandomNumber());
        getgsmarenaPage.clickConditionIAgree();
        getgsmarenaPage.clickConditionAge();
        //getgsmarenaPage.clickSubmitButton();
        return getgsmarenaPage;
    }

    default GetgsmarenaPage goToCreateAccountEmptyName(WebDriver driver){
        GetgsmarenaPage getgsmarenaPage = goToSignUp(driver);
        Random random = new Random();
        getgsmarenaPage.setRandomNumber(random.nextInt(9999999));
        getgsmarenaPage.setEmail("pepe" +  getgsmarenaPage.getRandomNumber() + "@gmail.com");
        getgsmarenaPage.setPassword("aaa" + getgsmarenaPage.getRandomNumber());
        getgsmarenaPage.clickConditionIAgree();
        getgsmarenaPage.clickConditionAge();
        getgsmarenaPage.clickSubmitButton();
        return getgsmarenaPage;
    }

    default GetgsmarenaPage goToCreateAccountEmptyEmail(WebDriver driver){
        GetgsmarenaPage getgsmarenaPage = goToSignUp(driver);
        Random random = new Random();
        getgsmarenaPage.setRandomNumber(random.nextInt(9999999));
        getgsmarenaPage.setNickName("pepe" + getgsmarenaPage.getRandomNumber() );
        getgsmarenaPage.setPassword("aaa" + getgsmarenaPage.getRandomNumber());
        getgsmarenaPage.clickConditionIAgree();
        getgsmarenaPage.clickConditionAge();
        //getgsmarenaPage.clickSubmitButton();
        return getgsmarenaPage;
    }

    default GetgsmarenaPage goToCreateAccountValidateConditions(WebDriver driver){
        GetgsmarenaPage getgsmarenaPage = goToSignUp(driver);
        Random random = new Random();
        getgsmarenaPage.setRandomNumber(random.nextInt(99999999));
        getgsmarenaPage.setNickName("pepe" + getgsmarenaPage.getRandomNumber() );
        getgsmarenaPage.setEmail("pepe" +  getgsmarenaPage.getRandomNumber() + "@gmail.com");
        getgsmarenaPage.setPassword("aaa" + getgsmarenaPage.getRandomNumber());
        //getgsmarenaPage.clickSubmitButton();
        return getgsmarenaPage;
    }


    default GetgsmarenaPage goToLoginUser(WebDriver driver, HashMap<String, String> args){
        GetgsmarenaPage getgsmarenaPage = goToCreateAccount(driver, args);
        getgsmarenaPage.clickLoginButton();
        getgsmarenaPage.setEmailLogin(args.get("email"));
        getgsmarenaPage.setPasswordLogin(args.get("pass"));
        getgsmarenaPage.clickLoginUserPassButton();
        return getgsmarenaPage;
    }

    default GetgsmarenaPage goToLoginUserInvalidEmailPassCombination(WebDriver driver, HashMap<String, String> args){
        GetgsmarenaPage getgsmarenaPage = goToCreateAccount(driver, args);
        getgsmarenaPage.clickLoginButton();
        getgsmarenaPage.setEmailLogin(args.get("email"));
        getgsmarenaPage.setPasswordLogin("XXX123123123");
        getgsmarenaPage.clickLoginUserPassButton();
        return getgsmarenaPage;
    }


    default GetgsmarenaPage goToLoginUserEmptyEmail(WebDriver driver){
        HomePage homePage = new HomePage(driver);
        GetgsmarenaPage getgsmarenaPage = homePage.clickLoginButton();
        //getgsmarenaPage.setEmailLogin("pepe" + getgsmarenaPage.getRandomNumber() + "@gmail.com");
        getgsmarenaPage.setPasswordLogin("aaa" + getgsmarenaPage.getRandomNumber());
        getgsmarenaPage.clickLoginUserPassButton();
        return getgsmarenaPage;
    }

    default GetgsmarenaPage goToLoginUserEmptyPass(WebDriver driver){
        HomePage homePage = new HomePage(driver);
        GetgsmarenaPage getgsmarenaPage = homePage.clickLoginButton();
        getgsmarenaPage.setEmailLogin("pepe" + getgsmarenaPage.getRandomNumber() + "@gmail.com");
        //getgsmarenaPage.setPasswordLogin("aaa" + getgsmarenaPage.getRandomNumber());
        getgsmarenaPage.clickLoginUserPassButton();
        return getgsmarenaPage;
    }

    default GetgsmarenaPage goToSearchGeneral(WebDriver driver){
        //GetgsmarenaPage getgsmarenaPage = goToLoginUser(driver);
        HomePage homePage = new HomePage(driver);
        GetgsmarenaPage getgsmarenaPage = homePage.clickSearchField();
        getgsmarenaPage.SearchGeneral("samsung");
        return getgsmarenaPage;
    }

    default GetgsmarenaPage goToSearchSpecific(WebDriver driver){
        HomePage homePage = new HomePage(driver);
        GetgsmarenaPage getgsmarenaPage = homePage.clickSearchField();//goToSignUp(driver);//goToLoginUser(driver);
        getgsmarenaPage.searchSpecific("samsung a72");
        return getgsmarenaPage;
    }

}
