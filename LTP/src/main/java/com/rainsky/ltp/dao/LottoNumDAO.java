package com.rainsky.ltp.dao;

import java.util.List;
import java.util.Map;

import com.rainsky.ltp.vo.LottoNumVO;

public interface LottoNumDAO {
	public List<Map<Integer, Integer>> getLottoNums();
	public void insertLottoNum(List<LottoNumVO> list);
	public int updateLottoNum(int lottoNum);
}
