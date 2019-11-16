package codingtest.skt;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class teset3 {
    public Integer solution(String a, String b) {
        ArrayList<String> notMatching = new ArrayList<>();

        //a->b 비교 b->a 비교
        setAnalyzeAlphabet(a, b, notMatching);
        setAnalyzeAlphabet(b, a, notMatching);

        return notMatching.size();
    }

    private void setAnalyzeAlphabet(String ownWord, String splitWord, List<String> notMatching) {
        List<String> ownWordList = Arrays.asList(ownWord.split(""));
        List<String> targetList = new LinkedList<>(Arrays.asList(splitWord.split("")));

        for (String str : ownWordList) {
            getMatching(str, targetList);
        }
        remainAlphabet(targetList, notMatching);
    }

    private void getMatching(String alphabet, List<String> target) {
        int index = 0;
        for (String str : target) {
            if (alphabet.equals(str)) {
                target.remove(index);
                break;
            }
            index++;
        }
    }

    private void remainAlphabet(List<String> target, List<String> notMatching) {
        for (String str : target) {
            notMatching.add(str);
        }
    }
}
