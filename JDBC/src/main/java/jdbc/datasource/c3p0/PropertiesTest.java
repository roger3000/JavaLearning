package jdbc.datasource.c3p0;

import java.net.URL;

public class PropertiesTest {
    public static void main(String[] args) {
        ClassLoader classLoader = PropertiesTest.class.getClassLoader();
        URL resource = classLoader.getResource("jdbc.properties");
    }
}
