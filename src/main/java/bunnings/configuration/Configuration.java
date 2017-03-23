package bunnings.configuration;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.apache.log4j.BasicConfigurator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * Created by mrinalirao on 17/03/17.
 *
 * The job of the configuration class is to fetch all
 * config parameters specified in the configuration file
 *
 */
@Data
public class Configuration {

    private static Logger logger= LoggerFactory.getLogger(Configuration.class);
    private Properties properties = new Properties();
    private String env;

    public @Getter @Setter static String firstName;
    public @Getter @Setter static String lastName;
    public @Getter @Setter static String postCode;
    public @Getter @Setter static String email;
    public @Getter @Setter static String password;

    public Configuration(){
        BasicConfigurator.configure();
        if(System.getProperty("env")!=null){
            this.env = System.getProperty(env);
        }
        else
            this.env="stage"; //set default as stage
        logger.info("fetching the env details from:" + this.env);

    }

    public Configuration(String env){
        this.env = env;
    }



    public String getConfig(String property){
        String config = null;
        logger.info("the current working directory is:::" + System.getProperty("user,dir"));
        try{
            properties.load(new FileInputStream("src/main/java/bunnings/configuration/properties/env.properties"));
            config = properties.getProperty(env);
            properties.load(new FileInputStream(config));
            firstName=properties.getProperty("firstName");
            lastName=properties.getProperty("lastName");
            postCode=properties.getProperty("postCode");
            email=properties.getProperty("email");
            password=properties.getProperty("password");

        } catch(IOException e){
            e.printStackTrace();
        }
        return properties.getProperty(property);

    }


}
