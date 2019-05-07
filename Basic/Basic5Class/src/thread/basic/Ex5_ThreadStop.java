package thread.basic;

public class Ex5_ThreadStop {

	public static void main(String[] args) {
		System.out.println("메인쓰레드:" + Thread.currentThread().getName());
		MakeCar3 mc = new MakeCar3();
		mc.start();
		try {
			Thread.sleep(2000);
		} catch (Exception e) {
		}
		System.out.println("쓰레드 종료");
		mc.flag = true;
		
//		mc.stop();
	}

}

class MakeCar3 extends Thread { // 동시에 작업 하는 것 처럼 보이게
	
	boolean flag = false;

	public void run() {
		for (int i = 0; i < 50; i++) {
			if(flag) return;
			System.out.println(getName() + "작업중");
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
			}

		}

	}
}