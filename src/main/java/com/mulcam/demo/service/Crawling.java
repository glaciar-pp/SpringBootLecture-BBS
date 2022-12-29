package com.mulcam.demo.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.mulcam.demo.entity.Interpark;

public class Crawling {

	public static void main(String[] args) throws IOException {
		bestSeller();
	}
	
	public static List<Interpark> bestSeller() throws IOException {
		String urlBase = "http://book.interpark.com";
		String urlSub = "/display/collectlist.do?_method=bestsellerHourNew&bookblockname=b_gnb&booklinkname=%BA%A3%BD%BA%C6%AE%C1%B8&bid1=bgnb_mn&bid2=LiveRanking&bid3=main&bid4=001";
		String url = urlBase + urlSub;
		Document doc = Jsoup.connect(url).get();
		Elements lis = doc.select(".listItem.singleType");
		System.out.println(lis.size());
		
		List<Interpark> list = new ArrayList<>();
		for (Element li: lis) {
			String title = li.select(".itemName").text().strip();
			String author = li.select(".author").text().strip();
			String company = li.select(".company").text().strip();
			String price_ = li.select(".price > em").text().strip();
			int price = Integer.parseInt(price_.replace(",", ""));
			String src = li.select(".coverImage").select("img").attr("src");
			Elements spans = li.select(".rankNumber.digit2").select("span");
			String rank_ = "";
			for (Element span: spans) {
				String classes = span.attr("class").strip();
				//System.out.println(classes);
				rank_ += classes.substring(classes.length() - 1);
			}
			int rank = Integer.parseInt(rank_);
			
			Interpark ip = new Interpark(rank, src, title, author, company, price);
			list.add(ip);
		}
		//list.forEach(x -> System.out.println(x));
		return list;
	}
	
}
