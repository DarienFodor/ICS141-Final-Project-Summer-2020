package ics141.mainproject;

public class EIC_Calculator {

	private int eicAmt2;
	private double eicAmt;
	private double ctcAmt;
	private double eicPCT;

	public int getEIC(TaxInfo CurrentTaxInfo) {
//inc = Total gross, dep = dependants
		double status = CurrentTaxInfo.getSts();
		double dep = CurrentTaxInfo.getDep();
		double inc = CurrentTaxInfo.getTotal();
		
		//1 = single and head of house hold? and I think 2 = Married
		if ((status == 0 || status == 1) && dep == 0) {
			if (inc > 7029 && inc < 8791) {
				eicAmt = 538;
			}
			else if (inc > 0 && inc < 7030) {
				eicPCT = (inc * 100) / 7030;
				eicAmt = (538 * eicPCT) / 100;
			}
			else if (inc > 8790 && inc < 15821) {
				inc = inc - 8791;
				eicPCT = (inc * 100) / 7030;
				eicPCT = Math.abs(eicPCT - 100);
				eicAmt = (538 * eicPCT) / 100;
			}
			else {
				eicAmt = 0;
			}}

		else if ((status == 0 || status == 1) && dep == 1) {
			if (inc > 10539 && inc < 19331) {
				eicAmt = 3584;
			}
			else if (inc > 0 && inc < 10540) {
				eicPCT = (inc * 100) / 10540;
				eicAmt = (3584 * eicPCT) / 100;
			}
			else if (inc > 19330 && inc < 41756) {
				inc = inc - 19330;
				eicPCT = (inc * 100) / 22425;
				eicPCT = Math.abs(eicPCT - 100);
				eicAmt = (3584 * eicPCT) / 100;
			}
			else {
				eicAmt = 0;
			}}

		else if ((status == 0 || status == 1) && dep == 2) {
			if (inc > 14800 && inc < 19331) {
				eicAmt = 5920;
			}
			else if (inc > 0 && inc < 14800) {
				eicPCT = (inc * 100) / 14800;
				eicAmt = (5920 * eicPCT) / 100;
			}
			else if (inc > 19330 && inc < 47441) {
				inc = inc - 19330;
				eicPCT = (inc * 100) / 28110;
				eicPCT = Math.abs(eicPCT - 100);
				eicAmt = (5920 * eicPCT) / 100;
			}
			else {
				eicAmt = 0;
			}}

		else if ((status == 0 || status == 1) && dep > 2) {
			if (inc > 14800 && inc < 19331) {
				eicAmt = 6660;
			}
			else if (inc > 0 && inc < 14800) {
				eicPCT = (inc * 100) / 14800;
				eicAmt = (6660 * eicPCT) / 100;
			}
			else if (inc > 19330 && inc < 50955) {
				inc = inc - 19330;
				eicPCT = (inc * 100) / 31624;
				eicPCT = Math.abs(eicPCT - 100);
				eicAmt = (6660 * eicPCT) / 100;
			}
			else {
				eicAmt = 0;
			}}
		
		else if (status == 2 && dep == 0) {
			if (inc > 7029 && inc < 14681) {
				eicAmt = 538;
			}
			else if (inc > 0 && inc < 7030) {
				eicPCT = (inc * 100) / 7030;
				eicAmt = (538 * eicPCT) / 100;
			}
			else if (inc > 14680 && inc < 21710) {
				inc = inc - 14681;
				eicPCT = (inc * 100) / 7030;
				eicPCT = Math.abs(eicPCT - 100);
				eicAmt = (538 * eicPCT) / 100;
			}
			else {
				eicAmt = 0;
			}}
		
		else if (status == 2 && dep == 1) {
			if (inc > 10539 && inc < 25221) {
				eicAmt = 3584;
			}
			else if (inc > 0 && inc < 10540) {
				eicPCT = (inc * 100) / 10540;
				eicAmt = (3584 * eicPCT) / 100;
			}
			else if (inc > 25219 && inc < 47647) {
				inc = inc - 25221;
				eicPCT = (inc * 100) / 22425;
				eicPCT = Math.abs(eicPCT - 100);
				eicAmt = (3584 * eicPCT) / 100;
			}
			else {
				eicAmt = 0;
			}}
		
		else if (status == 2 && dep == 2) {
			if (inc > 14800 && inc < 25221) {
				eicAmt = 5920;
			}
			else if (inc > 0 && inc < 14800) {
				eicPCT = (inc * 100) / 14800;
				eicAmt = (5920 * eicPCT) / 100;
			}
			else if (inc > 25219 && inc < 53331) {
				inc = inc - 25220;
				eicPCT = (inc * 100) / 28110;
				eicPCT = Math.abs(eicPCT - 100);
				eicAmt = (5920 * eicPCT) / 100;
			}
			else {
				eicAmt = 0;
			}}
		
		else if (status == 2 && dep > 2) {
			if (inc > 14800 && inc < 25221) {
				eicAmt = 6660;
			}
			else if (inc > 0 && inc < 14800) {
				eicPCT = (inc * 100) / 14800;
				eicAmt = (6660 * eicPCT) / 100;
			}
			else if (inc > 25219 && inc < 56845) {
				inc = inc - 25220;
				eicPCT = (inc * 100) / 31624;
				eicPCT = Math.abs(eicPCT - 100);
				eicAmt = (6660 * eicPCT) / 100;
			}
			else {
				eicAmt = 0;
			}}
		
		
		else {
			eicAmt = 0;
			System.out.println("Not Eligible");
		}

		eicAmt2 = (int) Math.rint(eicAmt);
		return eicAmt2;
		
	}


	public double getCtc(double dep) {
		if (dep > 0 && dep < 4) {
			ctcAmt = dep * 2000;
		}
		else if (dep > 3) {
			ctcAmt = 6000;
		}
		else {
			ctcAmt = 0;
		}
		return ctcAmt;
	}

}
