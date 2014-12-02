package test;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import jSon.*;

public class Client {
	public String sentToServer (String gSonString) throws Exception {
		String objectString = null;
		String modifiedSentence;
		Socket clientSocket = new Socket("127.0.0.1", 8888);
		DataOutputStream outToServer = new DataOutputStream(
				clientSocket.getOutputStream());
		
		byte[] input = gSonString.getBytes();
		byte key = (byte) 3.1470;
		byte[] encrypted = input;
		for (int i = 0; i < encrypted.length; i++)
			encrypted[i] = (byte) (encrypted[i] ^ key);

		outToServer.write(encrypted);
		outToServer.flush();
		BufferedReader inFromServer = new BufferedReader(new InputStreamReader(
				clientSocket.getInputStream()));
		modifiedSentence = inFromServer.readLine();
		
		System.out.println(modifiedSentence);
		String testString = new String(modifiedSentence).trim();
		byte[] input2 = testString.getBytes();
		byte key2 = (byte) 3.1470;
		byte[] encrypted2 = input2;
		for (int i = 0; i < encrypted2.length; i++)
			{encrypted2[i] = (byte) (encrypted2[i] ^ key2);}

		String decrypted2 = new String(encrypted2).trim();
		
		System.out.println("FROM SERVER: " + decrypted2);
		
		clientSocket.close();
		objectString = decrypted2;
		return objectString;
	}
}
