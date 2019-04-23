package e_method;

/*
	메소드명 : main
	인자: String[] args
	리턴형: void

*/
/*
	Test.java --> Test.class
		(1) 컴파일 : javac Test.java
	
		(2) 실행 : java Test 192.168.0.1 <scott tiger>
		
		--일반적으로 다른컴퓨터로 접속하기 위해 사용
*/
public class Ex09_Main {

	public static void main(String[] args) {
//			String ipadd = "192.168.0.2";
//			String id = "tom";
//			String pw = "bear";
		
		
		for (int i = 0; i < args.length; i++) {
			System.out.println(args[i]);
		}

	}

}
