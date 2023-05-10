package test.main;


import test.anotherPackage.Car;

public class MainClass {
	public static void main(String[] args) {

		
		Car car1 = new Car(null, 0, null);
		car1.info();
		
		Car car2 = car1.getCar();
		car2.info();
		car2.drive();
	}
}