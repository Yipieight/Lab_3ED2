package org.example;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import java.nio.file.Files;
import java.nio.file.Paths;


public class DecryptDES {

    public static byte[] decrypt(byte[] encryptedData, String key) throws Exception {
        DESKeySpec desKeySpec = new DESKeySpec(key.getBytes());
        SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
        SecretKey secretKey = keyFactory.generateSecret(desKeySpec);

        Cipher cipher = Cipher.getInstance("DES/ECB/PKCS5Padding");
        cipher.init(Cipher.DECRYPT_MODE, secretKey);

        return cipher.doFinal(encryptedData);
    }

    // Método para leer el archivo cifrado y descifrarlo
    public static void decryptFile(String encryptedFilePath, String decryptedFilePath, String key) throws Exception {
        byte[] encryptedData = Files.readAllBytes(Paths.get(encryptedFilePath));

        byte[] decryptedData = decrypt(encryptedData, key);

        Files.write(Paths.get(decryptedFilePath), decryptedData);
        
        System.out.println("Contenido descifrado: " + new String(decryptedData));
    }

    // Método principal
    public static void main(String[] args) {
        String key = "ok:uo1IN";  
        String encryptedFilePath = "archivo_encriptado_Jose_Garcia_Lab4.inc";
        String decryptedFilePath = "archivo_decifrado.txt";

        try {
            // Llamar al método para descifrar el archivo
            decryptFile(encryptedFilePath, decryptedFilePath, key);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

