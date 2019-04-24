package example;

import java.util.Scanner;

public class GradeTest {

	public static void main(String[] args) {

//		GradeExpr grade = new GradeExpr();
		
		Scanner input = new Scanner(System.in); 
		System.out.println("숫자를 입력 하세요.");
		int a = input.nextInt(); 
		int [] jumsu = new int [a];
		

		
		for(int i = 0; i <jumsu.length; i++) {
			Scanner sc = new Scanner(System.in);
			System.out.println("점수를 입력하세요.");
			int score = sc.nextInt();
			jumsu [i] = score; 
		}
		
		GradeExpr grade = new GradeExpr(jumsu);
		
		System.out.println("점수들 : ");
		
		for(int j = 0; j < jumsu.length; j ++) {
			System.out.print(jumsu[j]+" , ");
		}
		System.out.println();
		System.out.println("총합 : "+grade.getTotal());
		System.out.println("평균 : "+grade.getAverage());
		System.out.println("최고 점수 : "+grade.getGoodScore());
		System.out.println("최저 점수 : "+grade.getBadScore());
	}

}
