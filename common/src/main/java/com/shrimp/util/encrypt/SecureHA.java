package com.shrimp.util.encrypt;

import java.math.BigInteger;
import java.security.MessageDigest;

/**
 * @description: Secure Hash Algorithm，安全散列算法
 * @author: shrimp
 * @date: Created in 2020-01-11 18:39
 * @version: 1.0
 */
public class SecureHA {
    public static final String KEY_SHA = "SHA";

    public static String getResult(String inputStr) {
        BigInteger sha = null;
        try {
            byte[] inputData = inputStr.getBytes();
            MessageDigest messageDigest = MessageDigest.getInstance(KEY_SHA);
            messageDigest.update(inputData);
            sha = new BigInteger(messageDigest.digest());
            return sha.toString(32);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
