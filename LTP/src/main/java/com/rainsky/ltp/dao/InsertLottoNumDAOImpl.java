package com.rainsky.ltp.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.rainsky.ltp.mapper.InsertLottoNumMapper;
import com.rainsky.ltp.vo.LottoNumVO;

@Repository
public class InsertLottoNumDAOImpl implements InsertLottoNumDAO {
	
	@Autowired
	InsertLottoNumMapper lottoNumMapper;
	
	@Override
	public void insertLottoNum(List<LottoNumVO> list) {
		lottoNumMapper.insertLottoNum(list);
	}
}
