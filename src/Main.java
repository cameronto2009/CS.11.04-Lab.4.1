public class Main {

    public static void main(String[] args) {

    }


    public static boolean parenthesesCheck(String s) {
        int balance = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') {
                balance++;
            } else if (c == ')') {
                balance--;
            }
            if (balance < 0) {
                return false;
            }
        }
        return balance == 0;
    }


    public static String reverseInteger(int num) {
        String numStr = Integer.toString(num);
        String reversed = "";
        for (int i = numStr.length() - 1; i >= 0; i--) {
            reversed += numStr.charAt(i);
        }
        return reversed;
    }


    public static String encryptThis(String text) {
        String[] words = text.split(" ");
        String encrypted = "";

        for (String word : words) {
            if (word.length() == 0) continue;
            String encryptedWord = (int) word.charAt(0) + "";

            if (word.length() > 1) {
                encryptedWord += word.charAt(word.length() - 1);
                encryptedWord += word.substring(2, word.length() - 1);
                encryptedWord += word.charAt(1);
            }
            encrypted += encryptedWord + " ";
        }
        return encrypted.trim();
    }


    public static String decipherThis(String text) {
        String[] words = text.split(" ");
        String deciphered = "";

        for (String word : words) {
            String originalWord = "";
            int i = 0;

            while (i < word.length() && Character.isDigit(word.charAt(i))) {
                i++;
            }
            int charCode = Integer.parseInt(word.substring(0, i));
            originalWord += (char) charCode;

            if (i < word.length()) {
                originalWord += word.charAt(word.length() - 1);
                if (i + 1 < word.length() - 1) {
                    originalWord += word.substring(i, word.length() - 1);
                }
                originalWord += word.charAt(i);
            }
            deciphered += originalWord + " ";
        }
        return deciphered.trim();
    }
}