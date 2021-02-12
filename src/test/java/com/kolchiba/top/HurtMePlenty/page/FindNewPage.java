package com.kolchiba.top.HurtMePlenty.page;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static java.util.concurrent.TimeUnit.SECONDS;


public class FindNewPage extends AbstractPage {


    private final String BASE_URL = "https://cloud.google.com";
    private final static Logger logger = LogManager.getRootLogger();


    // Нажать кнопку поиска по порталу вверху страницы
    @FindBy(xpath = "//input[@class='devsite-search-field devsite-search-query']")
    private WebElement buttonSearch;
    // Ввести в поле поиска текст "Google Cloud Platform Pricing Calculator"
    @FindBy(xpath = "//input[@class='devsite-search-field devsite-search-query' and @type='text']")
    private WebElement searchField;
    //В результатах поиска кликнуть "Google Cloud Platform Pricing Calculator" и перейти на страницу калькулятора.
    private final By loadSearchLocator = By.xpath("//div[@class = 'gsc-thumbnail-inside' and div[@class = 'gs-title' and contains(., 'Pricing Calculator')]]");
    //Активировать раздел COMPUTE ENGINE вверху страницы
    @FindBy(xpath = "//div[@class='tab-holder compute' and @title='Compute Engine']")
    private WebElement computeEngineActivate;
    // Input Number of instances: 4
    @FindBy(xpath = "//input[@id='input_63']")
    private WebElement numberOfInstans;

    @FindBy(xpath = "//md-select-value[@id='select_value_label_56']/span[2]")
    private WebElement dropdownInstanceType;

    // VM Class: Regular
    @FindBy(xpath = "//md-select-value[@id='select_value_label_57']/span[2]")
    private WebElement vmClassType;
    // Instance type: n1-standard-8    (vCPUs: 8, RAM: 30 GB)
    @FindBy(xpath = "//md-select-value[@id='select_value_label_59']/span[2]")
    private WebElement seriesOfTypeOfMemory;

    @FindBy(xpath = "//md-select-value[@id='select_value_label_60']/span/div[1]")
    private WebElement oneInstanceTypeOfMemory;
    // * Выбрать Add GPUs
    @FindBy(xpath = "//*[@id='mainForm']/div[2]/div/md-card/md-card-content/div/div[1]/form/div[8]/div[1]/md-input-container/md-checkbox/div[2]")
    private WebElement addGpus;
    //         * Number of GPUs: 1
    @FindBy(xpath = "//md-select[@id='select_394']")
    private WebElement numberOfGpus;
    //        * GPU type: NVIDIA Tesla V100
    @FindBy(xpath = "//md-select[@id='select_396']")
    private WebElement typeOfGpus;
    //    * Local SSD: 2x375 Gb
    @FindBy(xpath = "//md-select-value[@id='select_value_label_354']")
    private WebElement localSsd;
    //      * Datacenter location: Frankfurt (europe-west3)
    @FindBy(xpath = "//*[@id='select_value_label_61']")
    private WebElement locationDatacenter;
    //    * Commited usage: 1 Year
    @FindBy(xpath = "//md-select-value[@id='select_value_label_62']")
    private WebElement usageCommited;
    //7. Нажать Add to Estimate
    @FindBy(xpath = "//button[@class='md-raised md-primary cpc-button md-button md-ink-ripple']")
    private WebElement addEstimate;
    //    Check
    @FindBy(xpath = "(//div[@class='md-list-item-text ng-binding'])[2]")
    private static WebElement tableVMClass;

    @FindBy(xpath = "(//div[@class='md-list-item-text ng-binding'])[3]")
    private static WebElement tableInstanceType;

    @FindBy(xpath = "(//div[@class='md-list-item-text ng-binding'])[4]")
    private static WebElement tableRegion;

    @FindBy(xpath = "(//div[@class='md-list-item-text ng-binding'])[5]")
    private static WebElement tableLocalSsd;

    @FindBy(xpath = "(//div[@class='md-list-item-text ng-binding'])[6]")
    private static WebElement tableCommitmentTerm;
    @FindBy(xpath = "//h2[@class='md-title']/b[@class='ng-binding']")
    private static WebElement tableTotalEstimateCost;

    @FindBy(xpath = "")
    private static WebElement switchOnIframe;

    public FindNewPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    @Override
    public FindNewPage openPage() {
        driver.navigate().to(BASE_URL);
        logger.info("Page opened");
        return this;
    }


    public void clickButton() {
        buttonSearch.click();
    }

    public void inputInSearchBox(String message) {
        searchField.sendKeys(message);
        searchField.submit();
        logger.info("Page loaded");

    }


    public void loadSearchPage() {
        WebElement loadPage = new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.presenceOfElementLocated(loadSearchLocator));
        loadPage.isDisplayed();

    }

    public void clickLink() {
        driver.findElement(By.xpath("(//div[contains(@class, 'gs-title')])[1]/a")).click();
    }


    public void activateComputeEngine() {
        driver.manage().timeouts().pageLoadTimeout(10, SECONDS);
        driver.switchTo().frame(0);
        driver.switchTo().frame(driver.findElement(By.xpath("//div[@class='cp-header']//iframe")));
        computeEngineActivate.click();
        logger.info("Compute engine activated");
    }

    public void inputNumberOfInstances(String number) {
        numberOfInstans.sendKeys(number);
    }

    public void selectInstanceTypeOfOperationalSystem() {
        dropdownInstanceType.click();
        driver.manage().timeouts().pageLoadTimeout(3, SECONDS);
        driver.findElement(By.xpath("//md-option[@id='select_option_65']")).click();
    }

    public void selectVMClassType() {
        vmClassType.click();
        driver.manage().timeouts().pageLoadTimeout(5, SECONDS);
        driver.findElement(By.xpath("//md-option[@id='select_option_78']")).click();

    }

    public void selectSeriesTypeOfMemory() {
        seriesOfTypeOfMemory.click();
        driver.manage().timeouts().pageLoadTimeout(5, SECONDS);

        driver.findElement(By.xpath("//*[@id='select_option_188']/div[1]")).click();

    }

    public void selectOneStandardInstanceTypeOfMemory() {
        oneInstanceTypeOfMemory.click();
        driver.manage().timeouts().pageLoadTimeout(5, SECONDS);
        driver.findElement(By.xpath("//*[@id='select_option_360']/div[1]")).click();
    }

    public void selectAddGpus() {
        addGpus.click();
    }

    public void selectValueNumberOfGpus() {
        numberOfGpus.click();
        driver.manage().timeouts().pageLoadTimeout(5, SECONDS);
        driver.findElement(By.xpath("//md-option[@id='select_option_399']/div")).click();
    }

    public void selectTypeOfGpus() {
        typeOfGpus.click();
        driver.manage().timeouts().pageLoadTimeout(5, SECONDS);
        driver.findElement(By.xpath("//md-option[@id='select_option_406']/div")).click();
    }

    public void selectLocalSsd() {
        localSsd.click();
        driver.manage().timeouts().pageLoadTimeout(5, SECONDS);
        driver.findElement(By.xpath("//md-option[@id='select_option_381']/div")).click();
    }

    public void selectDataCenterLocation() {
        locationDatacenter.click();
        driver.manage().timeouts().pageLoadTimeout(5, SECONDS);
        driver.findElement(By.xpath("//md-option[@id='select_option_205']/div")).click();

    }

    public void selectCommittedUsage() {
        usageCommited.click();
        driver.manage().timeouts().pageLoadTimeout(5, SECONDS);
        driver.findElement(By.xpath("//md-option[@id='select_option_97']/div")).click();

    }

    public void clickButtonAddToEstimate() {
        addEstimate.click();

    }

    public static void checkFields() {
        String classVM = "VM class: regular";
        String instanceType = "Instance type: n1-standard-8";
        String region = "Region: Frankfurt";
        String localSSD = "Total available local SSD space 2x375 GiB";
        String commitmentTerm = "Commitment term: 1 Year";
        String totalEstimatedCost = "Total Estimated Cost: USD 1,082.77 per 1 month";

        conformity(classVM, tableVMClass.getText());
        conformity(instanceType, tableInstanceType.getText());
        conformity(region, tableRegion.getText());
        conformity(localSSD, tableLocalSsd.getText());
        conformity(commitmentTerm, tableCommitmentTerm.getText());
        conformity(totalEstimatedCost, tableTotalEstimateCost.getText());

    }

    public static void conformity(String s1, String s2) {
        Boolean retValue = s1.equals(s2);
        logger.info("Data the same: " + retValue + "-->" + s1 + " <------> " + s2);
    }


}

