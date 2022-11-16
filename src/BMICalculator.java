import java.text.DecimalFormat;
import java.util.Scanner;
public class BMICalculator {
    /** Convert English to metric units, perform the BMI calculation.
     * NOTE: this method must properly handle bad data
     * @param inches user's height in inches
     * @param pounds user's weight in pounds
     * @return User's BMI weight(kg)/height(m)^2 a double
     */
    public static double computeBMI(int inches, int pounds) {
        double kgs, meters;
        meters = inches * 0.0254;
        kgs = pounds * 0.454;
        if(kgs <= 0 || meters <= 0)
            return 0.;
        return kgs/(Math.pow(meters, 2));
    }
    /**
     * Uses a scanner to prompt the user for info
     * Process the feet/inches conversion
     * Calls the computeBMI method and prints the correct information
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String userin = new String();
        int inches, pounds;
        DecimalFormat df = new DecimalFormat("0.00");
        while(true) {
            try {
                System.out.print("Enter you height in feet and inches (Ex 6'1\") or 0 to quit: ");
                userin = in.nextLine();
                if(userin.equals("0"))
                    break;
                // sanitize height and convert to inches
                inches = Integer.parseInt(userin.substring(0, userin.indexOf("'"))) * 12 + Integer.parseInt(userin.substring(userin.indexOf("'")+1, userin.length()-1));
             //   System.out.println("DEBUG: " + inches);
                System.out.print("Enter you weight in pounds: ");
                pounds = Integer.parseInt(in.nextLine());
              //  System.out.println("DEBUG: " + pounds);
                System.out.println("Your BMI, expressed as weight(kg)/height(m)^2: " + df.format(computeBMI(inches, pounds)));
            }
            catch(Exception e)  {
                System.out.println("There was an error, see here: " + e);
            }
        }
    }
}