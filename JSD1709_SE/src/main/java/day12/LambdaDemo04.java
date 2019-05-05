package day12;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class LambdaDemo04 {
	public static void main(String[] args) {
		List<String> list = new ArrayList<>();
		list.add("Tom");
		list.add("Jerry");
		list.add("熊大");
		list.add("熊二");

		Consumer<String> c = new Consumer<String>() {

			@Override
			public void accept(String t) {
				// TODO Auto-generated method stub
				System.out.println(t);
			}
		};

		list.forEach(e -> {
			System.out.println(e);
		});
		list.forEach(c);
	}
}
