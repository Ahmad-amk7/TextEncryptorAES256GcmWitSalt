# TextEncryptorAES256GcmWitSalt
A Java Swing application for encrypting and decrypting text using AES‑256 GCM with Salt and PBKDF2 key derivation.

👤 Über den Entwickler
Dieses Projekt wurde von Ahmad Khaddm entwickelt, einem praxisorientierten Java‑Entwickler mit Schwerpunkt auf sicherer Softwareentwicklung, moderner Kryptografie und sauberer Anwendungsarchitektur.
🇬🇧 README – English Version
🔐 TextEncryptorAES256GcmWitSalt
A Java Swing application for secure text encryption and decryption using AES‑256 GCM, PBKDF2 key derivation, and Salt.

📌 Overview
This project demonstrates modern encryption practices using AES‑256 GCM (Galois/Counter Mode), a highly recommended mode for secure data protection. The application provides a simple UI for encrypting and decrypting text using a password.

⚙️ Why AES‑256 GCM?
AES supports multiple modes, but GCM is considered one of the most secure and modern options.
Here’s why:

Authenticated Encryption (AEAD):  
GCM not only encrypts the data but also verifies its integrity. If any bit is modified, decryption fails immediately.

Faster and safer than CBC:  
Older modes like AES‑CBC require padding and are vulnerable to padding‑oracle attacks.
GCM avoids these issues entirely.

Widely recommended:  
Used in TLS 1.3, modern APIs, cloud systems, and security‑critical applications.

⚠️ Important Note About Salt
In this project, the salt is currently static (fixed).
This works for demonstration purposes, but should NOT be used in production.

❗ Why static salt is unsafe?
A fixed salt makes password‑derived keys predictable.

It reduces protection against rainbow‑table attacks.

It breaks the main purpose of salt: uniqueness per encryption.

✔️ Recommended approach
Generate a random salt for each encryption.

Store the salt securely (e.g., prepend it to the ciphertext).

Pass the salt to the encryption class as a string or byte array.

🚨 Responsibility Disclaimer
If the user loses the password or loses the salt,
decryption becomes impossible — even for the developer.
This is normal and expected behavior for strong cryptography.

🛠️ Technical Details
Algorithm: AES‑256 GCM

Key derivation: PBKDF2WithHmacSHA256

Salt: (currently static, should be random)

IV: 12 bytes (recommended GCM size)

Output: Base64(salt + iv + ciphertext)

🖥️ UI
The application provides two text fields:

Text to encryption

Text to decryption  
Plus buttons for Encryption, Decryption, and Clear.

📜 License
MIT License

🇩🇪 README – Deutsche Version
🔐 TextEncryptorAES256GcmWitSalt
Eine Java‑Swing‑Anwendung zur sicheren Textverschlüsselung und ‑entschlüsselung mit AES‑256 GCM, PBKDF2‑Schlüsselableitung und Salt.

📌 Überblick
Dieses Projekt zeigt moderne Verschlüsselungspraktiken mit AES‑256 GCM (Galois/Counter Mode).
Die Anwendung bietet eine einfache Benutzeroberfläche zum Verschlüsseln und Entschlüsseln von Texten mittels Passwort.

⚙️ Warum AES‑256 GCM?
AES bietet verschiedene Betriebsmodi, aber GCM gilt als einer der sichersten und modernsten.

Authentifizierte Verschlüsselung (AEAD):  
GCM verschlüsselt nicht nur die Daten, sondern prüft auch deren Integrität.
Jede Manipulation führt zu einem sofortigen Fehler.

Schneller und sicherer als CBC:  
Ältere Modi wie AES‑CBC benötigen Padding und sind anfällig für Padding‑Oracle‑Angriffe.
GCM vermeidet diese Probleme vollständig.

Empfohlen in modernen Standards:  
Verwendet in TLS 1.3, Cloud‑Systemen, APIs und sicherheitskritischen Anwendungen.

⚠️ Wichtiger Hinweis zum Salt
In diesem Projekt wird derzeit ein statisches Salt verwendet.
Dies ist für Demonstrationszwecke in Ordnung, aber nicht für produktive Nutzung geeignet.

❗ Warum ist statisches Salt unsicher?
Ein festes Salt macht passwortbasierte Schlüssel vorhersehbar.

Es reduziert den Schutz vor Rainbow‑Table‑Angriffen.

Es widerspricht dem Grundprinzip eines Salts: Einzigartigkeit pro Verschlüsselung.

✔️ Empfohlene Vorgehensweise
Für jede Verschlüsselung ein zufälliges Salt erzeugen.

Salt sicher speichern (z. B. vor den Ciphertext setzen).

Salt als String oder Byte‑Array an die Verschlüsselungsklasse übergeben.

🚨 Haftungsausschluss
Wenn das Passwort oder das Salt verloren geht,
ist eine Entschlüsselung unmöglich — selbst für den Entwickler.
Dies ist normales Verhalten bei starker Kryptografie.

🛠️ Technische Details
Algorithmus: AES‑256 GCM

Schlüsselableitung: PBKDF2WithHmacSHA256

Salt: (derzeit statisch, sollte zufällig sein)

IV: 12 Bytes

Ausgabe: Base64(salt + iv + ciphertext)

🖥️ Benutzeroberfläche
Die Anwendung bietet zwei Textfelder:

Text to encryption

Text to decryption  
Sowie Buttons für Verschlüsselung, Entschlüsselung und Löschen.

📜 Lizenz
MIT License

