public class Main {

    public static void main(String[] args) {
        // Example usage
        System.out.println(parenthesesCheck("()")); // true
        System.out.println(parenthesesCheck(")(()))")); // false
        System.out.println(parenthesesCheck("(")); // false
        System.out.println(parenthesesCheck("(())((()())())")); // true

        System.out.println(reverseInteger(1234)); // "4321"
        System.out.println(reverseInteger(2468)); // "8642"

        System.out.println(encryptThis("Hello good day")); // "72olle 103doo 100ya"
        System.out.println(encryptThis("Ready set go")); // "82yade 115te 103o"

        System.out.println(decipherThis("72olle 103doo 100ya")); // "Hello good day"
        System.out.println(decipherThis("82yade 115te 103o")); // "Ready set go"
    }

    public static boolean parenthesesCheck(String str) {
        int balance = 0;
        for (char c : str.toCharArray()) {
            if (c == '(') {
                balance++;
            } else if (c == ')') {
                balance--;
            }
            if (balance < 0) {
                return false; // More closing parentheses
            }
        }
        return balance == 0; // True if all parentheses are balanced
    }

    public static String reverseInteger(int num) {
        String numStr = String.valueOf(num);
        String reversedStr = "";
        for (int i = numStr.length() - 1; i >= 0; i--) {
            reversedStr += numStr.charAt(i); // Concatenate each character
        }
        return reversedStr;
    }

    public static String encryptThis(String text) {
        String[] words = text.split(" ");
        String encryptedMessage = "";

        for (String word : words) {
            if (word.length() > 0) {
                String encryptedWord = (int) word.charAt(0) + ""; // First letter as char code
                if (word.length() > 1) {
                    encryptedWord += word.charAt(word.length() - 1); // Last letter
                    encryptedWord += word.substring(2, word.length() - 1); // Middle part
                    encryptedWord += word.charAt(1); // Second letter
                }
                encryptedMessage += encryptedWord + " "; // Concatenate with space
            }
        }
        return encryptedMessage.trim(); // Remove trailing space
    }

    public static String decipherThis(String text) {
        String[] words = text.split(" ");
        String decryptedMessage = "";

        for (String word : words) {
            String decryptedWord = "";
            int charCodeEndIndex = 0;

            // Find the end of the character code
            while (charCodeEndIndex < word.length() && Character.isDigit(word.charAt(charCodeEndIndex))) {
                charCodeEndIndex++;
            }

            int charCode = Integer.parseInt(word.substring(0, charCodeEndIndex));
            decryptedWord += (char) charCode; // Append the first letter

            if (word.length() > charCodeEndIndex) {
                String remaining = word.substring(charCodeEndIndex);
                if (remaining.length() > 1) {
                    decryptedWord += remaining.charAt(remaining.length() - 1); // Last letter
                    decryptedWord += remaining.substring(1, remaining.length() - 1); // Middle part
                    decryptedWord += remaining.charAt(0); // Second letter
                } else if (remaining.length() == 1) {
                    decryptedWord += remaining.charAt(0); // If only one letter, just append it
                }
            }
            decryptedMessage += decryptedWord + " "; // Concatenate with space
        }
        return decryptedMessage.trim(); // Remove trailing space
    }
}