package thread.basic;

class Count {
	int i; // 멤버 변수

	void increment() {
		synchronized (this) { // 공유하는 객체나 자기 자신이라도 괄호 안에 들어가야 함! lock을 걸겠다
			i++;
		}
	} // 메소드
}

class ThreadCount extends Thread {
	Count cnt;

	public ThreadCount(Count cnt) {
		this.cnt = cnt;

	}

	public void run() {
		for (int i = 0; i < 100000000; i++) {
			cnt.increment();
		}
	}
}

public class Ex7_Synch {

	public static void main(String[] args) {
		Count cnt = new Count();

		ThreadCount tc1 = new ThreadCount(cnt);
		tc1.start();

		ThreadCount tc2 = new ThreadCount(cnt);
		tc2.start(); // run 메소드 호출

		try {
			tc1.join();
			tc2.join();
		} catch (InterruptedException e) {
		}

		System.out.println("i값 = " + cnt.i);

	}

}
