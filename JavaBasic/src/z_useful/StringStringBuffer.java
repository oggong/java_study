package z_useful;

/*
	자바에서 문자열 처리하는 클래스
	1. String
	2. StringBuffer
	3. StringBuilder = StringBuffer (99% 동일 - 1 % 다른점 )
*/
public class StringStringBuffer {

	public static void main(String[] args) {

		String s = "안녕";
		s += "하세요";
		System.out.println(s);

		StringBuffer sb = new StringBuffer("반갑"); // new 로 받아주는 게 정상임. String 도

		sb.append("습니다.");
		System.out.println(sb);

	}

}
