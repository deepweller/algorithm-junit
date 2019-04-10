package codingtest.kakao;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Solution2 {

    static int[] hackerCards(int[] collection, int d) {
        Arrays.sort(collection);
        ArrayList<Integer> result = new ArrayList<>();

        int sum = 0;
        for (int i = 1; i <= d; i++) {
            if (Arrays.binarySearch(collection, i) > 0) {
                continue;
            } else {
                sum += i;
                if (sum > d) break;
                result.add(i);
            }
        }

        int[] a = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            a[i] = result.get(i);
        }
        return a;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        int[] collection = {4, 6, 12, 8};
        int d = 14;
        int[] res = hackerCards(collection, d);

        for (int i = 0; i < res.length; i++) {
            System.out.println(res[i]);
        }

        scanner.close();
    }
}