package g_access.sub;

public class Access {

	private String a = "프라이빗 데이터";
	public String b = "퍼블릭 데이터";
	String c = "디폴트 데이터";
	protected String d = "프로텍티드 데이터";

	
	public void output() {
		System.out.println(a);
		System.out.println(b);
		System.out.println(c);
		System.out.println(d);
		
	}
}

/*
 * 접근 지정자 -private : 해당 클래스에만 허용 -public : 모든 허용 -default(아무지정없는경우) : 해당 패키지에만
 * 허용 -protected : 다른 패키지인 경우 상속관계에만 허용 (동일패키지 허용)
 * 
 * private < default <protected < public
 */
