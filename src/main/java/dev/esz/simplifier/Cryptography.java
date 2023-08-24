package dev.esz.simplifier;

import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

/**
 * <p>
 * A Java class to handle with cryptography, via the
 * {@link javax.crypto} class
 * </p>
 * <p>
 * The class uses two keys to perform a cryptography task
 * , the public key, used to encrypt the data, and a secret key,
 * used to decrypt the data
 * </p>
 *
 * @see javax.crypto.Cipher
 * @see java.nio.charset.StandardCharsets
 * @see java.security.InvalidKeyException
 * @see java.security.NoSuchAlgorithmException
 * @see javax.crypto.spec.SecretKeySpec
 *
 * @author EduardoStarZ
 *
 * @since 1.0.0
 */
public class Cryptography {

    private final String message;
    private final byte[] publicKey;
    private final SecretKey secretKey;
    byte[] encryptedMessage;
    Cipher cipher;

    /**
     * <p>
     * A constructor for the {@link Cryptography} class, setting the
     * data and the public key in it's array of bites form.
     * </p>
     *
     * @param data      The String to be used in the cryptography
     * @param publicKey A String containing 16 characters that
     *                  will act as the public key for encryption
     *
     * @since 1.0.0
     */
    public Cryptography(String data, String publicKey) {
        this.message = data;
        this.publicKey = publicKey.getBytes();

        secretKey = new SecretKeySpec(this.publicKey, "AES");
    }

    /**
     * <p>
     * A method that encrypts the set data declared
     * and encrypts it using the bytes defined in the public key
     * </p>
     *
     * @return A byte array containing the encrypted message
     *
     * @since 1.0.0
     */
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

    /**
     * <p>
     * A method the decrypts the data stored in a byte array
     * using the private key, which is also a byte array
     * </p>
     *
     * @return A String containing the decrypted data
     *
     * @since 1.0.0
     */
    public String decrypt(SecretKey secretKey, byte[] encryptedMessage) {
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

    /**
     * <p>
     * A method that returns the secret key, stored in the created instance of the
     * created object, once the {@link Cryptography} object is created
     * </p>
     *
     * @return A byte array containing the secret key, with size of
     *         16 different bytes (same size as the public key)
     *
     * @since 1.0.0
     */
    public SecretKey accessSecretKey() {
        return secretKey;
    }
}
