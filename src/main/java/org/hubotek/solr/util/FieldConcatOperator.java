package org.hubotek.solr.util;

import java.util.function.Function;


public class FieldConcatOperator {

	private static char delimiter = ',';

	/**
	 * 
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
