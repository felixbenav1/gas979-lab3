import java.util.Scanner;
import java.util.*;
import java.io.*;

/**
 * Lab3 grabs dates from dates.txt
 * and sends creates date and
 * daterange objects<br>
 * @author Felix
 *
 */
public class Lab3 {

	/**
	 * main method grabs dates from
	 * dates.txt and uses the date
	 * and daterange classes to create
	 * those objects accordingly<br>
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner in = null;
		try {
			in = new Scanner(new File("dates.txt"));
		} catch (FileNotFoundException exception) {
			System.err.println("failed to open dates.txt");
			System.exit(1);
		}

		ArrayList<Date> dates = new ArrayList<Date>();

		while (in.hasNextLine()) {
			String line = in.nextLine();
			Date date = new Date(line);
			dates.add(date);
			// System.out.println(date);
			// need more code for DateRange objects
		}

		processData(dates);

	}

	/**
	 * processData gets dates from an
	 * ArrayList and creates dateranges and/
	 * or prints out these objects<br>
	 * @param dates
	 */
	public static void processData(ArrayList<Date> dates) {
		int j;
		for (int i = 0; i < dates.size(); i++) {
			//check if first date in list
			if (i == 0 && !dates.get(i).getMonth().equals("NULL")) {
				System.out.println(dates.get(i));
			} else if (dates.get(i).getMonth().equals("NULL") ) {
				//date has null month meaning it is invalid
				System.out.println("Invalid Date");
			} else {
				//print valid date and create possible daterange
				// object with previous date
				System.out.println(dates.get(i));
				if (!dates.get(i - 1).getMonth().equals("NULL")) {
					j = dates.get(i - 1).compareTo(dates.get(i));
					if (j == -1) {
						DateRange daterng = new DateRange(dates.get(i - 1), dates.get(i));
						System.out.println(daterng);
					}
				}
			}
		}
	}

}
