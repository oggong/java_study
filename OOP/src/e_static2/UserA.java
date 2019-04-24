package e_static2;

public class UserA {
	DBConnect con; // 2. DBConnect 자료 구조 con 변수명

	public UserA() { // 실행
//		con = new DBConnect();

		con = DBConnect.getInstance(); // 3. getInstance() 메소드 의 결과 값을 받기 7
	}

	public void use() { // 9
		System.out.println("디비 작업중");
	}
}
