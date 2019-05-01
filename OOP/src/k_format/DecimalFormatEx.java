package k_format;

import java.text.DecimalFormat;

public class DecimalFormatEx {

	public static void main(String[] args) {

		double[] data = { 1, 234, 5613, 555555.123, 99.999999, 1234.50 };

		DecimalFormat df = new DecimalFormat("###,###,###.#########");

		for (int i = 0; i < data.length; i++) {
			System.out.println(df.format(data[i]));
		}
	}

}
