package org.hubotek.solr.util;

/**
 * Concatenates two strings resulting in a queryString like form (using &amp; entity).
 * 
 * @author JoseCanova
 *
 */
public class QueryStringConcatOperator {

	private static char delimiter = '&';
	
	/**
	 * @param t
	 * @param u
	 * @return the appended elements for field list construction.
	 */
	public static String apply(String t, String u) {
		StringBuilder str = new StringBuilder();
		if (!isEmpty(t)){
			return new StringBuilder().append(t).append(delimiter).append(u).toString();
		}else { 
			str.append(u);
		}
		return str.toString();
	}

	private static boolean isEmpty(String t) {
		return t==null || t.isEmpty();
	}
	
}
