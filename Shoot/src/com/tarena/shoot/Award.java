package com.tarena.shoot;

/**
 * �۷佱��
 * 
 * @author Administrator
 * 
 */
public interface Award {
	int DOUBLE_FIRE = 0; // ˫������
	int LIFE = 1; // һ����

	/** ��õĽ�������(�����0����1) */
	public int getAwardType();
}
