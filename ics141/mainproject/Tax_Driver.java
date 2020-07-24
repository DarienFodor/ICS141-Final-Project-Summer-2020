package ics141.mainproject;

import java.util.Scanner;

public class Tax_Driver {


// clean up any extra or redundent code
// bug test
// add a while loop
// make something to create standard decductions
	
	public static void main(String[] args) {
		EIC_Calculator cc3 = new EIC_Calculator();
		BracketCalculator pira = new BracketCalculator();
		
		double myCTC;
		double myEIC;
		double totalIncome, dependents, status, withholdings, taxCredits;
		Scanner reader = new Scanner(System.in);  
		
		System.out.println("Enter your total gross income: ");
		totalIncome = reader.nextDouble();
		System.out.println("Enter number of dependents: ");
		dependents = reader.nextDouble();
		System.out.println("Enter your total withholdings: ");
		withholdings = reader.nextDouble();
		System.out.println("Enter your any extraneous taxCredits (not including earned income credit or child credit): ");
		taxCredits = reader.nextDouble();
		System.out.println("Enter your filing status, 0 for single, 1 for head of household,  2 for joint married, and 3 for Married seperate: ");
		status = reader.nextDouble();
		
		TaxInfo UserInfo = new TaxInfo(totalIncome, taxCredits, withholdings,  status, dependents);
		
		myEIC = cc3.getEIC(UserInfo);
		System.out.println("Your earned income credit is: $" + myEIC);
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
		
		// is theis reader.close required?
		reader.close();

	}

}
