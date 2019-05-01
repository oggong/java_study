package example;

public class GradeExpr {

	static int jumsu[];

	public GradeExpr(int jumsu[]) {
		this.jumsu = jumsu;

	}

	public double getAverage() {
		int total2 = 0;
		double avg = 0;
		for (int i = 0; i < jumsu.length; i++) {
			total2 += jumsu[i];
			avg = total2 / jumsu.length;
		}
		return avg;
	}

	public int getTotal() {
		int total = 0;
		for (int i = 0; i < jumsu.length; i++) {
			total += jumsu[i];
		}
		return total;
	}

	public int getGoodScore() {
		int goodsc = jumsu[0];
		for (int i = 0; i < jumsu.length; i++) {
			if (goodsc <= jumsu[i]) {
				goodsc = jumsu[i];
			}
		}
		return goodsc;
	}

	public int getBadScore() {
		int badsc = jumsu[0];
		for (int i = 0; i < jumsu.length; i++) {
			if (badsc >= jumsu[i]) {
				badsc = jumsu[i];
			}
		}

		return badsc;
	}

}
