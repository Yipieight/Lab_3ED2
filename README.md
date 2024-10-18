
# Encriptación y Desencriptación DES en Java

Este repositorio contiene dos programas en Java para **encriptar** y **desencriptar** archivos utilizando el algoritmo **DES (Data Encryption Standard)** en modo **ECB (Electronic Code Book)**. Los programas demuestran cómo cifrar de forma segura el contenido de un archivo `.txt` y descifrarlo usando una clave compartida.

## Características

- **Encriptación DES** usando el algoritmo de cifrado simétrico.
- **Modo ECB (Electronic Code Book)**, que cifra los datos en bloques de tamaño fijo (64 bits).
- **PKCS5Padding**, que garantiza que los bloques de texto sin formato estén correctamente rellenados para cumplir con el tamaño de bloque de 64 bits requerido por DES.
- Métodos fáciles de usar para la encriptación y desencriptación de archivos.

---

## Tabla de Contenidos

1. [¿Qué es la Encriptación DES?](#qué-es-la-encriptación-des)
2. [Cómo Funciona el Código](#cómo-funciona-el-código)
3. [Cómo Usarlo](#cómo-usarlo)
4. [Mejoras](#mejoras)
5. [Referencias](#referencias)

---

## ¿Qué es la Encriptación DES?

El **Data Encryption Standard (DES)** es un algoritmo de clave simétrica para cifrar, lo que significa que la misma clave se usa tanto para cifrar como para descifrar. DES trabaja con bloques de datos de 64 bits, y su tamaño de clave es de 64 bits, aunque solo 56 bits se usan en el cifrado real, y los otros 8 bits se usan para la verificación de paridad.

El modo **ECB (Electronic Code Book)** cifra cada bloque de forma independiente, lo que significa que los bloques de texto sin formato repetidos producirán bloques de texto cifrado repetidos. Este modo generalmente no se recomienda para datos sensibles, ya que puede exponer patrones.

**PKCS5Padding** es un esquema de relleno que completa el último bloque de datos si es más corto que el tamaño requerido de 64 bits, asegurando que los datos de entrada sean múltiplos del tamaño del bloque.

---

## Cómo Funciona el Código

### **EncryptDES.java**

Esta clase se encarga de la encriptación de datos:

- **`encrypt(byte[] data, String key)`**: Este método toma los datos de entrada (en bytes) y una clave, y cifra los datos usando DES. La clave debe tener exactamente 8 caracteres (64 bits).
  
- **`encryptFile(String inputFilePath, String encryptedFilePath, String key)`**: Este método lee un archivo `.txt`, cifra el contenido usando DES y escribe la salida cifrada en un nuevo archivo.

### **DecryptDES.java**

Esta clase se encarga de la desencriptación de los datos previamente cifrados:

- **`decrypt(byte[] encryptedData, String key)`**: Este método descifra los datos utilizando la misma clave que se usó para cifrar. El resultado es el texto original.
  
- **`decryptFile(String encryptedFilePath, String decryptedFilePath, String key)`**: Lee el archivo cifrado, descifra su contenido y escribe los datos descifrados en un archivo.

---

## Cómo Usarlo

### 1. **Configuración**

Asegúrate de tener instalado un entorno de desarrollo de Java. Debes compilar y ejecutar el código con los siguientes pasos:

### 2. **Encriptación**

Para encriptar un archivo:
- Coloca tu archivo de texto sin formato (por ejemplo, `input.txt`) en el directorio del proyecto.
- Establece la clave (por ejemplo, `ok:uo1IN`) en `EncryptDES.java`.
- Ejecuta el proceso de encriptación ejecutando el método `main()` en `EncryptDES.java`.

```bash
javac EncryptDES.java
java EncryptDES
```

Esto generará un archivo cifrado (por ejemplo, `encrypted.inc`) en el directorio del proyecto.

### 3. **Desencriptación**

Para desencriptar el archivo:
- Usa la misma clave (por ejemplo, `ok:uo1IN`) que se utilizó para la encriptación.
- Ejecuta el proceso de desencriptación ejecutando el método `main()` en `DecryptDES.java`.

```bash
javac DecryptDES.java
java DecryptDES
```

El resultado será un archivo descifrado (por ejemplo, `decrypted.txt`).

---

## Mejoras

Aquí tienes algunas sugerencias para mejorar el código:

1. **Usar un Algoritmo Más Seguro**: DES se considera obsoleto e inseguro para la mayoría de las aplicaciones debido a su pequeño tamaño de clave (56 bits efectivos). Considera usar AES (Advanced Encryption Standard), que ofrece tamaños de clave de 128, 192 y 256 bits para un cifrado más fuerte.

2. **Cambiar a un Modo Más Seguro**: El modo ECB es vulnerable a ciertos tipos de ataques, ya que los bloques de texto sin formato idénticos producen bloques cifrados idénticos. Cambiar al modo **CBC (Cipher Block Chaining)** con un **IV (Vector de Inicialización)** mejorará la seguridad.

3. **Manejo de Errores**: La implementación actual carece de un manejo de errores detallado. Añadir excepciones personalizadas y un mejor reporte de errores (por ejemplo, archivos corruptos, claves incorrectas) haría el programa más robusto.

4. **Validación de Entradas**: Asegúrate de que el archivo de entrada esté correctamente formateado y que la clave tenga exactamente 8 caracteres para la encriptación DES. Se podría agregar validación de entradas adicional y mensajes de usuario para mejorar la usabilidad.

5. **Interfaz de Línea de Comandos (CLI)**: Podrías extender el programa para aceptar rutas de archivos y claves como argumentos de la línea de comandos en lugar de estar codificados. Esto haría que la herramienta sea más flexible y fácil de usar en diferentes casos de uso.

6. **Gestión de Claves**: Almacenar y gestionar de manera segura la clave de encriptación es fundamental. Considera añadir características para un almacenamiento seguro de claves o funciones de derivación de claves.

---

## José Andrés García Elías 1106423
