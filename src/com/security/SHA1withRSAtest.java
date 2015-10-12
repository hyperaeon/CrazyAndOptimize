package com.security;

import java.security.MessageDigest;
import java.security.PrivateKey;
import java.security.PublicKey;

import javax.crypto.Cipher;

import org.apache.xerces.impl.dv.util.Base64;

import com.mchange.util.Base64Encoder;

public class SHA1withRSAtest {

	//Produce signature.
	private static byte[] sign(byte[] content, PrivateKey privateKey) throws Exception {
		MessageDigest md = MessageDigest.getInstance("SHA1");
		byte[] bytes = md.digest(content);
		Cipher cipher = Cipher.getInstance("RSA");
		cipher.init(Cipher.ENCRYPT_MODE, privateKey);
		byte[] encryptBytes = cipher.doFinal(bytes);
		return encryptBytes;
	}
	
	//verify signature.
	private static boolean verify(byte[] content, byte[] sign, PublicKey publicKey) throws Exception {
		MessageDigest md = MessageDigest.getInstance("SHA1");
		byte[] bytes = md.digest(content);
		Cipher cipher = Cipher.getInstance("RSA");
		cipher.init(Cipher.DECRYPT_MODE, publicKey);
		byte[] decryptBytes = cipher.doFinal(sign);
		if (byte2base64(decryptBytes).equals(byte2base64(bytes))) {
			return true;
		} else {
			return false;
		}
	}

	private static Object byte2base64(byte[] decryptBytes) {
		return Base64.encode(decryptBytes);
	}
}
