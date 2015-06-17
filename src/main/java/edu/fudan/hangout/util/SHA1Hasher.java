package edu.fudan.hangout.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by Tong on 06.17.
 */
public class SHA1Hasher {

    public static String makeSHA1Hash(String input){
        MessageDigest md = null;
        try {
            md = MessageDigest.getInstance("SHA1");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        md.reset();
        byte[] buffer = input.getBytes();
        md.update(buffer);
        byte[] digest = md.digest();

        String hexStr = "";
        for (byte aDigest : digest) {
            hexStr += Integer.toString((aDigest & 0xff) + 0x100, 16).substring(1);
        }
        return hexStr;
    }
}
