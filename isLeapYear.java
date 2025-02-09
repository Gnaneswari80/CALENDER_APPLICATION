package calander;

public class isLeapYear {

	
	public static boolean leapyear(int year)
	{
		boolean ret=(year %4==0)&&(year%100!=0||year%400==0);
		
		return ret;
	}

}
