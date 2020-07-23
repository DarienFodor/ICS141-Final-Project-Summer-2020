import java.lang.annotation.Inherited;
import java.util.Scanner;

public class EIC_Tester {
Inherited CreditCalc3;
	public static void main(String[] args) {
		CreditCalc3 cc3 = new CreditCalc3();
		double myCTC;
		double myEIC;
		double income;
		double dependents;
		double status;
		Scanner reader = new Scanner(System.in);  
		
		System.out.println("Enter your gross income: ");
		income = reader.nextDouble();
		
		System.out.println("Enter number of dependents: ");
		dependents = reader.nextDouble();
		
		System.out.println("Enter your filing status, 1 for single, 2 for married: ");
		status = reader.nextDouble();

		myEIC = cc3.getEic(income, dependents, status);
		System.out.println("Your earned income credit is: $" + myEIC);
		
		myCTC = cc3.getCtc(dependents);
		System.out.println("Your child tax credit amount is $" + myCTC);
		
		reader.close();

	}

}
