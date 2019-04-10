package day03;

import java.io.File;
import java.io.FileFilter;

/**
 * File提供了一个重载的listFiles方法,允许传入一个FileFilter,
 * 然后将当前File表示的目录中满足该过滤器要求的子项返回
 * @author xhquan
 *
 */
public class File_listFiles2 {
	public static void main(String[] args) {
		/*
		 * 获取当前目录中所有以"."开头的文件
		 */
		
		File dir = new File(".");
//		FileFilter filter = new MyFilter();
		//使用匿名内部类重写FileFilter接口
		File[] files = dir.listFiles(new FileFilter() {
			
			public boolean accept(File pathname) {
				String file = pathname.getName();
				boolean flag = file.matches("\\.\\w+");
				return flag;
			}
		});
		for (int i = 0; i < files.length; i++) {
			System.out.println(files[i].getName());
		}
	}
}

//class MyFilter implements FileFilter{
//	/*
//	 * @see java.io.FileFilter#accept(java.io.File)
//	 * 添加过滤器,只要认为参数给定的file满足要求则返回true
//	 */
//	public boolean accept(File pathname) {
//		String name = pathname.getName();
//		boolean tf = name.matches("\\.\\w+");
//		return tf;
//	}
//	
//}
