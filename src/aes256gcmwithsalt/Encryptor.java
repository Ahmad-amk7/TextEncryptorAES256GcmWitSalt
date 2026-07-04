/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package aes256gcmwithsalt;

import java.nio.charset.StandardCharsets;
import java.security.spec.KeySpec;
import java.util.Base64;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;

/**
 *
 * @author Ahmad
 */
public class Encryptor {
    // the values here are solely for demonstrating the program's operation. uesing them is not recommended
    private static final String saltHier = "sdferhuKSDAKje457854sdKJhsdueissfhLHGHA8dsf752485sdkjfhhgfuraskLKAsdj45uh";
    
    public static String getEncryption(String strKey, String strSalt, String strText)
    {
        byte[] ivByte = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}; // or byte[] ivByte = new byte[12];
        GCMParameterSpec gCMParameterSpec = new GCMParameterSpec(128, ivByte);
        if(strSalt == null)
            strSalt = saltHier;
        
        try 
        {
            SecretKeyFactory secretKeyFactory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256");
            KeySpec keySpec = new PBEKeySpec(strKey.toCharArray(), strSalt.getBytes(), 65536, 256);
            SecretKey secretKey = secretKeyFactory.generateSecret(keySpec);
            SecretKeySpec secretKeySpec = new SecretKeySpec(secretKey.getEncoded(), "AES");
            
            Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding");
            cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec, gCMParameterSpec);
            
            return Base64.getEncoder().encodeToString(cipher.doFinal(strText.getBytes(StandardCharsets.UTF_8)));
        } 
        catch (Exception e) {
            System.err.println("the error is getEncryption is = " + e.toString());
        }
        
        
        return null;
    }
    
    public static String getDecryption(String strKey, String strSalt, String strText)
    {
        byte[] ivByte = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}; // or byte[] ivByte = new byte[12];
        GCMParameterSpec gCMParameterSpec = new GCMParameterSpec(128, ivByte);
        if(strSalt == null)
            strSalt = saltHier;
        
        try 
        {
            SecretKeyFactory secretKeyFactory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256");
            KeySpec keySpec = new PBEKeySpec(strKey.toCharArray(), strSalt.getBytes(), 65536, 256);
            SecretKey secretKey = secretKeyFactory.generateSecret(keySpec);
            SecretKeySpec secretKeySpec = new SecretKeySpec(secretKey.getEncoded(), "AES");
            
            Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding");
            cipher.init(Cipher.DECRYPT_MODE, secretKeySpec, gCMParameterSpec);
            
            return new String(cipher.doFinal(Base64.getDecoder().decode(strText)));
            
        } 
        catch (Exception e) {
            System.err.println("the error in getDecryption is = " + e.toString());
        }
        
        return null;
    }
    
}
