package base;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.CHROME;
import static com.codeborne.selenide.WebDriverRunner.FIREFOX;

public class BaseTest_stable {
    @BeforeAll
    public static void start(){
        Configuration.browser = CHROME;
        //Configuration.browser = FIREFOX;
        //Configuration.browser = OPERA;
        //Configuration.browser = SAFARI;
        //Configuration.headless = true;
        Configuration.timeout = 100000;
    }
    @BeforeEach
    public void openMainPage(){
            open("https://stable.carfix.ru/");
        }
    @AfterEach
    public void closeWebDriver(){
        WebDriverRunner.closeWebDriver();
        repeat_firefox();
    }
    //@RepeatedTest(1)
    public void repeat_firefox(){
        Configuration.browser = FIREFOX;
        Configuration.headless = true;
        Configuration.timeout = 100000;
    }
    /*
    @RepeatedTest(value = 1, name = "opera")
    public void repeatTestOPERA(){
        Configuration.browser = OPERA;
        Configuration.headless = false;
        Configuration.timeout = 10000;
    }
    */
}
