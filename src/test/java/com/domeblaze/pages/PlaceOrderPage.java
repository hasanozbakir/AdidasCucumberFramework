package com.domeblaze.pages;

import com.github.javafaker.Faker;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PlaceOrderPage extends BasePage{

    @FindBy(id = "name")
    public WebElement name;

    @FindBy(id = "country")
    public WebElement country;

    @FindBy(id = "city")
    public WebElement city;

    @FindBy(id = "card")
    public WebElement creditCard;

    @FindBy(id = "month")
    public WebElement month;

    @FindBy(id = "year")
    public WebElement year;

    @FindBy(xpath = "//button[.='Purchase']")
    public WebElement purchase;


    public void fillForm(){
        Faker faker = new Faker();
        name.sendKeys(faker.name().fullName());
        country.sendKeys(faker.country().name());
        city.sendKeys(faker.country().capital());
        creditCard.sendKeys(faker.finance().creditCard());
        month.sendKeys(""+faker.number().numberBetween(1,12));
        year.sendKeys(String.valueOf(faker.number().numberBetween(2022,2030)));
        purchase.click();
    }
    @FindBy(xpath = "//p[@class='lead text-muted ']")
    public WebElement orderDetails;


}
