/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nu.te4.finalproject.beans;

import java.io.InputStream;
import java.util.Properties;
import javax.ejb.EJB;

/**
 *
 * @author Erik
 */
@EJB
public class PropertiesBean {

    public String getProp(String key) {
        try {
            ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
            InputStream is = classLoader.getResourceAsStream("config.properties");
            
            Properties properties = new Properties();
            properties.load(is);
            
            return properties.getProperty(key);
        } catch (Exception e) {
            return "No value set";
        }
        
    }

}
