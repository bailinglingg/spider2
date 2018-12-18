package edu.csuft.bailing.spider2;

import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javafx.print.Collation;

/**
 *�������� 
 * @author zab12109
 *
 */
public class App {
//alt+/
	public static void main(String[] args) {
		
		//�̳߳�
		//�̶���С
		ExecutorService pool= Executors.newFixedThreadPool(4);
		
		//���޻���
		pool=Executors.newCachedThreadPool();
		//һ���߳�
		pool=Executors.newSingleThreadExecutor();
		
		
		ArrayList<Film> list=new ArrayList<>();
		
		
		String url="http://movie.douban.com/top250?start";
		
		for(int i=0;i<10;i++) {
			String path=String.format("%s=%d",url,i*25);
		  pool.submit(new Spider(path,list));	 
		}
		
		
		pool.shutdown();
				
		while(!pool.isTerminated()) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		//��������
		System.out.println(list.size());
		for(Film film:list) {
			System.out.print(film.toCSV());
		}
		//д���ļ�
		String file="d:/film.csv";//����·��
		file="film.csv";         //���·��
		
		//io
		//����
		Collections.sort(list);
		try (FileWriter out=new FileWriter(file)){
			//д����
			for (Film film : list) {
				out.write(film.toCSV());
			}
			System.out.println("ok");
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	}
