package com.assignments.imageCountJsoup;

import java.io.IOException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class ImageCount {
	public static void main(String[] args) throws IOException {
		int gen = 3;
		String url = "http://www.qainfotech.com";
		Document doc;
		Elements allLinks;
		Elements allImages;
		int randomLinkNum;
//		Random random;
		doc = Jsoup.connect(url).get();

		for (int i = 0; i < gen; i++) {
			allLinks = doc.select("a[href]");
			allImages = doc.getElementsByTag("img");
			System.out.println("Number of Links in Gen " + (i+1) + " --> " + allLinks.size());
			System.out.println("Number of Images in Gen " + (i+1) + " --> " + allImages.size());
			randomLinkNum = (int) (Math.random() * allLinks.size());
			if (!allLinks.get(randomLinkNum).attr("href").contains("http")) {
				System.out.println("Selecting Sublink --> " + url + allLinks.get(randomLinkNum).attr("href") +"\n");
				doc = Jsoup.connect(url + allLinks.get(randomLinkNum).attr("href")).get();
			} else {
				System.out.println("Selecting Sublink --> " + allLinks.get(randomLinkNum).attr("href") +"\n");
				doc = Jsoup.connect(allLinks.get(randomLinkNum).attr("href")).get();
			}
		}

	}
}
