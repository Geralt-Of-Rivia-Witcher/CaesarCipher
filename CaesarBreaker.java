import java.io.*;
import java.util.*;

public class CaesarBreaker
{
    public static int dkey(String encrypted)
    {
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        int counts[] = new int[26];
        for(int i = 0; i < encrypted.length(); i++)
        {
            int index = alphabet.indexOf(Character.toLowerCase(encrypted.charAt(i)));
            if(index != -1)
            {
                counts[index]++;
            }
        }
        int maxIndex = 0;
        for(int i = 0; i < counts.length; i++)
        {
            if(counts[i] > counts[maxIndex])
            {
                maxIndex = i;
            }
        }
        int dkey = maxIndex - 4;
        if(maxIndex < 4)
        {
            dkey = 26 - (4 - maxIndex);
        }
        System.err.println(dkey);
        return dkey;
    }

    public static String decrypt(String encrypted)
    {
        int dkey = dkey(encrypted);
        return CaesarCipher.encrypt(encrypted, 26 - dkey);
    }

    public static void main(String[] args) throws IOException
    {
        File file = new File("encrypted.txt");
        StringBuilder sb = new StringBuilder("");
        Scanner sc = new Scanner(file);
        while(sc.hasNext())
        {
            sb.append(sc.next() + " ");
        }
        sc.close();
        File newFile = new File("decrypted.txt");
        newFile.createNewFile();
        FileWriter writer = new FileWriter("decrypted.txt");
        writer.write(decrypt(sb.toString()));
        writer.close();
    }
}