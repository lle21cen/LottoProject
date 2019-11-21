package com.rainsky.ltp.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Locale;
import java.util.Map;
import java.util.TreeMap;

import javax.inject.Inject;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {

	private int nums[] = new int[46];
	private int temp[] = new int[46];
	private Map<Integer, Integer> map = new TreeMap<Integer, Integer>();
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	@Inject
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) throws Exception {

		ArrayList<Integer> arr = new ArrayList<Integer>();

		Document doc = Jsoup.connect("https://www.nlotto.co.kr/common.do?method=main").get();
		int latest_ver = Integer.parseInt(doc.select("#lottoDrwNo").text());

		logger.info("latest version = " + latest_ver);

		for (int i = 1; i <= latest_ver; i++) {

			doc = Jsoup.connect("https://www.nlotto.co.kr/gameResult.do?method=byWin&drwNo=" + i).get();
//		doc = Jsoup.connect("https://www.nlotto.co.kr/gameResult.do?method=byWin&drwNo=455").get();
			Elements contents = doc.select("span.ball_645");

			for (int j = 0; j < contents.size(); j++) {
				String e = contents.get(j).text();
				logger.info("element : " + e);

				nums[Integer.parseInt(e)]++;
				temp[Integer.parseInt(e)]--;
			}
		}

		Arrays.sort(temp);

		int min_num = -temp[6];
		int max_num = -temp[0];

		for (int i = 0; i < 10; i++) {
			System.out.println(i + " " + temp[i]);
		}

		System.out.println(max_num + " " + min_num);

		for (int i = 1; i <= 45; i++) {
			System.out.println(i + " nums = " + nums[i]);
			if (min_num <= nums[i] && nums[i] <= max_num) {
				arr.add(i);
			}
		}

		model.addAttribute("numbers", arr);
		return "home";
	}
}