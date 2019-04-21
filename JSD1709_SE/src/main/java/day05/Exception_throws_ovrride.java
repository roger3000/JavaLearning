package day05;

import java.awt.AWTException;
import java.io.IOException;

/**
 * 子类在重写父类一个含有throws声明异常抛出的方法时
 * 对throws的重写规则
 * @author 许皓泉
 *
 */
public class Exception_throws_ovrride {
	public void dosome() throws IOException,AWTException{

	}
}

class Son extends Exception_throws_ovrride{
	/*
	 * 可以不抛出异常
	 * 可以抛出部分异常
	 * 可以抛出父类异常的子类
	 * 
	 * 不可以抛出父类不存在的异常\额外异常
	 * (non-Javadoc)
	 * @see day05.Exception_throws_ovrride#dosome()
	 */
	public void dosome() {
		
	}
}
