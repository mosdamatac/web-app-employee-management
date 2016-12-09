package ca.bcit.comp4613.database.util;

import java.util.Properties;

import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;

public class EncryptDecrypt {
	
	private String passcode;
	private String encryptedValue;
	
	public void init(String passcode, String encryptedValue) {
		this.passcode = passcode;
		this.encryptedValue = encryptedValue;
	}
	
	public String decryptValue() {
		
		StandardPBEStringEncryptor encryptor = new StandardPBEStringEncryptor();
		encryptor.setPassword(passcode);
		String decryptedValue = encryptor.decrypt(encryptedValue);
		
		return decryptedValue;
	}
}
