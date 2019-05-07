package network1.basic;

import java.io.*;
import java.net.*;

public class SimpleServer {

	public final static int PORT = 5001; // PortNumer : 1024 ~ 포트번호 임의 지정 하나 해줘야 함!

	public static void main(String args[]) {

		ServerSocket server = null;
		DataInputStream in = null;
		DataOutputStream out = null;
		Socket clientSocket = null;

		try {
			// 1. 서버 소켓 생성
			server = new ServerSocket(PORT);
			System.out.println("SimpleServer started..");

			// 2. 클라이언트 접속시 소켓 생성
			// 3. 소켓의 입출력 스트림 얻기
			clientSocket = server.accept(); // Client 들어올때 까지 대기하다가 client가 접속하면 대기 상태 해제 하는 소켓
			in = new DataInputStream(clientSocket.getInputStream());
			out = new DataOutputStream(clientSocket.getOutputStream());

			// 4. 데이터 전송
			String line = in.readUTF();
			System.out.println("we received : " + line);
			if (line.compareTo("안녕") == 0) {
				out.writeUTF("힘내.....자");
			} else {
				out.writeUTF("인사말이 아닙니다.");
			}

			// 5. 소켓닫기
			in.close();
			out.close();
			clientSocket.close();
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
	}
}