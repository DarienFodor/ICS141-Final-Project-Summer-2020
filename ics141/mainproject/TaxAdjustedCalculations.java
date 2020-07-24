package ics141.mainproject;

public class TaxAdjustedCalculations {
	private double deduction, AGI;
	//single = 1, married joint = 2, 
	
	public double AdjustedCalc(double TotalIncome, double TaxCredits, double withholdings, long status) {
		deduction = StandardDeduction(status);
		TaxCredits = TaxCredits + getEIC(TotalIncome);
		AGI = TotalIncome - (TaxCredits + deduction + withholdings);
		return AGI; 
	}
	private double getEIC(double totalIncome) {
		return 0;
	}
	private double StandardDeduction(long status) {
		return 0;
		}
}
