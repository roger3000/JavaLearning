package day16.annotation;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Method;

/**
 * 一个简单的测试框架
 * <p>
 * 当主方法执行之后 自动测试所有标有注解的方法 判断方法是否有异常
 */
public class TestCheck {
    public static void main(String[] args) throws IOException {
//        1.创建计算器对象
        Calculator calculator = new Calculator();
//        2.获取字节码对象
        Class<? extends Calculator> cls = calculator.getClass();
//        3.获取所有方法
        Method[] clsMethods = cls.getMethods();

        int flag = 0;
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("log.txt"))) {
            for (Method method : clsMethods) {
                if (method.isAnnotationPresent(Check.class)) {
                    try {
                        method.invoke(calculator);
                    } catch (Exception e) {
                        flag += 1;
                        bw.write(method.getName() + "方法出错了");
                        bw.newLine();
                        bw.write("异常的名称:" + e.getCause().getClass().getSimpleName());
                        bw.newLine();
                        bw.write("异常的原因:" + e.getCause().getMessage());
                        bw.newLine();
                        bw.write("-----------------------------------");
                        bw.newLine();
                    }
                }
            }
            bw.write("本次测试一共出现了" + flag + "次错误");
        }
    }
}
