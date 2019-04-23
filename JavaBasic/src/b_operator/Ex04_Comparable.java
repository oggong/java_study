package b_operator;

/*
 * 비교 연산자 : > <  >= <= , == !=
 * 
*/

public class Ex04_Comparable {

	public static void main(String[] args) {

		int k = 100, e = 100, m = 100;
		double avg = (double) (k + e + m) / 3; // 소수점까지 보여주려면 casting 해줘야 함

		System.out.println("평균:" + avg);

		/*
		 * ------ 높은 점수 부터 써줘야 함 if (avg > 70) { System.out.println("c학점 입니다."); } else
		 * if (avg >= 80) { System.out.println("b학점 입니다."); } else if (avg >= 90) {
		 * System.out.println("a학점 입니다."); }
		 */

		/*
		 * if (avg >= 90) { System.out.println("a학점 입니다."); } else if (avg >= 80) {
		 * System.out.println("b학점 입니다."); } else if (avg > 70) {
		 * System.out.println("c학점 입니다."); }
		 */

		// double로 결과를 낸 평균 값을 10으로 나누고 int 형으로 바꿔주기

		String score = "";

		switch ((int) (avg / 10)) {
		case 10: // 이것이 없을 경우 F학점으로 나옴!!

		case 9:
			score = "A학점";
			break;
		case 8:
			score = "B학점";
			break;
		case 7:
			score = "C학점";
			break;
		case 6:
			score = "D학점";
			break;
		default:
			score = "F학점";

		}

		System.out.println(score);

	}

}
