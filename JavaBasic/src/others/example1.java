package others;

import java.util.Scanner;

/*
다솜이는 은진이의 옆집에 새로 이사왔다. 다솜이는 자기 방 번호를 예쁜 플라스틱 숫자로 문에 붙이려고 한다.

다솜이의 옆집에서는 플라스틱 숫자를 한 세트로 판다. 한 세트에는 0번부터 9번까지 숫자가 하나씩 들어있다. 
다솜이의 방 번호가 주어졌을 때, 필요한 세트의 개수의 최솟값을 출력하시오. 
(6은 9를 뒤집어서 이용할 수 있고, 9는 6을 뒤집어서 이용할 수 있다.)

첫째 줄에 다솜이의 방 번호 N이 주어진다. N은 1,000,000보다 작거나 같은 자연수 또는 0이다.
*/

public class example1 {

	public static void main(String[] args) {
		Scanner input= new Scanner(System.in);
		System.out.println("방번호를 입력하세요(0에서 1,000,000까지 설정할 수 있습니다.)");

		//방번호 입력받기

		String room_num =input.next(); 
		char[] num = new char[room_num.length()];
		int [] num_int= new int[num.length];
		int [] sum = new int[10];

		// 방번호의 자리수만큼 반복해서 들어가는 숫자의 총합을 구한다.
		for(int i=0; i<room_num.length(); i++) {
		num[i]=room_num.charAt(i);
		num_int[i]=Character.getNumericValue(num[i]); //char에 저장된 숫자를 int로 변환
		//System.out.print(num[i]);

		for (int j = 0; j <10; j++) {
		if(num_int[i]==j) {
		if(j!=9) {
		sum[j]++; 
		}else if(j==9) { //9와 6을 함께 쓸 수 있으므로 sum을 합산한다.
		sum[6]++;
		}
		}
		}
		}
		if(sum[6]%2==0) {//sum[6]이 짝수 인 경우, 9를 같이 쓸 수 있으므로 /2해야함.
		sum[6]/=2;
		}else sum[6]=sum[6]/2+1;//sum[6]이 홀수 인 경우, 9를 같이 쓸 수 있으므로 /2 +1해야함

		//sum값을 비교하여, 최대값을 구해서 필요한 갯수를 산출한다.
		int max = sum[0]; 
		for (int j = 0; j <10; j++) {
		for (int i = 0; i < sum.length; i++) {
		if(max< sum[i]) {
		max = sum[i];
		}
		}
		}
		System.out.println("방번호가 "+ room_num + "일때 필요한 세트 수는" +max+"입니다.");
		
		
		
		
	}

}
