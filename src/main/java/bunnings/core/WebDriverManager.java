package bunnings.core;

import bunnings.configuration.Configuration;
import bunnings.configuration.WebDriverConfig;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Locale;

/**
 * Created by mrinalirao on 18/03/17.
 *
 * The WebDriverManager class internally calls the
 * WebDriverConfig class to fetch the browser profiles.
 */
public class WebDriverManager {
    public enum Browser {
        CHROME, FIREFOX
    }

    public static WebDriver getWebDriverConfig(Configuration conf) {


        WebDriver webDriver = null;
        Browser browser = Browser.valueOf(conf.getConfig("browser").toUpperCase(Locale.ENGLISH));
        switch (browser) {
            case CHROME: {
                webDriver = new ChromeDriver(WebDriverConfig.getChromeConfig(conf));
                break;
            }
            case FIREFOX: {
            }
            default:
                return null;
        }
        return webDriver;
    }
}


