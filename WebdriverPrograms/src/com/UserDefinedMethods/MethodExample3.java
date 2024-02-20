package com.UserDefinedMethods;

public class MethodExample3 {
	
	
	private void multiplication() // private User defined method can be only be accessed within
    //     the same Class - can be called for any number of times
//.... *** private User defined methods cannot be accessed in any other different classes
{
int var1=20;
int var2=10;
int var3;

var3=var1*var2;
System.out.println(" The value of the varibale var3 after Multiplication is :- "+var3);

}

public static void main(String[] args) {


MethodExample3 m3 = new MethodExample3();
m3.multiplication();

m3.multiplication();

MethodExample2 hi = new MethodExample2();
hi.subtraction();



}

}
