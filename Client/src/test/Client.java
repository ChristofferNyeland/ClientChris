package test;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import encryption.Encryption;
import jSon.*;
public class Client { // Class that contains all details in order to communicate with server
	public String sentToServer (String gSonString) throws Exception { // sending by serializing it 
		Encryption cryptMessage = new Encryption(); // new object of encryption class
		String objectString = null; //empty String 
		String modifiedSentence;
		Socket clientSocket = new Socket("127.0.0.1", 8888); // IP and port ''localhost and port 8888''
		DataOutputStream outToServer = new DataOutputStream(
				clientSocket.getOutputStream()); // out to server
		
		byte[] encrypted = cryptMessage.decrypt(gSonString.getBytes()); // bytearray in order to encrypt/decrypt

		outToServer.write(encrypted);
		outToServer.flush();
		BufferedReader inFromServer = new BufferedReader(new InputStreamReader(
				clientSocket.getInputStream()));
		modifiedSentence = inFromServer.readLine();
		
		System.out.println(modifiedSentence);
		String testString = new String(modifiedSentence).trim();
		byte[] decrypted = cryptMessage.decrypt(testString.getBytes());
		String decrypted2 = new String(decrypted).trim();
		
		System.out.println("FROM SERVER: " + decrypted2);
		
		clientSocket.close(); // closing socket
		objectString = decrypted2;
		return objectString;
	}
}
