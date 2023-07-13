package com.isource.utility;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.Arrays;

import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;

public class EncryptionDecryption{
	
    private static SecretKeySpec secretKey;//It can be used to construct a <code>SecretKey</code> from a byte array
    private static byte[] key;
    private static String secret=PropertiesReader.getProperty("constant", "SECRETP_KEY_FOR_ENCRYPT_DECRYPT");
   
    public static void main(String[] args){}
    
    @SuppressWarnings("unused")
    public static void setKey(String myKey) {
		MessageDigest sha = null;
        try {
            key = myKey.getBytes("UTF-8");   // class. SHA-1 is a cryptographic hash function used to generate a fixed-size hash value.
            sha = MessageDigest.getInstance("SHA-1");   // SHA-1 is algorithm of the MessageDigest class.
            key = Arrays.copyOf(key, 16);                // key is original parameter and 16 is the new length 
            secretKey = new SecretKeySpec(key, "AES");  //AES is advanced Encryption Standard.
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }
    
   
    public static String encrypt(String strToEncrypt) {
        try {                                        //The IV is required for AES encryption in CBC mode.
            IvParameterSpec ivParameterSpec = new IvParameterSpec(secret.getBytes());
            setKey(secret);         //The cipher object is initialized for decryption using the secretKey and ivParameterSpec
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            cipher.init(Cipher.ENCRYPT_MODE, secretKey, ivParameterSpec);//doFinal method is called to perform the decryption operation on the byte array.
            return DatatypeConverter.printHexBinary(cipher.doFinal(strToEncrypt.getBytes("UTF-8")));  //printHexBinary Converts an array of bytes into a string.
        } catch (Exception e) {
            System.out.println("Error while encrypting: " + e.toString());// printHexBinary CONVERTS ARRAY OF BYTES INTO STRING.
        }
        return null;
    }
   
    
    public static String decrypt(String strToDecrypt) {
        try {
            IvParameterSpec ivParameterSpec = new IvParameterSpec(secret.getBytes());
            setKey(secret);
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
            cipher.init(Cipher.DECRYPT_MODE, secretKey, ivParameterSpec);
            
            return new String(cipher.doFinal(DatatypeConverter.parseHexBinary(strToDecrypt)));// here we have decryped the same by using parseHexBinary Method which converts String arguments into bytes
            
        } catch (Exception e) {
            System.out.println("Error while decrypting: " + e.toString());
        }
        return null;
    }
    
    
    public String tenderWebKeyGeneration(String email,String password, String companyServiceId, String date){
        SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
        date = format.format(date);
        String keyData = email +"|"+ password +"|"+ companyServiceId +"|"+date;
        return keyData;
    }
    public static String GenerateEncryptCode(String Date, String UserID,String UserEmailServiceQueryID, String CompanyServiceID, int tabId) {
        String GeneratedKey = Date + "|" + UserID + "|"+ UserEmailServiceQueryID+ "|" + CompanyServiceID + "|" + tabId;
        GeneratedKey = encrypt(GeneratedKey);
        return GeneratedKey;
    }
    public static String GenerateEncryptCode1(String emailid, String password,String companyServiceId, String date) {
        String GeneratedKey = emailid + "|" + password + "|"+ companyServiceId+ "|" + date;
        GeneratedKey = encrypt(GeneratedKey);
        return GeneratedKey;
    }
} 