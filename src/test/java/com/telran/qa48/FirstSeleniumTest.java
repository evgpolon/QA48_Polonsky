package com.telran.qa48;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;



public class FirstSeleniumTest {

    WebDriver driver;

 //   before - setUp


    @BeforeMethod
    public void setup() {
        driver = new ChromeDriver();
       // driver.get("https://www.tel-ran.com/");
        driver.manage().window().maximize();
        //window().maximize(); - вписывает окно в экран
        driver.navigate().to("https://www.tel-ran.com/");
        //driver.get - without history
        //driver.navigate - with history
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        // driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15)) - ожидание пока загрузятся все элементы на странице


        driver.navigate().to("https://bstore.bezeq.co.il/");
        driver.navigate().back(); //back возвращает на предыдущий метод
        driver.navigate().forward(); //forward передвигает на один метод вперед после предыдущего
        driver.navigate().refresh();

    }

 //    tests

    @Test
    public void openGoogleTest(){
        System.out.println("TELRAN opened");
    }

 //    after - tearDown

@AfterMethod
//enabled = true по дефолту
    public void tearDown() {
       // driver.quit(); - закрывает все вкладки
    driver.close(); // закрывает текущую вкладку
}


}
