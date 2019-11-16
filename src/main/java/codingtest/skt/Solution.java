package codingtest.skt;

public class Solution {
    public int solution(int[] A) {
        int result = A[0];

        for (int startIndex = 0; startIndex < A.length; startIndex++) {
            for (int endIndex = startIndex; endIndex < A.length; endIndex++) {
                int absSum = calcAbsSum(startIndex, endIndex, A);

                if (absSum == 0) {
                    return 0;
                }

                if (absSum < result) {
                    result = absSum;
                }
            }
        }

        return result;
    }

    private int calcAbsSum(int startIndex, int endIndex, int[] A) {
        int sum = 0;
        for (int i = startIndex; i <= endIndex; i++) {
            sum += A[i];
        }

        System.out.println(startIndex + "/" + endIndex + "=" + Math.abs(sum));

        return Math.abs(sum);
    }
}
