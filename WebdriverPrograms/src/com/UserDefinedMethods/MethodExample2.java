package com.UserDefinedMethods;

public class MethodExample2 {
	// User defined Names should always be unique
	protected void subtraction()
	{
	int var1=20;
	int var2=10;
	int var3;

	var3=var1-var2;
	System.out.println(" The value of the varibale var3 after subtraction is :- "+var3);

	}

	public static void main(String[] args)
	{
	MethodExample2 m2 = new MethodExample2();
	m2.addition();

	/*
	MethodExample2 a2 = new MethodExample2();
	a2.subtraction();
	*/

	m2.subtraction();
	m2.subtraction();

	m2.addition();

	}

	public void addition()
	{
	int var1=20;
	int var2=10;
	int var3;

	var3=var1+var2;
	System.out.println(" The value of the varibale var3 after Addition is :- "+var3);


	}
}
