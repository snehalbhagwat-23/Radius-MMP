package org.iit.healthcare.utility;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class AppLibrary {
	static Random rand= new Random();
	
	public static String getFutureDate(int days,String pattern)
	{
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE, days);
		Date d = cal.getTime();
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		String date = sdf.format(d);
		return date;
	}
	
	
	
	public static String selectFutureDate(int days){
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DAY_OF_MONTH, days);
		Date date= cal.getTime();
		System.out.println(date);
		SimpleDateFormat sdf =new SimpleDateFormat("MM/dd/YYYY");
		String formatdate = sdf.format(date);
		System.out.println(formatdate);
		return formatdate;	
		
		
	}
	
	public static String getRandomString(int noOfChars)
	{

		Random rand = new Random();
		String s = "";
		int bound = noOfChars;
		//char[] charArray = new char[bound];
		for(int i=0; i<bound; i++)
		{
			char c = (char) ('a'+rand.nextInt(26));
			s = s+c;
		}
		System.out.println("getRandomString Method returning "+s);
		return s;
			}
	public static String getRandom(int number,int range){
		 Random rand= new Random();
		 
		String str= "";
		for(int i=0;i<number;i++){
			str=str+12;
			System.out.println(str);
			
		}
		return str+rand.nextInt(range);	
	}
		
		public static int getRandomNoOfDigits(int noOfDigits){
			
			rand = new Random();
			int addend1=0, addend2=0; String zero ="";String bound = "";int result=0;
			for(int i=1;i<=(noOfDigits-1); i++){
				zero = zero+0;
			}
			zero = 1+zero;
			addend1 = Integer.parseInt(zero);
			for (int j=1; j<=(noOfDigits-1); j++){
				bound = bound+9;
			}
			bound = 8+bound;
			addend2 = Integer.parseInt(bound);
			result = addend1+ rand.nextInt(addend2);
			System.out.println("Random "+noOfDigits+ " digit number is : "+result);
			return result;
			
	}
	public static String getRandomState(){
		String state="";
		String[] stateArray= {"Alabama", "Alaska", "Arizona", "Arkansas", "California", "Colorado", "Connecticut", "Delaware", "Florida", "Georgia",
				"Hawaii", "Idaho", "Illinois", "Indiana", "Iowa", "Kansas", "Kentucky", "Louisiana", "Maine","Maryland", "Massachusetts", "Michigan",
				"Minnesota", "Mississippi", "Missouri", "Montana", "Nebraska", "Nevada", "New Hampshire", "New Jersey", "New Mexico", "New York",
				"North Carolina", "North Dakota", "Ohio", "Oklahoma", "Oregon", "Pennsylvania", "Rhode Island", "South Carolina", "South Dakota",
				"Tennessee", "Texas", "Utah", "Vermont", "Virginia", "Washington", "West Virginia", "Wisconsin", "Wyoming" };
		int num= rand.nextInt(49);
		state= stateArray[num];
		System.out.println(state);
		return state;
		
		
	}
}
