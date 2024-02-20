package com.Loops;

public class WhileExample {
	public static void main(String[] args) {


		int var=5;

		while(var > 1)
		{
		// True Block
		System.out.println(var +" - "+" WebDriver ");
		var--;
		}


		System.out.println(" ##################### ");
		System.out.println();

		int var1=8;

		while(var1 <= 12)
		{
		System.out.println(var1+" Selenium ");
		var1=var1+2;
		}

		System.out.println(" ##################### ");
		System.out.println();

		System.out.println(" The value of the variable var1 now is "+ var1);

		while(var1 <= 15)
		{
		System.out.println(var1+" "+" Testing ");
		var1++;
		}


		while(var1 <= 25)
		{
		System.out.println(var1+" "+" Java ");
		var1=var1+3;
		System.out.println(" The current value of the variable var1 is "+var1);
		}



		}


}
