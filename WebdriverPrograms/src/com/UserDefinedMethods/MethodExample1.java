package com.UserDefinedMethods;

public class MethodExample1 {
	
	

		// User defined Method
		// User defined method in a  Java Class will not be executed by itself
		// To perform the Operations in a Java Class - mandatory the Class should have a Main Method

		// User defined methods should never be written with in the main Method - should be always be
//		      written outside the main method only

		// user defined methods can be written either above the Main method of below the main method

		//* User defined methods are created Once - can be utilized for any number of times based on
//		     our need - User defined methods are created for ***ReUsability purpose

		public static void main(String[] args)
		{
		MethodExample1 m1 = new MethodExample1(); // creating an object to the Current Class

		// using the Objected created - calling the User Defined Method
		m1.srini();

		System.out.println();
		m1.srini();

		System.out.println();
		m1.srini();

		}


		public void srini()
		{
		System.out.println(" This is my User Defined Method ");
		}


		

}
