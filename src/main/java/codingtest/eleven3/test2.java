package codingtest.eleven3;

import java.util.Arrays;

public class test2 {

    public static void main(String[] args) {
        String[] array = {"qwe", "asd", "zxc", "rty", "fgh", "vbn"};
        System.out.println(solution(array));
    }

    private static int solution(String[] A) {
        int result = 0;

        for (int j = 0; j < A.length - 1; j++) {
            for (int k = j + 1; k < A.length - 1; k++) {
                String word = "";
                for (int i = 1; i <= A.length; i++) {
                    word += A[j + i - 1];
                }
                if (!isTextDifferent(word)) {
                    result = Math.max(result, word.length());
                }
            }
        }

        return result;
    }

    private static boolean isTextDifferent(String checkingText) {

        String[] stringArray = checkingText.split("");
        Arrays.sort(stringArray);

        for (int i = 0; i < stringArray.length - 1; i++) {
            if (stringArray[i].equals(stringArray[i + 1])) {
                return true;
            }
        }

        return false;
    }
}

/*
public int solution(String[] A) {

        if(A == null) { return 0; }
        if(A.length == 0) { return 0; }

        int textLength = 0;

        for(int i=0; i<A.length; i++) {
            String concatText = A[i];
            String mainText = A[i];

            if(!isTextDifferent(mainText)) {
                for(String subText : A) {
                    if(!mainText.equals(subText)) {
                        concatText += subText;
                        if(textLength < getTextLength(concatText)) {
                            textLength = getTextLength(concatText);
                        }
                    }
                }
            }
        }

        return textLength;
    }

    private static int getTextLength(String text) {
        int textLength = 0;
        if(!isTextDifferent(text)) {
            textLength = text.length();
        }

        return textLength;
    }

    private static boolean isTextDifferent(String checkingText) {

        String[] stringArray = checkingText.split("");
        Arrays.sort(stringArray);

        for(int i=0; i<stringArray.length-1; i++) {
            if(stringArray[i].equals(stringArray[i+1])) {
                return true;
            }
        }

        return false;
    }
 */