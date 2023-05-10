package test.main;

import java.util.*;

public class Lotto {
	public static void main(String[] args) {
		/*
		 * 1. java 콘솔창 실행 결과 로또를 몇개 구입하시겠어요 : 2 1, 4, 5, 6, 40, 45 3, 4, 10, 15, 16, 20
		 * 
		 * 단) 번호는 오름차순 정렬되어있어야 한다. 중복된 번호가 나오면 안된다.
		 */
		Scanner scan = new Scanner(System.in);
		

		System.out.println("로또를 몇개 구입하시겠어요? :");
		int num = scan.nextInt();

		for (int i = 0; i<num; i++) {
			getLotto();
		}
	}

	public static void getLotto() {
		Random ran = new Random();
		
		TreeSet<Integer> lotto = new TreeSet();
		
		while (lotto.size() < 6) {
			lotto.add(ran.nextInt(45) + 1);
		}
		
		System.out.println(lotto);
	}
}
