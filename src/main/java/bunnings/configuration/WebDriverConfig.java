package bunnings.configuration;

import org.openqa.selenium.remote.DesiredCapabilities;

/**
 * Created by mrinalirao on 17/03/17.
 */
public class WebDriverConfig {

    public static DesiredCapabilities getChromeConfig(Configuration conf){

        DesiredCapabilities desiredCapabilities = DesiredCapabilities.chrome();
        desiredCapabilities.setJavascriptEnabled(true);
        System.setProperty("webdriver.chrome.driver",conf.getConfig("chromeDriverPath"));
        return desiredCapabilities;

    }
}
