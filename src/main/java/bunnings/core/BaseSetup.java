package bunnings.core;

import bunnings.configuration.Configuration;
import org.openqa.selenium.WebDriver;

/**
 * Created by mrinalirao on 18/03/17.
 *
 * The BaseSetup class is main Setup class which has a static
 * block to initialize the Configuration and WebDriver instances.
 *
 * The Test classes extend this class and this class can contain
 * initializations for mappers, api-clients etc as well.
 *
 */
public class BaseSetup {
    protected static Configuration conf;
    protected static WebDriver webDriver;

    static{
        conf = new Configuration();
        webDriver = WebDriverManager.getWebDriverConfig(conf);

    }

}
