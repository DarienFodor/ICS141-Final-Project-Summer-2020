package ics141.mainproject;

public class TaxInfo {
	/*
	 * we ignore personal exemptions and itemized deductions. Work off of Adjusted gross income
	 * need to change all doubles to long + 00, which would get rid of all the float buggery but I didn't occur to me till I was almost done
	 * https://www.irs.gov/taxtopics/tc500
	 * ignore deductibles and base everything off of standard income is my suggestion, but it can go either way
	 * There is a fourth category for taxes(maybe?) which is Married Filily jointly. A qualified widow falls into married joint
	*/
	private double AGI; String STS;
	public TaxInfo(double AdjustedGrossIncome, String status) {
		AGI = AdjustedGrossIncome;
		STS = status;
	}
	public double tax_bracket(){
		double tax_credit = 0;
		// = gross adjusted income
		if (STS.equalsIgnoreCase("Single")) {
			//Single
			tax_credit = bracketSingle();
		}
		if (STS.equalsIgnoreCase("Joint")) {
			//Joint Married
			tax_credit = bracketMarried();
		}
		if (STS.equalsIgnoreCase("HOH")) {
			//Head of household
			tax_credit = bracketHOH();
		}
		return tax_credit;
	}
	//all of the following three functions work on the same basis, take AGI in, find the maximum bracket it fits into, then run it thorugh all brackets.
	public double bracketSingle(){
		double tax_credit = 0, incomeWithinRange = 0; 
		double tempAGI = AGI;
		if (tempAGI > 518400){
			incomeWithinRange = tempAGI - 518400;
			tax_credit = tax_credit + (incomeWithinRange * 0.37);
			tempAGI = 518400;
		}
		if (tempAGI <= 518400 && tempAGI > 207351){
			incomeWithinRange = tempAGI - 207350;
			tax_credit = tax_credit + (incomeWithinRange * 0.35);
			tempAGI = 207350;
		}
		if (tempAGI <= 207350 && tempAGI > 163300){
			incomeWithinRange = tempAGI - 163301;
			tax_credit = tax_credit + (incomeWithinRange * 0.32);
			tempAGI = 163301;
		}
		if (tempAGI <= 163300 && tempAGI > 85525){
			incomeWithinRange = tempAGI - 85525;
			tax_credit = tax_credit + (incomeWithinRange * 0.24);
			tempAGI = 85525;
		}
		if (tempAGI <= 85525 && tempAGI > 40125){
			incomeWithinRange = tempAGI - 40125;
			tax_credit = tax_credit + (incomeWithinRange * 0.22);
			tempAGI = 40125;
		}
		if (tempAGI <= 40126 && tempAGI > 9875){
			incomeWithinRange = tempAGI - 9875;
			tax_credit = tax_credit + (incomeWithinRange * 0.12);
			tempAGI = 9875;
		}
		if (tempAGI <= 9875 && tempAGI > 0) {
			incomeWithinRange = tempAGI - 0;
			tax_credit = tax_credit + (incomeWithinRange * 0.10);
			tempAGI = 0;
			//The redundant 0s are staying in to maintain internal readablity
		}
	
		return tax_credit;
	} 
	public double bracketMarried() {
		double tax_credit = 0, incomeWithinRange = 0; 
		double tempAGI = AGI;
		if (tempAGI > 622050){
			incomeWithinRange = tempAGI - 622050;
			tax_credit = tax_credit + (incomeWithinRange * 0.37);
			tempAGI = 622050;
		}
		if (tempAGI <= 518400 && tempAGI > 414700){
			incomeWithinRange = tempAGI - 414700;
			tax_credit = tax_credit + (incomeWithinRange * 0.35);
			tempAGI = 414700;
		}
		if (tempAGI <= 414700 && tempAGI > 326600){
			incomeWithinRange = tempAGI - 326600;
			tax_credit = tax_credit + (incomeWithinRange * 0.32);
			tempAGI = 326600;
		}
		if (tempAGI <= 326600 && tempAGI > 171050){
			incomeWithinRange = tempAGI - 171050;
			tax_credit = tax_credit + (incomeWithinRange * 0.24);
			tempAGI = 171050;
		}
		if (tempAGI <= 171050 && tempAGI > 80250){
			incomeWithinRange = tempAGI - 80250;
			tax_credit = tax_credit + (incomeWithinRange * 0.22);
			tempAGI = 80250;
		}
		if (tempAGI <= 80250 && tempAGI > 19750){
			incomeWithinRange = tempAGI - 19750;
			tax_credit = tax_credit + (incomeWithinRange * 0.12);
			tempAGI = 19750;
		}
		if (tempAGI <= 19750 && tempAGI > 0) {
			incomeWithinRange = tempAGI - 0;
			tax_credit = tax_credit + (incomeWithinRange * 0.10);
			tempAGI = 0;
			//The redundant 0s are staying in to maintain internal readablity
		}
		return tax_credit;
	}
	public double bracketHOH() {
		double tax_credit = 0, incomeWithinRange = 0; 
		double tempAGI = AGI;
		if (tempAGI > 518400){
			incomeWithinRange = tempAGI - 518400;
			tax_credit = tax_credit + (incomeWithinRange * 0.37);
			tempAGI = 518400;
		}
		if (tempAGI <= 518400 && tempAGI > 207350){
			incomeWithinRange = tempAGI - 207350;
			tax_credit = tax_credit + (incomeWithinRange * 0.35);
			tempAGI = 207350;
		}
		if (tempAGI <= 207350 && tempAGI > 163300){
			incomeWithinRange = tempAGI - 163300;
			tax_credit = tax_credit + (incomeWithinRange * 0.32);
			tempAGI = 163300;
		}
		if (tempAGI <= 163300 && tempAGI > 85500){
			incomeWithinRange = tempAGI - 85500;
			tax_credit = tax_credit + (incomeWithinRange * 0.24);
			tempAGI = 85500;
		}
		if (tempAGI <= 85500 && tempAGI > 53700){
			incomeWithinRange = tempAGI - 53700;
			tax_credit = tax_credit + (incomeWithinRange * 0.22);
			tempAGI = 53700;
		}
		if (tempAGI <= 53700 && tempAGI > 14100){
			incomeWithinRange = tempAGI - 14100;
			tax_credit = tax_credit + (incomeWithinRange * 0.12);
			tempAGI = 14100;
		}
		if (tempAGI <= 14100 && tempAGI > 0) {
			incomeWithinRange = tempAGI - 0;
			tax_credit = tax_credit + (incomeWithinRange * 0.10);
			tempAGI = 0;
			//The redundant 0s are staying in to maintain internal readablity
		}
		return tax_credit;
	}
}

