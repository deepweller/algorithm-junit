package codingtest.kakaoej;

import java.io.*;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Solution3 {
    private static final Scanner scan = new Scanner(System.in);

    public static void main(String args[]) throws Exception {
        // read the string filename

        String filename;
        filename = scan.nextLine();

        BufferedReader br = new BufferedReader(new FileReader(filename));
        String line = null;

        Set<String> set = new TreeSet<>();

        while ((line = br.readLine()) != null) {
            String[] data = line.split(" ");
            if ("200".equals(data[8]) && data[6] != null && (data[6].toLowerCase().endsWith(".gif"))) {
                set.add(data[6].substring(data[6].lastIndexOf("/") + 1));
            }
        }
        br.close();

        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("gifs_" + filename)));
        set.stream().forEach(s -> {
            pw.println(s);
        });

        pw.close();
    }
}
