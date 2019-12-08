package codingtest.eleven;

import java.util.Arrays;
import java.util.List;

public class Test1 {
    public static void main(String[] args) {
        System.out.println(test(5, 1234));
    }

    public static int test(int A, int B) {
        String strA = String.valueOf(A);
        String strB = String.valueOf(B);

        List<String> strA_split = Arrays.asList(strA.split(""));
        List<String> strB_split = Arrays.asList(strB.split(""));

        if (!strB_split.contains(strA_split.get(0))) {
            return -1;
        }

        if (strA_split.size() == 1) {
            for (int i = 0; i < strB_split.size(); i++) {
                if (strB_split.get(i).equals(strA)) {
                    return i;
                }
            }
        }

        int result = -1;
        for (int i = 0; i < strB_split.size(); i++) {
            int index = i + 1;

            if (strB_split.get(i).equals(strA_split.get(0)) && strA_split.size() > 1) {
                int exit = 1;
                for (int j = 1; j < strA_split.size(); j++) {
                    if (strB_split.get(index).equals(strA_split.get(j))) {
                        result = i;
                        index++;
                        exit++;
                    }

                    if (exit == strA_split.size()) {
                        return result;
                    }
                }
            }
        }

        return result;
    }
}
