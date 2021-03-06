package com.ncube.test.testng.tests.hotline_tests;

import com.ncube.test.pages.hotline_pages.AppleIPhone7Page;
import com.ncube.test.pages.hotline_pages.HotlinePage;
import com.ncube.test.webtestsbase.BaseTest;
import org.testng.annotations.Test;

import static org.junit.Assert.assertTrue;


public class HotlineTest extends BaseTest {

    @Test
    public void searchTheCheapestIphone7Test() {
        HotlinePage hotlinePage = new HotlinePage();
        AppleIPhone7Page iPhone7Page;

        hotlinePage.fillInSearchBox("iPhone");
        iPhone7Page = hotlinePage.chooseAppleIPhone7FromList("Apple iPhone 7");

        iPhone7Page.goToAllOffersTab()
                    .getAllOffers()
                    .filterInvisibleElements()
                    .filterOffersWithReviewsNotLessThen(11)
                    .filterOffersWithWarrantyMonthsNotLessThen(6)
                    .chooseTheCheapestElement();

        iPhone7Page.switchTab(1);

        assertTrue("The page's URL address should contains \"mrfix.com.ua\"",
                iPhone7Page.getCurrentURL().contains("mrfix.com.ua"));

    }
}
