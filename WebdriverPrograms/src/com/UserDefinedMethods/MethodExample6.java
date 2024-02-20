package com.UserDefinedMethods;

public class MethodExample6 {
	
	
	// Global Variables / instance Variables
	int var1=50;

	public void addition()
	{
	// local Variables
	int var1=20;
	//int var2=40;
	int var3;

	var3=var1+var2;
	System.out.println(" The value of the variable var3 after addition is :- "+var3);
	}

	// Global Variables / instance Variables
	int var2=100;
	int var3;
	public void subtraction()
	{
	var3=var1-var2;
	System.out.println(" The value of the variable var3 after subtraction is :- "+var3);
	}

	public static void main(String[] args) {

	MethodExample6 m6 = new MethodExample6();
	m6.addition();
	m6.subtraction();
	}
	

}
