import java.util.*;
import java.io.*;

/**
 * This daterange class contains
 * a range of two dates<br>
 * @author Felix
 *
 */
public class DateRange {
	
	private Date date1;
	private Date date2;
	
	/**
	 * This method creates a daterange
	 * object between two dates<br>
	 * @param date1
	 * @param date2
	 */
	public DateRange(Date date1, Date date2) {
		super();
		this.date1 = date1;
		this.date2 = date2;
	}
	
	/**
	 * 
	 */
	public String toString() {
		return "DateRange: " + date1 + " - " + date2;
	}

}
