package Exercise_6_9;
//Write a class that contains the following two methods://

//Convert from feet to meters//
//public static double footToMeter(double foot)//

// Convert from meters to feet// 
//public static double meterToFoot(double meter)//

//The formula for the conversion is://
//meter = 0.305 * foot//
//foot = 3.279 * meter//

public class Exercise_6_9 {
    //Using main method//
	public static void main(String[] args) {
		//This is the display table layout//
		System.out.println(
			"\nFeet     Meters     |     Meters     Feet\n" +
			"----------------------------------------------");
		for (double feet = 1.0, meters = 20.0; feet <= 10.0; feet++, meters += 5) {
			System.out.printf("%4.1f     ", feet);
			System.out.printf("%6.3f", footToMeter(feet));
			System.out.print("     |     ");
			System.out.printf("%-11.1f", meters);
			System.out.printf("%7.3f\n", meterToFoot(meters));
		}
	}
	
	//This will convert feet to meters//
	public static double footToMeter(double foot) {
		return 0.305 * foot;
	}

	//This will convert meters to feet //
	public static double meterToFoot(double meter) {
		return 3.279 * meter;
	}
}