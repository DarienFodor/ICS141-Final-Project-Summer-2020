package mainproject;

import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class EIC_Tester {


// clean up any extra or redundent code Jason Jorgenson 7-27-20 I did my best it was like 2 things 
// bug test
// add a while loop Done Jason Jorgenson 7-27-20
// make something to create standard decductions(that used to calculate the AGI, just make a method to calculate it, based on filing status)
// 
	
	public static void main(String[] args) {
		//Jason Jorgenson 7-27-20
		//Below is the first set for done in the while loop.
		boolean done = false;
		while(!done) {
		EIC_Calculator cc3 = new EIC_Calculator();
		BracketCalculator pira = new BracketCalculator();
		
		//double myCTC;
		//double myEIC;
		//Jason Jorgenson 7-27-20 they are both doubles so we can define them with the others. See below
		double myCTC,myEIC,totalIncome, dependents, status, withholdings, taxCredits;
		 
		//Jason Jorgenson 7-27-20 replaced with Scanner
		
		Scanner in = new Scanner(System.in);
		System.out.println("Enter your total gross income: ");
		totalIncome = in.nextDouble();
		System.out.println("Enter number of dependents: ");
		dependents = in.nextDouble();
		System.out.println("Enter your total withholdings: ");
		withholdings = in.nextDouble();
		System.out.println("Enter your any extraneous taxCredits (not including earned income credit or child credit): ");
		taxCredits = in.nextDouble();
		System.out.println("Enter your filing status, 0 for single, 1 for head of household,  2 for joint married, and 3 for Married seperate: ");
		status = in.nextDouble();
		
		TaxInfo UserInfo = new TaxInfo(totalIncome, taxCredits, withholdings,  status, dependents);
		
		myEIC = cc3.getEIC(UserInfo);
		System.out.println("\n" + "Your earned income credit is: $" + myEIC);
		myCTC = cc3.getCtc(UserInfo.getDep());
		System.out.println("Your child tax credit amount is $" + myCTC);
		
		taxCredits = taxCredits + myEIC + myCTC;
		TaxInfo creditDone = new TaxInfo(taxCredits, UserInfo);
		// adds the correct tax credits
		double AdjustedGrossIncome = creditDone.AGIcalculator();
		TaxInfo CalcInfo = new TaxInfo(creditDone, AdjustedGrossIncome);
		// calulates adjust gross income, then puts it into the object
		long taxesOwed = pira.tax_Bracket(CalcInfo);
		TaxInfo CompletedInfo = new TaxInfo(CalcInfo, taxesOwed);
		
		System.out.println(CompletedInfo.toString());
		
		//Jason Jorgenson 7-27-20 created output to File. 
		
		try {
			  File desktop = new File(System.getProperty("user.home"), "Desktop");
			  Scanner save = new Scanner(System.in);
			  System.out.println("Would you like to save this to your desktop? Yes or No");
			  String str = save.nextLine();
			  if (str.equalsIgnoreCase("Yes")) {
			      FileWriter myWriter = new FileWriter(desktop + "\\TaxFiling.txt");
			      myWriter.write(CompletedInfo.toString());
			      myWriter.close();
			      System.out.println("Successfully wrote to the file.");
			  }
		    } catch (IOException e) {
		      System.out.println("Error writing to file. Please try the program again");
		    }
		
		// is theis reader.close required? 
		
		//Jason Jorgneson 7-27-20
		//I did not find a use for the reader.close. I updated it to just use scanner inputs. 
		//Below is the variable set for done in the while loop. 
		
		Scanner exit = new Scanner(System.in);
        System.out.println("Please enter a string('q' to exit): ");
        String str = exit.nextLine();
        if (str.equalsIgnoreCase("q")) {
        	done = true;}
	}
		
		
		
	}

}
