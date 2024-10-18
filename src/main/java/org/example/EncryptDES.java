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


public class EncryptDES {

    // Método para encriptar el contenido
    public static byte[] encrypt(byte[] data, String key) throws Exception {
        // Convertir la clave a formato DES
        DESKeySpec desKeySpec = new DESKeySpec(key.getBytes());
        SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
        SecretKey secretKey = keyFactory.generateSecret(desKeySpec);

        // Crear una instancia de Cipher para DES en modo ECB
        Cipher cipher = Cipher.getInstance("DES/ECB/PKCS5Padding");
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);

        // Encriptar el contenido
        return cipher.doFinal(data);
    }

    // Método para leer un archivo de texto y encriptarlo
    public static void encryptFile(String inputFilePath, String encryptedFilePath, String key) throws Exception {
        // Leer el contenido del archivo
        byte[] fileData = Files.readAllBytes(Paths.get(inputFilePath));

        // Encriptar el contenido del archivo
        byte[] encryptedData = encrypt(fileData, key);

        // Guardar el contenido encriptado en un nuevo archivo
        Files.write(Paths.get(encryptedFilePath), encryptedData);

        // Mostrar el contenido encriptado (opcional, en Base64 para legibilidad)
        System.out.println("Contenido encriptado (Base64): " + Base64.getEncoder().encodeToString(encryptedData));
    }

    // Método principal
    public static void Encriptar() {
        // Clave de 8 caracteres para DES
        String key = "ok:uo1IN";  // Clave proporcionada
        String inputFilePath = "Output_Jose_Garcia_Lab4.txt";  // Ruta del archivo de entrada
        String encryptedFilePath = "archivo_encriptado_Jose_Garcia_Lab4.inc";  // Ruta del archivo encriptado de salida

        try {
            // Llamar al método para encriptar el archivo
            encryptFile(inputFilePath, encryptedFilePath, key);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

