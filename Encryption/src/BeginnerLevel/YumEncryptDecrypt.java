package BeginnerLevel;
public class YumEncryptDecrypt {
    
    public static void main(String[] args) {
        String originalText = "The cat sat on the mat.";
        String encryptedText = encrypt(originalText);
        String decryptedText = decrypt(encryptedText);

        System.out.println("Original Text: " + originalText);
        System.out.println("Encrypted Text: " + encryptedText);
        System.out.println("Decrypted Text: " + decryptedText);
    }

    // Encrypt the string by adding "yum" after each "t"
    public static String encrypt(String input) {
        return input.replaceAll("t", "tyum");
    }

    // Decrypt the string by removing "yum" after each "t"
    public static String decrypt(String input) {
        return input.replaceAll("tyum", "t");
    }
}
