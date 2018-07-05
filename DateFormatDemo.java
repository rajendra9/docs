package i18n.dates;
/*import static java.text.DateFormat.FULL;
import static java.text.DateFormat.LONG;
import static java.text.DateFormat.MEDIUM;
import static java.text.DateFormat.SHORT;

import java.text.DateFormat;
import java.text.FieldPosition;
import java.util.Date;
import java.util.Locale;
*/
import java.time.format.DateTimeFormatter;
import java.util.Locale;

import static java.time.format.FormatStyle.FULL;
import static java.time.format.FormatStyle.LONG;
import static java.time.format.FormatStyle.MEDIUM;
import static java.time.format.FormatStyle.SHORT;
import java.time.ZoneId;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;

public class DateFormatDemo {

 /* public String usingOldFormats() {
	  StringBuffer sb = new StringBuffer();
	  Date dt = new Date();

	  DateFormat dFormat = 
	     DateFormat.getDateTimeInstance(LONG,LONG,Locale.FRENCH);
	  sb = dFormat.format(dt,sb,
	         new FieldPosition(DateFormat.DATE_FIELD));
	  sb.append("\n");

	  dFormat = 
	      DateFormat.getDateTimeInstance(MEDIUM,MEDIUM);
	  sb = dFormat.format(dt,sb,
	      new FieldPosition(DateFormat.DATE_FIELD));
	  sb.append("\n");

	  dFormat = 
	    DateFormat.getDateTimeInstance(SHORT,SHORT);
	  sb = dFormat.format(dt,sb,
	     new FieldPosition(DateFormat.DATE_FIELD));
	  sb.append("\n"); 

	  dFormat = 
	     DateFormat.getDateTimeInstance(FULL,FULL);
	  sb = 
	    dFormat.format(dt,sb,
	      new FieldPosition(DateFormat.DATE_FIELD));
	  sb.append("\n");

	  dFormat = DateFormat.getDateTimeInstance();        
	  sb.append("Default:: ");
	  sb = dFormat.format(dt,sb,
	     new FieldPosition(DateFormat.DATE_FIELD));
	  sb.append("\n");
	  return sb.toString(); 	
     }
  */
	
  public String usingNewFormats() {
      StringBuffer sb = new StringBuffer();
	  LocalDateTime ldtNow = LocalDateTime.now();
	  System.out.println(ldtNow);
	  DateTimeFormatter formatter = 
			  DateTimeFormatter.ofLocalizedDateTime(FULL,FULL);
	  ZoneId zoneId = ZoneId.systemDefault();
	  ZonedDateTime zdtNow = ldtNow.atZone(zoneId);
	  String str = zdtNow.format(formatter);
	  sb.append(str);
	  sb.append("\n");
	  formatter = formatter.withLocale(Locale.FRANCE);
      sb.append("In French:" + zdtNow.format(formatter));
      sb.append("\n");
	  
	  formatter = 
		  DateTimeFormatter.ofLocalizedDateTime(LONG,LONG);
	  sb.append(zdtNow.format(formatter));
      sb.append("\n");

      formatter = 
    	 DateTimeFormatter.ofLocalizedDateTime(MEDIUM,MEDIUM);
      sb.append(zdtNow.format(formatter));
      sb.append("\n");
	
      formatter = 
    	 DateTimeFormatter.ofLocalizedDateTime(SHORT, SHORT);
      sb.append(zdtNow.format(formatter));
      sb.append("\n");     
      
      return  sb.toString();	

  }
  
  public static void main(String[] args) {
    try {
	  DateFormatDemo dateFormatDemo = new DateFormatDemo();
	  String result = dateFormatDemo.usingNewFormats();
	  System.out.println(result);
    }catch(Exception ex) {
    	ex.printStackTrace();
    }
  }
}