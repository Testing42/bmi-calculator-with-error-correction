package edu.cscc;
import java.util.Scanner;


public class Main {

    final static double LBS_TO_KGS = 2.2046;
    final static double IN_TO_M = 39.37;
    private static Scanner input = new Scanner(System.in);
    private static final String INPUT_ERROR = "Input is not valid, try again";

    public static void main(String[] args) {
        double lbs, inches, meters, kgs, bmi;
        String classification;


            System.out.println("Calculate BMI");
            lbs = inputWeight();
            inches = inputHeight();

        kgs = convertToKilograms(lbs);
        meters = convertToMeters(inches);
        bmi = calcBMI(meters, kgs);
        classification = bmiClassification(bmi);
        System.out.println("Your BMI is " + bmi);
        System.out.println("Your BMI classification is " + classification);
    }

        private static Double inputWeight() {
            double lbs = 0;
            do {
                System.out.print("Enter weight in lbs: ");
                try {
                    String weightIN = input.nextLine();
                    lbs = Double.parseDouble(weightIN);
                    if(lbs < 1){
                        System.out.println(INPUT_ERROR);
                    }
                } catch (NumberFormatException | NullPointerException e) {
                    System.out.println(INPUT_ERROR);
                }
            } while (lbs == 0 | lbs < 0);
            return lbs;
        }

        private static double inputHeight() {
            double inches = 0;
            do{
                System.out.print("Enter your height in inches: ");
                try {
                    String heightIN = input.nextLine();
                    inches = Double.parseDouble(heightIN);
                    if(inches < 1){
                        System.out.println(INPUT_ERROR);
                    }
                } catch (NumberFormatException | NullPointerException e) {
                    System.out.println(INPUT_ERROR);
                }
            } while (inches == 0 | inches < 0);
            return inches;
        }

    public static double convertToKilograms(double lbs) {
        double kgs = lbs / LBS_TO_KGS;
        return kgs;
    }

    public static double convertToMeters(double inches) {
        double meters = inches / IN_TO_M;
        return meters;
    }


    public static double calcBMI(double meters, double kgs) {
        double bmi;
        bmi = kgs / (meters * meters);
        return bmi;
    }

    public static String bmiClassification(double bmi) {
        String classification = "";
        if (bmi < 18.5) {
            classification = "Underweight";
        } else if (bmi >= 18.5 && bmi < 25) {
            classification = "Healthy weight";
        } else if (bmi >= 25 && bmi < 30) {
            classification = "Overweight";
        } else {
            classification = "Obese";
        }
        return classification;
    }
}
