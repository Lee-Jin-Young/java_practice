package test.main;

import java.util.*;

public class RSP_autoMain {
	public static void main(String[] args) {
		Random ran = new Random();
		int userCnt = 0;
		int comCnt = 0;
		int sameCnt = 0;
		String[] rsp = {"가위","바위","보"};

		for (int i = 0; i < 100; i++) {

			int user = ran.nextInt(1, 3);
			int com = ran.nextInt(1, 3);

			if (user == com) {
				System.out.printf("유저는 %s, 컴퓨터는 %s 따라서 ", rsp[user], rsp[com]);
				System.out.println("무승부");
				sameCnt++;
			} else if ((user + 1) % 3 == com) {
				System.out.printf("유저는 %s, 컴퓨터는 %s 따라서 ", rsp[user], rsp[com]);
				System.out.println("패");
				comCnt++;
			} else {
				System.out.printf("유저는 %s, 컴퓨터는 %s 따라서 ", rsp[user], rsp[com]);
				System.out.println("승");
				userCnt++;
			}
		}
		System.out.printf("%d승 %d무 %d패\n",userCnt,sameCnt,comCnt);
	}
}
