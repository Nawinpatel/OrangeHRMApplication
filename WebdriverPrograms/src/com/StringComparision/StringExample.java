package com.StringComparision;

public class StringExample {
	public static void main(String[] args) {
		System.out.println();
		System.out.println("************** equals ***************");
		System.out.println();


		String var1="LiveTech";
		String var2="SeleniumWebDriver";

		if(var1.equals(var2))
		{
		System.out.println(" var1 variable value is EQUAL to var2 variable value ");
		}
		else
		{
		System.out.println(" var1 variable value is NOT EQUAL to var2 variable value  ");
		}


		System.out.println();

		String var3="LiveTech";
		String var4="Livetech";
		if(var3.equals(var4))
		{
		System.out.println(" var3 variable value is EQUAL to var4 variable value ");
		}
		else
		{
		System.out.println(" var3 variable value is NOT EQUAL to var4 variable value  ");
		}

		System.out.println();
		System.out.println("************** equalsIgnoreCase ***************");
		System.out.println();

		String var5="LiveTech";
		String var6="Livetech";

		if(var5.equalsIgnoreCase(var6))
		{
		System.out.println(" var5 variable value is EQUAL to var6 variable value ");
		}
		else
		{
		System.out.println(" var5 variable value is NOT EQUAL to var6 variable value ");
		}

		System.out.println();

		String var7="LiveTech";
		String var8="Livetech "; // a value along with a Space
		if(var7.equalsIgnoreCase(var8))
		{
		System.out.println(" var7 variable value is EQUAL to var8 variable value ");
		}
		else
		{
		System.out.println(" var7 variable value is NOT EQUAL to var8 variable value ");
		}
		System.out.println();
		System.out.println("************** contains ***************");
		System.out.println();

		// Checking for an existence of One String Value in another String Value
		String var9="Tech";
		String var10="LiveTech ";
		if(var9.contains(var10))
		{
		System.out.println(" String Existing ");
		}
		else
		{
		System.out.println(" String NOT Exsiting ");
		}

		if(var10.contains(var9))
		{
		System.out.println(" String Existing ");
		}
		else
		{
		System.out.println(" String NOT Exsiting ");
		}

		System.out.println();
		System.out.println(" *********Finding the Number of characters of a String *********");
		System.out.println();

		int hello=var10.length();
		System.out.println(" The number of characters in the varaible var10 is :- "+hello);

		System.out.println();
		System.out.println("   **** finding which variable is greater than - var1 and var2 *****Not related to alphabet greatness - but for the number of characters of the Strings**");
		System.out.println();
		
		int var1VariableValueLength=var1.length();
		int var2VariableValueLength=var2.length();

		System.out.println(" The number of characters of the var1 variable value is :- "+var1VariableValueLength);
		System.out.println(" The number of characters of the var2 variable value is :- "+var2VariableValueLength);

		if(var1VariableValueLength>var2VariableValueLength)
		{
		System.out.println(" Var1 Variable value is greater than Var2 Variable value ");
		}
		else
		{
		System.out.println(" Var2 Variable value is greater than Var1 Variable value ");
		}

		System.out.println();
		System.out.println( "   ##############   OR - finding the greater String value ############## ");
		System.out.println();
		
		if(var1.length()>var2.length())
		{
		System.out.println(" Var1 Variable value is greater than Var2 Variable value ");
		}
		else
		{
		System.out.println(" Var2 Variable value is greater than Var1 Variable value ");
		}


		System.out.println();
		String var11="LiveTech";

		System.out.println("  The character at the index 3 is   "+var11.charAt(3));

		System.out.println("  The character at the index 3 is   "+var11.charAt(7));

		}


}
