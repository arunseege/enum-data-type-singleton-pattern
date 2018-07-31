package com.justcode.enumdemo.enumdatatypedemo;

import java.time.MonthDay;
import java.util.EnumMap;
import java.util.EnumSet;

/**
 * Hello world!
 *
 */
public class App 
{
	
	  public  enum Days {SUNDAY (1){

		@Override
		public String asLowerCase() {
			return Days.SUNDAY.toString().toLowerCase();
		}
		  
	  },MONDAY (2) {
		@Override
		public String asLowerCase() {
			
			return this.toString().toLowerCase();
		}
	},TUESDAY (3) {
		@Override
		public String asLowerCase() {
			// TODO Auto-generated method stub
			return this.toString().toLowerCase();
		}
	},WEDNESDAY (4) {
		@Override
		public String asLowerCase() {
			// TODO Auto-generated method stub
			return this.toString().toLowerCase();
		}
	},THURSDAY (5) {
		@Override
		public String asLowerCase() {
			// TODO Auto-generated method stub
			return this.toString().toLowerCase();
		}
	},FRIDAY (6) {
		@Override
		public String asLowerCase() {
			// TODO Auto-generated method stub
			return this.toString().toLowerCase();
		}
	},SATURDAY (7) {
		@Override
		public String asLowerCase() {
			// TODO Auto-generated method stub
			return this.toString().toLowerCase();
		}
	};
		
		  //we can add fields to java enum.each constant enum value gets these fields
		  private int num = 0;
		  Days(int num){
			  this.num=num;
		  };
		 
		  public String getDayNum(){
			  return "Hi Arun Seege today number is-->"+this.num;
		  }
		  
		  //enum can have abstract methods ,if so then each enum instance must implement it
		  public abstract String asLowerCase(); 
	  };
	  
	  
    public static void main( String[] args )
    {
     
    	  System.out.println(Days.SUNDAY.hashCode());
    	  System.out.println(Days.FRIDAY.hashCode());
    	  
    	  for(Days days:Days.values()){
    		  System.out.println(days+" "+days.hashCode());
    	  }
    	  
    	  Days sunday=Days.valueOf("SUNDAY");
    	  System.out.println("invoking num with enum instance--->"+sunday.num);
    	  System.out.println("invoking name with enum instance--->"+sunday.name());
    	  System.out.println("invoking ordinal with enum instance--->"+Days.FRIDAY.ordinal());
    	  System.out.println("invoking toString with enum instance--->"+sunday.toString());
    	  System.out.println("invoking getDayNum() of enum instance--->"+sunday.getDayNum());
    	  System.out.println("invoking abstract method of enum instance--->"+Days.MONDAY.asLowerCase());
  System.out.println(Days.WEDNESDAY+"  is same as "+Days.WEDNESDAY.toString()); 
  System.out.println("invoking valueOf() to get an instance of enum class-->"+Days.valueOf("THURSDAY"));
  
  
  EnumSet<App.Days> enumsetOfDays = EnumSet.of(Days.SUNDAY,Days.WEDNESDAY,Days.FRIDAY);
//  EnumSet<App.Days> enumsetOfDays = EnumSet.of(e)
  for(Days days:enumsetOfDays){
	  System.out.println(days.num+" "+days.asLowerCase()+" "+days.ordinal());
  }
  
  System.out.println(enumsetOfDays);
  
 EnumMap<Days, String> enummapOfDays = new EnumMap<Days,String>(Days.class);
 for(Days days:Days.values()){
	 enummapOfDays.put(days, days.asLowerCase());
 }
 System.out.println(enummapOfDays);
    }
}
