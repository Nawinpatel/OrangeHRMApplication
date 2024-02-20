package com.UserDefinedMethods;

public class MethodExample7 {
	
	
	// Global Variables / instance Variables
	double var1=50;

	public void addition() // withOut Parameter
	{
	// local Variables
	int var1=20;
	//int var2=40;
	double var3;

	var3=var1+var2;
	System.out.println(" The value of the variable var3 after addition is :- "+var3);
	}

	public void addition(int var1,int var2) // method with Parameter
	                              // method with signature
	{

	var3=var1+var2;
	System.out.println(" The value of the variable var3 after addition along with 2 parameters is :- "+var3);
	}

	public void addition(int var1,int var2,int var3) // method with Parameter
	    // method with signature
	{

	var3=var3+var1+var2;
	System.out.println(" The value of the variable var3 after addition along with 3 parameters is :- "+var3);
	}

	public void addition(int var1,double var2,double var3) // method with Parameter
	    // method with signature
	{

	var3=var3+var1+var2;
	System.out.println(" The value of the variable var3 after addition along with 3 parameters is :- "+var3);
	}

	// Global Variables / instance Variables
	double var2=100;
	double var3;

	public void subtraction()
	{
	var3=var1-var2; // will take values declared Globally
	System.out.println(" The value of the variable var3 after subtraction is :- "+var3);
	}

	public static void main(String[] args) {

	MethodExample7 m7 = new MethodExample7();
	m7.subtraction();

	m7.addition();
	m7.addition();
	m7.addition();

	m7.addition(90, 60);
	m7.addition(40, 60);
	m7.addition(80, 90);

	m7.addition(50, 20, 90);

	// Whenever the Methods names are similar but with different method Signature/parameters- its is called
	// Method OverLoading - OPP's

	m7.addition(10, 50.123, 80.012);
	}

}

