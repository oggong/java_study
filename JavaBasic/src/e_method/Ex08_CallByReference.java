package e_method;

public class Ex08_CallByReference {

	public static void main(String[] args) {
		StringBuffer a = new StringBuffer("행복하자");
		StringBuffer b = new StringBuffer("짝꿍님");

		add(a, b);

		System.out.println("2.A= " + a + "B=" + b);

	} // String은 원래 call by reference 가 맞다.
		// string의 특징 때문에 call by reference 와 다른 결과가 나온다.
		// call by value 와 같은 결과

	static void add(StringBuffer a, StringBuffer b) {
		a.append(b);
		System.out.println("1.A= " + a + "B=" + b);
	}

}
