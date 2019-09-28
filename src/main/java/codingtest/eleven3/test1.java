package codingtest.eleven3;

public class test1 {
    public static void main(String[] args) {
//        System.out.println(solution("abcab"));
//        System.out.println(solution("codilty"));
//        System.out.println(solution("aaa"));
//        System.out.println(solution("aabcaabcabda"));
        System.out.println(solution("aacqvbnaabm"));
    }

    public static int solution(String s) {
        int result = -1;
        int length = s.length();

        for (int i = 0; i < length - 2; i++) {
            if (isMaxDistance(result, length, i)) break;

            String word = s.substring(i, i + 2);
            int distance = checkIterator(s, word, i);
            result = Math.max(result, distance);
        }

        return result == 0 ? -1 : result;
    }

    private static boolean isMaxDistance(int result, int length, int startIndex) {
        return result > length - 2 - startIndex;
    }

    private static int checkIterator(String str, String word, int startIndex) {
        int distance = 0;

        for (int i = startIndex + 1; i < str.length() - 1; i++) {
            if (word.equals(str.substring(i, i + 2))) {
                distance = i - startIndex;
            }
        }

        return distance;
    }
}
