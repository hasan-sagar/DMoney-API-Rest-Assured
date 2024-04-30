package config;

import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;

public class Utils {
    //set environment variables in config properties
    public static void setEnvVar(String key, String value) throws ConfigurationException {
        PropertiesConfiguration config = new PropertiesConfiguration("./src/test/resources/config.properties");
        config.setProperty(key, value);
        config.save();
    }

    //generate random number
    public static int generateRandomNumber(int min, int max) {
        double randomId = Math.random() * (max - min) + min;
        return (int) randomId;
    }

    public static void main(String[] args) {
        int randomNumber = generateRandomNumber(1000, 9999);
        System.out.println(randomNumber);
    }

}