package language;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Language i = null;

		while (true) {
			Scanner sc = new Scanner(System.in);
			System.out.println("언어를 선택하세요. 1.한국어2.영어 3.일본어");
			int sel = sc.nextInt();
			switch (sel) {
			case 1:
				i = new Kor();
				break;
			case 2:
				i = new Eng();
				break;
			case 3:
				i = new Jap();
				break;
			}
			Scanner sc1 = new Scanner(System.in);
			System.out.println("메시지를 선택하세요. 1.인사말2.자기소개 3.하고픈말");
			int msg = sc1.nextInt();
			switch (msg) {
			case 1:
				i.insa();
				;
				break;
			case 2:
				i.intro();
				break;
			case 3:
				i.wtalk();
				break;
			}

			Scanner sc2 = new Scanner(System.in);
			System.out.println("다시 하시겠습니까? (Y/N)");
			char ch = sc2.nextLine().charAt(0);

			if (ch == 'y' | ch == 'Y') {
				continue;
			} else {
				break;
			}
		}
	}

}
