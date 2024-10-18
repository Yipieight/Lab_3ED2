package org.example;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Base64;


public class DecryptDES {

    // Método para descifrar el contenido del archivo
    public static byte[] decrypt(byte[] encryptedData, String key) throws Exception {
        // Convertir la clave a formato DES
        DESKeySpec desKeySpec = new DESKeySpec(key.getBytes());
        SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
        SecretKey secretKey = keyFactory.generateSecret(desKeySpec);

        // Crear una instancia de Cipher para DES en Modo ECB
        Cipher cipher = Cipher.getInstance("DES/ECB/PKCS5Padding");
        cipher.init(Cipher.DECRYPT_MODE, secretKey);

        // Descifrar el contenido
        return cipher.doFinal(encryptedData);
    }

    // Método para leer el archivo cifrado y descifrarlo
    public static void decryptFile(String encryptedFilePath, String decryptedFilePath, String key) throws Exception {
        // Leer el contenido cifrado del archivo
        byte[] encryptedData = Files.readAllBytes(Paths.get(encryptedFilePath));

        // Descifrar el contenido usando la clave
        byte[] decryptedData = decrypt(encryptedData, key);

        // Guardar el contenido descifrado en un nuevo archivo o mostrarlo
        Files.write(Paths.get(decryptedFilePath), decryptedData);
        
        // Mostrar el contenido en la consola
        System.out.println("Contenido descifrado: " + new String(decryptedData));
    }

    // Método principal
    public static void main(String[] args) {
        // Clave de 8 caracteres para DES
        String key = "ok:uo1IN";  // Reemplazar con la clave que tienes
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

