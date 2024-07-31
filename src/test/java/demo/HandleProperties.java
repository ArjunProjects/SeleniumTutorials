package demo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class HandleProperties {

    public static void main(String[] args) throws IOException {

        Properties p = new Properties();
        FileInputStream fis = new FileInputStream(".//src//test//java//config//sample.properties");

        p.load(fis);
        System.out.println("first name is "+p.getProperty("fname"));
        System.out.println("first name is "+p.getProperty("lname"));
        System.out.println("first name is "+p.getProperty("location"));
        System.out.println("first name is "+p.getProperty("experience"));
    }
}
