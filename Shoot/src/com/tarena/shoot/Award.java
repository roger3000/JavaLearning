package com.tarena.shoot;

/**
 * 蜜蜂奖励
 * 
 * @author Administrator
 * 
 */
public interface Award {
	int DOUBLE_FIRE = 0; // 双倍火力
	int LIFE = 1; // 一条命

	/** 获得的奖励类型(上面的0或者1) */
	public int getAwardType();
}
