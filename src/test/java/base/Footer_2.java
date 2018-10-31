package base;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;

import java.net.URL;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.CHROME;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static com.codeborne.selenide.WebDriverRunner.url;

public class Footer_2 {
    public static SelenideElement footerMenuTable(int tableNumber){
        return $("[itemtype] .column:nth-of-type(" + tableNumber + ") .links-list:nth-of-type(1) ul li:nth-of-type(1)");
    }
    public static SelenideElement footerMenuColumn(int tableNumber, int columnNumber){
        return $("[itemtype] .column:nth-of-type(" + tableNumber +") .links-list:nth-of-type("+ columnNumber +") ul li:nth-of-type(1)");
    }
    public static SelenideElement footerMenuLine(int tableNumber, int columnNumber, int lineNumber){
        return $("[itemtype] .column:nth-of-type(" + tableNumber + ") .links-list:nth-of-type("+ columnNumber +") ul li:nth-of-type(" + lineNumber + ")");
    }

    @Test
    public void footerTest(){
        Configuration.browser = CHROME;
        Configuration.headless = false;
        open("https://carfix.ru/");
        String linkName;
        for (int tableNumber = 3; footerMenuTable(tableNumber).exists(); tableNumber++) {
            for (int columnNumber = 1; footerMenuColumn(tableNumber, columnNumber).exists(); columnNumber++) {
                for (int lineNumber = 1; footerMenuLine(tableNumber, columnNumber, lineNumber).exists() & (!footerMenuLine(tableNumber, columnNumber, lineNumber).has(Condition.text("Блог"))); lineNumber++) {
                    linkName = footerMenuLine(tableNumber, columnNumber, lineNumber).getText();
                    footerMenuLine(tableNumber, columnNumber, lineNumber).findElementByLinkText(linkName).click();
                    System.out.println(linkName + " " + url());
                    //sleep(2000);
                    //$(".breadcrumb li:nth-of-type(2)").shouldHave(Condition.text(linkName));
                    open("https://carfix.ru/");
                }
            }
        }
    }
}

