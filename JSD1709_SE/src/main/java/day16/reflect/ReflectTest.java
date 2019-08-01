package day16.reflect;

import day16.annotation.Pro;

import java.lang.reflect.Method;

@Pro(className = "day16.annotation.Demo02", methodName = "show")
public class ReflectTest {
    public static void main(String[] args) throws Exception {
        /*前提: 不能改变任何代码. 可以创建任意类的对象, 可以执行任意方法*/

//        1. 解析注解
//        1.1 获取该类的字节码对象
        Class<ReflectTest> reflectTestClass = ReflectTest.class;
//        2.获取上面的注解对象
        //其实就是在内存中生产了一个该接口的子类实现对象
        Pro annotation = reflectTestClass.getAnnotation(Pro.class);
//        3. 调用注解对象中定义的抽象方法, 获取返回值
        String className = annotation.className();
        String methodName = annotation.methodName();

//        4.通过反射加载类
        Class<?> cls = Class.forName(className);
        Object newInstance = cls.newInstance();
        Method method = cls.getMethod(methodName);

        method.invoke(newInstance);

    }
}
