//This code was written by Anton Janovsky.
//This code is licensed as GPL Gnu V3.
//The Source code is avalable here https://github.com/antonjan/get_fx_rates
//This program will fech FX rates from the SBSA web and write the results to cmd output.
//This is my version 1.0 of the program.
import java.io.IOException;
import java.text.*;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.io.FileOutputStream;
import java.util.*;
public class Get_fx_rates_from_SBSA_NP {

  public static void  main(String[] args) {

    String fileName = "Rates.csv";
    Date dateTime = new Date();
    for ( int i = 0; i < args.length; i++ )
   	    System.out.println( args[i] );
        if (args.length > 0){
          fileName = args[0];
        }
        if (args.length > 1){
          SimpleDateFormat simplDateFormat = new SimpleDateFormat ("yyyy-MM-dd ' ' hh:mm:ss.S"); //Sun 2004.07.18 at 04:14:09 PM  (E yyyy.MM.dd 'at' hh:mm:ss a zzz)
          //dateTime = args[1];
          try{
          Date date = simplDateFormat.parse(args[1]);
          dateTime = date;
        }catch (Exception e) {
        e.printStackTrace();
        }
        }
        else{
          System.out.println("Usage: java Get_fx_rates_from_SBSA_NP <file name> <time date>");
          System.out.println("E.G. java Get_fx_rates_from_SBSA_NP rates.csv \"2018-09-28 16:01:12.0\"");
          System.out.println("Date :" + dateTime);

        }


    try {
     Document doc = Jsoup.connect("http://ws15.standardbank.co.za/finSnapShot/GetforexServlet").get();;
      // get the page title
      String title = doc.title();
      Element body = doc.body();
      Elements fonts = body.getElementsByTag("font");
      String fileContent ="";
      //writing the time and Date
      System.out.print("Date of rate: " + fonts.get(1).text() + "\n");
	fileContent = "Date of rate: " + fonts.get(1).text() + "\n";
  String[][] gridArray = new String[51][8]; //50 Rows and 7 colonms of data
      //Writing all currensy values
      int item = 0;

      for (int i=23; i < 381; i++) {
	      if (i == 44){
		i++;
	      }
        int colunm =0;
	 //write_Rates_to_file("test 123");
	 //System.out.print(item + "," + fonts.get(i).text());
   gridArray[item][colunm] = fonts.get(i).text(); //50 Rows and 7 colonms of data
	 i++;
   colunm++;
   System.out.print(item + "," + fonts.get(i).text() + "ZAR");
	 fileContent = fileContent + item + "," + fonts.get(i).text() + "ZAR";
   gridArray[item][colunm] = fonts.get(i).text();
	 i++;
   colunm++;
	 System.out.print("," + fonts.get(i).text());
	 fileContent = fileContent + "," + fonts.get(i).text();
   gridArray[item][colunm] = fonts.get(i).text();
	 i++;
   colunm++;
	 //System.out.print("," + fonts.get(i).text());
   gridArray[item][colunm] = fonts.get(i).text();
	 i++;
   colunm++;
	 //System.out.print("," + fonts.get(i).text());
   gridArray[item][colunm] = fonts.get(i).text();
	 i++;
   colunm++;
	 //System.out.print("," + fonts.get(i).text());
   gridArray[item][colunm] = fonts.get(i).text();
	 i++;
   colunm++;
	 //System.out.print("," + fonts.get(i).text() + "\n" );
   gridArray[item][colunm] = fonts.get(i).text();
	 System.out.print("\n");
	 fileContent = fileContent + "\n";
	 item++;
      }
      write_Rates_to_file(fileContent);
    } catch (IOException e) {
    e.printStackTrace();
    }
  }
  public static void write_Rates_to_file(String rates) throws IOException {
    String str = "";
    str = rates;
    String fileName = "Rates.csv";
    FileOutputStream outputStream = new FileOutputStream(fileName);
    byte[] strToBytes = str.getBytes();
    outputStream.write(strToBytes);

    outputStream.close();

  }
  public static int calculateRateWith_new_base(int base1,int base2,int currency1,int currency2){
/*
To calculate the cross-rate between Sterling (GBP) and the Mexican Peso (MXN), using the US Dollar (USD) as the common currency.
Let us assume that rates are quoted as follows:

    GBPUSD = 1.43130 / 1.43160
    USDMXN = 9.02000 / 9.03000

    GBPMXN = GBP / USD x USD / MXN
    MXN / GBP = 1 /GBP / USD  x  USD / MXN
    For GBP/MXN – to buy a variable amount of MXN per 1 GBP:

    Bid = 1.43130 x 9.02000 = 12.91 - the bank buys GBP and sells MXN
    Offer = 1.43160 x 9.03000 = 12.93 - the bank sells GBP and buys MXN
    So GBP/MXN = 12.91 / 12.93

For MXN/GBP – to buy a variable amount of GBP per 1 MXN:

    Bid = 1 1.43160  x  9.03000 = 0.07735 - the bank buys MXN and sells GBP
    Offer = 1 1.43130  x  9.02000 = 0.07746 - the bank sells MXN and buys GBP
    So MXN/GBP = 0.07735 / 0.07746
*/
  int bid = base1*base2;
  int offer = currency1*currency2;
  int calValue = bid/offer;

return calValue;
}
  }
