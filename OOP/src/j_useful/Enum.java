package j_useful;



enum Size {
	SMALL, MEDIUM, LARGE
}

public class Enum {

	public static void main(String[] args) {
		Size size = Size.SMALL; // 추후에 화면에서 넘어오는 값

		switch (size) {
		case SMALL:
			System.out.println("작은 거");
			break;
		case MEDIUM:
			System.out.println("중간 거");
			break;
		case LARGE:
			System.out.println("큰 거");
			break;

		}
	}
}
