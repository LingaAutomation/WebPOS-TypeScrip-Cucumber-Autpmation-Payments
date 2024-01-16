package com.qa.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;

import java.util.concurrent.TimeUnit;

public class TGPosSettingsPage extends BasePage {


    public void swipeUntilSaveChangesButton(String direction) throws Exception {
        direction = direction.toLowerCase();

        int i = 0;
        boolean found = false;

        while (i < 3) {
            try {
                if (isElementExists()) {
                    found = true;
                    break;
                } else {
                    scrollToElement(By.id(saveChangesButton), direction);
                    i++;
                    continue;
                }
            } catch (Exception e) {
                scrollToElement(By.id(saveChangesButton), direction);
                i++;
                if (i == 3)
                    Assert.fail(e.getMessage());
                continue;
            }
        }
    }

    public void closeAskCustomerNameOptionIfEnable() throws Exception {


        WebElement element = mergeAndFindMobileElement(posSettingHeader);
        String actualName = elementGetText(element, "verify posSettingHeader");
        String expectedName = "Till Settings";

        Assert.assertEquals(actualName, expectedName);

        WebElement askCustomerName = driver.findElement(By.xpath("//ion-item[contains(.,' Ask Customer Name ')]//ion-toggle[@aria-checked='true']"));

        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", askCustomerName);

        askCustomerName.click();
    }


    public void closeEnableCashDropOptionIfEnable(String direction) throws Exception {
        direction = direction.toLowerCase();

        int i = 0;
        boolean found = false;

        while (i < 3) {
            try {
                if (isElementExists()) {
                    found = true;
                    break;
                } else {
                    scrollToElement(By.id(barTabOption), direction);
                    i++;
                    continue;
                }
            } catch (Exception e) {
                scrollToElement(By.id(barTabOption), direction);
                i++;
                if (i == 3)
                    Assert.fail(e.getMessage());
                continue;
            }
        }
        WebElement element1 = mergeAndFindMobileElement(enableCashDropToggle);
        String value = getAttribute(element1, "value");

        if (value.contains("0")) {
            WebElement menuIcon = mergeAndFindMobileElement(operationMenuIcon);
            elementClick(menuIcon, "click operationMenuIcon ");

            WebElement tabPos = mergeAndFindMobileElement(posTab);
            elementClick(tabPos, "click operationMenuIcon ");

        } else if (value.contains("1")) {
            WebElement element = mergeAndFindMobileElement(askCustomerNameToggle);
            elementClick(element, "click askCustomerNameToggle ");
            swipeUntilSaveChangesButton("down");

            WebElement element2 = mergeAndFindMobileElement(saveChangesButton);
            elementClick(element2, "click saveChangesButton ");

            WebElement menuIcon = mergeAndFindMobileElement(operationMenuIcon);
            elementClick(menuIcon, "click operationMenuIcon ");

            WebElement tabPos = mergeAndFindMobileElement(posTab);
            elementClick(tabPos, "click operationMenuIcon ");
        }
    }

    public void openEnableCashDropOptionIfDisable(String direction) throws Exception {
//        direction = direction.toLowerCase();
//
//        int i = 0;
//        boolean found = false;
//
//        while (i < 3) {
//            try {
//                if (isElementExists()) {
//                    found = true;
//                    break;
//                } else {
//                    scrollToElement(barTabOption, direction);
//                    i++;
//                    continue;
//                }
//            } catch (Exception e) {
//                scrollToElement(barTabOption, direction);
//                i++;
//                if (i == 3)
//                    Assert.fail(e.getMessage());
//                continue;
//            }
//        }
        WebElement element1 = mergeAndFindMobileElement(enableCashDropToggle);
        String value = getAttribute(element1, "value");

        if (value.contains("0")) {
            WebElement element = mergeAndFindMobileElement(enableCashDropToggle);
            elementClick(element, "click askCustomerNameToggle ");
            swipeUntilSaveChangesButton("down");

            WebElement element2 = mergeAndFindMobileElement(saveChangesButton);
            elementClick(element2, "click saveChangesButton ");

            WebElement element3 = mergeAndFindMobileElement(doneButton);
            elementClick(element3, "click doneButton ");


            WebElement menuIcon = mergeAndFindMobileElement(operationMenuIcon);
            elementClick(menuIcon, "click operationMenuIcon ");

//            WebElement tabPos= mergeAndFindMobileElement(posTab);
//            elementClick(tabPos, "click operationMenuIcon ");


        } else if (value.contains("1")) {
            WebElement menuIcon = mergeAndFindMobileElement(operationMenuIcon);
            elementClick(menuIcon, "click operationMenuIcon ");

//            WebElement tabPos= mergeAndFindMobileElement(posTab);
//            elementClick(tabPos, "click operationMenuIcon ");
        }
    }

    @FindBy(xpath = "//linga-icon[@symbol='menuIcon']")
    WebElement ToggleIcon;

    public void openAskCustomerNameOptionIfDisable(String direction, String direction1) throws Exception {


        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

            Thread.sleep(5000);
            elementClick(ToggleIcon, "Toggle Icon Selected");
            elementClick(posSettings, "posSettings Selected");
            for (int u = 0; u <= 10; u++) {
                driver.findElement(By.tagName("html")).sendKeys(Keys.END);
                driver.findElement(By.tagName("html")).sendKeys(Keys.END);
            }

            WebElement e1 = driver.findElement(By.xpath("//ion-label[.=' Ask Customer Name ']/..//ion-toggle"));
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", e1);
            elementClick(e1, "Cash Drop Button Selected");

            WebElement saveChanges = (WebElement) driver.findElement(By.xpath("(//button[contains(.,'Save Changes')])[2]"));
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", saveChanges);
            elementClick(saveChanges, "Save Changes Button Selected");

    }



//        public void closeEnableCashDropOptionIfDisable(){
////        direction = direction.toLowerCase();
////        int i = 0;
////        boolean found = false;
////
////        while (i < 3) {
////            try {
////                if (isElementExists()) {
////                    found = true;
////                    break;
////                } else {
////                    scrollToElement(enableCashDropToggle, direction);
////                    i++;
////                    continue;
////                }
////            } catch (Exception e) {
////                scrollToElement(enableCashDropToggle, direction);
////                i++;
////                if (i == 3)
////                    Assert.fail(e.getMessage());
////                continue;
////            }
////        }
//            WebElement element1 = mergeAndFindMobileElement(enableCashDropToggle);
//            String value = getAttribute(element1, "value");
//
//            if (value.contains("1")) {
//                WebElement element = mergeAndFindMobileElement(enableCashDropToggle);
//                elementClick(element, "click askCustomerNameToggle ");
////            swipeUntilSaveChangesButton("down");
//
//                WebElement element2 = mergeAndFindMobileElement(saveChangesButton);
//                elementClick(element2, "click saveChangesButton ");
//
//                WebElement element3 = mergeAndFindMobileElement(doneButton);
//                elementClick(element3, "click saveChangesButton ");
//
//                WebElement menuIcon = mergeAndFindMobileElement(operationMenuIcon);
//                elementClick(menuIcon, "click operationMenuIcon ");
//
//                WebElement tabPos = mergeAndFindMobileElement(posTab);
////            elementClick(tabPos, "click operationMenuIcon ");
//
//            } else if (value.contains("0")) {
//                WebElement menuIcon = mergeAndFindMobileElement(operationMenuIcon);
//                elementClick(menuIcon, "click operationMenuIcon ");
//
//                WebElement tabPos = mergeAndFindMobileElement(posTab);
////            elementClick(tabPos, "click operationMenuIcon ");
//            }
//        }

    }











