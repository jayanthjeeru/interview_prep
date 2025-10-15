package com.commonadapterfw;
import java.io.UnsupportedEncodingException;
import java.util.Base64;
import java.util.regex.Pattern;

public class Base64Convertion {
	

	public static String decodeBase64OrReturnOriginal(String input) {
        try {
            // Attempt to decode the string using Base64
            byte[] decodedBytes = Base64.getDecoder().decode(input);

            // Convert the decoded bytes to a string using UTF-8 encoding
            String res = new String(decodedBytes, "UTF-8");
            System.out.println(res);
            if(!res.contains("�"))  //�
            	return res;
            else
            	return input;
        } catch (Exception e) {
            // If an exception is thrown, return the original string
            return input;
        }
    }

    public static void main(String[] args) {
    	
    	System.out.println("123::hi".split("::")[0]);
    	
        String base64String = "SGVsbG8gd29ybGQ="; // Base64-encoded "Hello world"
        String nonBase64String = "mnbas1";

        String decodedBase64String = decodeBase64OrReturnOriginal(base64String);
        String decodedNonBase64String = decodeBase64OrReturnOriginal(nonBase64String);

        System.out.println("Decoded Base64 String: " + decodedBase64String);
        System.out.println("Original Non-Base64 String: " + decodedNonBase64String);
    }
}
