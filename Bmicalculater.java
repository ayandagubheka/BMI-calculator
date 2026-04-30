/**
*@author Ayanda
**/
//package bmicalculate;
import java.util.Locale;	
import java.util.Scanner;


public class Bmicalculater{	
	
	
	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);
		scanner.useLocale(Locale.US);
		
		String name;
		String surname;
		System.out.println("WELCOME TO BMI CALCULATOR");
		System.out.println("ENTER YOUR NAME:");
		name = scanner.nextLine();
		System.out.println("ENTER YOUR SURNAME:");
		surname = scanner.nextLine();
		char repeat = 0;
		
		do{
			// all our code
			int unitChoice = getUnitChoice(scanner);
			
			double weight = (unitChoice == 1)? getValidInput(scanner, "Enter your weight in kilograms : ",10,600):
			getValidInput(scanner, "Enter your weight in pounds",22, 1300);
			
			double height =(unitChoice == 1)? getValidInput(scanner, "Enter your height in meters :",0.5, 2.5)
			:getValidInput(scanner, "Enter your weight in inches",20, 100);
			
			double bmi = calculateBMI(unitChoice, weight, height);
			
			
			System.out.println("BMI IS "+ bmi);
			
			if(bmi < 18.5){
				System.out.println(name+" "+ surname +" YOU ARE UNDERWEIGHT");
			}else if(bmi < 25){
				System.out.println(name+" "+ surname +" YOU ARE NORMAL WEIGHT");
			}else if(bmi < 30){
				System.out.println(name+" "+ surname +" YOU ARE OVERWEIGHT");
			}else{
				System.out.println(name+" "+ surname +" YOU ARE OBESE");
			}
            System.out.println("Take care of yourself.");
			
			//repeat = askToRepeat(scanner);
			System.out.println();
			
		}while (repeat == 'Y' || repeat == 'y');
		
	}
//unit - Metric and Imperial
public static int getUnitChoice(Scanner scanner){
	int choice;
	
	while(true){
		System.out.println("Select a preferred unit:\n"
		+ "1. Metric (kg, m)\ne"
		+ "2. Imperial (lbs, in)\n"
		+"3.please select either ");
		
		if(scanner.hasNextInt()){
			choice = scanner.nextInt();
			if(choice == 1 || choice == 2){
				break;
			}else{
				System.out.println("Invalid choice. PLease enter either 1 or 2");
			}
		}else{
			System.out.println("Invalid input. Please enter a number (1 or 2");
			scanner.next();
		}
	}
	
	return choice;

}

public static double getValidInput(Scanner scanner, String prompt, double min, double max){
	double value;
	
	while(true){
		System.out.println(prompt);
		
		if(scanner.hasNextDouble()){
			value = scanner.nextDouble();
			if(value >= min && value <= max){
				break;
			}
			else{
				System.out.printf("Please enter a value between %.1f and %.1f.\n", min,max);
				scanner.next();
			}
		}
	}
	return value;

	}
	
	public static double calculateBMI(int unitChoice, double weight, double height){
		double totalBMI;
		
		if(unitChoice == 1){
			totalBMI = weight/(height*height);
		}else{
			totalBMI = (703*weight)/(height/height);
		}
	
		
		return totalBMI;
}
	
}
	
