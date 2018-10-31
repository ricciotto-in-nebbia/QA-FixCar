package base;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.sleep;
import static com.codeborne.selenide.WebDriverRunner.CHROME;

public class Footer {
    public static SelenideElement footerMenuColumn(int columnNumber){
        return $("[itemtype] .column:nth-of-type(3) .links-list:nth-of-type("+ columnNumber +") ul li:nth-of-type(1)");
    }
   public static SelenideElement footerMenuLine(int columnNumber, int lineNumber){
        return $("[itemtype] .column:nth-of-type(3) .links-list:nth-of-type("+ columnNumber +") ul li:nth-of-type(" + lineNumber + ")");
    }

    @Test
    public void footerTest(){
        Configuration.browser = CHROME;
        Configuration.headless = false;
        open("https://carfix.ru/");
        String linkName;
        for (int columnNumber = 1; footerMenuColumn(columnNumber).exists(); columnNumber++){
            for (int lineNumber = 1; footerMenuLine(columnNumber, lineNumber).exists() & (!footerMenuLine(columnNumber, lineNumber).has(Condition.text("Услуги"))); lineNumber++){
                linkName = footerMenuLine(columnNumber, lineNumber).getText();
                footerMenuLine(columnNumber, lineNumber).findElementByLinkText(linkName).click();
                //sleep(2000);
                //$(".breadcrumb li:nth-of-type(2)").shouldHave(Condition.text(linkName));
                open("https://carfix.ru/");
            }

        }

    }
}