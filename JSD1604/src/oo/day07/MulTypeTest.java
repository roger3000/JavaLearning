package oo.day07;

public class MulTypeTest {
	public static void main(String[] args) {
		Aoo o1 = new Boo();
		Boo o2 = (Boo)o1;
		Inter1 o4 = (Inter1)o1;
//		Coo o3 = (Coo)o1;
//		Doo o5 = (Doo)o1;
	}
}

interface Inter1{}

class Aoo{}

class Boo extends Aoo implements Inter1{}

class Coo extends Aoo{}

class Doo extends Boo{}