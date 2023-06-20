package dev.esz.simplifier;

import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

public class Cryptography {

    private final String message;
    private final byte[] publicKey;

    byte[] encryptedMessage;

    SecretKey secretKey;

    Cipher cipher;

    public Cryptography(String message, String publicKey) {
        this.message = message;
        this.publicKey = publicKey.getBytes();

        secretKey = new SecretKeySpec(this.publicKey, "AES");
    }

    public byte[] encrypt() {
        try {
            cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
        } catch (NoSuchAlgorithmException | NoSuchPaddingException e) {
            throw new RuntimeException(e);
        }

        try {
            cipher.init(Cipher.ENCRYPT_MODE, secretKey);
        } catch (InvalidKeyException e) {
            throw new RuntimeException(e);
        }

        try {
            encryptedMessage = cipher.doFinal(message.getBytes());
            return encryptedMessage;
        } catch (IllegalBlockSizeException | BadPaddingException e) {
            throw new RuntimeException(e);
        }
    }

    public String decrypt() {
        try {
            Cipher.getInstance("AES/ECB/PKCS5Padding");
        } catch (NoSuchAlgorithmException | NoSuchPaddingException e) {
            throw new RuntimeException(e);
        }
        try {
            cipher.init(Cipher.DECRYPT_MODE, secretKey);
            byte[] decryptedMessageBytes = cipher.doFinal(encryptedMessage);

            return new String(decryptedMessageBytes, StandardCharsets.UTF_8);
        } catch (InvalidKeyException | IllegalBlockSizeException | BadPaddingException e) {
            throw new RuntimeException(e);
        }


    }

    public byte[] accessSecretKey() {
        return secretKey.toString().getBytes();
    }
}
