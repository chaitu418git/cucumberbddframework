package pages;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Common {
public static void main(String[] args)
{
	DateFormat DF=DateFormat.getDateTimeInstance();
	Date date=new Date();
//	System.out.println(date);
//	String DateValue=DF.format(date);
//	
//	System.out.println(DateValue);
//	DateValue=DateValue.replaceAll(":", "_");
//	DateValue=DateValue.replaceAll(",", "");
//	System.out.println(DateValue);
	//return DateValue;
	SimpleDateFormat formatter = new SimpleDateFormat("M-d-yyyy");
	String strDate= formatter.format(date);
	System.out.println(strDate);
}
}
