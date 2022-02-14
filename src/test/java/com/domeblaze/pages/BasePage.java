package com.domeblaze.pages;

import com.domeblaze.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public abstract class BasePage {

    public BasePage(){
        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy(xpath = "//a[contains(.,'Home')]")
    public WebElement hpme;

    @FindBy(xpath = "//a[.='Cart']")
    public WebElement cart;
}
