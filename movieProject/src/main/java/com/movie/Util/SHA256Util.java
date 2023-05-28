package com.movie.Util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Random;

/*
	 * SHA-256 ��ȣȭ
	 * */

public class SHA256Util{
	/* SHA-256 ��ȣȭ
	  
	  @param salt(String) SALT ��
	  
	*/
	public static String getEncrypt(String source, String salt) throws NoSuchAlgorithmException{
		System.out.println("sha 부분 : source::"+source+"salt::"+salt );
		return getEncrypt(source, salt.getBytes());
	}
	
	/*
	 SHA-256 ��ȣȭ
	 
	 @param salt(byte[]) SATL ��
	 
	 */
	
	public static String getEncrypt(String source, byte[] salt) throws NoSuchAlgorithmException{
		String result = "";
		
		 MessageDigest sha = MessageDigest.getInstance("SHA-256");
	        sha.update(source.getBytes());
	 
	        byte[] digest = sha.digest();
	        for (int i=0; i<digest.length; i++) {
	        	result += Integer.toHexString(digest[i] & 0xFF).toUpperCase();
	        }


	
		return result;
	}
	/*
	 	SALT�� ���´�.	 
	 	@return
	*/
	
	public static String generateSalt(){
		Random random = new Random();
		
		byte[] salt = new byte[8];
		random.nextBytes(salt);
		
		StringBuffer sb = new StringBuffer();
		for(int i = 0; i<salt.length;i++){
			//byte ���� hex ������ �ٲٱ�
			sb.append(String.format("%02x", salt[i]));
		}
		return sb.toString();
	}
	
}