package com.rainsky.ltp.dao;

import java.util.List;

import com.rainsky.ltp.vo.LottoNumVO;

public interface LottoNumDAO {
	public List<LottoNumVO> selectNum() throws Exception;
}
