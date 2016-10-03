import java.util.*;
import java.io.*;

/**
 * This date class parses and
 * contains a date object<br>
 * @author Felix
 *
 */
public class Date implements Comparable<Date> {
	private String month;
	private int monthnum;
	private int day;
	private int year;

	//number of valid days in each month according to array[monthnum]
	private static final int[] DAYS_PER_MONTH = { 0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

	/**
	 * This Date constructor parses a
	 * date string and stores it
	 * in a date object<br>
	 * @param date
	 */
	public Date(String date) {
		super();
		String[] temp = date.split(" ");
		this.year = Integer.parseInt(temp[2]);
		this.day = Integer.parseInt(temp[1].replace(",", ""));
		this.month = temp[0];

		//set appropriate month for object
		if (month.substring(0, 3).equals("Jan")) {
			this.month = "January";
			this.monthnum = 1;
		} else if (month.substring(0, 3).equals("Feb")) {
			this.month = "February";
			this.monthnum = 2;
		} else if (month.substring(0, 3).equals("Mar")) {
			this.month = "March";
			this.monthnum = 3;
		} else if (month.substring(0, 3).equals("Apr")) {
			this.month = "April";
			this.monthnum = 4;
		} else if (month.substring(0, 3).equals("May")) {
			this.month = "May";
			this.monthnum = 5;
		} else if (month.substring(0, 3).equals("Jun")) {
			this.month = "June";
			this.monthnum = 6;
		} else if (month.substring(0, 3).equals("Jul")) {
			this.month = "July";
			this.monthnum = 7;
		} else if (month.substring(0, 3).equals("Aug")) {
			this.month = "August";
			this.monthnum = 8;
		} else if (month.substring(0, 3).equals("Sep")) {
			this.month = "September";
			this.monthnum = 9;
		} else if (month.substring(0, 3).equals("Oct")) {
			this.month = "October";
			this.monthnum = 10;
		} else if (month.substring(0, 3).equals("Nov")) {
			this.month = "November";
			this.monthnum = 11;
		} else if (month.substring(0, 3).equals("Dec")) {
			this.month = "December";
			this.monthnum = 12;
		}
		// catch statement?

		else {
			this.month = "NULL";
			this.monthnum = 1;
		}

		// check if day in range for month
		if (this.day <= 0 || (this.day > DAYS_PER_MONTH[this.monthnum] && !(this.monthnum == 2 && this.day == 29))) {
			this.month = "NULL";
			this.monthnum = 0;
			this.day = 0;
			this.year = 0;
		}

		// check for leap year if month is 2 and day is 29
		if (this.monthnum == 2 && this.day == 29
				&& !(this.year % 400 == 0 || (this.year % 4 == 0 && this.year % 100 != 0))) {
			this.month = "NULL";
			this.monthnum = 0;
			this.day = 0;
			this.year = 0;
		}

	}
	
	/**
	 * compareTo function compares
	 * this object with a date
	 * passed in<br>
	 * @param other<br>
	 * @return -1 if daterange
	 * 0 if dates are equal,
	 * and -1 if daterange is not valid<br>
	 */
	public int compareTo (Date other) {
		if(this.year > other.year){
			return 1;
		}
		else if(this.year < other.year){
			return -1;
		}
		else if(this.monthnum < other.monthnum){
			return -1;
		}
		else if(this.monthnum == other.monthnum && this.day < other.day){
			return -1;
		}
		else if(this.monthnum == other.monthnum && this.day == other.day
				&& this.year == other.year){
			return 0;
		}
		else{
			return 1;
		}
	}

	/**
	 * 
	 * @return
	 */
	public String getMonth() {
		return month;
	}

	/**
	 * 
	 * @return
	 */
	public int getDay() {
		return day;
	}

	/**
	 * 
	 * @return
	 */
	public int getYear() {
		return year;
	}

	/**
	 * 
	 */
	public String toString() {
		return "Date: " + month + " " + day + ", " + year;
	}
}
