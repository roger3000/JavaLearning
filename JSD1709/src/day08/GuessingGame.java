package day08;

import java.util.Scanner;

//���ַ���Ϸ
public class GuessingGame {
	//������
	public static void main(String[] args) {
		//�����������
		char[] chs = generate();
		System.out.println("��Ϸ��ʼ");
		System.out.println(chs); //char[] ��ֱ�����
		int score = 500;
		
		while (true) {
			System.out.println("��������ĸ�� ");
			@SuppressWarnings("resource")
			Scanner scan = new Scanner(System.in);
			String s = scan.nextLine().toUpperCase();
			if (s.equals("EXIT")) {  		//�������Ͳ�����== ��String�ǻ������� ��Ҫ��equals
				System.out.println("��Ϸ���� ������");
				break;
			}
			int[] result = check(chs, s.toCharArray());
			if(result[0] == chs.length && result[1] == chs.length) {
				System.out.println("�¶��ˣ� ��Ϸ����,���յ÷֣�"+score);
				break;
			}else {
				System.out.println("�¶���"+result[0]+"�����¶���"+result[1]+"��λ��");
				score-=10;
			}
		}
	}
	//�����ַ�����, �������ַ��ظ�
	public static char[] generate() {
		char[] chs = new char[5];
//		for (int i = 0; i < chs.length; i++) {
//			chs[i] = (char) ('A'+Math.random()*('Z'-'A'+1));
//		}
		char[] verb = {'A','B','C','D','E','F','G','H','I','J','K',
		                       'L','M','N','O','P','Q','R','S','T',
		                       'U','V','W','X','Y','Z'};
		boolean[] flags = new boolean[verb.length];
		for (int i = 0; i < chs.length; i++) {
			int pos;
			do {
				pos = (int)(Math.random()*verb.length);
			}while(flags[pos]);
			
			chs[i] = verb[pos];
			flags[pos] = true;
		}
		return chs;
	}
	//�ַ�����Ա�
	public static int[] check(char[] chs, char[] input) {
		//result[0]: ��ȷ���ַ����� result[1]�� ��ȷ��λ��
		int[] result = new int[2];
		for (int i = 0; i < input.length; i++) {
			for (int j = 0; j < chs.length; j++) {
				if(input[i] == chs[j]) {
					result[0]++;
					if(i == j) {
						result[1]++;
					}
					break;	//ʣ�µ�chs������Ա�
				}
			}
		}
		
		return result;
	}
}
