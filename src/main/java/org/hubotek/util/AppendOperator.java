package org.hubotek.util;

/**
 * Append the first and second elements of the function. 
 * Noting that the append method.
 * @author JoseCanova
 *
 */
public class AppendOperator {

	public static String append(String first , String second)
	{ 
		return new StringBuilder().append(first).append(second).toString();
	}
	
}
