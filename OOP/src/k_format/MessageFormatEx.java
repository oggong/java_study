package k_format;

import java.text.MessageFormat;

public class MessageFormatEx {

	public static void main(String[] args) {

		String message = "오늘 점심은 <{0}> {1}님, 본문생략.......감사합니다.";
		String[][] data = { { "홍길동", "부장님" }, { "홍길동", "과장님" }, { "홍길동", "대리님" }, { "홍길동", "사원님" } };

		for (int i = 0; i < data.length; i++) {
			System.out.println(MessageFormat.format(message, data[i]));
		}
	}

}
