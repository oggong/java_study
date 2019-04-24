package e_static;

//java Main 실행 
//
//Main m = new Main(); 

//m.main();


public class Main {

	public static void main(String[] args) { 

		Book b1 = new Book(); // 객체 생성
		Book b2 = new Book();
		Book b3 = new Book();
//		System.out.println("갯수 :" + b1.getCount());
//		System.out.println("갯수 :" + b2.getCount());
//		System.out.println("갯수 :" + b3.getCount());
		
		System.out.println("갯수 :"+ Book.getCount() +" "+ b3.temp);
	
		}

}
