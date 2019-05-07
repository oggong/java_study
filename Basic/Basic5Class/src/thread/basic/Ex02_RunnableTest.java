package thread.basic;

public class Ex02_RunnableTest {

	public static void main(String[] args) {
		MakeCar2 mc1 = new MakeCar2("차틀만들기");
		Thread t1 = new Thread(mc1); // mc1을 빼먹어도 에러 안나기 때문에 주의 해줘야 함!
		t1.start();

//		MakeCar1 mc2 = new MakeCar1("도색");
//		Thread t2 = new Thread(mc2);
//		t2.start(); // 동시에 작업하지 않지만 그렇게 보이게 하겠다1!!1111!
//----------------------------------------------------------------------
//		Thread t2 = new Thread(new MakeCar2("도색"));
//		t2.start();

//----------------------------------------------------------------------
		// 축약
		new Thread(new MakeCar2("도색")).start();

		System.out.println("프로그램 끝");
	}// main

}// Ex02_ThreadTest

class MakeCar2 implements Runnable { // 동시에 작업 하는 것 처럼 보이게
	String work;

	MakeCar2(String _work) {
		work = _work;
	}

	public void run() {
		for (int i = 0; i < 5; i++) {
			System.out.println(work + "작업중");

			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
			}

		}
	}
}