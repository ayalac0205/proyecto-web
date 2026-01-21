
package retoautomatizacion.Demo.Stepdefinitions;

import net.serenitybdd.annotations.Managed;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import io.cucumber.java.Before;
import io.cucumber.java.After;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.File;

public class Hooks {

    private WebDriver driver;

    private static final String DRIVER_PATH = "C:\\drivers\\chromedriver\\chromedriver.exe"; // <-- cambia aquí

    @Before
    public void prepararEscenario() {
        OnStage.setTheStage(new OnlineCast());

        File exe = new File(DRIVER_PATH);
        if (!exe.exists()) {
            throw new IllegalStateException("No se encontró chromedriver en: " + DRIVER_PATH);
        }
        // Forzar Selenium a usar SOLO este binario (evita Selenium Manager)
        System.setProperty("webdriver.chrome.driver", exe.getAbsolutePath());
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--start-maximized");
        // options.addArguments("--headless=new"); // si lo necesitas
        ChromeDriverService service = new ChromeDriverService.Builder()
                .usingDriverExecutable(exe)
                .usingAnyFreePort()
                .build();
        driver = new ChromeDriver(service, options);
        OnStage.theActorCalled("Brandon").can(BrowseTheWeb.with(driver));
    }

//        @Managed(driver = "chrome") // Serenity se encarga del driver (Selenium Manager)
//        WebDriver driver;
//
//        @Before
//        public void prepararEscenario() {
//            OnStage.setTheStage(new OnlineCast());
//            OnStage.theActorCalled("Brandon").can(BrowseTheWeb.with(driver));
//        }

        @After
        public void cerrar() {
            if (driver != null) {
                try { driver.quit(); } catch (Exception ignored) {}
            }
        }
    }


