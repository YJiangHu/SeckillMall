package com.mall.seckill.cache;

public interface KeyPrefix {
		
	public int expireSeconds();
	
	public String getPrefix();
	
}
