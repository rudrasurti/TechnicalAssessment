/**
 * @author 
 */

/***************************************************/

package com.driver.utils;

public class UsernameUtils {

	private UsernameUtils() {
	}

	public static String getUserName() {
		return System.getProperty("user.name");
	}

}
