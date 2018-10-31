package base;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.CHROME;
import static com.codeborne.selenide.WebDriverRunner.url;

public class DemixCycle {
   public static SelenideElement bigSectionClick(int sectionClick){
       return $(".navigationMain li:nth-of-type("+ sectionClick +")");
   }
   public static SelenideElement tableColumn(int manWomanChild, int column, int line){
       return $(By.xpath("//div[@id='containerMainMenu']/div[1]/div[3]/div["+ manWomanChild +"]/div["+ column +"]/ul/li["+ line +"]"));
       //return $(".header .header__desktop__menu:nth-of-type(3) div:nth-of-type("+ manWomanChild +") [class='col-4']:nth-of-type("+ column +") ul li:nth-of-type("+ line +")");
   }     //(".header .header__desktop__menu:nth-of-type(3) div:nth-of-type(" + elementNumberTag +") [class='col-4']:nth-of-type(" + elementNumberCol +") ul li:nth-of-type(" + elementNumberPoint +")");

    @Test
    public void demixMainMenuTest(){
       Configuration.browser = CHROME;
       Configuration.headless = true;
       open("https://www.demix-sport.com/");
       String linkName;
       for (int sectionStep = 1, gender = 1; bigSectionClick(sectionStep).exists() & (!bigSectionClick(sectionStep).has(Condition.text("Виды спорта"))); sectionStep++, gender++){
           bigSectionClick(sectionStep).click();
           for (int col = 1, lin = 1; tableColumn(gender, col, lin).exists(); col++){
               for (; tableColumn(gender, col, lin).exists(); lin++){
                   linkName = tableColumn(gender, col, lin).getText();
                   tableColumn(gender, col, lin).findElementByLinkText(linkName).click();
                   System.out.println(linkName + ": " + url());
                   //open("https://www.demix-sport.com/");
                   bigSectionClick(sectionStep).click();
               }
           }
       }
   }
}
