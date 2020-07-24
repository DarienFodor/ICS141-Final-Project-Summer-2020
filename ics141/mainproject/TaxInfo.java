package ics141.mainproject;

public class TaxInfo {
	/*
     * we ignore personal exemptions and itemized deductions. Work off of Adjusted gross income
	 * need to change all doubles to long + 00, which would get rid of all the float buggery but I didn't occur to me till I was almost done
	 * https://www.irs.gov/taxtopics/tc500
	 * ignore deductibles and base everything off of standard income is my suggestion, but it can go either way
	 * There is a fourth category for taxes(maybe?) which is Married Filily jointly. A qualified widow falls into married joint
	income - standard deduct, withholdings, any tax credits, EIC
	*/
	
	private double agi;
	private double sts;
	private double total;
	private double credit;
	private double withhold;
	private double dep;
	private long payment;
	public TaxInfo(double TotalIncome, double TaxCredits, double withholdings, double status, double dependents) {
		dep = dependents;
		withhold = withholdings;
		credit = TaxCredits;
		total = TotalIncome;
		sts = status;
		agi = 0;
		payment = 0;
		
	}
	public TaxInfo(TaxInfo OldTaxinfo, double AdjustedGrossIncome) {
		dep = OldTaxinfo.dep;
		withhold = OldTaxinfo.withhold;
		credit = OldTaxinfo.credit;
		total = OldTaxinfo.total;
		sts = OldTaxinfo.sts;
		agi = AdjustedGrossIncome;
		payment = OldTaxinfo.payment;
	}
	
	public TaxInfo(double taxCredits, TaxInfo OldTaxinfo) {
		dep = OldTaxinfo.dep;
		withhold = OldTaxinfo.withhold;
		credit = taxCredits;
		total = OldTaxinfo.total;
		sts = OldTaxinfo.sts;
		agi = OldTaxinfo.agi;
		payment = OldTaxinfo.payment;
	}

	public TaxInfo(TaxInfo OldTaxinfo, long taxesOwed) {
		dep = OldTaxinfo.dep;
		withhold = OldTaxinfo.withhold;
		credit = OldTaxinfo.credit;
		total = OldTaxinfo.total;
		sts = OldTaxinfo.sts;
		agi = OldTaxinfo.agi;
		payment = taxesOwed;
	}
	
	public double getTotal() {
		return total;
	}
	public double getCredit() {
		return credit;
	}
	public double getWithhold() {
		return withhold;
	}
	public double getSts() {
		return sts;
	}
	public double getDep() {
		return dep;
	}
	public double getAgi() {
		return agi;
	}
	public double getPayment() {
		return payment;
	}
	
	public double AGIcalculator() {
		double StanDeduct = 0;
		double AdjustedGrossIncome = total - (withhold + StanDeduct + credit);
		return AdjustedGrossIncome;
	}
		
	
	
	public String toString() {
		String status = null;
		if (sts == 0) {
			status = "Single";
			}
		if (sts == 1) {
			status = "Head of household";
			}
		if (sts == 2) {
			status = "Married filling jointly";}
		if (sts == 3){
			status = "Married filling seperate";}
		return "Total income is " + total + " Filling status: " + status +" Total dependents: " + dep + " Total withholdings: " + withhold + " Total tax credits: " + credit 
				+ " Adjusted gross income: " + agi + " and the final payment owed to the IRS is estimated at $" + payment;
	}
}



