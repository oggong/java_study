package g_access;

// 접근 지정자는 4가지 


import g_access.sub.Access;

public class SubClassMain extends Access { // 상속!

	public static void main(String[] args) {
		SubClassMain me = new SubClassMain();
//		me.a = "프라이빗 변경"; 
		me.b = "퍼블릭 변경";
//		me.c = "디폴트 변경";
		me.d = "프로텍티드 변경"; //상속 관계에 있을때는 접근가능
		me.output();
	}
}