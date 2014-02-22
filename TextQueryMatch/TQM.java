import java.io.*;
import java.util.*;

public class TQM {

    public static void main (String [] args) {
        Scanner in = new Scanner(System.in);
        
        if (!in.hasNext())
            throw new IllegalArgumentException("Empty file!");

        int num = in.nextInt();
        in.nextLine();

        for (int i = 0; i < num; i += 2) {
            System.out.print((i / 2 + 1) + " ");
            if (check(in.nextLine(), in.nextLine()))
                System.out.println(1);
            else
                System.out.println(0);
        }
    }

    public static boolean check(String query, String body) {
        
        return true;
    }
}