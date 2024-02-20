package com.Loops;


public class DoWhileExample {
	public static void main(String[] args) {
	
		int var=2;

		do
		{
		System.out.println(var+" - "+" Selenium ");
		var++;

		System.out.println(" The current value of the variable var is :- "+var);

		}while(var >=5);


		System.out.println(" $$$$$$$$$$$$$$$$$$$$$$$ ");
		System.out.println();

		do
		{
		System.out.println(var +" - "+" Testing ");
		var=var+5;
		}while(var <= 1);
		
		}
	
}
