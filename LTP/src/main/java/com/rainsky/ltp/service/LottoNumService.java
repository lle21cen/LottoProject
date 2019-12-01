package com.rainsky.ltp.service;

import java.util.List;
import java.util.Map;

import com.rainsky.ltp.vo.LottoNumVO;

public interface LottoNumService {
	public List<Map<Integer, Integer>> getLottoNums();
	public void insertLottoNum(List<LottoNumVO> list);
	public int updateLottoNum(int lottoNum);
}
