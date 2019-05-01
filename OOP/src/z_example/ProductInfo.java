package z_example;

import java.util.*;

public class ProductInfo {
	public int productID;
	public int numberOfProduct;

	public static void main(String[] args) {
		Product pro1 = null;
		Product pro2 = null;
		Product pro3 = null;

		ArrayList<String> list = null;
		ArrayList<String> list2 = null;
		ArrayList<String> list3 = null;

		while (true) {
			Scanner sc = new Scanner(System.in);
			System.out.println("상품 추가(1),모든 상품조회(2),끝내기(3) >>");
			int sel1 = sc.nextInt();

			if (sel1 == 1) {
				System.out.println("상품 종류 책(1),음악CD(2),회화책(3) >>");
				int sel2 = sc.nextInt();
				if (sel2 == 1) {
					list = new ArrayList<String>(3);
					Scanner sc1 = new Scanner(System.in);
					String[] Book = { "상품 설명 >>", "생산자 >>", "가격 >>", "책 제목 >>", "저자 >>", "언어 >>", "ISBN >>" };
					for (int a = 0; a < Book.length; a++) {
						System.out.println(Book[a]);
						String a1 = sc.next();
						list.add(a1);
					}
					pro1 = new Book((String) list.get(0), (String) list.get(1), (String) list.get(2),
							(String) list.get(3), (String) list.get(4), (String) list.get(5), list.get(6));

				} else if (sel2 == 2) {
					list2 = new ArrayList<String>(3);
					Scanner sc2 = new Scanner(System.in);
					String[] CD = { "상품 설명 >>", "생산자 >>", "가격 >>", "앨범 제목>>", "가수 >>" };
					for (int b = 0; b < CD.length; b++) {
						System.out.println(CD[b]);
						String b1 = sc2.next();
						list2.add(b1);
					}
					pro2 = new CompactDisc((String) list2.get(0), (String) list2.get(1), (String) list2.get(2),
							(String) list2.get(3), (String) list2.get(4), (String) list2.get(5));
				} else if (sel2 == 3) {
					list3 = new ArrayList<String>(3);
					Scanner sc3 = new Scanner(System.in);
					String[] CBook = { "상품 설명 >>", "생산자 >>", "가격 >>", "책 제목 >>", "저자 >>", "언어 >>", "ISBN >>" };
					for (int c = 0; c < CBook.length; c++) {
						System.out.println(CBook[c]);
						String c1 = sc3.next();
						list3.add(c1);
					}
					pro3 = new ConversationBook((String) list3.get(1), (String) list3.get(2), (String) list3.get(3),
							(String) list3.get(4), (String) list3.get(5), (String) list3.get(6), list3.get(7));
				}
			} else if (sel1 == 2) {
				pro1.showInfo();
				pro2.showInfo();
				pro3.showInfo();
			} else {
				break;
			}
		}

	}

}
