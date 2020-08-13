package com.rohit.restapi;

import java.io.IOException;
import java.util.ArrayList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class WebScrappingJsoupApplication {

	public static void main(String[] args) throws IOException {
		SpringApplication.run(WebScrappingJsoupApplication.class, args);
		
//		WebScrappingAmazon();	

		WebScrappingRealtor();
	}
	
	

	public static void WebScrappingRealtor() throws IOException {
		
		String url = "https://www.realtor.ca/map#ZoomLevel=14&Center=43.749257%2C-79.726582&LatitudeMax=43.76823&LongitudeMax=-79.68620&LatitudeMin=43.73028&LongitudeMin=-79.76696&Sort=6-D&PropertyTypeGroupID=1&PropertySearchTypeId=1&TransactionTypeId=2&BuildingTypeId=1&ConstructionStyleId=3&Currency=CAD";		
		
		Document page = Jsoup.connect(url).get();
		Elements listingElements = page.select("div.smallListingCardAddress");
		
		System.out.println(listingElements);
		for (Element e : listingElements) {
			System.out.println(e.text());
		}
	}	

	
	
/*	
									// Get 50 best seller books from Amazon
public static void WebScrappingAmazon() throws IOException {
		
		String url = "https://www.amazon.ca/Best-Sellers-Books/zgbs/books/ref=zg_bs_nav_0\n";
		Document page = Jsoup.connect(url).get();
// Return all book information
		Elements listingElements = page.select(".zg-item-immersion");
		ArrayList<String> listingList = new ArrayList<>();	
		
		for (Element e : listingElements) {
//			System.out.println(e.text());
			listingList.add(e.text());
		}
		
		for(String book : listingList) {
			System.out.println(" Book :"+book);
			System.out.println("");			
		}						
}
*/
	
	
}

