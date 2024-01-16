package com.qa.pages;

import com.qa.utils.TestUtils;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.By;

public class TGUserLoginScreen extends SignInScreen{

    TestUtils utils = new TestUtils();

//    @iOSXCUITFindBy (id ="User Login")
//    private WebElement titleTxt;
    String titleTxt = "User Login";

//    @iOSXCUITFindBy (xpath = "//XCUIElementTypeApplication[@name=\"Linga POS\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[3]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTextField")
//    //@iOSXCUITFindBy (id = "ID")
//    private WebElement eMailTxtFld;

    String eMailTxtFld = "//XCUIElementTypeApplication[@name=\"Linga POS\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[3]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTextField";

//    @iOSXCUITFindBy (xpath = "//XCUIElementTypeApplication[@name=\"Linga POS\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[3]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeSecureTextField")
//    private WebElement passwordTxtFld;
    String passwordTxtFld = "//XCUIElementTypeApplication[@name=\"Linga POS\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[3]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeSecureTextField";

//    @iOSXCUITFindBy (id = "Finish")
//    private WebElement finishBtn;
    String finishBtn = "Finish";

//    @iOSXCUITFindBy (xpath = "//XCUIElementTypeStaticText[@name=\"Invalid username or password\"]")
//    private WebElement errTxt;
//    String errTxt = "//XCUIElementTypeStaticText[@name=\"Invalid username or password\"]";
    String errTxt = "Invalid username or password";

//    String cancel = "//XCUIElementTypeStaticText[@name=\"Cancel\"]";
    String cancel = "Cancel";

    String clearEmailXpath = "//XCUIElementTypeApplication[@name=\"Linga POS\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[3]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeSecureTextField";

    String clearPasswordXPath = "//XCUIElementTypeApplication[@name=\"Linga POS\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[3]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTextField";



    public String getTitle() {

        WebElement element=mergeAndFindMobileElement(titleTxt);
        String message = elementGetText(element, "user login window's title is - ");
        return message;
//        return elementGetText(titleTxt, "user login window's title is - ");
    }

    public void enterEMail(String eMailAddress) throws InterruptedException {
        //clear(eMailTxtFld);
        WebElement element=mergeAndFindMobileElement(eMailTxtFld);
        element.sendKeys(eMailAddress, "login with " + eMailAddress);
//        driver.hideKeyboard();
    }

    public void enterPassword(String password) {
        //clear(passwordTxtFld);
        WebElement element=mergeAndFindMobileElement(passwordTxtFld);
        element.sendKeys(password, "password is " + password);
    }

    public ClockInScreen pressFinishBtn() {
        WebElement element=mergeAndFindMobileElement(finishBtn);
        elementClick(element, "press finish button");
//        elementClick(finishBtn, "press finish button");
        return new ClockInScreen();
    }

    public ClockInScreen login(String eMail, String password) throws InterruptedException {
        enterEMail(eMail);
        enterPassword(password);
        return pressFinishBtn();
    }

    public String getErrTxt() {
        waitForVisibility(By.id(errTxt));
        WebElement element=mergeAndFindMobileElement(errTxt);
        String err = elementGetText(element, "error text is - ");
        return err;

//        String err = elementGetText(errTxt, "error text is - ");
//        return err;
    }
//    public String getErrTxt() {
////        waitForVisibility(errTxt);
//        String err = getText(errTxt, "error text is - ");
//        return err;
//    }


    //Click Cancel button
    public void clickCancel(){
        WebElement element1=mergeAndFindMobileElement(cancel);
        elementClick(element1,"click cancel");
    }

    public void clearEmailId(){
        WebElement element1=mergeAndFindMobileElement(clearEmailXpath);
        element1.clear();
    }

    public void clearPassword(){
        WebElement element1=mergeAndFindMobileElement(clearPasswordXPath);
        element1.clear();
    }

}
