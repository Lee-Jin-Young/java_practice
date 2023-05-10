package test.anotherPackage;

import java.util.Scanner;

public class Car {
	public String name;
	public int price;
	public String color;
	String status;
	
	Scanner sc = new Scanner(System.in);
	
	public Car(String name, int b, String color) {
		this.name = name;
		this.price = b;
		this.color = color;
	}

	public void info() {
		System.out.printf("%s차의 이름은 %s이고 가격은 %d만원 입니다.\n",color,name,price);
	}
	
	public void drive() {
		System.out.println("운전중인가요? y|n");
		boolean isDriving = sc.next().equals("y") ? true : false;
		status = isDriving ? "달리는 중이다." : "멈춰있다.";
		System.out.printf("%s는 %s",name,status);
	}
	
	public void setCar() {
		
	}
	
	public Car getCar() {
		System.out.println("자동차 정보 입력");
		System.out.println("이름 <엔터> 가격 <엔터> 색상");
		String a = sc.next();
		int b = sc.nextInt();
		String c = sc.next();
		return new Car(a,b,c);
		
	}
}