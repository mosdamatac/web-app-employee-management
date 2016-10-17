package ca.bcit.comp4613.database.util;

import java.util.Properties;

import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;

public class EncryptDecrypt {
	
	private String passcodeKey;
	private String encryptedValue;
	
	public void init(String passcodeKey, String encryptedValue) {
		this.passcodeKey = passcodeKey;
		this.encryptedValue = encryptedValue;
	}
	
	public String decryptValue() {
		String passcode = System.getProperty(passcodeKey);
		
		StandardPBEStringEncryptor encryptor = new StandardPBEStringEncryptor();
		encryptor.setPassword(passcode);
		String decryptedValue = encryptor.decrypt(encryptedValue);
		
		return decryptedValue;
	}
}
