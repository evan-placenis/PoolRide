package controllers;

public class encryptionController {
    private static final int key = 345;

    //encryption
    public static String encrypt(String plaintext, int shift) {
        StringBuilder ciphertext = new StringBuilder();
        for (int i = 0; i < plaintext.length(); i++) {
            char ch = plaintext.charAt(i);
            ch = (char) (((ch - 32 + shift) % 95 + 95) % 95 + 32);
            ciphertext.append(ch);
        }
        return ciphertext.toString();
    }

    public static String decrypt(String ciphertext, int shift) {
        StringBuilder plaintext = new StringBuilder();
        for (int i = 0; i < ciphertext.length(); i++) {
            char ch = ciphertext.charAt(i);
            ch = (char) (((ch - 32 - shift + 95) % 95 + 95) % 95 + 32);
            plaintext.append(ch);
        }
        return plaintext.toString();
    }


    public static int getKey() {
        return key;
    }
}
