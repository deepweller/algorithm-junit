package codingtest.kakaoej;

import java.util.Scanner;

public class Solution {
    /*
     * Complete the 'getShiftedString' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts following parameters:
     *  1. STRING s
     *  2. INTEGER leftShifts
     *  3. INTEGER rightShifts
     */

    public static String getShiftedString(String s, int leftShifts, int rightShifts) {
        // Write your code here

        String result = "";
        String[] splitStr = s.split("");

        if (rightShifts != 0 && rightShifts > s.length()) {
            rightShifts = rightShifts % s.length();
        }
        if (leftShifts != 0 && leftShifts > s.length()) {
            leftShifts = leftShifts % s.length();
        }

        result = s.substring(leftShifts) + s.substring(0, leftShifts);
        result = result.substring(result.length() - rightShifts) + result.substring(0, result.length() - rightShifts);

        return result;
    }


    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String str = getShiftedString("abcd", 0, 1);
        System.out.println(str);
        scanner.close();
    }
}
