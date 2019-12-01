package com.rainsky.ltp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rainsky.ltp.dao.InsertLottoNumDAO;
import com.rainsky.ltp.vo.LottoNumVO;

@Service
public class InsertLottoNumServiceImpl implements InsertLottoNumService{
	
	@Autowired
	InsertLottoNumDAO lottoNumDAO;
	
	public void insertLottoNum(List<LottoNumVO> list) {
		lottoNumDAO.insertLottoNum(list);
	}	
}
