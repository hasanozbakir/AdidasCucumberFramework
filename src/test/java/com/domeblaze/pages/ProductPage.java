package com.domeblaze.pages;

import com.domeblaze.utilities.BrowserUtils;
import com.domeblaze.utilities.Driver;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductPage extends BasePage {

    @FindBy(xpath = "//a[.='Add to cart']")
    public WebElement addToCartElement;

    @FindBy(xpath = "//button[.='Place Order']")
    public WebElement placeOrder;

    @FindBy(id = "totalp")
    public WebElement totalPrice;

    public void navigateTo(String product, String category){
        Driver.get().findElement(By.linkText(category)).click();
        Driver.get().findElement(By.linkText(product)).click();
    }

    public void addToCart(){
        addToCartElement.click();
        WebDriverWait wait = new WebDriverWait(Driver.get(),10);
        wait.until(ExpectedConditions.alertIsPresent());

        Alert alert = Driver.get().switchTo().alert();
        alert.accept();
    }

    public void deleteProduct(String product){
        String locator = "//tbody//td[contains(.,'"+product+"')]/../td[4]/a";
        Driver.get().findElement(By.xpath(locator)).click();
        BrowserUtils.waitFor(2);

    }
}
