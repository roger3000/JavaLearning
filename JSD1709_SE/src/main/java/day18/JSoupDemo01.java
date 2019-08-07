package day18;

import cn.wanghaomiao.xpath.exception.XpathSyntaxErrorException;
import cn.wanghaomiao.xpath.model.JXDocument;
import cn.wanghaomiao.xpath.model.JXNode;
import jdk.nashorn.internal.runtime.regexp.RegExp;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.regex.Pattern;

public class JSoupDemo01 {
    ClassLoader classLoader = JSoupDemo01.class.getClassLoader();
    String path = classLoader.getResource("student.xml").getPath();

    @Test
    public void JSoup(){

        try {
            Document parse = Jsoup.parse(new File(path), "utf-8");
//            URL url = new URL("http://www.bilibili.com");
//            Document dom = Jsoup.parse(url, 10000);
//            System.out.println(dom);
//            Elements elementsMatchingText = dom.getElementsMatchingText("<\\S");
//            System.out.println(elementsMatchingText);
            Elements name = parse.getElementsByTag("name");
            System.out.println(name.text());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void Document(){
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

    @Test
    public void selector(){
//        使用与css相同的选择器
        try {
            Document parse = Jsoup.parse(new File(path), "utf-8");
            Elements name = parse.select("name");
//            System.out.println(name);
            Elements student_age = parse.select("student[number=heima_0001] age");
            System.out.println(student_age);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void selectorTest(){
        Document document;
        try {
            document = Jsoup.parse(new URL("http://www.bilibili.com"), 1000);
            Elements p = document.select("p[title]");
            for (Element element : p) {
                System.out.println(element.text());
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void xPath() throws IOException, XpathSyntaxErrorException {
        Document document = Jsoup.parse(new File(path), "utf-8");
        JXDocument jxDocument = new JXDocument(document);
        List<JXNode> jxNodes = jxDocument.selN("//student");
        for (JXNode node : jxNodes){
            System.out.println(node);
        }
    }
}
