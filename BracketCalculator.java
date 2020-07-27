package mainproject;

public class BracketCalculator {
	public long tax_Bracket(TaxInfo bracketInfo){
		double taxes_owed = 0;
		// = gross adjusted income
		double status = bracketInfo.getSts(); 
		if (status == (0)) {
			//Single
			taxes_owed = bracketSingle(bracketInfo);
		}
		if (status == 1 ) {
			//Joint Married
			taxes_owed = bracketMarriedJoint(bracketInfo);
		}
		if (status == (2)) {
			//Head of household
			taxes_owed = bracketHOH(bracketInfo);
		}
		if (status == (3)) {
			//Married seperate
			taxes_owed = bracketMarriedSeperate(bracketInfo);
		}
		taxes_owed = taxes_owed - bracketInfo.getCredit();
		long payment = Math.round(taxes_owed);
		return payment;
	}
	
	//all of the following three functions work on the same basis, take agi in, find the maximum bracket it fits into, then run it thorugh all brackets.
	private double bracketSingle(TaxInfo bracketInfo){
		double taxes_owed = 0, incomeWithinRange = 0; 
		double tempagi = bracketInfo.getAgi();
		if (tempagi > 518400){
			incomeWithinRange = tempagi - 518400;
			taxes_owed = taxes_owed + (incomeWithinRange * 0.37);
			tempagi = 518400;
		}
		if (tempagi <= 518400 && tempagi > 207351){
			incomeWithinRange = tempagi - 207350;
			taxes_owed = taxes_owed + (incomeWithinRange * 0.35);
			tempagi = 207350;
		}
		if (tempagi <= 207350 && tempagi > 163300){
			incomeWithinRange = tempagi - 163301;
			taxes_owed = taxes_owed + (incomeWithinRange * 0.32);
			tempagi = 163301;
		}
		if (tempagi <= 163300 && tempagi > 85525){
			incomeWithinRange = tempagi - 85525;
			taxes_owed = taxes_owed + (incomeWithinRange * 0.24);
			tempagi = 85525;
		}
		if (tempagi <= 85525 && tempagi > 40125){
			incomeWithinRange = tempagi - 40125;
			taxes_owed = taxes_owed + (incomeWithinRange * 0.22);
			tempagi = 40125;
		}
		if (tempagi <= 40126 && tempagi > 9875){
			incomeWithinRange = tempagi - 9875;
			taxes_owed = taxes_owed + (incomeWithinRange * 0.12);
			tempagi = 9875;
		}
		if (tempagi <= 9875 && tempagi > 0) {
			incomeWithinRange = tempagi - 0;
			taxes_owed = taxes_owed + (incomeWithinRange * 0.10);
			tempagi = 0;
			//The redundant 0s are staying in to maintain internal readablity
		}
	
		return taxes_owed;
	} 
	private double bracketMarriedJoint(TaxInfo bracketInfo) {
		double taxes_owed = 0, incomeWithinRange = 0; 
		double tempagi = bracketInfo.getAgi();
		if (tempagi > 622050){
			incomeWithinRange = tempagi - 622050;
			taxes_owed = taxes_owed + (incomeWithinRange * 0.37);
			tempagi = 622050;
		}
		if (tempagi <= 622050 && tempagi > 414700){
			incomeWithinRange = tempagi - 414700;
			taxes_owed = taxes_owed + (incomeWithinRange * 0.35);
			tempagi = 414700;
		}
		if (tempagi <= 414700 && tempagi > 326600){
			incomeWithinRange = tempagi - 326600;
			taxes_owed = taxes_owed + (incomeWithinRange * 0.32);
			tempagi = 326600;
		}
		if (tempagi <= 326600 && tempagi > 171050){
			incomeWithinRange = tempagi - 171050;
			taxes_owed = taxes_owed + (incomeWithinRange * 0.24);
			tempagi = 171050;
		}
		if (tempagi <= 171050 && tempagi > 80250){
			incomeWithinRange = tempagi - 80250;
			taxes_owed = taxes_owed + (incomeWithinRange * 0.22);
			tempagi = 80250;
		}
		if (tempagi <= 80250 && tempagi > 19750){
			incomeWithinRange = tempagi - 19750;
			taxes_owed = taxes_owed + (incomeWithinRange * 0.12);
			tempagi = 19750;
		}
		if (tempagi <= 19750 && tempagi > 0) {
			incomeWithinRange = tempagi - 0;
			taxes_owed = taxes_owed + (incomeWithinRange * 0.10);
			tempagi = 0;
			//The redundant 0s are staying in to maintain internal readablity
		}
		return taxes_owed;
	}
	private double bracketHOH(TaxInfo bracketInfo) {
		double taxes_owed = 0, incomeWithinRange = 0; 
		double tempagi = bracketInfo.getAgi();
		if (tempagi > 518400){
			incomeWithinRange = tempagi - 518400;
			taxes_owed = taxes_owed + (incomeWithinRange * 0.37);
			tempagi = 518400;
		}
		if (tempagi <= 518400 && tempagi > 207350){
			incomeWithinRange = tempagi - 207350;
			taxes_owed = taxes_owed + (incomeWithinRange * 0.35);
			tempagi = 207350;
		}
		if (tempagi <= 207350 && tempagi > 163300){
			incomeWithinRange = tempagi - 163300;
			taxes_owed = taxes_owed + (incomeWithinRange * 0.32);
			tempagi = 163300;
		}
		if (tempagi <= 163300 && tempagi > 85500){
			incomeWithinRange = tempagi - 85500;
			taxes_owed = taxes_owed + (incomeWithinRange * 0.24);
			tempagi = 85500;
		}
		if (tempagi <= 85500 && tempagi > 53700){
			incomeWithinRange = tempagi - 53700;
			taxes_owed = taxes_owed + (incomeWithinRange * 0.22);
			tempagi = 53700;
		}
		if (tempagi <= 53700 && tempagi > 14100){
			incomeWithinRange = tempagi - 14100;
			taxes_owed = taxes_owed + (incomeWithinRange * 0.12);
			tempagi = 14100;
		}
		if (tempagi <= 14100 && tempagi > 0) {
			incomeWithinRange = tempagi - 0;
			taxes_owed = taxes_owed + (incomeWithinRange * 0.10);
			tempagi = 0;
			//The redundant 0s are staying in to maintain internal readablity
		}
		return taxes_owed;
	}
	private double bracketMarriedSeperate(TaxInfo bracketInfo) {
		double taxes_owed = 0, incomeWithinRange = 0; 
		double tempagi = bracketInfo.getAgi();
		if (tempagi > 311025){
			incomeWithinRange = tempagi - 311025;
			taxes_owed = taxes_owed + (incomeWithinRange * 0.37);
			tempagi = 311025;
		}
		if (tempagi <= 311025 && tempagi > 207350){
			incomeWithinRange = tempagi - 207350;
			taxes_owed = taxes_owed + (incomeWithinRange * 0.35);
			tempagi = 207350;
		}
		if (tempagi <= 207350 && tempagi > 163300){
			incomeWithinRange = tempagi - 163300;
			taxes_owed = taxes_owed + (incomeWithinRange * 0.32);
			tempagi = 163300;
		}
		if (tempagi <= 163300 && tempagi > 85525){
			incomeWithinRange = tempagi - 85525;
			taxes_owed = taxes_owed + (incomeWithinRange * 0.24);
			tempagi = 85525;
		}
		if (tempagi <= 85525 && tempagi > 40125){
			incomeWithinRange = tempagi - 40125;
			taxes_owed = taxes_owed + (incomeWithinRange * 0.22);
			tempagi = 40125;
		}
		if (tempagi <= 40125 && tempagi > 9875){
			incomeWithinRange = tempagi - 9875;
			taxes_owed = taxes_owed + (incomeWithinRange * 0.12);
			tempagi = 9875;
		}
		if (tempagi <= 9875 && tempagi > 0) {
			incomeWithinRange = tempagi - 0;
			taxes_owed = taxes_owed + (incomeWithinRange * 0.10);
			tempagi = 0;
			//The redundant 0s are staying in to maintain internal readablity
		}
	
		return taxes_owed;
	}


}
