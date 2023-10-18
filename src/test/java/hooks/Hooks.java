package hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utilities.Driver;

public class Hooks {

    /*
         Hooks : Her bir Scenario ya da Scenario Outline dan once ya da sonra calismasini istedigimiz methodlar bulunur.
         @Before ve @After methodlarini icerir

     */

    @Before
    public void setup(){
        System.out.println("Before çalıştı");
    }

    @After
    public void tearDown(Scenario scenario){

        System.out.println("After çalıştı");

        final byte[] failedScreenshot=((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);

        // Eger bir Scenario FAIL ederse, ekran goruntusunu al ve rapora ekle
        if (scenario.isFailed()) {
            //             ekran goruntusu      file tipi              ekran goruntusunun adi
            scenario.attach(failedScreenshot, "image/png", "failed_screenshot"+scenario.getName());

           // Driver.closeDriver(); ==? Burasi tarayici kapatir

        }
    }
}