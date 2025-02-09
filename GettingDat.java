package calander;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class GettingDate {

	public static String init[][]=new String[7][7];
	public static int endDate[]=new int[13];
	public static int day;
	public static int year;
	public static int month;
	public static int date;
	public static int endday;
	public static int today;
	public static int presentMonth;
	public static int presentYear;
	public static int colorSet=-1;
public	static void initvalues()
	{
	int count=0;
	
	int printdate=1;
	colorSet=-1;
	for(int i=1;i<7;i++)
	{
		 for(int j=0;j<7;j++) {
			 
			 if(count>=day&&printdate<=endDate[month-1]) {
				 init[i][j]=Integer.toString(printdate); 
					if(presentMonth==month&&presentYear==year&&date==printdate) 
		        	 colorSet=count+7;
				 printdate++;
				 endday=j+1;
				 if(endday==7)
					 endday=0;
			 }
			 else
				 init[i][j]=" ";
			count++;
			
				 
			  }
		
	}
	
		
	}


	public GettingDate() {
		
		String s[]=new String[8];///day 0,day 1....
	
		s[0]="Sunday";
		s[1]="Monday";
		s[2]="Tuesday";
		s[3]="wednesday";
		s[4]="Thursday";
		s[5]="Friday";
		s[6]="Saturday";
	
		init[0][0]="Sun";
		init[0][1]="mon";
		init[0][2]="Tus";init[0][3]="Wed";init[0][4]="Thur";
		init[0][5]="Fri";init[0][6]="Sat";
		
		endDate[0]=31;
		//endDate[1]=28;//leap year
		endDate[2]=31;
		endDate[3]=30;
		endDate[4]=31;endDate[5]=30;endDate[6]=31;
		endDate[7]=31;endDate[8]=30;endDate[9]=31;
		endDate[10]=30;endDate[11]=31;
		
		GregorianCalendar g=new GregorianCalendar(); 
			month=g.get(Calendar.MONTH);
			presentMonth=month;
			date=g.get(Calendar.DATE);
			year =g.get(Calendar.YEAR);
			presentYear=year;
		Date d=new Date();
		 today=d.getDay();
		 day=today;
		 
		 if(isLeapYear.leapyear(year))
				endDate[1]=29;
			else
				endDate[1]=28;
				
		 
		 GettingStartDayOfCurrentMonth ob=new GettingStartDayOfCurrentMonth();
                //day means... it will contains present day sunday etc
		         //We need to find the day before 10 days(10 means date=10)
		 
			day= ob.nDaysBefore(day,date);
			GettingDate.initvalues();
	
	}

}
