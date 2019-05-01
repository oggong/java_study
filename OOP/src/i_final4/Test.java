package i_final4;

/*
	final - 변경 불가  ======== 한번 정해져 있는 거 그냥 써라
		final field - 값 변경 불가(상수 처리)
		final method - overriding을 막는것 <--------> abstract와 같이 쓰지 말기!
		final class - 상속 불가
	
*/
class Parent {
	String field = "부모님꺼"; // final 이 붙으면 무조건 변경 불가 . 한번 고정한값으로 끝까지 써야함

	public void job() {
		System.out.println("부모님께서 장만");
	}
}

class Child extends Parent {
	Child() {
		field = "내꺼임";
	}

	public void job() {
		System.out.println("물려받아 탕진");
	}
}

public class Test {

	public static void main(String[] args) {
		Parent p = new Child();
		System.out.println(p.field);
		p.job();

	}

}
