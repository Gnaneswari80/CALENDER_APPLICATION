package calander;

import java.awt.Color;
import java.awt.Font;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class main1 {

	
	public JTextField []tf=new JTextField[50];
	public static String mont[]=new String[12];
	
	
	public main1() {
		
		
		
		JButton b=new JButton(">");
		JButton b2=new JButton("<");
		JLabel l1=new JLabel();
		JLabel l2=new JLabel();
		JLabel heading=new JLabel("CALENDER");
		JFrame f1=new JFrame("CALANDER APPLICATION Developed By Gnaneswari");
		f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE );
		f1.setSize(900,900);
		//Panel adding
		JPanel p=new JPanel();
		//p.setBorder(BorderFactory.createLineBorder(new Color(0,87,69), 230));
		p.setLayout(null);
		p.setBackground(new Color(10,10,23));
		f1.getContentPane().add(p);
		/// Adding button1
		p.add(b);
        b.setBounds(600,100,50,50);
	b.setBackground(new Color(0,20,23));
		b.setVisible(true);
		b.setForeground(Color.WHITE);
		b.setFont(new Font("Arial",Font.BOLD,25));
		//Adding Button2
		p.add(b2);
        b2.setBounds(600,250,50,50);
	b2.setBackground(new Color(0,20,23));
		b2.setVisible(true);
		b2.setForeground(Color.WHITE);
		b2.setFont(new Font("Arial",Font.BOLD,25));
		//Adding Label1
		p.add(l1);
		l1.setBounds(50,50,100,50);
		l1.setBackground(new Color(10,10,23));
		l1.setVisible(true);
		l1.setForeground(Color.orange);
		l1.setFont(new Font("Arial",Font.BOLD,22));
		//Adding Label2
		p.add(l2);
		l2.setBounds(500,50,50,50);
		l2.setBackground(new Color(0,20,23));
		l2.setVisible(true);
	    l2.setForeground(Color.orange);
		l2.setFont(new Font("Arial",Font.BOLD,22));
		//////Adding lable3 HEADING 
		p.add(heading);
		heading.setBounds(200,50,190,50);
		heading.setBackground(new Color(0,20,23));
		heading.setVisible(true);
		heading.setForeground(Color.BLUE);
		heading.setFont(new Font("Arial",Font.BOLD,22));
		int x ;
		int y = 100;
		int cn = 0;
		 GettingDate GD=new  GettingDate();
		l1.setText(mont[GD.month-1]);//Month will Display
		l2.setText(Integer.toString(GD.year));//Year Will Display
		for(int k=0;k<7;k++) {
			x=100;
		for(int i=0;i<7;i++) {
		
		tf[cn]=new JTextField(2);
		
		///All Sundays will be in RED font Color 
		if(i==0)
			tf[cn].setForeground(Color.red);
		else//Remaining days color except sunday
		   tf[cn].setForeground(Color.cyan);
		//sun mon ,tues , wed ... saturday  is in green color
		if(k==0)
			tf[cn].setForeground(Color.green);
		
		tf[cn].setBounds(x,y,60,60);
		tf[cn].setEditable(true);
	   tf[cn].setText(GD.init[k][i]);//(Integer.toString(count));
		if(GD.colorSet==cn)
			tf[cn].setBackground(new Color(100,10,23));
		else
			tf[cn].setBackground(new Color(0,20,23));
		
	
		tf[cn].setFont(new Font("Arial",Font.BOLD,14));
		//increasing x-axis value
		x+=60;
		//user can't Edit the textBox
		tf[cn].setEditable(false);
		
		p.add(tf[cn]);
		cn++;
		
		}
		//increasing y-axis value
		y+=60;
		}
		
		
		//click on button1
		b.addActionListener(e->{
			try {

				 
				GD.month++;
				
				if(GD.month==13)
				{
					GD.month=1;GD.year+=1;
					 if(isLeapYear.leapyear(GD.year))
							GD.endDate[1]=29;
						else
							GD.endDate[1]=28;
				}
				
				//the end day .. important 
				///Because Next month ,will start after the enday of these month
					GD.day=GD.endday;
				
				 GettingDate.initvalues();
				int c=0;
				 l1.setText(mont[GD.month-1]);
				 l2.setText(Integer.toString(GD.year));
			
				 for(int k=0;k<7;k++) {
					
					for(int i=0;i<7;i++) {
						
				 tf[c].setText(GD.init[k][i]);
				 if(GD.colorSet==c)//current day will be in differnt color
						tf[c].setBackground(new Color(100,10,23));
					else
						tf[c].setBackground(new Color(0,20,23));
				 
				 c++;
					}
				 }
			
			}catch(Exception ex)
			{
				ex.printStackTrace();
			}
		});
		
		//click on second Button
		b2.addActionListener(e->{
			try {
				
				GD.month--;
				if(GD.month==0)
				{
					GD.month=12;GD.year-=1;
					 if(isLeapYear.leapyear(GD.year))
							GD.endDate[1]=29;
						else
							GD.endDate[1]=28;
				}
				//Finding Previous month of starting day
				GettingStartDayOfCurrentMonth ob=new GettingStartDayOfCurrentMonth();

				GD.day= ob.nDaysBefore(GD.day,+GD.endDate[ GD.month-1]+1);
				
				GettingDate.initvalues();//initilisig values
				int c=0;
				 l1.setText(mont[GD.month-1]);
				 l2.setText(Integer.toString(GD.year));
				
				 for(int k=0;k<7;k++) {
					
					for(int i=0;i<7;i++) {
					
				 tf[c].setText(GD.init[k][i]);
				 if(GD.colorSet==c)
						tf[c].setBackground(new Color(100,10,23));
					else
						tf[c].setBackground(new Color(0,20,23));
				 c++;
					}
				 }
				 
			}catch(Exception ex) {
				ex.printStackTrace();
			}
		});
		
		f1.setVisible(true); //Keep These Here ONLY ,,WE Get Perfect output
		
		

		
	}
	
		public static void main(String[] args) {
		
			mont[0]="JAN";mont[1]="Feb";mont[2]="Mar";
			mont[3]="Apr";mont[4]="May";mont[5]="Jun";
			mont[6]="July";mont[7]="Agust";mont[8]="Sep";
			mont[9]="Oct";mont[10]="Nov";mont[11]="Dec";
			new main1();
			
	}

}

