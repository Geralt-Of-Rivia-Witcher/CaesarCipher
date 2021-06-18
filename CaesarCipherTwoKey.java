import java.io.*;
import java.util.*;

public class CaesarCipherTwoKey
{
    public static String encryptTwoKeys(String input, int key1, int key2)
    {
        StringBuilder encrypted = new StringBuilder("");
        for(int i = 0; i < input.length(); i++)
        {
            String str = Character.toString(input.charAt(i));
            if(i % 2 == 0)
            {
                encrypted.append(CaesarCipher.encrypt(str, key1));
            }
            else
            {
                encrypted.append(CaesarCipher.encrypt(str, key2));
            }
        }
        return encrypted.toString();
    }

    public static void main(String[] args) throws IOException
    {
        int key1 = 4;
        int key2 = 10;
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
        writer.write(encryptTwoKeys(sb.toString(), key1, key2));
        writer.close();
    }
}
