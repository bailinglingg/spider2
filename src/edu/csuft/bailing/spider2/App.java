package edu.csuft.bailing.spider2;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 *程序的入口 
 * @author zab12109
 *
 */
public class App {
//alt+/
	public static void main(String[] args) {
		
	//目标URL
		String url="http://movie.douban.com/top250";
		//使用JSOUP抓取文档
	
		
			try {
				Document doc= Jsoup.connect(url).get();
				
				Elements es = doc.select(".grid_view .item");
				System.out.println(es.size());
				
				for(Element e :es) {
					//每一部影片
					Element t=e.select(".title").first();
					String num=e.select(".star span").last().text();
					System.out.println(t.text()+","+num);
				}
				
				
//				String title=doc.title();
//				String data=doc.data();
				
//				System.out.println(title);
//				System.out.println(data);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	}
