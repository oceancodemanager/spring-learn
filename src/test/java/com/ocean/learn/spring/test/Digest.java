package com.ocean.learn.spring.test;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.UUID;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

import org.apache.commons.codec.binary.Hex;

public class Digest {
	public static void main(String[] args) {
		md5Encode();
		// desEncode();
	}

	public static void md5Encode() {
		long b = System.currentTimeMillis();
		try {
			MessageDigest digest = MessageDigest.getInstance("MD5");
			for (int i = 0; i < 100; i++) {
				String uuid = UUID.randomUUID().toString();
				System.out.println("a:" + new String(Hex.encodeHex(digest.digest(uuid.getBytes()))));
			}
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		System.out.println("md5:" + (System.currentTimeMillis() - b));
	}

	public static void desEncode() {
		long b = System.currentTimeMillis();
		try {
			KeyGenerator generator = KeyGenerator.getInstance("DES");
			SecretKey key = generator.generateKey();
			Cipher cipher = Cipher.getInstance("DES");
			cipher.init(Cipher.ENCRYPT_MODE, key);
			for (int i = 0; i < 100000; i++) {
				String uuid = UUID.randomUUID().toString();
				cipher.doFinal(uuid.getBytes());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("des:" + (System.currentTimeMillis() - b));
	}

}
