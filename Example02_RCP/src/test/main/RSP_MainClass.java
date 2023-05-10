package test.main;

import java.util.*;

public class RSP_MainClass {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Random ran = new Random();
		
		int user = 4;
		int com = ran.nextInt(1,3);
		String[] rsp = {"가위","바위","보"};
		
		while(true) {
			System.out.println("가위:0, 바위:1, 보:2");
			user = sc.nextInt();
			
			while (user<0 || 2<user) {
				System.out.println("0,1,2중 하나를 입력하세요");
				user = sc.nextInt();
			}
			
			if (user == com) {
				System.out.printf("user : %s, com : %s\n", rsp[user], rsp[com]);
				System.out.println("무승부");
			} else if ((user + 1) % 3 == com) {
				System.out.printf("user : %s, com : %s\n", rsp[user], rsp[com]);
				System.out.println("패");
			} else {
				System.out.printf("user : %s, com : %s\n", rsp[user], rsp[com]);
				System.out.println("승");
			}
			
			System.out.println("다시 : 0, 종료 : 1");
			if(sc.nextInt() == 1) {
				break;
			}
		} //while
		
		System.out.println("게임을 종료하였습니다.");
				
	}
}
