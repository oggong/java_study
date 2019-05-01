package g_access;

import g_access.sub.Access;

public class Main {

	public static void main(String[] args) {
		Access me = new Access();
//		me.a = "프라이빗 변경"; 동일 패키지 내에서는 private 빼고는 모두 접근 가능
		me.b = "퍼블릭 변경";
//		me.c = "디폴트 변경"; 다른 패키지에 있을때에는 public 만 접근 가능
//		me.d = "프로텍티드 변경"; 
		me.output();
	}

}
