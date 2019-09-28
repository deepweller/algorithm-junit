package codingtest.eleven2;

public class test1 {
    public static void main(String[] args) {
        System.out.println(solution("acbac"));
//        System.out.println(solution("codilty"));
//        System.out.println(solution("aaa"));
//        System.out.println(solution("aabcaabcabda"));
    }

    public static int solution(String s) {
        int result = -1;

        for (int i = 0; i < s.length() - 2; i++) {
            for (int j = i + 1; j < s.length() - 1; j++) {

                String str1 = s.substring(i, i + 1);
                String str2 = s.substring(j, j + 1);
                System.err.println(str1 + " / " + str2);

                if (s.substring(i, i + 1).equals(s.substring(j, j + 1))) {
                    result = Math.max(result, (j - i));
                    System.err.println(result);
                }
            }
        }

        return result;
    }

}
