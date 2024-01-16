package com.qa.pages;

import com.qa.utils.TestUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static com.qa.utils.TestUtils.driver;

public class PhoneOrderScreen extends BasePage {


    String phoneOrderTab = "//button//span[text()=' Phone/Web Orders ']";

    String driverStatusTabTitle= "//button//span[text()=' Future ']";

    @FindBy(xpath = "For Here")
    private WebElement forHereBtnPhoneOrderScreen;

    @FindBy(xpath = "To Go")
    private WebElement toGoBtnPhoneOrderScreen;

    @FindBy(xpath = "Edit")
    private WebElement editBtn;

    @FindBy(xpath = "Cancel Order")
    private  WebElement cancelOrderBtn;

    @FindBy(xpath = "Print")
    private WebElement printBtn;

//    @FindBy(xpath = "//XCUIElementTypeStaticText[@xpath=\"Driver is offline Still Do you want to continue\"]")
//    private WebElement driverOffline;

    @FindBy(xpath = "No")
    private WebElement noBtn;

    @FindBy(xpath = "//button[contains(.,'Yes')]")
    private WebElement YesBtn;

    @FindBy(xpath = "//div[.='Departure']")
    private WebElement departureBtn;

    @FindBy(xpath = "//span[contains(.,'Out')]")
    private WebElement outTabBtn;

    @FindBy(xpath = "//div[.='Arrival']")
    private WebElement arrivalBtn;

    @FindBy(xpath = "Cash")
    private WebElement cashBtn;

    @FindBy(xpath = "Delivery orders cannot be submitted here.")
    private WebElement deliveryOrderCannot;

    @FindBy(xpath = "Payment(s) made on this check,Can you return this to Auto r")
    private WebElement paymentMadeOnThisCheckPopup;

    @FindBy(xpath = "Future")
    private WebElement futureTab;

    @FindBy(xpath = "(//XCUIElementTypeButton[@xpath=\"New\"])")
    private WebElement newTabBtn;

    @FindBy(xpath = "New(1)")
    WebElement newTabBtn1;


    @FindBy(xpath = "//XCUIElementTypeApplication[@xpath=\"Linga POS\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[3]/XCUIElementTypeOther[1]/XCUIElementTypeOther/XCUIElementTypeTextField[3]")
    private WebElement searchTabInFutureTab;

    @FindBy(xpath = "//input[@data-placeholder='Check No']")
    private WebElement searchTabInActiveTab;

    @FindBy(xpath = "//input[@data-placeholder='Check No']")
    private WebElement searchTabClosedTab;

    @FindBy(xpath = "//XCUIElementTypeApplication[@xpath=\"Linga POS\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[3]/XCUIElementTypeOther[1]/XCUIElementTypeOther/XCUIElementTypeTextField")
    private WebElement searchTabInOutTab;

    @FindBy(xpath = "//XCUIElementTypeApplication[@xpath=\"Linga POS\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[3]/XCUIElementTypeOther[1]/XCUIElementTypeOther/XCUIElementTypeTextField")
    private WebElement searchTabInCompleteTab;

    @FindBy(xpath = "")
    private WebElement searchTabNewTab;

    //XCUIElementTypeApplication[@xpath="Linga POS"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[3]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[1]/XCUIElementTypeOther/XCUIElementTypeSearchField
    @FindBy(xpath = "//input[@ placeholder='Search xpath or Check Number']")
    WebElement searchTabInBarTab;

    @FindBy(xpath = "//input[@ placeholder='Search xpath or Check Number']")
    WebElement searchTabInBarTab1;

    @FindBy(xpath = "(//button[@class='searchbar-clear-button sc-ion-searchbar-md'])[1]")
    WebElement clearTextBtn;

    public void clickPhoneOrderTab(){
        elementClick(phoneOrderTab,"Tapped Phone Order Button");
    }

    public void clickForHereTab(){
        elementClick(forHereBtnPhoneOrderScreen,"Tapped For Here Button in Phone Order Screen");
    }

    public void clickToGoTab(){
        elementClick(toGoBtnPhoneOrderScreen,"Tapped To Go Button in Phone Order Screen");
    }

    public void clickEditBtn(){
        elementClick (editBtn,"Tapped Edit Button in phone order tab");
    }

    public void clickCancelOrderBtn(){
        elementClick (cancelOrderBtn,"Tapped Cancel Order Button in phone order tab");
    }

    public void clickPrintBtn(){
        elementClick (printBtn,"Tapped print Button in phone order tab");
    }

    public String verifyPhoneOrderTab(){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        return elementGetText(convertWebElement(driverStatusTabTitle),"Phone order Tab is displayed - ");
    }

    public void clickActiveDriver(String xpath) throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        Thread.sleep(1000);
        WebElement serach_driver1 = driver.findElement(By.xpath("//linga-icon[@symbol='searchIcon']"));
        serach_driver1.click();
        WebElement serach_driver = driver.findElement(By.xpath("//input[@placeholder='Search driver by name']"));
        serach_driver.clear();
        serach_driver.sendKeys(xpath);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        WebElement Auto = driver.findElement(By.xpath("//ion-row[contains(@class,'driverBtn')]//button[contains(.,'"+xpath+"')]"));
        elementClick(Auto,"Tapped Active Diver as - "+xpath);
    }
    public void verifyDriverAdded(String xpath){
        try{
            WebElement Auto=mergeAndFindElement(xpath,"",TestUtils.Accessibility);
            if (Auto.isDisplayed()) {
                utils.log().info("Driver xpath is - "+ xpath);
            }}
        catch (Exception e){
        }

    }


    public void verifyPopup(){
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        // WebElement el2 = mergeAndFindElement("Driver is offline   Still Do you want to continue","",TestUtils.Accessibility
        // );
        WebElement el2 = driver.findElement(By.xpath("//p[.='Driver is offline. Still do you want to continue?']"));
        if(el2.isDisplayed()){
            utils.log().info("Driver Offline Popup is Displayed");
        }else {
            utils.log().info("Driver Offline Popup is not  Displayed");
        }
    }

    public void tapNoButton(){
        elementClick(noBtn,"Tapped No Button in the Driver offline popup");
    }

    public void tapYesButton(){
        elementClick(YesBtn,"Tapped No Button in the Driver offline popup");
    }

    public void clickDepartureBtn(){
        elementClick(departureBtn,"Tapped Departure Button");
    }

    public void clickOutTab() throws InterruptedException {
        //  driver.manage().timeouts().implicitlyWait(3,TimeUnit.SECONDS);
        Thread.sleep(900);
        elementClick(outTabBtn,"Tapped Out Tab Button");
    }

    public void clickArrivalTab(){
        elementClick(arrivalBtn,"Tapped Out Tab Button");
    }

    public String verifyCashWindow(){
        return elementGetText(cashBtn,"Tapped cash button");
    }

    public String getWarningMsg(){
        return elementGetText(deliveryOrderCannot,"Warning Message - ");
    }

    public String verifyPaymentMadePopup(){
        return elementGetText(paymentMadeOnThisCheckPopup,"Void Popup is Displayed - ");
    }

    public void clickFutureTab(){
        elementClick(futureTab,"Tapped Future Tab");
    }

    public void clickNewTab(){
        elementClick(newTabBtn,"Tapped New Tab");
    }

    public void clickNewTab1(){
        elementClick(newTabBtn1,"Tapped New Tab");
    }

    public void selectCloseCheckInFutureTab() throws InterruptedException {
        Thread.sleep(500);
        String globalCheckNumber = TestUtils.globalCheckNumber;
        searchTabInFutureTab.clear();
        searchTabInFutureTab.sendKeys(globalCheckNumber);
        //  WebElement phoneOrders = mergeAndFindElement(globalCheckNumber,"",TestUtils.Accessibility);
        // elementClick(phoneOrders,"Tapped Closed Check - "+ globalCheckNumber);
//        try {
//            WebElement phoneOrders = (WebElement) driver.findElement(By.xpath()("(//XCUIElementTypeStaticText[@xpath=\"" + globalCheckNumber + "\"])[2]");
//
//            //   (//XCUIElementTypeStaticText[@xpath="Auto Ragav"])[1]
//
//            if (phoneOrders.isDisplayed()) {
//                //elementClick(phoneOrders,"Tapped Closed Check in closed tab - "+ globalCheckNumber);
//                utils.log().info("Closed Check be duplicate" + globalCheckNumber);
//            }
//        } catch (Exception h) {
        WebElement phoneOrders1 = (WebElement) driver.findElement(By.xpath("//XCUIElementTypeStaticText[@xpath=\"" + globalCheckNumber + "\"]"));

        if (phoneOrders1.isDisplayed()) {
            elementClick(phoneOrders1, "Tapped Closed Check in Future tab - " + globalCheckNumber);
        }else{
            utils.log().info("Not see closed check "+globalCheckNumber);
        }

        // }
    }

    public void selectCloseCheckInOutTab() throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(3,TimeUnit.SECONDS);
        Thread.sleep(800);
        String globalCheckNumber = TestUtils.globalCheckNumber;
//        searchTabInOutTab.clear();
//        searchTabInOutTab.sendKeys(globalCheckNumber);
        //  WebElement phoneOrders = mergeAndFindElement(globalCheckNumber,"",TestUtils.Accessibility
        //  );
        // elementClick(phoneOrders,"Tapped Closed Check in out tab - "+ globalCheckNumber);
//        try {
//            WebElement phoneOrders = (WebElement) driver.findElement(By.xpath()("(//XCUIElementTypeStaticText[@xpath=\"" + globalCheckNumber + "\"])[2]");
//
//            //   (//XCUIElementTypeStaticText[@xpath="Auto Ragav"])[1]
//
//            if (phoneOrders.isDisplayed()) {
//                //elementClick(phoneOrders,"Tapped Closed Check in closed tab - "+ globalCheckNumber);
//                utils.log().info("Closed Check be duplicate" + globalCheckNumber);
//            }
//        } catch (Exception h) {
        WebElement phoneOrders1 = (WebElement) driver.findElement(By.xpath("//div[@class='cdk-virtual-scroll-content-wrapper']//div//div//tr//td[.='"+globalCheckNumber+"']"));

        if (phoneOrders1.isDisplayed()) {
            elementClick(phoneOrders1, "Tapped Closed Check in Out tab - " + globalCheckNumber);
        }else {
//            utils.log().info("closed check is not available"+ globalCheckNumber);
        }
//        }
    }

    public void selectCloseCheckInNewTab() throws InterruptedException {
        Thread.sleep(2000);
        String globalCheckNumber=TestUtils.globalCheckNumber;
//        searchTabNewTab.click();
//        searchTabNewTab.clear();
//        searchTabNewTab.sendKeys(globalCheckNumber);
        // WebElement phoneOrders =  mergeAndFindElement(globalCheckNumber,"",TestUtils.Accessibility
        // );
        //elementClick(phoneOrders,"Tapped Closed Check in New Tab - "+ globalCheckNumber);
//      //  try {
//            WebElement phoneOrders = (WebElement) driver.findElement(By.xpath()("(//XCUIElementTypeStaticText[@xpath=\"" + globalCheckNumber + "\"])[2]");
//
//            //   (//XCUIElementTypeStaticText[@xpath="Auto Ragav"])[1]
//
//            if (phoneOrders.isDisplayed()) {
//                //elementClick(phoneOrders,"Tapped Closed Check in closed tab - "+ globalCheckNumber);
//                utils.log().info("New Tab Check be duplicate" + globalCheckNumber);
//            }
        //  } catch (Exception h) {
        WebElement phoneOrders1 = (WebElement) driver.findElement(By.xpath("//div[@class='cdk-virtual-scroll-content-wrapper']//div//div//tr//td[.='"+globalCheckNumber+"']"));

        if (phoneOrders1.isDisplayed()) {
            elementClick(phoneOrders1, "Tapped Closed Check in New tab - " + globalCheckNumber);
        }else{
//            utils.log().info("closed check is not available"+ globalCheckNumber);
        }
        //elementClick(phoneOrders,"Tapped Closed Check in closed tab - "+ globalCheckNumber);
        // }

    }

//    public void selectClosedCheckFromClosedTab() throws InterruptedException {
//        Thread.sleep(1200);
//        String globalCheckNumber=TestUtils.globalCheckNumber;
//        searchTabClosedTab.sendKeys(globalCheckNumber);
//        WebElement phoneOrders =  mergeAndFindElement(globalCheckNumber,"",TestUtils.Accessibility);
//        elementClick(phoneOrders,"Tapped Closed Check in closed tab - "+ globalCheckNumber);
//    }

    public void selectClosedCheckFromClosedTab1() throws InterruptedException {
        //   driver.manage().timeouts().implicitlyWait(2,TimeUnit.SECONDS);
        Thread.sleep(1000);
        String globalCheckNumber = TestUtils.globalCheckNumber;
        searchTabClosedTab.clear();
        searchTabClosedTab.sendKeys(globalCheckNumber);
        //  WebElement phoneOrders =  mergeAndFindElement(globalCheckNumber,"",TestUtils.Accessibility);
//        try {
//            WebElement phoneOrders = (WebElement) driver.findElement(By.xpath()("(//XCUIElementTypeStaticText[@xpath=\"" + globalCheckNumber + "\"])[2]");
//
//            //   (//XCUIElementTypeStaticText[@xpath="Auto Ragav"])[1]
//
//            if (phoneOrders.isDisplayed()) {
//                //elementClick(phoneOrders,"Tapped Closed Check in closed tab - "+ globalCheckNumber);
//                utils.log().info("Closed Check be duplicate" + globalCheckNumber);
//            }
//        } catch (Exception h) {
        WebElement phoneOrders1 = (WebElement) driver.findElements(By.xpath(globalCheckNumber));

        if (phoneOrders1.isDisplayed()) {
            elementClick(phoneOrders1, "Tapped Closed Check in closed tab - " + globalCheckNumber);
        }else{
            utils.log().info("closed check is not available"+ globalCheckNumber);
        }
        //elementClick(phoneOrders,"Tapped Closed Check in closed tab - "+ globalCheckNumber);
        //   }

    }

    public void selectActiveCheckFromClosedTab11() throws InterruptedException {
        Thread.sleep(500);
        String globalCheckNumber=TestUtils.globalCheckNumber;
        searchTabInActiveTab.clear();
        searchTabInActiveTab.sendKeys(globalCheckNumber);

        List<WebElement> phoneOrders1 = driver.findElements(By.xpath("//div[(@class='cdk-virtual-scroll-content-wrapper')]//div"));
        utils.log().info(phoneOrders1.size());
        if(phoneOrders1.size() == 1)
        {
            elementClick("//div[(@class='cdk-virtual-scroll-content-wrapper')]//div[1]", "Tapped Closed Check in closed tab - " + globalCheckNumber);
        }else{
            utils.log().info("closed check is not available - "+ globalCheckNumber);
            int w = 1/0;
            elementClick("//div[(@class='cdk-virtual-scroll-content-wrapper')]//div[1]", "Tapped Closed Check in closed tab - " + globalCheckNumber);
        }

    }

    public void selectClosedCheckFromClosedTab11() throws InterruptedException {
        //   driver.manage().timeouts().implicitlyWait(2,TimeUnit.SECONDS);
        Thread.sleep(5000);
        String globalCheckNumber = TestUtils.globalCheckNumber1;
        searchTabClosedTab.clear();
        searchTabClosedTab.sendKeys(globalCheckNumber);

        List<WebElement> phoneOrders1 = driver.findElements(By.xpath("//div[(@class='cdk-virtual-scroll-content-wrapper')]//div"));
        utils.log().info(phoneOrders1.size());
        if(phoneOrders1.size() == 1)
        {
            elementClick("//div[(@class='cdk-virtual-scroll-content-wrapper')]//div[1]", "Tapped Closed Check in closed tab - " + globalCheckNumber);
        }else{
            utils.log().info("closed check is not available - "+ globalCheckNumber);
            int w = 1/0;
            elementClick("//div[(@class='cdk-virtual-scroll-content-wrapper')]//div[1]", "Tapped Closed Check in closed tab - " + globalCheckNumber);
        }
    }
    public void clickActiveDriverAfterassigned(String xpath) throws InterruptedException {
        Thread.sleep(2000);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        WebElement Auto = driver.findElement(By.xpath("//ion-row[contains(@class,'driverBtn')]//button[contains(.,'"+xpath+"')]"));
        elementClick(Auto,"Tapped Active Diver as - "+xpath);
    }
    public void selectClosedCheckFromClosedTab() throws InterruptedException {
        //   driver.manage().timeouts().implicitlyWait(2,TimeUnit.SECONDS);
        Thread.sleep(5000);
        String globalCheckNumber = TestUtils.globalCheckNumber;
        searchTabClosedTab.clear();
        searchTabClosedTab.sendKeys(globalCheckNumber);

            List<WebElement> phoneOrders1 = driver.findElements(By.xpath("//div[(@class='cdk-virtual-scroll-content-wrapper')]//div"));
            utils.log().info(phoneOrders1.size());
            if(phoneOrders1.size() == 1)
            {
            elementClick("//div[(@class='cdk-virtual-scroll-content-wrapper')]//div[1]", "Tapped Closed Check in closed tab - " + globalCheckNumber);
        }else{
            utils.log().info("closed check is not available - "+ globalCheckNumber);
            int w = 1/0;
                elementClick("//div[(@class='cdk-virtual-scroll-content-wrapper')]//div[1]", "Tapped Closed Check in closed tab - " + globalCheckNumber);
            }
    }
    public void selectClosedCheckFromActiveTab() throws InterruptedException {
        Thread.sleep(500);
        String globalCheckNumber=TestUtils.globalCheckNumber;
        searchTabInActiveTab.clear();
        searchTabInActiveTab.sendKeys(globalCheckNumber);

        List<WebElement> phoneOrders1 = driver.findElements(By.xpath("//div[(@class='cdk-virtual-scroll-content-wrapper')]//div"));
        utils.log().info(phoneOrders1.size());
        if(phoneOrders1.size() == 1)
        {
            elementClick("//div[(@class='cdk-virtual-scroll-content-wrapper')]//div[1]", "Tapped Closed Check in closed tab - " + globalCheckNumber);
        }else{
            utils.log().info("closed check is not available - "+ globalCheckNumber);
            int w = 1/0;
            elementClick("//div[(@class='cdk-virtual-scroll-content-wrapper')]//div[1]", "Tapped Closed Check in closed tab - " + globalCheckNumber);
        }

    }

    public void selectCloseCheckInCompleteTab() throws InterruptedException {
        Thread.sleep(500);
        String globalCheckNumber=TestUtils.globalCheckNumber;
        searchTabInCompleteTab.clear();
        searchTabInCompleteTab.sendKeys(globalCheckNumber);
        // WebElement phoneOrders =  mergeAndFindElement(globalCheckNumber,"",TestUtils.Accessibility);
        //elementClick(phoneOrders,"Tapped Closed Check in complete Tab - "+ globalCheckNumber);

//        try {
//            WebElement phoneOrders = (WebElement) driver.findElement(By.xpath()("(//XCUIElementTypeStaticText[@xpath=\"" + globalCheckNumber + "\"])[2]");
//
//            //   (//XCUIElementTypeStaticText[@xpath="Auto Ragav"])[1]
//
//            if (phoneOrders.isDisplayed()) {
//                //elementClick(phoneOrders,"Tapped Closed Check in closed tab - "+ globalCheckNumber);
//                utils.log().info("Active Check be duplicate" + globalCheckNumber);
//            }
//        } catch (Exception h) {
        WebElement phoneOrders1 = (WebElement) driver.findElement(By.xpath("//XCUIElementTypeStaticText[@xpath=\"" + globalCheckNumber + "\"]"));

        if (phoneOrders1.isDisplayed()) {
            elementClick(phoneOrders1, "Tapped Closed Check in Complete tab - " + globalCheckNumber);
        }else{
            utils.log().info("closed check is not available"+ globalCheckNumber);
        }
        //elementClick(phoneOrders,"Tapped Closed Check in closed tab - "+ globalCheckNumber);
        //  }
    }


    public void verifyClosedCheckInCompleteTab() throws InterruptedException {
        Thread.sleep(500);
        String globalCheckNumber=TestUtils.globalCheckNumber;
        driver.findElement(By.xpath("//ion-content//ion-row[2]//button[contains(@class,'phone_grid_web')]//span[contains(.,'Name')]")).click();
        driver.findElement(By.xpath("//button[contains(@class,'matSerach-filter')]//span[contains(.,'Check#')]")).click();
//        searchTabInCompleteTab.clear();
//        searchTabInCompleteTab.sendKeys(globalCheckNumber);
        Thread.sleep(2000);
        WebElement e =  driver.findElement(By.xpath("//div[@class='cdk-virtual-scroll-content-wrapper']//div//div//tr//td[.='"+globalCheckNumber+"']"));
        Thread.sleep(2000);
        if(e.isDisplayed()) {
            elementClick(e, "Selected - ");
        }
        else{
            ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);",e);
            elementClick(e, "Selected - " );
        }
//        WebElement phoneOrders = driver.findElement(By.xpath("//div[@class='cdk-virtual-scroll-content-wrapper']//div//div//tr//td[.='"+globalCheckNumber+"']"));
//        if (phoneOrders.isDisplayed()){
////            utils.log().info(globalCheckNumber + " - Closed Check is displayed in complete tab");
//        }else {
////            utils.log().info("Closed check is not displayed");
//        }
    }

    public void verifyClosedCheckInNewTab() throws InterruptedException {
        Thread.sleep(500);
        String globalCheckNumber=TestUtils.globalCheckNumber;
        searchTabNewTab.clear();
        searchTabNewTab.sendKeys(globalCheckNumber);
        WebElement phoneOrders =  mergeAndFindElement(globalCheckNumber,"",TestUtils.Accessibility);
        if (phoneOrders.isDisplayed()){
            utils.log().info(globalCheckNumber + " - Closed Check is displayed in new tab");
        }else {
            utils.log().info("Closed check is not displayed");
        }
    }

    public void verifyClosedCheckInOutTab() throws InterruptedException {
        Thread.sleep(500);
        String globalCheckNumber=TestUtils.globalCheckNumber;
        searchTabInOutTab.clear();
        searchTabInOutTab.sendKeys(globalCheckNumber);
        WebElement phoneOrders =  mergeAndFindElement(globalCheckNumber,"",TestUtils.Accessibility);
        if (phoneOrders.isDisplayed()){
            utils.log().info(globalCheckNumber + " - Closed Check is displayed in out tab");
        }else {
            utils.log().info("Closed check is not displayed");
        }
    }

    public void verifyClosedCheckInFutureTab() throws InterruptedException {
        Thread.sleep(500);
        String globalCheckNumber=TestUtils.globalCheckNumber;
        searchTabInFutureTab.clear();
        searchTabInFutureTab.sendKeys(globalCheckNumber);
        WebElement phoneOrders = mergeAndFindElement(globalCheckNumber,"",TestUtils.Accessibility);
        if (phoneOrders.isDisplayed()){
            utils.log().info(globalCheckNumber + " - Closed Check is displayed in future tab");
        }else {
            utils.log().info("Closed check is not displayed");
        }
    }

    public void verifyClosedCheckInActiveCheckTab() throws InterruptedException {
        Thread.sleep(500);
        String globalCheckNumber=TestUtils.globalCheckNumber;
        searchTabInActiveTab.clear();
        searchTabInActiveTab.sendKeys(globalCheckNumber);
        WebElement phoneOrders =  mergeAndFindElement(globalCheckNumber,"",TestUtils.Accessibility);
        if (phoneOrders.isDisplayed()){
            utils.log().info(globalCheckNumber + " - Closed Check is displayed in Active tab");
        }else {
            utils.log().info("Closed check is not displayed");
        }
    }

    public void verifyClosedCheckInClosedCheckTab() throws InterruptedException {
        Thread.sleep(500);
        String globalCheckNumber=TestUtils.globalCheckNumber;
        searchTabClosedTab.clear();
        searchTabClosedTab.sendKeys(globalCheckNumber);
        WebElement phoneOrders = mergeAndFindElement(globalCheckNumber,"",TestUtils.Accessibility);
        if (phoneOrders.isDisplayed()){
            elementClick(phoneOrders,"Tapped Closed Checks");
            utils.log().info(globalCheckNumber + " - Closed Check is displayed in closed tab");
        }else {
            utils.log().info("Closed check is not displayed");
        }
    }

    public void verifyPaidCheckIsVisibleOrNot() throws InterruptedException {
        Thread.sleep(500);
        String globalCheckNumber=TestUtils.globalCheckNumber;
        searchTabInOutTab.clear();
        searchTabInOutTab.sendKeys(globalCheckNumber);
        WebElement phoneOrders =  mergeAndFindElement(globalCheckNumber,"",TestUtils.Accessibility);
        if (phoneOrders.isDisplayed()){
            utils.log().info(globalCheckNumber + " - Closed Check is displayed in closed tab");
        }else {
            utils.log().info("Closed check is not displayed");
        }

    }

    //    Added Today
public void shouldSeeClosedCheckInBArTab() throws InterruptedException {
    Thread.sleep(1500);
    String globalCheckNumber=TestUtils.globalCheckNumber;
    searchTabInBarTab.clear();
    searchTabInBarTab.sendKeys(globalCheckNumber);
    Thread.sleep(3000);
    WebElement phoneOrders =  mergeAndFindMobileElement("//div[@class='bartab-row-col seated']");
    if (phoneOrders.isDisplayed()) {
        utils.log().info("Displayed - "+phoneOrders.getText());
    }else{
        utils.log().info("NOT Displayed - "+phoneOrders.getText());
    }
//    elementClick(phoneOrders,"Tapped Closed Check in closed tab - "+ globalCheckNumber);
    Thread.sleep(1000);
}
    public void pressClosedCheckInBarTab() throws InterruptedException {
        Thread.sleep(1500);
        String globalCheckNumber=TestUtils.globalCheckNumber;
        searchTabInBarTab.clear();
        searchTabInBarTab.sendKeys(globalCheckNumber);
        Thread.sleep(3000);
        WebElement phoneOrders =  mergeAndFindMobileElement("//div[@class='bartab-row-col seated']");
        elementClick(phoneOrders,"Tapped Closed Check in closed tab - "+ globalCheckNumber);
        Thread.sleep(2000);
    }
    public void pressClosedCheckInBarTab1() throws InterruptedException {
        Thread.sleep(1500);
        String globalCheckNumber=TestUtils.globalCheckNumber1;
        searchTabInBarTab.clear();
        searchTabInBarTab.sendKeys(globalCheckNumber);
        Thread.sleep(3000);
        WebElement phoneOrders =  mergeAndFindMobileElement("//div[@class='bartab-row-col seated']");
        elementClick(phoneOrders,"Tapped Closed Check in closed tab - "+ globalCheckNumber);
        Thread.sleep(2000);
    }

    public void clickYesBtn() throws InterruptedException {
        Thread.sleep(2000);
        driver.findElement(By.xpath("//button[.=' Yes ']")).click();
        utils.log().info("YEs Selected");
    }

    public void clickClearText() throws InterruptedException {
        Thread.sleep(100);
        elementClick(clearTextBtn,"Tapped Clear Text");
    }

    public void clickMergedBar() throws InterruptedException {
        Thread.sleep(1500);
        String globalCheckNumber=TestUtils.globalCheckNumber;
        searchTabInBarTab1.clear();
        searchTabInBarTab1.sendKeys(globalCheckNumber);
        Thread.sleep(2500);//XCUIElementTypeApplication[@xpath="Linga POS"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[3]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeCollectionView[2]/XCUIElementTypeCell/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[1]
        WebElement phoneOrders =  mergeAndFindMobileElement("//div[@class='bartab-row-col seated']");
        elementClick(phoneOrders,"Tapped Closed Check in closed tab - "+ globalCheckNumber);
    }
}
