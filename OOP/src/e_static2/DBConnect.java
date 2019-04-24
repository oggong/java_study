package e_static2;

public class DBConnect {

	static DBConnect db; // 변수 선언  6

	private DBConnect() { //4 
		System.out.println("실제로 디비에 연결을 얻어옴");
	}

	public static DBConnect getInstance() { // 3. getInstance 실행 
		if(db == null) db = new DBConnect();
		return db; //5
		
	} // 한번 뜨게 됨!! 
	// 자원을 한번쓰고 다른 class 에 공유 하기 위해 static 으로 공유!!
}
