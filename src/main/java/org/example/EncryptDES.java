package org.example;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import java.nio.file.Files;
import java.nio.file.Paths;


public class EncryptDES {

    public static byte[] encrypt(byte[] data, String key) throws Exception {
        DESKeySpec desKeySpec = new DESKeySpec(key.getBytes());
        SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
        SecretKey secretKey = keyFactory.generateSecret(desKeySpec);

        Cipher cipher = Cipher.getInstance("DES/ECB/PKCS5Padding");
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);

        return cipher.doFinal(data);
    }

    public static void encryptFile(String inputFilePath, String encryptedFilePath, String key) throws Exception {
        byte[] fileData = Files.readAllBytes(Paths.get(inputFilePath));

        byte[] encryptedData = encrypt(fileData, key);

        Files.write(Paths.get(encryptedFilePath), encryptedData);
    }

    public static void Encriptar() {
        // Clave de 8 caracteres para DES
        String key = "ok:uo1IN";  // Clave proporcionada
        String inputFilePath = "Output_Jose_Garcia_Lab4.txt";  // Ruta del archivo qie se quiere evaluar
        String encryptedFilePath = "archivo_encriptado_Jose_Garcia_Lab4.inc";  // Ruta del archivo salida

        try {
            // Llamar al método para encriptar el archivo
            encryptFile(inputFilePath, encryptedFilePath, key);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

