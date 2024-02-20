package com.UserDefinedMethods;

public class MethodExample5 {

	public static void main(String[] args) {

		MethodExample2 m2 = new MethodExample2();
		System.out.println(" ============ MethodExample2 Class User Defined Methods =========");
		m2.addition();
		m2.subtraction();

		System.out.println();
	//MethodExample3 m3 = new MethodExample3();
		System.out.println(" ============ MethodExample3 Class User Defined Methods =========");
		System.out.println(" Multiplication Method is a private - hence cannot he called ");
		System.out.println();

		MethodExample4 m4 = new MethodExample4();
		System.out.println(" ============ MethodExample4 Class User Defined Methods =========");
		m4.division2();
		}
}
