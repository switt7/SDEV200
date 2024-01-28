package Exercise_10_14;

//MyDate

// -year: int                               
// -month: int                              
// -day: int                                
// +MyDate()                                
// +MyDate(elapsedTime: long)               
// +MyDate(year: int, month: int, day: int) 
// +getYear(): int                          
// +getMonth(): int                         
// +getDay(): int                           
// +setDate(elapsedTime: long)              

import java.util.GregorianCalendar;

//Implement MyDate class
public class MyDate {
	// Data Fields
	private int year;
	private int month;
	private int day;

	//Generates a MyDate object for current date
	MyDate() {
		GregorianCalendar calander = new GregorianCalendar();
		year = calander.get(GregorianCalendar.YEAR);
		month = calander.get(GregorianCalendar.MONTH);
		day = calander.get(GregorianCalendar.DAY_OF_MONTH);
	}

	//Generates a MyDate object with a specific elapsed time since
	//midnight, January 1, 1970, in milliseconds 
	MyDate(long elapsedTime) {
		setDate(elapsedTime);
	}

	//Generates a MyDate object with the specific year, month, and day
	MyDate(int year, int month, int day) {
		this.year = year;
		this.month = month;
		this.day = day;
	}

	//Return year 
	public int getYear() {
		return year;
	}

	//Return month 
	public String getMonth() {
		String m = String.valueOf(month + 1);
		return (month < 10 ? "0" + m : m);
	}

	//Return day 
	public String getDay() {
		String d = String.valueOf(day);
		return (day < 10 ? "0" + d : d);
	}

	//This sets a new date for object that is using the elapsed time 
	public void setDate(long elapsedTime) {
		GregorianCalendar calander = new GregorianCalendar();
		calander.setTimeInMillis(elapsedTime);
		year = calander.get(GregorianCalendar.YEAR);
		month = calander.get(GregorianCalendar.MONTH);
		day = calander.get(GregorianCalendar.DAY_OF_MONTH);
	} 
}
    

