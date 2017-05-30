package tool;

import java.text.DecimalFormat;
import java.text.NumberFormat;

public class StringAction {
	public static String numberFormat(long num) {
		NumberFormat nf = NumberFormat.getNumberInstance();
		DecimalFormat df = (DecimalFormat)nf;
		df.applyPattern("###,###.###");
		String output = df.format(num);
		
		return output;
	}

	public static void main(String[] args) {
		System.out.println(numberFormat(100000000));
	}
}
