package crolling;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Hanbit {

	public static void main(String[] args) {

		// 자바 외 적인 것은 반드시 예외처리
		try {

			String url = "http://www.hanbit.co.kr/media/";
			Document doc = Jsoup.connect(url).get();
//			System.out.println(doc);
			
			Elements body = doc.select("div.sub_book_list_area .book_tit > a");
			for(Element title : body) {
				System.out.println(title.text());
			}
			
		} catch (IOException e) {
			System.out.println("예외 발생");
			e.printStackTrace();
		}

	}
}
