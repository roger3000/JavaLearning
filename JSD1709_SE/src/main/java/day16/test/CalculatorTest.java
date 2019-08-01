package day16.test;

import day16.junit.Calculator;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CalculatorTest {
    /**
     * 初始化方法  使用注解@Before
     * 用于资源申请 所有测试方法再执行之前都会先执行该方法
     */
    @After
    public void init() {
        System.out.println("init");
    }

    /**
     * close方法 使用注解@After
     * 在所有方法结束之后调用 用于资源的释放
     */
    @Before
    public void close() {
        System.out.println("close");
    }

    /*
     * 测试add方法
     * */
    @Test
    public void testAdd() {
        System.out.println("我被执行了");
        Calculator c = new Calculator();

        System.out.println(c.add(1, 2));
        System.out.println(c.sub(2, 1));

//        使用断言来测试结果
        Assert.assertEquals(c.add(1, 4), 4);
    }

}
