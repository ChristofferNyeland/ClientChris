package encryption;

public class Encryption {
	
	public String decrypt(byte[] b)
	{
		byte[] input = gSonString.getBytes();
		byte key = (byte) 3.1470;
		byte[] encrypted = input;
		for (int i = 0; i < encrypted.length; i++)
			encrypted[i] = (byte) (encrypted[i] ^ key);
		
		return null;

		

}
}
