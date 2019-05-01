package z_etc;

import java.util.ArrayList;

public class Test2 {

	public static void main(String[] args) {

		ArrayList<String> data = method();

//		for (int i = 0; i < data.size(); i++) {
//			String str = (String) data.get(i); // return 하고싶은 값의 형으로 변환
//			System.out.println(str);
//		}
		for(String s : data) {
			System.out.println(s);
		}
	}

	static ArrayList<String> method() { // <String> 제너릭스
		String a = "올라";
		String b = "헬로우";
		String c = "안녕";

		ArrayList<String> list = new ArrayList<String>(); // 뭔가 새로운 것이 들어올때 마다 자동적으로 추가함... 필요 없는 메모리를 많이 차지함.
		list.add(a);
		list.add(b);
		list.add(c);
		list.add("곤니치와"); // 전구 포시와 노란 밑줄은 - 자료형을 정확히 해라!
		return list;
	}
}
