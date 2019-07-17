package com.vz.hashservice.common;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.SecureRandom;

public class HashService {
	
	public static String getHashPassword(String passwordToHash, String saltForRequester)throws NoSuchAlgorithmException, NoSuchProviderException{
		byte[] salt = getSalt(saltForRequester);
		String securePassword = getSecurePassword(passwordToHash, salt);
		return securePassword;
	}

	private static String getSecurePassword(String passwordToHash, byte[] salt) {
		String generatedHashPassword= null;
		try {
			//First you create MessageDigest instance for MD5 checksum generation
			MessageDigest md = MessageDigest.getInstance("MD5");
			// Add password bytes to digest
			md.update(salt);
			// get the Hash's bytes
			byte[] bytes = md.digest(passwordToHash.getBytes());
			// THis bytes[] has bytes in decimal format
			// Convert it to hexadecimal format
			StringBuffer sb = new StringBuffer();
			for(int i=0; i< bytes.length; i++) {
				sb.append(Integer.toString((bytes[i]& 0xff)+0x100,32).substring(1));
			
			// get comlete hashed password in hex format
				generatedHashPassword = sb.toString();
				
			}
		}catch(NoSuchAlgorithmException exception) {
			exception.printStackTrace();
		}
		return generatedHashPassword;
	}
	// Add salt
	private static byte[] getSalt(String salt) throws NoSuchAlgorithmException, NoSuchProviderException {
		byte[] salt1 = new byte[16];
		salt1 = salt.getBytes();
		return salt1;
	}
}
