package com.qa.pages;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.By;

public class TGOrdersAndDriversListScreen extends BasePage {
//    @iOSXCUITFindBy(xpath = "//*[@name='Table Layout']"  )
//    private WebElement tableLayoutTab;
    String tableLayoutTab = "Table Layout";



//    @iOSXCUITFindBy( accessibility = "All"  )
//    private WebElement allBtn;
      String allBtn = "All";

    public void pressTableLayout() {
        WebElement element=mergeAndFindMobileElement(tableLayoutTab);
        elementClick(element, "Tapped Table Layout Tab");

//        elementClick(tableLayoutTab, "Tapped Table Layout Tab");
    }

    public void pressAll() {
        WebElement element=mergeAndFindMobileElement(allBtn);
        elementClick(element, "Tapped All Button");
//        elementClick(allBtn, "Tapped Table Layout Tab");
    }
}
