package com.rainsky.ltp.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rainsky.ltp.dao.LottoNumDAO;
import com.rainsky.ltp.vo.LottoNumVO;

@Service
public class LottoNumServiceImpl implements LottoNumService{
	
	@Autowired
	LottoNumDAO lottoNumDAO;
	
	public void insertLottoNum(List<LottoNumVO> list) {
		lottoNumDAO.insertLottoNum(list);
	}	
	
	@Override
	public int updateLottoNum(int lottoNum) {
		return lottoNumDAO.updateLottoNum(lottoNum);
	}
	
	@Override
	public List<Map<Integer, Integer>> getLottoNums() {
		return lottoNumDAO.getLottoNums();
	}
}
