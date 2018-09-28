//package com.robgravelle.scraper;
 
import java.io.IOException;
 
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
 
public class Get_fx_rates_from_SBSA {
 
  public static void main(String[] args) {
    try {
      // fetch the document over HTTP
      // Proxy proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress("127.0.0.1", 8080));
     //Proxy proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress("127.0.0.1", 3128)); 
     // Document doc = Jsoup.connect("http://ws15.standardbank.co.za/finSnapShot/GetforexServlet").proxy("127.0.0.1", 3128).userAgent("Mozilla/5.0 (Macintosh; U; Intel Mac OS X 10.4; en-US; rv:1.9.2.2) Gecko/20100316 Firefox/3.6.2").header("Content-Language", "en-US").get();;
     Document doc = Jsoup.connect("http://ws15.standardbank.co.za/finSnapShot/GetforexServlet").get();; 
      // get the page title
      String title = doc.title();
      System.out.println("title: " + title);
      Element body = doc.body(); 
      Elements fonts = body.getElementsByTag("font");
      //for (Element font : fonts) {
      for (int i=23; i < 381; i++) {
	      if (i == 44){
		i++;
	      }
	 System.out.print(i + " " + fonts.get(i).text());     
	 i++;
         System.out.print("," + fonts.get(i).text());
	 i++;
	 System.out.print("," + fonts.get(i).text());
	 i++;
	 System.out.print("," + fonts.get(i).text());
	 i++;
	 System.out.print("," + fonts.get(i).text());
	 i++;
	 System.out.print("," + fonts.get(i).text());
	 i++;
	 System.out.print("," + fonts.get(i).text() + "\n" );
      }
      // get all links in page
      //Elements links = doc.select("a[href]");
      //Elements fxName = doc.select("td[font]");
      //Elements sampleDiv = doc.getElementById("font");
      //System.out.println("Data: " + sampleDiv.text());
      //Elements links2 = sampleDiv.getElementsByTag("font");
      //for (Element link : links2) {
        // get the value from the href attribute
       // System.out.println("\nlink: " + link.attr("font"));
       // System.out.println("text: " + link.text());
	//System.out.println("fx: " + fxName.attr("font"));
	//System.out.println("Fx val: " + fxName.text());
      //}
    } catch (IOException e) {
    e.printStackTrace();
    }
  }
}
