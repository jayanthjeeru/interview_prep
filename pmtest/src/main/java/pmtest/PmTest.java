package pmtest;
import java.util.regex.Pattern;
import java.util.Base64;
public class PmTest {

	public static void main(String[] args) {
        String testString = "dhj1zq=="; // Replace with your string

        if (isBase64(testString)) {
            System.out.println("The string is likely base64-encoded.");
            if(true) {
	            byte[] decodedBytes = Base64.getDecoder().decode(testString);
	
	            // Extract the numeric part from the decoded string
	            String numericPart = new String(decodedBytes).replace("\"", "").trim();
	
	            if(numericPart.matches("[0-9]+")) {
		            // Parse the numeric part as a float
		            float floatValue = Float.parseFloat(numericPart);
		            // Print the float value
		            System.out.println("Float Value: " + floatValue);
	            }
	            System.out.println(numericPart.toString());
            }
        } else {
            System.out.println("The string is not base64-encoded.");
        }
    }
	
	private static long bytesToLong(byte[] bytes) {
        long value = 0;
        for (int i = 0; i < bytes.length; i++) {
            value |= ((long) bytes[i] & 0xFF) << (8 * i);
        }
        return value;
    }

    private static boolean isBase64(String s) {
        // Check if the string length is a multiple of 4
        if (s.length() % 4 != 0) {
            return false;
        }

        // Check if the string contains only valid base64 characters
        Pattern pattern = Pattern.compile("^[a-zA-Z0-9+/]*={0,3}$");
        return pattern.matcher(s).matches();
    }
	
	
	
}
