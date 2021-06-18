import java.io.*;
import java.util.*;

public class CaesarCipher
{
    public static String encrypt(String input, int key)
    {
        String alteredString = input.toUpperCase();
        StringBuilder encrypted = new StringBuilder("");
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String shiftedAlphabet = alphabet.substring(key) + alphabet.substring(0, key);
        for(int i = 0; i < input.length(); i++)
        {
            char c = alteredString.charAt(i);
            int index = alphabet.indexOf(c);
            if(index != -1)
            {
                if(Character.isUpperCase(input.charAt(i)))
                {
                    encrypted.append(shiftedAlphabet.charAt(index));
                }
                else
                {
                    encrypted.append(Character.toString(shiftedAlphabet.charAt(index)).toLowerCase());
                }
            }
            else
            {
                encrypted.append(c);
            }
        }
        return encrypted.toString();
    }

    public static void main(String[] args) throws IOException
    {
        int key = 4;
        File file = new File("decrypted.txt");
        StringBuilder sb = new StringBuilder("");
        Scanner sc = new Scanner(file);
        while(sc.hasNext())
        {
            sb.append(sc.next() + " ");
        }
        sc.close();
        File newFile = new File("encrypted.txt");
        newFile.createNewFile();
        FileWriter writer = new FileWriter("encrypted.txt");
        writer.write(encrypt(sb.toString(), key));
        writer.close();
    }
}
