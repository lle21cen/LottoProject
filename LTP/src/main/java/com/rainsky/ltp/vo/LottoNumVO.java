package com.rainsky.ltp.vo;

public class LottoNumVO {
	int num, num_cnt;

	public LottoNumVO(int num, int num_cnt) {
		this.num = num;
		this.num_cnt = num_cnt;
	}
	
	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public int getNum_cnt() {
		return num_cnt;
	}

	public void setNum_cnt(int num_cnt) {
		this.num_cnt = num_cnt;
	}
	
	public void increaseNum_cnt() {
		this.num_cnt++;
	}
}
