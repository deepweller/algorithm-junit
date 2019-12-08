package codingtest.eleven;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Test2 {
    public static void main(String[] args) {
        System.out.println(solution(1, 111));
    }

    public static int solution(int A, int B) {
        if (A == B && A < 100) {
            return 1;
        }

        int result = 0;
        for (int i = A; i <= B; i++) {
            String str = String.valueOf(i);
            List<String> split = Arrays.asList(str.split(""));
            if (check(split)) {
                result++;
            }
        }

        return result;
    }

    public static boolean check(List<String> split) {
        Map<String, Integer> countMap = new HashMap<>();

        for (String str : split) {
            if (countMap.get(str) != null) {
                if (countMap.get(str) >= 2) {
                    return false;
                } else {
                    countMap.put(str, countMap.get(str) + 1);
                }
            } else {
                countMap.put(str, 1);
            }
        }
        return true;
    }


}
