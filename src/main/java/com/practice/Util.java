package com.practice;

public class Util {
	public static boolean isEven(int num) {
		return num%2==0;
	}
	
    public static boolean isValidEmail(String email) {
        return email != null && email.matches("^[\\w._%+-]+@[\\w.-]+\\.[a-zA-Z]{2,}$");
    }
}
