package com.springapp.mvc;

import org.springframework.stereotype.Service;

import javax.crypto.*;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.Charset;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

/**
 * Created by sardesh on 9/1/16.
 */
@Service
public class PaymentGateway {
    private final String secret_key = "Q9fbkBF8au24C9wshGRW9utecYpyXye5vhFLtHFdGjRg3a4HxPYxPYRfKutZx5N4";
    private static final Charset ASCII = Charset.forName("US-ASCII");

    public String verifyPymentDetails(String msg) {
        byte[] cipherBytes = Base64.getDecoder().decode(msg);
        String aesDecriptedStr = "";
        byte [] iv = secret_key.getBytes(ASCII);
        byte [] keyBytes = secret_key.getBytes(ASCII);

        SecretKey aesKey = new SecretKeySpec(keyBytes, "AES");
       try {
           Cipher cipher = Cipher.getInstance("AES/CBC/NOPADDING");
           cipher.init(Cipher.DECRYPT_MODE, aesKey, new IvParameterSpec(iv));

           byte[] result = cipher.doFinal(cipherBytes);
           return String.valueOf(result);
       } catch (NoSuchPaddingException e) {
           e.printStackTrace();
       } catch (InvalidAlgorithmParameterException e) {
           e.printStackTrace();
       } catch (NoSuchAlgorithmException e) {
           e.printStackTrace();
       } catch (IllegalBlockSizeException e) {
           e.printStackTrace();
       } catch (BadPaddingException e) {
           e.printStackTrace();
       } catch (InvalidKeyException e) {
           e.printStackTrace();
       }
       return "some thing went wrong";
    }

}
