package codingtest.kakao;

import java.io.IOException;

public class Solution1 {

    static String decode(String encoded) {

        encoded = new StringBuilder(encoded).reverse().toString();

        int tmp = 0;
        String result = "";

        for (int i = 0; i < encoded.length(); i += tmp) {
            String str = "";

            char[] strList = encoded.toCharArray();
            int num = Integer.parseInt(String.valueOf(strList[i]));

            if (num == 1) {
                str = String.valueOf(strList[i]) + String.valueOf(strList[i + 1]) + String.valueOf(strList[i + 2]);
                tmp = 3;
            } else {
                str = String.valueOf(strList[i]) + String.valueOf(strList[i + 1]);
                tmp = 2;
            }
            char ch = (char) Integer.parseInt(str);
            result += String.valueOf(ch);
        }

        return result;
    }

    public static void main(String[] args) throws IOException {
        String encoded = "1219950180111108236115111016623101401611235115012312161151110101111127";
        String res = decode(encoded);
        System.err.println(res);
    }
}