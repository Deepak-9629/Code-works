package firstweektask;

public class Task5 {

    
    public static String reverseString(String str) {
        return new StringBuilder(str).reverse().toString();
    }

    
    public static int countOccurrences(String text, String sub) {
        if (text == null || sub == null || sub.isEmpty()) {
            return 0;
        }

        int count = 0, index = 0;
        while ((index = text.indexOf(sub, index)) != -1) {
            count++;
            index += sub.length();
        }
        return count;
    }

    
    public static String splitAndCapitalize(String str) {
        if (str == null || str.isEmpty()) {
            return "";
        }

        String[] words = str.split("\\s+");
        StringBuilder result = new StringBuilder();

        for (String word : words) {
            if (!word.isEmpty()) {
                result.append(Character.toUpperCase(word.charAt(0)))
                      .append(word.substring(1).toLowerCase())
                      .append(" ");
            }
        }

        return result.toString().trim();
    }

    
    public static void main(String[] args) {
        String testString = "hello world! java is fun.";
        String subString = "is";

        
        System.out.println("Reversed String: " + reverseString(testString));

        
        System.out.println("Occurrences of '" + subString + "': " + countOccurrences(testString, subString));

        
        System.out.println("Capitalized Words: " + splitAndCapitalize(testString));
    }
}
