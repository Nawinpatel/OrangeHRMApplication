package com.Loops;

public class NestedLoopsExample {
	
	public static void main(String[] args) {


		// Nested loops
		for(int a=0;a<2;a++) // Outer Loop
		{
		for(int b=1;b<=2;b++) // Inner Loop
		{
		System.out.println(" Selenium ");
		}
		}


		System.out.println(" ######### 2 ############ ");
		System.out.println();

		for(int a=0;a<2;a++) // Outer Loop
		{
		for(int b=1;b<=2;b++) // Inner Loop
		{
		System.out.println(b);
		}
		}


		System.out.println(" ########## 3 ########### ");
		System.out.println();

		for(int a=0;a<2;a++) // Outer Loop
		{
		for(int b=1;b<=2;b++) // Inner Loop
		{
		System.out.println(a+b);
		}
		}

		System.out.println(" ########### 4 ########## ");
		System.out.println();

		for(int a=0;a<2;a++) // Outer Loop
		{
		for(int b=1;b<=2;b++) // Inner Loop
		{
		System.out.println(" Testing ");
		}
		System.out.println();
		}


		System.out.println(" ########## 5 ########### ");
		System.out.println();

		for(int a=0;a<2;a++) // Outer Loop
		{
		for(int b=1;b<=2;b++) // Inner Loop
		{
		System.out.print(" * ");
		}
		System.out.println();
		}


		System.out.println(" ########## 6 ########### ");
		System.out.println();

		for(int index1=5;index1>=0;index1--)
		{
		for(int index2=index1;index2>=0;index2--)
		{
		System.out.print(index2 +"  ");      
		}
		System.out.println();
		}

		System.out.println(" ########## 7 ########### ");
		System.out.println();


		for(int index1=5;index1>=1;index1--)
		{
		for(int index2=1;index2<index1;index2++)
		{
		System.out.print(index1 +"  ");      
		}
		System.out.println();
		}

		System.out.println(" ########## 8 ########### ");
		System.out.println();

		for(int index1=5;index1>=1;index1--)
		{
		for(int index2=1;index2<index1;index2++)
		{
		System.out.print(" * " +"  ");      
		}
		System.out.println();
		}


		System.out.println(" ########## 9 ########### ");
		System.out.println();

		for(int index1=5;index1>=1;index1--)
		{
		for(int index2=1;index2<index1;index2++)
		{
		System.out.print(index2 +"  ");      
		}
		System.out.println();
		}


		System.out.println(" %%%%%%%%%%%%%%%%%%%%%%%%%% ");


		for(int i=1;i<=3;i++)
		{
		System.out.println(" Hello ");
		//break;
		continue;
		}

		}

}
