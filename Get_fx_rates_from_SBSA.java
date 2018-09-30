//This code was written by Anton Janovsky.
//This code is licensed as GPL Gnu V3.
//The Source code is avalable here https://github.com/antonjan/get_fx_rates
//This program will fech FX rates from the SBSA web and write the results to cmd output.
//This is my version 1.0 of the program.
import java.io.IOException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
 
public class Get_fx_rates_from_SBSA {
 
  public static void main(String[] args) {
    try {
     Document doc = Jsoup.connect("http://ws15.standardbank.co.za/finSnapShot/GetforexServlet").get();; 
      // get the page title
      String title = doc.title();
      Element body = doc.body(); 
      Elements fonts = body.getElementsByTag("font");
      //writing the time and Date
      System.out.print("Date of rate: " + fonts.get(1).text() + "\n");
      //Writing all currensy values
      int item = 0; 
      for (int i=23; i < 381; i++) {
	      if (i == 44){
		i++;
	      }
	      
	 System.out.print(item + "," + fonts.get(i).text());     
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
	 item++;
      }
    } catch (IOException e) {
    e.printStackTrace();
    }
  }
}
