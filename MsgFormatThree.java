package i18n.messageformat;
import java.text.MessageFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.Locale;

public class MsgFormatThree {

 public static void main(String[] args) {
 
  String start = "The cost of "; 
  String item  = "Gold bangles";
  String verb  = " is ";
  int qty      = 5;
  double tot   = 12450.80;

 
  String src = "{0} {1,number,integer} {2} {3} "
               +"{4,number,currency} on {5}";

  MessageFormat mFormat =
       new MessageFormat(src,Locale.FRANCE);       
  StringBuffer sb = new StringBuffer();

  StringBuffer result = 
     mFormat.format(new Object[]{ start, new Integer(qty),
     item, verb, new Double(tot), LocalDate.now()}, sb, null);

  System.out.println("In French:"+result);

  sb.setLength(0);
 
  mFormat.setLocale(Locale.GERMANY);

  mFormat.applyPattern(src);

 result = 
    mFormat.format(new Object[]{start, new Integer(qty),
          item, verb, new Double(tot), LocalDate.now()}, sb, null);
   System.out.println("In German:"+result);
 }

}