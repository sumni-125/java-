package day21.chatt.실습;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client1 {

	Socket socket; // 통신할 소켓 -기반스트림(들어오는 길, 나가는 길)

	DataInputStream dis;
	DataOutputStream dos;
	Scanner sc = new Scanner(System.in);

	public Client1() {

		// 서버 ip, 포트번호
		//
		try {
			socket = new Socket("localhost"		, 	6100);
								//192.168.100.40
			dis = new DataInputStream(socket.getInputStream());
			dos = new DataOutputStream(socket.getOutputStream());

			// 보내기
			sendMsg();
			
			// 받기
			recvMsg();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private void sendMsg() {
		// TODO Auto-generated method stub

		try {
			String msg = sc.nextLine();
			dos.writeUTF(msg);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private void recvMsg() {
		// TODO Auto-generated method stub
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

		new Client1();

	}

}
