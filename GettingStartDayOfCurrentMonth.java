package calander;

public class GettingStartDayOfCurrentMonth {

	public int R;
	int nDaysBefore(int D,int N) {
		R=(D-N)%7;
		while(R<0) {
			R+=7;
			
		}
/*if R becomes-1...then loop-> -1+7=6;returning (6+1)7,,sun=0,Mon=1...Sat=6
		There is no  Equalant value(day) ..So Returning 0*/
		if(R+1==7)
			return 0;
		return R+1;
		
	}
	
	

}
