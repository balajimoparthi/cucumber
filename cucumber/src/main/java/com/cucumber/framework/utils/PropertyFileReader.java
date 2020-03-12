package com.cucumber.framework.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertyFileReader {
	
	private static PropertyFileReader instance;
	private static final Object lock = new Object();
	private static String propertyFilePath = System.getProperty("user.dir")+
            "\\src\\Config\\config.properties";
	
	private static String url;
    private static String userName;
    private static String passWord;
 
    //Create a Singleton instance. We need only one instance of Property Manager.
    public static PropertyFileReader getInstance () {
        if (instance == null) {
          		synchronized(lock) {
                instance = new PropertyFileReader();
                instance.loadData();
            }
        }
        return instance;
    }
 
    //Get all configuration data and assign to related fields.
    private void loadData() {
        //Declare a properties object
        Properties prop = new Properties();
 
        //Read configuration.properties file
        try {
            prop.load(new FileInputStream(propertyFilePath));
            //prop.load(this.getClass().getClassLoader().getResourceAsStream("configuration.properties"));
        } catch (IOException e) {
            System.out.println("Configuration properties file cannot be found");
        }
 
        //Get properties from configuration.properties
        url = prop.getProperty("url");
        userName = prop.getProperty("username");
        passWord = prop.getProperty("password");
    }
 
    public String getURL () {
      return url;
    }
 
    public String getUsername () {
        return userName;
    }
 
    public String getPassword () {
        return passWord;
    }
}
