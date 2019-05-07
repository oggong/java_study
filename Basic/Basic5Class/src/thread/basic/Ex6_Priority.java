package thread.basic;

public class Ex6_Priority {

	public static void main(String[] args) {

		MakeCar mc1 = new MakeCar("차틀", Thread.NORM_PRIORITY); // 상수 처리
		mc1.start();

		MakeCar mc2 = new MakeCar("도색", Thread.NORM_PRIORITY);
		mc2.start();

	}// main

}// class

class MakeCar extends Thread {
	String work;

	MakeCar(String _work, int prio) {
		work = _work;
		setPriority(prio);
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