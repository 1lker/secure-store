To compile & install
```bash
mvn clean install
```

To execute
```bash
mvn exec:java -Dexec.mainClass="com.securestore.SecureStoreApplication"
```


* Example output

```bash
[INFO] --- exec:3.0.0:java (default-cli) @ SecureStore ---
Cihaz belirteci kaydedildi: 63807d398a275b55163add7453a935a50e2e088e310e92952d73411e8324d077
Cihaz Belirteci: 63807d398a275b55163add7453a935a50e2e088e310e92952d73411e8324d077
MFA Gizli Anahtarı: K3ER5WBKIYJJSK4D
MFA Doğrulaması: false
Dosya şifrelendi.
Dosya güvenli.
Etkinlik normal.
Kullanıcının dosyayı okuma izni var.
Log: 2024-12-03T11:42:15.127333Z | User: user123 | File: file123 | Action: READ | Device: DeviceInfo
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time:  1.015 s
[INFO] Finished at: 2024-12-03T14:42:15+03:00
[INFO] ------------------------------------------------------------------------
(base) ilkeryoru@ilkers-MacBook-Pro Secure-File-System % mvn exec:java -Dexec.mainClass="com.securestore.SecureStoreApplication"
[INFO] Scanning for projects...
[INFO] 
[INFO] --------------------< com.securestore:SecureStore >---------------------
[INFO] Building SecureStore 1.0-SNAPSHOT
[INFO]   from pom.xml
[INFO] --------------------------------[ jar ]---------------------------------
[INFO] 
[INFO] --- exec:3.0.0:java (default-cli) @ SecureStore ---
Cihaz belirteci kaydedildi: 63807d398a275b55163add7453a935a50e2e088e310e92952d73411e8324d077
Cihaz Belirteci: 63807d398a275b55163add7453a935a50e2e088e310e92952d73411e8324d077
MFA Gizli Anahtarı: HG2NJFRGS4X5FGSS
MFA Doğrulaması: false
Dosya şifrelendi.
Dosya güvenli.
Etkinlik normal.
Kullanıcının dosyayı okuma izni var.
Log: 2024-12-03T11:44:09.473111Z | User: user123 | File: file123 | Action: READ | Device: DeviceInfo
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time:  1.093 s
[INFO] Finished at: 2024-12-03T14:44:09+03:00
[INFO] ------------------------------------------------------------------------
(base) ilkeryoru@ilkers-MacBook-Pro Secure-File-System % 
````

