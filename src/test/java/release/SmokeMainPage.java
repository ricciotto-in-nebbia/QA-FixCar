package release;

import base.BaseTest;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import org.junit.Assert;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.url;

public class SmokeMainPage extends BaseTest {
    @Test
    @RepeatedTest(value = 1, name = "firefox")
    public void howItWork(){
        $("[itemtype='http\\:\\/\\/schema\\.org\\/WPHeader'] [itemscope] [href='\\/faq']").shouldBe(Condition.visible).click();
        Assert.assertEquals("https://carfix.ru/faq", url());
    }
    @Test
    @RepeatedTest(value = 1, name = "firefox")
    //@RepeatedTest(value = 2, name = "op")
    public void uslugi(){
        $("[itemtype='http\\:\\/\\/schema\\.org\\/WPHeader'] [href='\\/uslugi\\.category\\/1']").shouldBe(Condition.visible).click();
        Assert.assertEquals ("https://carfix.ru/uslugi", url());
    }
    @Test
    @RepeatedTest(value = 1, name = "firefox")
    public void marki(){
        $("[itemtype='http\\:\\/\\/schema\\.org\\/WPHeader'] [href='\\/marki']").shouldBe(Condition.visible).click();
        Assert.assertEquals("https://carfix.ru/marki", url());
    }
    @Test
    @RepeatedTest(value = 1, name = "firefox")
    public void partners(){
        $("[itemtype='http\\:\\/\\/schema\\.org\\/WPHeader'] .more").shouldBe(Condition.visible).click();
        $("[itemtype='http\\:\\/\\/schema\\.org\\/WPHeader'] .item:nth-of-type(2) .block").shouldBe(Condition.visible).click();
        Assert.assertEquals("https://carfix.ru/partners", url());
    }
    @Test
    @RepeatedTest(value = 1, name = "firefox")
    public void otzivi(){
        $("[itemtype='http\\:\\/\\/schema\\.org\\/WPHeader'] .more").shouldBe(Condition.visible).click();
        $("[itemtype='http\\:\\/\\/schema\\.org\\/WPHeader'] .item:nth-of-type(3) .block").shouldBe(Condition.visible).click();
        Assert.assertEquals("https://carfix.ru/reviews", url());
    }
    @Test
    @RepeatedTest(value = 1, name = "firefox")
    public void calculation(){
        $(".button-big").shouldBe(Condition.visible).click();
        Assert.assertEquals("https://carfix.ru/calc", url());
    }

    public static SelenideElement uslugi (int usluga_nomer){
        return $(".operations-menu-panel .menu-item:nth-of-type(" + usluga_nomer +") .category-block");
    }
    @Test
    @RepeatedTest(value = 1, name = "firefox")
    public void vibor_uslugi(){
        String nazvanie_uslugi;
        //for(int poryadkovii_nomer_uslugi = 1; poryadkovii_nomer_uslugi <= 16; poryadkovii_nomer_uslugi++){
        for(int poryadkovii_nomer_uslugi = 1; uslugi(poryadkovii_nomer_uslugi).exists() & (!uslugi(poryadkovii_nomer_uslugi).has(text("Нужна консультация"))); poryadkovii_nomer_uslugi++){
            nazvanie_uslugi = uslugi(poryadkovii_nomer_uslugi).getText();
            uslugi(poryadkovii_nomer_uslugi).click();
            $(".breadcrumb li:nth-of-type(2)").shouldHave(text(nazvanie_uslugi));
            open("https://carfix.ru/");
        }
    }

/* услуги вручную
    @Test
    @RepeatedTest(value = 1, name = "firefox")
    public void diagnostika(){
        $(".operations-menu-panel .menu-item:nth-of-type(1) .category-block").shouldBe(Condition.visible).click();
        Assert.assertEquals("https://carfix.ru/uslugi/diagnostika", url());
    }
    @Test
    @RepeatedTest(value = 1, name = "firefox")
    public void kuzovnie_raboti(){
        $(".operations-menu-panel .menu-item:nth-of-type(4) .category-block").shouldBe(Condition.visible).click();
        Assert.assertEquals("https://carfix.ru/uslugi/kuzovnye-raboty", url());
    }
    @Test
    @RepeatedTest(value = 1, name = "firefox")
    public void podveska(){
        $(".operations-menu-panel .menu-item:nth-of-type(7) .category-block").shouldBe(Condition.visible).click();
        Assert.assertEquals("https://carfix.ru/uslugi/podveska", url());
    }
    @Test
    @RepeatedTest(value = 1, name = "firefox")
    void stekla_fari(){
        $(".operations-menu-panel .menu-item:nth-of-type(10) .category-block").shouldBe(Condition.visible).click();
        Assert.assertEquals("https://carfix.ru/uslugi/stekla-fary", url());
    }
    @Test
    @RepeatedTest(value = 1, name = "firefox")
    public void tormoza(){
        $(".operations-menu-panel .menu-item:nth-of-type(13) .category-block").shouldBe(Condition.visible).click();
        Assert.assertEquals("https://carfix.ru/uslugi/tormoznaja-sistema", url());
    }
    @Test
    @RepeatedTest(value = 1, name = "firefox")
    public void elektrika(){
        $(".operations-menu-panel .menu-item:nth-of-type(16) .category-block").shouldBe(Condition.visible).click();
        Assert.assertEquals("https://carfix.ru/uslugi/elektrika-avto", url());
    }
    @Test
    @RepeatedTest(value = 1, name = "firefox")
    public void dop_oborudovanie(){
        $(".operations-menu-panel .menu-item:nth-of-type(2) .category-block").shouldBe(Condition.visible).click();
        Assert.assertEquals("https://carfix.ru/uslugi/dopolnitelnoe-oborudovanie", url());
    }
    @Test
    @RepeatedTest(value = 1, name = "firefox")
    public void maslo_jidkosti_filtri(){
        $(".operations-menu-panel .menu-item:nth-of-type(5) .category-block").shouldBe(Condition.visible).click();
        Assert.assertEquals("https://carfix.ru/uslugi/maslo-zhidkosti-filtry", url());
    }
    @Test
    @RepeatedTest(value = 1, name = "firefox")
    public void polirovka_uhod(){
        $(".operations-menu-panel .menu-item:nth-of-type(8) .category-block").shouldBe(Condition.visible).click();
        Assert.assertEquals("https://carfix.ru/uslugi/polirovka-uhod-za-avto", url());
    }
    @Test
    @RepeatedTest(value = 1, name = "firefox")
    public void teh_obslujivanie(){
        $(".operations-menu-panel .menu-item:nth-of-type(11) .category-block").shouldBe(Condition.visible).click();
        Assert.assertEquals("https://carfix.ru/uslugi/tehnicheskoe-obsluzhivanie", url());
    }
    @Test
    @RepeatedTest(value = 1, name = "firefox")
    public void transmissiya(){
        $(".operations-menu-panel .menu-item:nth-of-type(14) .category-block").shouldBe(Condition.visible).click();
        Assert.assertEquals("https://carfix.ru/uslugi/transmissija", url());
    }*/

    @Test
    @RepeatedTest(value = 1, name = "firefox")
    public void nujna_konsultaciya(){
        $(".hidden-mobile .category-block").shouldBe(Condition.visible).click();
        Assert.assertEquals("https://carfix.ru/consultation", url());
    }/*
    @Test
    @RepeatedTest(value = 1, name = "firefox")
    public void zaschitnaya_plenka(){
        $(".operations-menu-panel .menu-item:nth-of-type(3) .category-block").shouldBe(Condition.visible).click();
        Assert.assertEquals("https://carfix.ru/uslugi/zaschitnye-plenki-na-avto", url());
    }
    @Test
    @RepeatedTest(value = 1, name = "firefox")
    public void moika_himchistka(){
        $(".operations-menu-panel .menu-item:nth-of-type(6) .category-block").shouldBe(Condition.visible).click();
        Assert.assertEquals("https://carfix.ru/uslugi/mojka-himchistka", url());
    }
    @Test
    @RepeatedTest(value = 1, name = "firefox")
    public void slojnii_agregatnii_remont(){
        $(".operations-menu-panel .menu-item:nth-of-type(9) .category-block").shouldBe(Condition.visible).click();
        Assert.assertEquals("https://carfix.ru/uslugi/agregatnyj-remont", url());
    }
    @Test
    @RepeatedTest(value = 1, name = "firefox")
    public void tonirovka(){
        $(".operations-menu-panel .menu-item:nth-of-type(12) .category-block").shouldBe(Condition.visible).click();
        Assert.assertEquals("https://carfix.ru/uslugi/tonirovka-avto", url());
    }
    @Test
    @RepeatedTest(value = 1, name = "firefox")
    public void shinimontaj(){
        $(".operations-menu-panel .menu-item:nth-of-type(15) .category-block").shouldBe(Condition.visible).click();
        Assert.assertEquals("https://carfix.ru/uslugi/shinomontazh", url());
    }
    @Test
    @RepeatedTest(value = 1, name = "firefox")
    public void audi(){
        $(".brands-list [class='item-4 link']:nth-of-type(1)").shouldBe(Condition.visible).click();
        Assert.assertEquals("https://carfix.ru/marki/audi", url());
    }
    @Test
    @RepeatedTest(value = 1, name = "firefox")
    public void bmw(){
        $(".brands-list [class='item-4 link']:nth-of-type(2)").shouldBe(Condition.visible).click();
        Assert.assertEquals("https://carfix.ru/marki/bmw", url());
    }
    @Test
    @RepeatedTest(value = 1, name = "firefox")
    public void chevrolet(){
        $(".brands-list [class='item-4 link']:nth-of-type(3)").shouldBe(Condition.visible).click();
        Assert.assertEquals("https://carfix.ru/marki/chevrolet", url());
    }
    @Test//копировать отсюда
    @RepeatedTest(value = 1, name = "firefox")
    public void citroen() {
        $(".brands-list [class='item-4 link']:nth-of-type(4)").shouldBe(Condition.visible).click();
        Assert.assertEquals("https://carfix.ru/marki/citroen", url());
    }
    @Test
    @RepeatedTest(value = 1, name = "firefox")
    public void ford(){
        $(".brands-list [class='item-4 link']:nth-of-type(5)").shouldBe(Condition.visible).click();
        Assert.assertEquals("https://carfix.ru/marki/ford", url());
    }
    @Test
    @RepeatedTest(value = 1, name = "firefox")
    public void honda(){
        $(".brands-list [class='item-4 link']:nth-of-type(6)").shouldBe(Condition.visible).click();
        Assert.assertEquals("https://carfix.ru/marki/honda", url());
    }
    @Test
    @RepeatedTest(value = 1, name = "firefox")
    public void hyundai(){
        $(".brands-list [class='item-4 link']:nth-of-type(7)").shouldBe(Condition.visible).click();
        Assert.assertEquals("https://carfix.ru/marki/hyundai", url());
    }
    @Test
    @RepeatedTest(value = 1, name = "firefox")
    public void kia(){
        $(".brands-list [class='item-4 link']:nth-of-type(8)").shouldBe(Condition.visible).click();
        Assert.assertEquals("https://carfix.ru/marki/kia", url());
    }
    @Test
    @RepeatedTest(value = 1, name = "firefox")
    public void lada_vaz(){
        $(".brands-list [class='item-4 link']:nth-of-type(9)").shouldBe(Condition.visible).click();
        Assert.assertEquals("https://carfix.ru/marki/lada-vaz", url());
    }
    @Test
    @RepeatedTest(value = 1, name = "firefox")
    public void mazda(){
        $(".brands-list [class='item-4 link']:nth-of-type(10)").shouldBe(Condition.visible).click();
        Assert.assertEquals("https://carfix.ru/marki/mazda", url());
    }
    @Test
    @RepeatedTest(value = 1, name = "firefox")
    public void mercedes_benz(){
        $(".brands-list [class='item-4 link']:nth-of-type(11)").shouldBe(Condition.visible).click();
        Assert.assertEquals("https://carfix.ru/marki/mercedes-benz", url());
    }
    @Test
    @RepeatedTest(value = 1, name = "firefox")
    public void mitsubishi(){
        $(".brands-list [class='item-4 link']:nth-of-type(12)").shouldBe(Condition.visible).click();
        Assert.assertEquals("https://carfix.ru/marki/mitsubishi", url());
    }
    @Test
    @RepeatedTest(value = 1, name = "firefox")
    public void nissan(){
        $(".brands-list [class='item-4 link']:nth-of-type(13)").shouldBe(Condition.visible).click();
        Assert.assertEquals("https://carfix.ru/marki/nissan", url());
    }
    @Test
    @RepeatedTest(value = 1, name = "firefox")
    public void opel(){
        $(".brands-list [class='item-4 link']:nth-of-type(14)").shouldBe(Condition.visible).click();
        Assert.assertEquals("https://carfix.ru/marki/opel", url());
    }
    @Test
    @RepeatedTest(value = 1, name = "firefox")
    public void peugeot(){
        $(".brands-list [class='item-4 link']:nth-of-type(15)").shouldBe(Condition.visible).click();
        Assert.assertEquals("https://carfix.ru/marki/peugeot", url());
    }
    @Test
    @RepeatedTest(value = 1, name = "firefox")
    public void renault(){
        $(".brands-list [class='item-4 link']:nth-of-type(16)").shouldBe(Condition.visible).click();
        Assert.assertEquals("https://carfix.ru/marki/renault", url());
    }
    @Test
    @RepeatedTest(value = 1, name = "firefox")
    public void skoda(){
        $(".brands-list [class='item-4 link']:nth-of-type(17)").shouldBe(Condition.visible).click();
        Assert.assertEquals("https://carfix.ru/marki/skoda", url());
    }
    @Test
    @RepeatedTest(value = 1, name = "firefox")
    public void toyota(){
        $(".brands-list [class='item-4 link']:nth-of-type(18)").shouldBe(Condition.visible).click();
        Assert.assertEquals("https://carfix.ru/marki/toyota", url());
    }
    @Test
    @RepeatedTest(value = 1, name = "firefox")
    public void volkswagen(){
        $(".brands-list [class='item-4 link']:nth-of-type(19)").shouldBe(Condition.visible).click();
        Assert.assertEquals("https://carfix.ru/marki/volkswagen", url());
    }
    @Test
    @RepeatedTest(value = 1, name = "firefox")
    public void volvo() {
        $(".brands-list [class='item-4 link']:nth-of-type(20)").shouldBe(Condition.visible).click();
        Assert.assertEquals("https://carfix.ru/marki/volvo", url());
    }*/

    public static SelenideElement marki (int number){
        return $(".brands-list [class='item-4 link']:nth-of-type(" + number + ")");
    }
    @Test
    @RepeatedTest(value = 1, name = "firefox")
    public void marksCycle() {
        String name_marka;//это то, что мы копируем из меню (ссылки) для проверки
        for (int number1 = 1; marki(number1).exists(); number1++) {
            name_marka = marki(number1).getText();
            marki(number1).click();
            $(".hero-car-inner .title").shouldHave(text("Ремонт и обслуживание " + name_marka));
            open("https://carfix.ru/");
        }
    }

    @Test
    @RepeatedTest(value = 1, name = "firefox")
    public void all_marks(){
        $(".page-content .panel:nth-of-type(5) [type]").shouldBe(Condition.visible).click();
        Assert.assertEquals("https://carfix.ru/marki", url());
    }
    @Test
    @RepeatedTest(value = 1, name = "firefox")
    public void vse_otzivi(){
        $(".hidden-mobile [type]").shouldBe(Condition.visible).click();
        Assert.assertEquals("https://carfix.ru/reviews", url());
    }
    @Test
    @RepeatedTest(value = 1, name = "firefox")
    public void meduza(){
        $(".slider-wrapper .prev").shouldBe(Condition.visible).click();
        $(".medusa [rel] .lazy-sprite-loaded").shouldBe(Condition.visible).click();
        switchTo().window("Как выбрать автосервис? — Meduza");
        Assert.assertEquals("https://meduza.io/cards/kak-vybrat-avtoservis", url());
    }
    @Test
    @RepeatedTest(value = 1, name = "firefox")
    public void avtovzglyad(){
        $(".slider-wrapper .prev").shouldBe(Condition.visible).click();
        $(".avtovzglyad [rel] .lazy-sprite-loaded").shouldBe(Condition.visible).click();
        switchTo().window("CarFix: как через интернет получить гарантированную скидку на ремонт машины - Лайфхак - АвтоВзгляд");
        Assert.assertEquals("https://www.avtovzglyad.ru/sovety/ekspluataciya/2016-08-09-carfix-kak-cherez-internet-poluchit-garantirovannuju-skidku-na-remont-mashiny/", url());
    }
    @Test
    @RepeatedTest(value = 1, name = "firefox")
    public void aifru(){
        $(".slider-wrapper .prev").shouldBe(Condition.visible).click();
        $(".aifru [rel] .lazy-sprite-loaded").shouldBe(Condition.visible).click();
        switchTo().window("В Тулу с самоваром. Можно ли приезжать к официалам со своими запчастями? | Обслуживание | Авто | Аргументы и Факты");
        Assert.assertEquals("http://www.aif.ru/auto/support/v_tulu_s_samovarom_mozhno_li_priezzhat_k_oficialam_so_svoimi_zapchastyami", url());
    }
    @Test
    @RepeatedTest(value = 1, name = "firefox")
    public void kpru(){
        $(".slider-wrapper .prev").shouldBe(Condition.visible).click();
        $(".kpru [rel] .lazy-sprite-loaded").shouldBe(Condition.visible).click();
        switchTo().window("Экономим на авторемонте");
        Assert.assertEquals("https://www.kp.ru/daily/26583.5/3599203/", url());
    }
    @Test
    @RepeatedTest(value = 1, name = "firefox")
    public void rabota(){
        $(".slider-wrapper .next").shouldBe(Condition.visible).click();
        $(".rabota [rel] .lazy-sprite-loaded").shouldBe(Condition.visible).click();
        switchTo().window("Оскар Хартманн о жизни, бизнесе и игре на аккордеоне — Rabota.ru");
        Assert.assertEquals("https://www.rabota.ru/articles/career/oscarhartmann-110", url());
    }
    @Test
    @RepeatedTest(value = 1, name = "firefox")
    public void vedomosti(){
        $(".slider-wrapper .next").shouldBe(Condition.visible).click();
        $(".vedomosti [rel] .lazy-sprite-loaded").shouldBe(Condition.visible).click();
        switchTo().window("Новый автопроект Оскара Хартманна привлек инвестиции Mail.ru Group – ВЕДОМОСТИ");
        Assert.assertEquals("https://www.vedomosti.ru/technology/articles/2016/10/26/662395-avtoproekt-oskara-hartmanna", url());
    }
    @Test
    @RepeatedTest(value = 1, name = "firefox")
    public void vc(){
        $(".slider-wrapper .next").shouldBe(Condition.visible).click();
        $(".slider-wrapper .next").shouldBe(Condition.visible).click();
        $(".vc [rel] .lazy-sprite-loaded").shouldBe(Condition.visible).click();
        switchTo().window(1);
        $("[itemprop]").shouldHave(text("Сооснователь CarPrice Оскар Хартманн инвестировал 1 млн евро в сервис ремонта машин по фиксированной цене CarFix"));
    }
    @Test
    @RepeatedTest(value = 1, name = "firefox")
    public void sostav(){
        $(".slider-wrapper .next").shouldBe(Condition.visible).click();
        $(".slider-wrapper .next").shouldBe(Condition.visible).click();
        $(".slider-wrapper .next").shouldBe(Condition.visible).click();
        $(".sostav [rel] .lazy-sprite-loaded").shouldBe(Condition.visible).click();
        switchTo().window("Сооснователь KupiVIP займется авторемонтом");
        Assert.assertEquals("http://www.sostav.ru/publication/soosnovatel-kupivip-zajmetsya-avtoremontom-22963.html", url());
    }
    @Test
    @RepeatedTest(value = 1, name = "firefox")
    public void rambler(){
        $(".slider-wrapper .next").shouldBe(Condition.visible).click();
        $(".slider-wrapper .next").shouldBe(Condition.visible).click();
        $(".slider-wrapper .next").shouldBe(Condition.visible).click();
        $(".slider-wrapper .next").shouldBe(Condition.visible).click();
        $(".rambler .lazy-sprite-loaded").shouldBe(Condition.visible).click();
        switchTo().window("Оскар Хартман отремонтирует автомобили — Рамблер/авто");
        Assert.assertEquals("https://auto.rambler.ru/news/34105988-oskar-hartman-otremontiruet-avtomobili/", url());
    }
    @Test
    @RepeatedTest(value = 1, name = "firefox")
    public void roem(){
        $(".slider-wrapper .next").shouldBe(Condition.visible).click();
        $(".slider-wrapper .next").shouldBe(Condition.visible).click();
        $(".slider-wrapper .next").shouldBe(Condition.visible).click();
        $(".slider-wrapper .next").shouldBe(Condition.visible).click();
        $(".slider-wrapper .next").shouldBe(Condition.visible).click();
        $(".roem [rel] .lazy-sprite-loaded").shouldBe(Condition.visible).click();
        switchTo().window("Оскар Хартманн опять нашёл не умершую автомобильную нишу в онлайне — ремонт → Roem.ru");
        Assert.assertEquals("https://roem.ru/06-07-2016/228231/oskar-hartmann-carfix/", url());
    }
    @Test
    @RepeatedTest(value = 1, name = "firefox")
    public void firrma(){
        $(".slider-wrapper .next").shouldBe(Condition.visible).click();
        $(".slider-wrapper .next").shouldBe(Condition.visible).click();
        $(".slider-wrapper .next").shouldBe(Condition.visible).click();
        $(".slider-wrapper .next").shouldBe(Condition.visible).click();
        $(".slider-wrapper .next").shouldBe(Condition.visible).click();
        $(".slider-wrapper .next").shouldBe(Condition.visible).click();
        $(".firrma [rel] .lazy-sprite-loaded").shouldBe(Condition.visible).click();
        sleep(5000);
        switchTo().window(1);
        Assert.assertEquals("http://firrma.ru/data/news/8182/", url());
        //$(".text").shouldHave(text("ОСКАР ХАРТМАНН ВЛОЖИЛ 1 МЛН ЕВРО В СЕРВИС ПО РЕМОНТУ АВТОМОБИЛЕЙ CARFIX"));

    }
    @Test
    @RepeatedTest(value = 1, name = "firefox")
    public void secretmag(){
        $(".slider-wrapper .next").shouldBe(Condition.visible).click();
        $(".slider-wrapper .next").shouldBe(Condition.visible).click();
        $(".slider-wrapper .next").shouldBe(Condition.visible).click();
        $(".slider-wrapper .next").shouldBe(Condition.visible).click();
        $(".slider-wrapper .next").shouldBe(Condition.visible).click();
        $(".slider-wrapper .next").shouldBe(Condition.visible).click();
        $(".slider-wrapper .next").shouldBe(Condition.visible).click();
        $(".secretmag [rel] .lazy-sprite-loaded").shouldBe(Condition.visible).click();
        switchTo().window("CarFix привлёк $5 млн от Mail.Ru Group и других инвесторов");
        Assert.assertEquals("https://secretmag.ru/news/servis-carfix-privlyok-usd5-mln-ot-mail-ru-group-i-drugih-investorov-26-10-2016.htm", url());
    }
    @Test
    @RepeatedTest(value = 1, name = "firefox")
    public void avtorodina(){
        $(".slider-wrapper .next").shouldBe(Condition.visible).click();
        $(".slider-wrapper .next").shouldBe(Condition.visible).click();
        $(".slider-wrapper .next").shouldBe(Condition.visible).click();
        $(".slider-wrapper .next").shouldBe(Condition.visible).click();
        $(".slider-wrapper .next").shouldBe(Condition.visible).click();
        $(".slider-wrapper .next").shouldBe(Condition.visible).click();
        $(".slider-wrapper .next").shouldBe(Condition.visible).click();
        $(".slider-wrapper .next").shouldBe(Condition.visible).click();
        $(".avtorodina [rel] .lazy-sprite-loaded").shouldBe(Condition.visible).click();
        switchTo().window("Апперкот «гаражного мастера»");
        Assert.assertEquals("http://autorodina.ru/proverka/proverka-avtomobilnoy-texniki/apperkot-garazhnogo-mastera/.html", url());
    }
    @Test
    @RepeatedTest(value = 1, name = "firefox")
    public void kommersant(){
        $(".slider-wrapper .next").shouldBe(Condition.visible).click();
        $(".slider-wrapper .next").shouldBe(Condition.visible).click();
        $(".slider-wrapper .next").shouldBe(Condition.visible).click();
        $(".slider-wrapper .next").shouldBe(Condition.visible).click();
        $(".slider-wrapper .next").shouldBe(Condition.visible).click();
        $(".slider-wrapper .next").shouldBe(Condition.visible).click();
        $(".slider-wrapper .next").shouldBe(Condition.visible).click();
        $(".slider-wrapper .next").shouldBe(Condition.visible).click();
        $(".kommersant [rel] .lazy-sprite-loaded").shouldBe(Condition.visible).click();
        switchTo().window("Оскар Хартманн отремонтирует автомобили – Картина дня – Коммерсантъ");
        Assert.assertEquals("https://www.kommersant.ru/doc/3031087", url());
    }
    @Test
    @RepeatedTest(value = 1, name = "firefox")
    public void calc(){
        $("[data-async-trigger]").click();
        Assert.assertEquals("https://carfix.ru/calc", url());
    }
    @Test
    @RepeatedTest(value = 1, name = "firefox")
    public void konsultacia(){
        $(".request-btn").click();
        Assert.assertEquals("https://carfix.ru/consultation", url());
    }
    @Test
    @RepeatedTest(value = 1, name = "firefox")
    public void foot_howItWorks(){
        $("[itemtype='http\\:\\/\\/schema\\.org\\/LocalBusiness'] [href='\\/faq']").click();
        Assert.assertEquals("https://carfix.ru/faq", url());
    }
    @Test
    @RepeatedTest(value = 1, name = "firefox")
    public void foot_reviews(){
        $("[itemtype='http\\:\\/\\/schema\\.org\\/LocalBusiness'] [href='\\/reviews']").click();
        Assert.assertEquals("https://carfix.ru/reviews", url());
    }
    @Test
    @RepeatedTest(value = 1, name = "firefox")
    public void foot_blog(){
        $("[href='\\/blog']").click();
        Assert.assertEquals("https://carfix.ru/blog", url());
    }
    @Test
    @RepeatedTest(value = 1, name = "firefox")
    public void foot_marki(){
        $("[itemtype='http\\:\\/\\/schema\\.org\\/LocalBusiness'] [href='\\/marki']").click();
        Assert.assertEquals("https://carfix.ru/marki", url());
    }
    @Test
    @RepeatedTest(value = 1, name = "firefox")
    public void foot_avtoservisy(){
        $("[itemtype='http\\:\\/\\/schema\\.org\\/LocalBusiness'] [href='\\/avtoservisy']").click();
        Assert.assertEquals("https://carfix.ru/avtoservisy", url());
    }
    @Test
    @RepeatedTest(value = 1, name = "firefox")
    public void foot_oferta(){
        $("[href='\\/terms']").click();
        Assert.assertEquals("https://carfix.ru/terms", url());
    }
    @Test
    @RepeatedTest(value = 1, name = "firefox")
    public void foot_rekviziti(){
        $("[href='\\/about\\/identification']").click();
        Assert.assertEquals("https://carfix.ru/about/identification", url());
    }
    @Test
    @RepeatedTest(value = 1, name = "firefox")
    public void foot_kontakti(){
        $("[href='\\/contacts']").click();
        Assert.assertEquals("https://carfix.ru/contacts", url());
    }
    @Test
    @RepeatedTest(value = 1, name = "firefox")
    public void foot_partners(){
        $("[itemtype='http\\:\\/\\/schema\\.org\\/LocalBusiness'] [href='\\/partners']").click();
        Assert.assertEquals("https://carfix.ru/partners", url());
    }
}
