import java.io.*;
import java.util.*;

public class CaesarBreakerTwoKey
{
    public static String halfOfString(String message, int start)
    {
        StringBuilder sb = new StringBuilder("");
        for(int i = start; i < message.length(); i += 2)
        {
            sb.append(message.charAt(i));
        }
        System.out.println();
        System.out.println(sb.toString());
        return sb.toString();
    }
    
    public static String decryptTwoKeys(String encrypted)
    {
        String firstHalf = halfOfString(encrypted, 0);
        String secondHalf = halfOfString(encrypted, 1);
        firstHalf = CaesarBreaker.decrypt(firstHalf);
        secondHalf = CaesarBreaker.decrypt(secondHalf);
        StringBuilder sb = new StringBuilder("");
        int index = 0;
        for(int i = 0; i < encrypted.length(); i++)
        {
            if(i % 2 == 0)
            {
                sb.append(firstHalf.charAt(index));
            }
            else
            {
                sb.append(secondHalf.charAt(index++));
            }
        }
        return sb.toString();
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
        writer.write(decryptTwoKeys(sb.toString()));
        writer.close();
    }
}