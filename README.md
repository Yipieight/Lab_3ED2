
# DES Encryption & Decryption in Java

This repository contains two Java programs for **encrypting** and **decrypting** files using the **DES (Data Encryption Standard)** algorithm in **ECB (Electronic Code Book)** mode. The programs demonstrate how to securely encrypt the contents of a `.txt` file and decrypt it back using a shared key.

## Features

- **DES encryption** using the symmetric encryption algorithm.
- **ECB (Electronic Code Book)** mode, which encrypts data in fixed-size blocks (64 bits).
- **PKCS5Padding**, which ensures the plaintext blocks are correctly padded to meet DES's 64-bit block size requirement.
- Easy-to-use methods for file-based encryption and decryption.

---

## Table of Contents

1. [What is DES Encryption?](#what-is-des-encryption)
2. [How the Code Works](#how-the-code-works)
3. [How to Use](#how-to-use)
4. [Improvements](#improvements)
5. [References](#references)

---

## What is DES Encryption?

**Data Encryption Standard (DES)** is a symmetric key algorithm for encryption, meaning that the same key is used for both encryption and decryption. DES uses 64-bit blocks of data, and its key size is 64 bits, but only 56 bits are used in actual encryption, with the remaining 8 bits used for parity checking.

**ECB (Electronic Code Book)** mode encrypts each block independently, which means repeated plaintext blocks will produce repeated ciphertext blocks. This mode is generally not recommended for sensitive data as it can expose patterns.

**PKCS5Padding** is a padding scheme that fills up the last block of data if it's shorter than the required 64-bit size, ensuring the input data is a multiple of the block size.

---

## How the Code Works

### **EncryptDES.java**

This class handles the encryption of data:

- **`encrypt(byte[] data, String key)`**: This method takes the input data (in bytes) and a key, and encrypts the data using DES. The key must be exactly 8 characters (64 bits).
  
- **`encryptFile(String inputFilePath, String encryptedFilePath, String key)`**: This method reads a `.txt` file, encrypts the content using DES, and writes the encrypted output to a new file.

### **DecryptDES.java**

This class handles the decryption of the previously encrypted data:

- **`decrypt(byte[] encryptedData, String key)`**: This method decrypts the data using the same key that was used for encryption. The result is the original plaintext.
  
- **`decryptFile(String encryptedFilePath, String decryptedFilePath, String key)`**: Reads the encrypted file, decrypts its content, and writes the decrypted data back to a file.

---

## How to Use

### 1. **Setup**

Ensure you have a Java development environment installed. You'll need to compile and run the code with the following steps:

### 2. **Encryption**

To encrypt a file:
- Place your plaintext file (e.g., `input.txt`) in the project directory.
- Set the key (e.g., `ok:uo1IN`) in `EncryptDES.java`.
- Run the encryption process by executing the `main()` method in `EncryptDES.java`.

```bash
javac EncryptDES.java
java EncryptDES
```

This will generate an encrypted file (e.g., `encrypted.inc`) in the project directory.

### 3. **Decryption**

To decrypt the file:
- Use the same key (e.g., `ok:uo1IN`) that was used for encryption.
- Run the decryption process by executing the `main()` method in `DecryptDES.java`.

```bash
javac DecryptDES.java
java DecryptDES
```

The output will be a decrypted file (e.g., `decrypted.txt`).

---

## Improvements

Here are some suggestions for improving the code:

1. **Use a More Secure Algorithm**: DES is considered outdated and insecure for most applications due to its small key size (56-bit effective key length). Consider using AES (Advanced Encryption Standard) instead, which offers 128-bit, 192-bit, and 256-bit key sizes for stronger encryption.

2. **Switch to a More Secure Mode**: ECB mode is vulnerable to certain types of attacks since identical plaintext blocks produce identical ciphertext blocks. Switching to **CBC (Cipher Block Chaining)** mode with an **IV (Initialization Vector)** will improve security.

3. **Error Handling**: The current implementation lacks detailed error handling. Adding custom exceptions and better error reporting (e.g., handling corrupted files, incorrect keys) would make the program more robust.

4. **Input Validation**: Ensure that the input file is correctly formatted and the key is exactly 8 characters for DES encryption. Additional input validation and user prompts could be added to improve usability.

5. **Command-Line Interface (CLI)**: You could extend the program to accept file paths and keys as command-line arguments instead of hardcoding them in the program. This would make the tool more flexible and user-friendly for different use cases.

6. **Key Management**: Storing and securely managing the encryption key is critical. Consider adding features for secure key storage or key derivation functions.

---

## References

- [Java Cryptography Architecture (JCA) Documentation](https://docs.oracle.com/javase/8/docs/technotes/guides/security/crypto/CryptoSpec.html)
- [Introduction to Data Encryption Standard (DES)](https://en.wikipedia.org/wiki/Data_Encryption_Standard)
- [Symmetric Encryption Algorithms](https://docs.oracle.com/javase/7/docs/technotes/guides/security/crypto/CryptoSpec.html#Symmetric)

---

If you have any questions or feedback, feel free to open an issue or contribute to the repository. Thank you for checking out this project!
