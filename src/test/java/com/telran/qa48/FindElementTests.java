package com.telran.qa48;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class FindElementTests {

    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.get("https://icarro-v1.netlify.app/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void findElementByTagName(){

        System.out.println("Test name: findElementByTagName");
        WebElement element = driver.findElement(By.tagName("h1"));
        System.out.println("tagName h1 is: " + element.getText());

        List<WebElement> list = driver.findElements(By.tagName("a"));
        System.out.println(list.size());
    }

    @Test
    public void findElementBySimpleLocators(){
       // System.out.println("Test name: findElementBySimpleLocators");
        driver.findElement(By.id("root"));
       // if (driver.findElement(By.id("root")).isDisplayed()) {
        //    System.out.println("id was found");}
        driver.findElement(By.className("mobile-header"));
       // if (driver.findElement(By.className("mobile-header")).isDisplayed()) {
      //      System.out.println("class was found");}
    //by link Text
        driver.findElement(By.linkText("Let car work"));
    // by partiallink
        driver.findElement(By.partialLinkText("car"));
    }

    @Test
    public void findElementsByCssSelectorTest(){
        // tagName == css
        //driver.findElement(By.tagName("h1"));
        driver.findElement(By.cssSelector("h1"));

        //id->Css (#)
       // driver.findElement(By.id("root"));
        driver.findElement(By.cssSelector("#root"));

        // class name -> css (.)
        //driver.findElement(By.className("mobile-header"));
        driver.findElement(By.cssSelector(".mobile-header"));

        // [attr = 'value']
        driver.findElement(By.cssSelector("[href='/login']"));
        //contains->*
        driver.findElement(By.cssSelector("[href*='/let']"));
        //start->^
        driver.findElement(By.cssSelector(("[href^='/le']")));
        //end on -> $
        driver.findElement(By.cssSelector(("[href$='work']")));
        //tag + id
        driver.findElement(By.cssSelector("div#root"));
        // tag + class
        driver.findElement(By.cssSelector("div.search-card"));
        driver.findElement(By.cssSelector("div.mobile-header"));
    }

    @Test
    public void findElementByXpath() {
        // tagName -> xpath - //tag
        //driver.findElement(By.tagName("h1"));
        driver.findElement(By.xpath("//h1"));

        //id -> xpath - //*[@id='value']
        // driver.findElement(By.id("root"));
        driver.findElement(By.xpath("//div[@id='root']"));

        // class name -> xpath - //*[#class='value']
        //driver.findElement(By.className("mobile-header"));
        driver.findElement(By.xpath("//div[@class='mobile-header']"));
        //contains->//*[contains(.,'Text')]
        driver.findElement(By.xpath("//h2[contains(.,'Yalla')]"));
        //equal-> //*[text()='Text']
        driver.findElement(By.xpath("//h2[text()='Type your data and hit Yalla!']"));
        driver.findElement(By.xpath("//h2[.='Type your data and hit Yalla!']"));
        //start -> //*[starts-with(@attr,'Text')]
        driver.findElement(By.xpath("//label[starts-with(@for,'c')]"));

        //move up
        driver.findElement(By.xpath("//a[@class='navigation-link']/.."));

        // parent
        driver.findElement(By.xpath("//h1/parent::*"));
        driver.findElement(By.xpath("//h1/parent::div"));
        driver.findElement(By.xpath("//h1/.."));
        // ancestor
        driver.findElement(By.xpath("//h1/ancestor::*")); //all
        driver.findElement(By.xpath("//h1/ancestor::div")); //two options
        driver.findElement(By.xpath("//h1/ancestor::div[2]")); //same level
        //following-sibling
        driver.findElement(By.xpath("//h1/following-sibling::form"));
        // preceding-sibling
        driver.findElement(By.xpath("//h2/preceding-sibling::*"));








    }
}
