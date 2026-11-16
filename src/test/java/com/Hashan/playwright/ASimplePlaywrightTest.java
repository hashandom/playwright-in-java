package com.Hashan.playwright;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.junit.UsePlaywright;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

@UsePlaywright 
public class ASimplePlaywrightTest {
    

   

    @Test
    void shouldShowThePageTitle(Page page) {
        page.navigate("https://practicesoftwaretesting.com/");
        String title = page.title();
        System.out.println("this is page title: " + title);
        Assertions.assertEquals("Practice Software Testing - Toolshop - v5.0", title);
    }

    @Test 
    void shouldSearchByKeyword(Page page) {
        page.navigate("https://practicesoftwaretesting.com/");
        page.locator("#search-query").fill("Pliers");
        page.locator("//button[@type='submit']").click();
        int matchingCount = page.locator(".card").count();
        Assertions.assertTrue(matchingCount > 0);
        System.out.println("Number of matching products: " + matchingCount);
    }

    
}
