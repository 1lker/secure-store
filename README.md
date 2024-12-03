# SecureStore - Advanced Secure File Storage System

## Overview
SecureStore is an advanced secure file storage system developed in Java, designed to securely store and manage sensitive data. The system offers multi-layered security features to protect your data, including multi-factor authentication, advanced encryption techniques, dynamic re-encryption algorithms, granular access control, tamper detection, and machine learning-based anomaly detection.

## Features
- **Device Registration and Authentication**
    - **Multi-Factor Authentication (MFA):** Implements MFA during initial setup using Google Authenticator.
    - **Device Pairing:** Generates a unique device identity token using your device's MAC ID, device fingerprint, and user credentials, securely storing it.
- **Advanced Encryption Techniques**
    - **Elliptic Curve Cryptography (ECC):** Utilized for key exchange and management.
    - **Hybrid Encryption System:** Combines symmetric (AES-256) and asymmetric encryption for both speed and robust security.
    - **Randomized Salt Value:** Uses a random salt value for each encryption process.
- **File and Metadata Layering**
    - **Separate Encryption:** Encrypts file content and metadata separately.
    - **Integrity Check:** Generates a SHA-512 hash for the file content.
- **Dynamic Re-Encryption Algorithms**
    - **AI-Based Adaptive Encryption:** Dynamically changes the encryption method based on usage patterns, file sensitivity, and user behavior.
    - **Key Rotation:** Rotates keys upon each open and close, storing them securely in the background.
- **Granular Access Control**
    - **Role-Based Access Control (RBAC):** Applied for shared files.
    - **Unique Decryption Keys:** Each user is provided with a unique decryption key tied to their biometric data.
    - **Auditing and Logging:** Every file interaction is logged with timestamps and device information.
- **File Format Conversion and Obfuscation**
    - **Proprietary Format Conversion:** Converts files into a proprietary format before encryption.
    - **Multi-Layer Obfuscation:** Used to conceal file types from potential attackers.
- **Tamper Detection and Prevention**
    - **Tamper-Evident Tokens:** Detects unauthorized changes to the system or files.
    - **Self-Destruct Mechanism:** Deletes encryption keys and renders all files unreadable if tampering is detected.
- **Anomaly Detection with Machine Learning**
    - **Anomaly Detection:** Monitors file access and encryption patterns to detect unusual activities.

## Requirements
- Java Development Kit (JDK) 11 or higher
- Apache Maven
- Maven Dependencies: The project uses various libraries managed via Maven, which will be automatically downloaded.

## Installation
1. Clone the Repository:
        ```bash
        git clone https://github.com/yourusername/SecureStore.git
        cd SecureStore
        ```
2. Ensure the Project Structure:
        Make sure the following directory structure exists:
        ```plaintext
        SecureStore/
        ├── pom.xml
        ├── src/
        │   ├── main/
        │   │   ├── java/
        │   │   │   └── com/
        │   │   │       └── securestore/
        │   │   │           ├── models/
        │   │   │           ├── security/
        │   │   │           ├── services/
        │   │   │           └── SecureStoreApplication.java
        │   └── resources/
        └── secure_files/
                └── sample.txt
        ```
        Create a `secure_files` folder in the project root and add a test `sample.txt` file for demonstration.
3. Build the Project:
        ```bash
        mvn clean install
        ```
4. Run the Application:
        ```bash
        mvn exec:java
        ```

## Usage
When you run the application, it performs a series of security operations demonstrating the features of the SecureStore system:
- Device Registration and MFA Authentication
- File Encryption with Advanced Encryption Techniques
- Tamper Detection and Self-Destruct Mechanism Simulation
- Anomaly Detection (Placeholder used due to absence of a real model)
- Access Control and Logging

## Directory Structure
- `src/main/java/com/securestore`
    - `models`: Contains data model classes like `EncryptedFile` and `UserBehavior`.
    - `security`: Contains helper classes for encryption and hashing operations.
    - `services`: Implements various features such as device registration, MFA, encryption services, and access control.
    - `SecureStoreApplication.java`: The main class that runs the application.
- `src/main/resources`
    - `models`: Placeholder for machine learning models (can be integrated in the future).
- `secure_files`
    - Directory where files to be encrypted and processed are stored.

## Dependencies
The project utilizes the following main dependencies:
- Spring Security: For authentication and security features.
- Google Authenticator: For MFA implementation.
- Bouncy Castle: For advanced cryptographic functions.
- Apache Commons Codec: Utility library for encoding and hashing.
- SLF4J: For logging purposes.
These dependencies are managed via Maven and specified in the `pom.xml` file.

## Limitations
- **Machine Learning Model:** The anomaly detection feature currently uses random values as a placeholder due to the absence of a real machine learning model.
- **Biometric Data Processing:** Biometric key generation is not integrated with real biometric hardware or data and uses placeholder implementations.

## Future Enhancements
- Integration of a Real Machine Learning Model: For effective anomaly detection.
- Biometric Authentication: Integration with biometric devices for key generation and authentication.
- User Interface: Development of a GUI or web interface for better user interaction.

## Contributing
Contributions are welcome! Please follow these steps:
1. Fork the repository.
2. Create a new branch (`git checkout -b feature/YourFeature`).
3. Commit your changes (`git commit -am 'Add a new feature'`).
4. Push to the branch (`git push origin feature/YourFeature`).
5. Open a Pull Request.

## License
This project is licensed under the MIT License - see the LICENSE file for details.

## Acknowledgments
Inspired by the need for advanced security system designs and robust data protection mechanisms. Thanks to all open-source contributors and library authors who made this project possible.
