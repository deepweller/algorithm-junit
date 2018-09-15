package algorithm.recursive;

import algorithm.AlgorithmUtil;

public class QuickSort{

    public static int[] solution(int[] arr, int left, int right) {
        if (arr == null) return null;

        int[] result = arr;
        if (left >= right) return result;

        int pivotPos = partition(result, left, right);

        result = solution(result, left, pivotPos - 1);
        result = solution(result, pivotPos + 1, right);

        return result;
    }

    private static int partition(int[] arr, int left, int right) {
        if (arr == null || left < 0) return -1;
        int pivotValue = arr[right];
        int endOfLowBlock = left - 1;

        for (int pos = left; pos < right; ++pos) {
            if (pivotValue > arr[pos]) {
                endOfLowBlock += 1;
                AlgorithmUtil.swapValue(arr, pos, endOfLowBlock);
            }
        }
        endOfLowBlock += 1;
        AlgorithmUtil.swapValue(arr, right, endOfLowBlock);

        return endOfLowBlock;
    }
}
