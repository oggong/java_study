package c_control;

public class Ex02_if_학번 {

	public static void main(String[] args) {
		/*
		 * 우리대학의 학번은 총 10자리로 되어 있습니다. 맨 앞의 4자리는 입학년도이고 5번째 문자는 단과대 번호입니다. (charAt() 이용)
		 * 1 : 공대 2 : 사회대 그 뒤의 2자리는 각 학과번호입니다. 공과대학인 경우는 11 : 컴퓨터학과 12 : 소프트웨어학과 13 :
		 * 모바일학과 22 : 자바학과 33 : 서버학과 사회대학인 경우는 11 : 사회학과 12 : 경영학과 13 : 경제학과
		 * 
		 * 공과대학인 경우는 (substring() 이용 ) ex) 2017111001 는 2017년도에 입학한 공대 컴퓨터학과 학생입니다 ex)
		 * 2019211001 는 2019년도에 입학한 사회대 사회학과 학생입니다 ex) 2018133001 는 2018년도에 입학한 공대 서버학과
		 * 학생입니다 .equals 이용 !!! 문자 비교
		 */

		String hakbun = "2017111001";
		String hakyeon = hakbun.substring(0, 4); // 입학년도
		char dan = hakbun.charAt(4); // 단과 구하기
		String dande = "";
		String hak = hakbun.substring(5, 7); // 학과 구하기
		String hakgwa = "";

		if (dan == '1') {
			dande = "공대";
//			if (hak.equals("11")) {
//				hakgwa = "컴퓨터학과";
//			}
			switch (hak) {
			case "11":
				hakgwa = "컴퓨터학과";
				break;
			case "12":
				hakgwa = "소프트웨어학과";
				break;
			case "13":
				hakgwa = "모바일학과";
				break;
			case "22":
				hakgwa = "자바학과";
				break;
			case "33":
				hakgwa = "서버학과";
				break;
			default:
			}

		} else if (dan == '2') {
			dande = "사회대";
			switch (hak) {
			case "11":
				hakgwa = "사회학과";
				break;
			case "12":
				hakgwa = "경영학과";
				break;
			case "13":
				hakgwa = "경제학과";
				break;

			default:
			}

//			if (hak.equals("11")) {
//				hakgwa = "사회학과";
//			}
		}
		System.out.println(hakbun + "님은" + hakyeon + "년에 입학한 " + dande + " " + hakgwa + "학생입니다.");
	}

}