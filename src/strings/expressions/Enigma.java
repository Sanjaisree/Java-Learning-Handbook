package strings.expressions;

import java.util.Scanner;

public class Enigma {
        static String encrypt(String message, int key) {
            StringBuilder result = new StringBuilder();
            for (int i = 0; i < message.length(); i++) {
                char ch = message.charAt(i);
                char encryptedChar = (char) (ch ^ key);
                result.append(encryptedChar);
            }
            return result.toString();
        }
        static String decrypt(String cipher, int key) {
            StringBuilder result = new StringBuilder();
            for (int i = 0; i < cipher.length(); i++) {
                char ch = cipher.charAt(i);
                char decryptedChar = (char) (ch ^ key);
                result.append(decryptedChar);
            }
            return result.toString();
        }
        public static void main(String[] args) {
            Scanner scan = new Scanner(System.in);
            System.out.print("Enter message: ");
            String message = scan.nextLine();
            System.out.print("Enter key: ");
            int key = scan.nextInt();


            String encrypted = encrypt(message, key);
            String decrypted = decrypt(encrypted, key);

            System.out.println("Original  : " + message);
            System.out.println("key  : " + key);
            System.out.println("Encrypted : " + encrypted);
            System.out.println("Decrypted : " + decrypted);
        }

}
