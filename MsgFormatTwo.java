package  i18n.messageformat;

import java.text.Format;
import java.text.MessageFormat;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;


public class MsgFormatTwo {

 public static void main(String[] args) {
  
  String patt[] = {"{0} is at a distance of {1} from {2} city."+
                   " Created as a satellite town on {3}.",

                   "{0} is at a distance of {1,number,##.####}"+  
                   " from {2} city.Created as a satellite town on"+
                   " {3}.",

                  "{0} is at a distance of {1,number,integer} from "+
                  " {2} city.Created as a satellite town on "+
                  " {3}."};

  MessageFormat mFormat = new MessageFormat("");
  String sat = "Tambaram";
  double dist = 31.50058;
  String city = "Chennai";
  /*Date d = 
   new GregorianCalendar(1962, Calendar.MARCH, 11).getTime();*/
  LocalDate d = LocalDate.of(2018,  Month.MARCH, 11);
  FormatStyle[] styles = { FormatStyle.LONG, FormatStyle.FULL, FormatStyle.SHORT };
  DateTimeFormatter formatter = null; 
   
  Format newFormat = null;
  
  Object[] params = {sat,new Double(dist),city,d};
    
  for(int i=0;i<patt.length;i++) {
   
   mFormat.applyPattern(patt[i]);
   formatter = DateTimeFormatter.ofLocalizedDate(styles[i]);
   newFormat = formatter.toFormat();
   mFormat.setFormat(3, newFormat);
   
   System.out.println("\n" + mFormat.format(params));
  }
 }

}     