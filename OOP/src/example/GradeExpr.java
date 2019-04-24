package example;

public class GradeExpr {

	int jumsu[]; // 10, 20, 30

	public GradeExpr(int[] jumsu) {
		this.jumsu = jumsu;
	}

	public double getAverage() {
		double avg;
		double total2 = 0;
		for (int i = 0; i < jumsu.length; i++) {
			total2 += jumsu[i];
		}
		return avg = total2 / jumsu.length;

	}

	public int getTotal() {
		int total = 0;
		for (int i = 0; i < jumsu.length; i++) {
			total += jumsu[i];
		}
		return total;
	}

	public int getGoodScore() {
		int max = jumsu[0];

		for (int i = 0; i < jumsu.length; i++) {
			if (max <= jumsu[i]) {
				max = jumsu[i];
			}

		}
		return max;
	}

	public int getBadScore() {
		int min = jumsu[0];

		for (int i = 0; i < jumsu.length; i++) {
			if (min >= jumsu[i]) {
				min = jumsu[i];
			}

		}
		return min;
	}

}
