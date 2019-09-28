package codingtest.eleven2;

import java.util.ArrayList;
import java.util.List;

public class test2 {
    public static void main(String[] args) {
        System.out.println(solution(new String[]{"abc", "kkk", "def", "csv"}));
    }

    public static int solution(String[] a) {

        int result = 0;
        List<String> list = new ArrayList<>();

        for (String s : a) {
            boolean flag = true;
            for (int i = 0; i < s.length(); i++) {
                if (s.contains(s.substring(i, i + 1))) {
                    flag = false;
                }
            }
            if (flag) {
                list.add(s);
            }
        }

        String concat = String.join("", list);

        boolean flag = true;
        for (int i = 0; i < concat.length(); i++) {
            if (concat.contains(concat.substring(i, i + 1))) {
                flag = false;
            }
        }


        return 0;
    }
}
