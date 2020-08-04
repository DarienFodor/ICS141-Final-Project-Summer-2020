package ics141.mainproject;

public class TaxInfo {

		private double agi;
		private double sts;
		private double total;
		private double credit;
		private double withhold;
		private double dep;
		private long payment;
		//initial constucter #1
		public TaxInfo(double TotalIncome, double TaxCredits, double withholdings, double status, double dependents) {
			dep = dependents;
			withhold = withholdings;
			credit = TaxCredits;
			total = TotalIncome;
			sts = status;
			agi = 0;
			payment = 0;	
		}
		//Adds agi to the object #3
		public TaxInfo(TaxInfo OldTaxinfo, double AdjustedGrossIncome) {
			dep = OldTaxinfo.dep;
			withhold = OldTaxinfo.withhold;
			credit = OldTaxinfo.credit;
			total = OldTaxinfo.total;
			sts = OldTaxinfo.sts;
			agi = AdjustedGrossIncome;
			payment = OldTaxinfo.payment;
		}
		//adds the tax credit #2
		public TaxInfo(double taxCredits, TaxInfo OldTaxinfo) {
			dep = OldTaxinfo.dep;
			withhold = OldTaxinfo.withhold;
			credit = taxCredits;
			total = OldTaxinfo.total;
			sts = OldTaxinfo.sts;
			agi = OldTaxinfo.agi;
			payment = OldTaxinfo.payment;
		}
		//adds the taxes owed $4
		public TaxInfo(TaxInfo OldTaxinfo, long taxesOwed) {
			dep = OldTaxinfo.dep;
			withhold = OldTaxinfo.withhold;
			credit = OldTaxinfo.credit;
			total = OldTaxinfo.total;
			sts = OldTaxinfo.sts;
			agi = OldTaxinfo.agi;
			payment = taxesOwed;
		}
		//these all do exactly what you would guess.
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
			//name is a little ambiguous, payment is towards the IRS. That means this would be taxOwed
		}

		//This calculates the standard deduction. It's what 90% of Americans use.
		private double StanDeduct() {
			double deduct = 0;
			if (sts == 0 || sts == 3) {
				//Single, married seperate
				deduct = 12400;
			}
			if (sts== 1) {
				//HOH
				deduct = 18650;
				}
			if (sts== 2) {
				//Married, Joint
				deduct = 24800;
				}
			return deduct;
		}
		//Name is self explanatory
		public double AGIcalculator() {
			double AdjustedGrossIncome = total - (withhold + StanDeduct());
			return AdjustedGrossIncome;
		}	
		
		//Creates the final outputted string 
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
			return "Total income is " + total + "\n" + "Filling status: " + status + "\n" +"Total dependents: " + dep + "\n" + "Total withholdings: " + withhold + "\n" + "Total tax credits: " + credit + "\n"
					+ "Adjusted gross income: " + agi + "\n" + "\n" +"The final payment owed to the IRS is estimated at $" + payment + "\n";
		}
}		
