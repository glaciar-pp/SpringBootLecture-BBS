package com.mulcam.demo.service;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.mulcam.demo.entity.Chart;
import com.mulcam.demo.entity.Book;

public class Old {

	public static void main(String[] args) throws IOException {
		genieChart();
	}
	
	public static List<Chart> genieChart() throws IOException {
		String url = "https://www.genie.co.kr/chart/top200";
		String userAgent = "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/108.0.0.0 Safari/537.36";
		List<Chart> list = new ArrayList<>();
//		url = "https://www.genie.co.kr/chart/top200?ditc=D&ymd=20221229&hh=21&rtm=Y&pg=1";
		LocalDateTime now = LocalDateTime.now();
		String ymd = now.toString().substring(0,10).replace("-", "");
		String hh = now.toString().substring(11,13);
//		System.out.println(ymd + ":" + hh);
		
		for (int i=1; i<=4; i++) {
			url = "https://www.genie.co.kr/chart/top200?ditc=D&ymd=" + ymd + "&hh=" + hh + "&rtm=Y&pg=" + i;
			Document doc = Jsoup.connect(url).userAgent(userAgent).get();
			Elements trs = doc.select(".list-wrap").select("tbody").select("tr.list");
			//System.out.println(trs.size());
			
			for (Element tr: trs) {
				String rank_ = tr.select(".number").text().split(" ")[0];
				int rank = Integer.parseInt(rank_);
				String src_ = tr.select("a.cover > img").attr("src");
				String image = "https:" + src_;
				String title = tr.select(".title.ellipsis").text().strip();
				String artist = tr.select(".artist.ellipsis").text().strip();
				String album = tr.select(".albumtitle.ellipsis").text().strip();
				Chart genie = new Chart(rank, image, title, artist, album);
				list.add(genie);
			}
		}
//		System.out.println(list.size());
		list.forEach(x -> System.out.println(x));
		return list;
	}
	
	public static List<Book> bestSeller() throws IOException {
		String urlBase = "http://book.interpark.com";
		String urlSub = "/display/collectlist.do?_method=bestsellerHourNew&bookblockname=b_gnb&booklinkname=%BA%A3%BD%BA%C6%AE%C1%B8&bid1=bgnb_mn&bid2=LiveRanking&bid3=main&bid4=001";
		String url = urlBase + urlSub;
		Document doc = Jsoup.connect(url).get();
		Elements lis = doc.select(".listItem.singleType");
//		System.out.println(lis.size());
		
		List<Book> list = new ArrayList<>();
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
//				System.out.println(classes);
				rank_ += classes.substring(classes.length() - 1);
			}
			int rank = Integer.parseInt(rank_);
			
			Book ip = new Book(rank, src, title, author, company, price);
			list.add(ip);
		}
//		list.forEach(x -> System.out.println(x));
		return list;
	}
	
}
