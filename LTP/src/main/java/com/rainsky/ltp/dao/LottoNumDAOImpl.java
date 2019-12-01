package com.rainsky.ltp.dao;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.rainsky.ltp.mapper.LottoNumMapper;
import com.rainsky.ltp.vo.LottoNumVO;

@Repository
public class LottoNumDAOImpl implements LottoNumDAO {
	
	@Autowired
	LottoNumMapper lottoNumMapper;
	
	@Override
	public void insertLottoNum(List<LottoNumVO> list) {
		lottoNumMapper.insertLottoNum(list);
	}
	
	@Override
	public int updateLottoNum(int lottoNum) {
		return lottoNumMapper.updateLottoNum(lottoNum);
	}
	
	@Override
	public List<Map<Integer, Integer>> getLottoNums() {
		return lottoNumMapper.getLottoNums();
	}
}
