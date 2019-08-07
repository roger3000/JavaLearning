package day18;

import jdk.nashorn.internal.runtime.regexp.RegExp;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.net.URL;

public class JSoupDemo01 {
    @Test
    public void JSoup(){
        ClassLoader classLoader = JSoupDemo01.class.getClassLoader();
        String path = classLoader.getResource("student.xml").getPath();

        try {
//            Document parse = Jsoup.parse(new File(path), "utf-8");
            URL url = new URL("http://www.bilibili.com");
            Document dom = Jsoup.parse(url, 10000);
            System.out.println(dom);
            Elements elementsMatchingText = dom.getElementsMatchingText("^title\\S[\"](.*)[\"]><(.*)\"");
            System.out.println(elementsMatchingText);
//            Elements name = parse.getElementsByTag("name");
//            System.out.println(name.text());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void Document(){
        ClassLoader classLoader = JSoupDemo01.class.getClassLoader();

        try {
            Document parse = Jsoup.parse(new File(classLoader.getResource("student.xml").getPath()), "utf-8");
            Elements student = parse.getElementsByTag("student");
//            System.out.println(student);
            for (Element element : student) {
                System.out.println(element.getElementsByTag("name"));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
