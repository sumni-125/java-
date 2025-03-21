package day21.chatt.실습;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

//서버
//서버소켓

//클라이언트 - 서버(1 : 1 채팅)
public class Server1 {

	ServerSocket serverSocket; // 서버소켓
	Socket clientSocket; // 클라이언트와 통신할 소켓 (전화기 역할 - 기반스트림(나가는통로, 들어오는통로))
							// 바이트스트림입니다

	// 보조스트림
	DataInputStream dis;
	DataOutputStream dos;

	Scanner sc = new Scanner(System.in);

	public Server1() {
		// 포트번호 ( 5000 ~ 9999 )
		try {
			serverSocket = new ServerSocket(6100);
			System.out.println("서버 기다리는중");
			clientSocket = serverSocket.accept();
			System.out.println("서버 start!!");

			String clinetIp = clientSocket.getInetAddress().toString();

			dis = new DataInputStream(clientSocket.getInputStream()); // 들어오는길
			dos = new DataOutputStream(clientSocket.getOutputStream());// 나가는길

			// 받기

			recvMsg();

			// 보내기

			sendMsg();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		

	}

	private void sendMsg() {

		try {
			String msg = sc.nextLine();
			dos.writeUTF(msg);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private void recvMsg() {
		String msg;
		
		try {
			msg = dis.readUTF();
			System.out.println(msg);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub	
		
		new Server1();
	}

}
