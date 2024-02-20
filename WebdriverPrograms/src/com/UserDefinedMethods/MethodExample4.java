package com.UserDefinedMethods;

public class MethodExample4 {
	
	private void division1()
	{
	int var1=20;
	int var2=10;
	int var3;

	var3=var1/var2;
	System.out.println(" The value of the varibale var3 after Division is :- "+var3);

	}

	public static void main(String[] args) {

	MethodExample4 m4 = new MethodExample4();
	System.out.println(" ******* Method of MethodExmaple4 Class ******* ");
	m4.division1();

	System.out.println();

	MethodExample2 hello = new MethodExample2();
	System.out.println(" ******* Methods of MethodExmaple2 Class ******* ");
	hello.addition();
	hello.subtraction();

	System.out.println();

	hello.addition();
	hello.subtraction();

	//MethodExample3 laddu = new MethodExample3();

	m4.division2();
	}

	void division2()
	{
	int var1=20;
	int var2=10;
	int var3;

	var3=var1/var2;
	System.out.println(" The value of the varibale var3 after Division is :- "+var3);

	}

}
