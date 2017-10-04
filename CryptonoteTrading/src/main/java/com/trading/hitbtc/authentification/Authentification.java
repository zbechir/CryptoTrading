package com.trading.hitbtc.authentification;

import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Date;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Authentification {
	private String secretKey = "f7bf3f6449e9f1e9df07500bd9f0b359";
	private String publicKey = "097dc62a2e6c3af659358684fe911b87";
	private static final Logger log = LoggerFactory.getLogger(Authentification.class);

	public Authentification() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getUri(String order) {
		String message = "";
		Date date = new Date();
		message = order + "nonce=" + date.getTime() + "&apikey=" + publicKey;
		return message;
	}

	public String hmacDigest(String message) {

		String digest = null;

		String algo = "HmacSHA512";

		try {

			SecretKeySpec key = new SecretKeySpec((secretKey).getBytes("UTF-8"), algo);

			Mac mac = Mac.getInstance(algo);

			mac.init(key);

			byte[] bytes = mac.doFinal(message.getBytes("UTF-8"));

			StringBuilder hash = new StringBuilder();

			for (int i = 0; i < bytes.length; i++) {

				String hex = Integer.toHexString(0xFF & bytes[i]);

				if (hex.length() == 1) {

					hash.append('0');

				}

				hash.append(hex);

			}

			digest = hash.toString();

		} catch (UnsupportedEncodingException e) {

			e.printStackTrace();

		} catch (InvalidKeyException e) {

			e.printStackTrace();

		} catch (NoSuchAlgorithmException e) {

			e.printStackTrace();

		}

		return digest;

	}
}
