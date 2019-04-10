package codingtest.kakao;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Solution {

    static long findSimilar(long a, long b) {
        long result = 0;
        String stra = sorting(a);
        String strb = sorting(b);
        if (stra.equals(strb)) {
            result = combi(stra);
        } else {
            result = combi(strb);
        }

        return result;
    }

    static long combi(String str) {
        String[] spstr = str.split("");
        int[] number = new int[spstr.length];

        for (int i = 0; i < number.length; i++) {
            number[i] = Integer.parseInt(spstr[i]);
        }

        int[] counter = new int[10];

        for (int i = 0; i < number.length; i++) {
            counter[number[i]]++;
        }

        long down = 1;

        for (int i = 0; i < counter.length; i++) {
            int aaa = counter[i];
            if (aaa > 0) down *= fact(aaa);
            System.err.println(down);
        }
        System.err.println(down);
        long up = fact(str.length());

        return up / down;
    }

    public static String sorting(long a) {
        String original = String.valueOf(a);
        char[] chars = original.toCharArray();
        Arrays.sort(chars);
        String sorted = new String(chars);
        return sorted;
    }

    public static long fact(long n) {

        if (n <= 1)
            return n;
        else
            return fact(n - 1) * n;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        long res = findSimilar(112, 121);

        System.err.println(res);
        scanner.close();
    }
}