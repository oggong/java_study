package f_recursive;

public class Factorial {

//	5! = 5*4*3*2*1

	public static void main(String[] args) {
		int fac = 0;
		fac = facFunc(5);
		System.out.println("5 factorial :" + fac);
	}

	static int facFunc(int i) {
		if (i == 1)
			return 1;
		return i * facFunc(i - 1);
	}
}
