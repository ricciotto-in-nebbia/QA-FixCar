package base;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.WebDriverRunner.CHROME;
import static com.codeborne.selenide.WebDriverRunner.FIREFOX;
import static com.codeborne.selenide.Selenide.open;

//import DMX.tests.BaseTest;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.url;

public class testTESTtest {
    /*ты можешь запустить тест на проде демикса!!! ссылку я заменила в коде, у меня работает
    Нам нужно протестировать меню. Если на каждый пункт меню прописывать действие и проверку, то это будет огроменный кусок кода.
    Плюс к этому пункты меню могут измениться, или добавиться и тд. И тоггда тест придется переписывать.
    Поэтому мы пишем ЦИКЛ.
    Идем на сайт и исследуем в режиме разработчика как именно формируется меню и за что можно зацепиться.
            Выясняем, что у меню есть основные пункты меню (мужчинам, женщинам и тд)
    в этих пунктах меню есть колонки (виды спорта, одежда и тд)
    В колонках есть пункты меню (майки футболки..и тд)
    в коде мы видим, что есть некий css такого вида .header .header__desktop__menu:nth-of-type(3) div:nth-of-type(3) [class='col-4']:nth-of-type(3) li
    меняя цифры в скобках мы получаем нужный элемент в меню.
    пункт в меню номер (3) (это ДЕТЯМ) в открытом меню детям колонка номер(3)(это колонка ДРУГОЕ) [class='col-4'] пункт в колонке(1) это пункт аксессуары
    прописываем названия для этих пунктов. Смотри строку 17. В ней мы создаем селенидэлемент

    и называем его menuTagElement (это верхний самый пункт, например женщинам) в скобках пишем что у этого
    элемента может быть число, то самое которое будет отвечать за поряждковый номер этого менб, мужчинам это 1, женщинам 2 и тд
    таким же образом прописываем название элемента КОлонка, смотри стрроку 21, в скобках мы пишем что колонку мы высчитываем по номеру менютэг и собственно самой колонки
    тоже самое делаем для пунктов меню, называем их  menuPointElement и задаем место где его искать, то есть номер менютэг, колонка, и сам номер пункта
    элементы созданы, можно начинать писать сам цикл

    общее описание : у нас цикл внутри цикла получился
    строка 37: Пока существует менютэг и он не является текстом сейл (потому что сейл это не выпадающее меню, там проверка не пройдет)
    мы кликаем на этот менютэг (это общий цикл, он написан) То есть пока робот будет видеть что пункты меню существуют он будет на них кликать один за одним)
    далее внутри этого цикла мы пишем еще один , строка 40
    пока существует колонка робот будет ее находить (это второй цикл, он написан)
    внутри этого цикла пишем третий цикл, последний. Начинаем со строки 42
    пока существует поинтэлемент , робот будет его находить, далее он будет брать текст из этого пункта и запоминать его!! это написано в строке 43
    далее он будет на него кликать, будет осущкествляться переход на страничку , ну например футболки, и уже на этой страничке робот будет сравнивать текст который он взял в 43 строке и сравнивать его
    с тем что он видит на банере , на той странице куда он перешел.
    Смысл в том, что если он нажал на пункт меню ФУТБОЛКИ, то на странице с товарами куда он перейдет должен быть банер с надписью ФУТБОЛКИ,
    мы так проверяем что переход осуществился и он верный и соответствует тому пункту меню откуда мы пришли.
            lineNumber++; эта строка означает что к поинтнамберу последовательно прибавляется по единичке, это позволяет пройти все пункты меню
    соответственно такие строки есть для каждого цикла
    в принципе все, когда робот прогонит все вариантвы, независимо от их количества, то он закончит тест, у него условия перестанут выполняться.
            готово.
    пыталась написать понятно, но возможно что ты ничего не поймешь)))*/
    //public class MenuTest extends BaseTest {

    @BeforeEach
    public void openMainPage(){
        Configuration.browser = CHROME;
        open ("https://www.demix-sport.com/ ");
    }

    public static SelenideElement menuTagElement(int elementNumber){
        return  $(".navigationMain li:nth-of-type(" + elementNumber + ")");
    }

    public static SelenideElement menuColumnElement(int elementNumberTag, int elementNumberCol){
        return  $(".header div:nth-of-type(" + elementNumberTag +") > [class='col-4']:nth-of-type(" + elementNumberCol + ")");
    }

    public static SelenideElement menuPointElement(int elementNumberTag, int elementNumberCol, int elementNumberPoint){
        return  $(".header .header__desktop__menu:nth-of-type(3) div:nth-of-type(" + elementNumberTag +") [class='col-4']:nth-of-type(" + elementNumberCol +") ul li:nth-of-type(" + elementNumberPoint +")");
    }

    @Test
    public void menuLinkTest(){
        String pointName;
        $(".headerCol1 .logo").shouldBe(Condition.visible);
        int elementNumber1 = 1;
        int columnNumber;
        int lineNumber;
        
        while (menuTagElement(elementNumber1).exists() & (!menuTagElement(elementNumber1).has(text("SALE")))){
            menuTagElement(elementNumber1).click();
            columnNumber = 1;

            while (menuColumnElement(elementNumber1, columnNumber).exists()){
                lineNumber = 1;

                while (menuPointElement(elementNumber1,columnNumber,lineNumber).exists()){

                    pointName = menuPointElement(elementNumber1,columnNumber,lineNumber).getText();
                    menuPointElement(elementNumber1,columnNumber,lineNumber)
                            .findElementByLinkText(pointName)
                            .click();
                    $(".page__title__banner__text").shouldHave(text(pointName));
                    menuTagElement(elementNumber1).click();
                    System.out.println(pointName +" " +url());
                    lineNumber++;
                }
                columnNumber++;
            }
            elementNumber1++;
        }
    }
   // public void findTEXT(){
   //     open("carfix.ru");
   //     $(".man .title").shouldHave(text("Ремонта автомобиля прозрачно"));
   // }
}

    //Configuration.browser = System.getProperty("selenide.browser", "chrome");

/*
// by index
switchTo().window(1);

// by name or title or handle
switchTo().window("Title of the window");

// for switching to default window
switchTo().defaultContent();
 */