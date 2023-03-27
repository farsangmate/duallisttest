package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DualListPage {

    WebDriver driver;

    public DualListPage(WebDriver driver)
    {
        this.driver = driver;
    }

    private final String url = "https://demo.seleniumeasy.com/bootstrap-dual-list-box-demo.html";

    public void navigate()
    {
        driver.navigate().to(url);
    }
    private final By searchBox1 = By.xpath("//div[@class='dual-list list-left col-md-5']//input");

    public void inputMessage(String message)
    {
        driver.findElement(searchBox1).sendKeys(message);
    }

    private final By selectButton1 = By.xpath("//div[@class='dual-list list-left col-md-5']//a");

    private final By addItem = By.xpath("//button[@class=\"btn btn-default btn-sm move-right\"]");

    private String rightListItem = "//div[@class='dual-list list-right col-md-5']//input/following::li[contains(text(), '%s')]";

    public void clickSelectBtn1()
    {
        driver.findElement(selectButton1).click();
    }

    public void clickAddItem()
    {
        driver.findElement(addItem).click();
    }

    public boolean findRightListItem(String word)
    {
        try
        {
            rightListItem = String.format(rightListItem, word);
            //rightListItem = rightListItem.replace("@@@@@", word);
            driver.findElement(By.xpath(rightListItem));
            return true;
        } catch (Exception e){
            return false;
        }
    }

}
