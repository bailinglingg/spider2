package edu.csuft.bailing.spider2;

import java.io.IOException;
import java.util.ArrayList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class App2 {
	 public static void main(String[] args) {
		 //路径
		 String url=" https://www.kugou.com/yy/html/rank.html";
		 //2 JSOUP
		 try {
			Document doc= Jsoup.connect(url).get();
			Elements es = doc.select(".grid_view .item");
			System.out.println(es.size());
			//创建一个存储影片的列表
			ArrayList<Music> list=new ArrayList<>();
			
			for(Element e :es) {
				Music m=new Music();
				//每一首音乐
				m.id=Integer.parseInt(e.select(".pic em").first().text());
				m.info=e.select(".bd p").first().text();
				m.title=e.select(".title").first().text();
				list.add(m);
//				Element t=e.select(".title").first();
//			    String num=e.select(".star span").last().text();
//				System.out.println(t.text()+","+num);
				
//				f.id;
//				f.title;
				list.add(m);
				System.out.println(m);
			}
			
			
//			String title=doc.title();
//			String data=doc.data();
			
//			System.out.println(title);
//			System.out.println(data);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	 }
	 

}
