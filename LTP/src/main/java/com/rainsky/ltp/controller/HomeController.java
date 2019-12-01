package com.rainsky.ltp.controller;

import java.util.ArrayList;
import java.util.Locale;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.rainsky.ltp.service.InsertLottoNumService;
import com.rainsky.ltp.vo.LottoNumVO;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {

	@Autowired
	InsertLottoNumService lottoNumService;
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) throws Exception {

		ArrayList<LottoNumVO> numlist = new ArrayList<LottoNumVO>();
		for(int i=0; i<46; i++)
			numlist.add(new LottoNumVO(i, 0));

		Document doc = Jsoup.connect("https://www.nlotto.co.kr/common.do?method=main").get();
		int latest_ver = Integer.parseInt(doc.select("#lottoDrwNo").text());

		logger.info("latest version = " + latest_ver);

		for (int i = 1; i <= latest_ver; i++) {

			doc = Jsoup.connect("https://www.nlotto.co.kr/gameResult.do?method=byWin&drwNo=" + i).get();
			Elements contents = doc.select("span.ball_645");

			for (int j = 0; j < contents.size(); j++) {
				String e = contents.get(j).text();
				logger.info("element : " + e);
				int index = Integer.parseInt(e);
				numlist.get(index).increaseNum_cnt();
			}
		}

		
		lottoNumService.insertLottoNum(numlist);
		model.addAttribute("numbers", numlist);
		return "home";
	}
}