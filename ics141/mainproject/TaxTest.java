package ics141.mainproject;

public class TaxTest {
	public static void main(String[] args) {
	TaxInfo John = new TaxInfo(1000000.0, "Single");
	System.out.println(John.tax_bracket());
	}
}