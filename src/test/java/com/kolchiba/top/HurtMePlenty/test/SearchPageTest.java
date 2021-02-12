package com.kolchiba.top.HurtMePlenty.test;


import com.kolchiba.top.HurtMePlenty.page.FindNewPage;
import org.testng.annotations.Test;

public class SearchPageTest extends CommonConditions {


    @Test
    public void searchResultPage() {
        FindNewPage searchPage = new FindNewPage(driver);
        searchPage.openPage();
        searchPage.clickButton();
        searchPage.inputInSearchBox("Google Cloud Platform Pricing Calculator");
        searchPage.loadSearchPage();
        searchPage.clickLink();
        searchPage.activateComputeEngine();
        searchPage.inputNumberOfInstances("4");
        searchPage.selectInstanceTypeOfOperationalSystem();
        searchPage.selectVMClassType();
        searchPage.selectSeriesTypeOfMemory();
        searchPage.selectOneStandardInstanceTypeOfMemory();
        searchPage.selectAddGpus();
        searchPage.selectValueNumberOfGpus();
        searchPage.selectTypeOfGpus();
        searchPage.selectLocalSsd();
        searchPage.selectDataCenterLocation();
        searchPage.selectCommittedUsage();
        searchPage.clickButtonAddToEstimate();
        FindNewPage.checkFields();
    }

}