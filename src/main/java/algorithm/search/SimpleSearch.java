package algorithm.search;

import algorithm.AlgorithmUtil;

public class SimpleSearch implements Search {

    @Override
    public int findCount(int size, int num) {
        int[] array = AlgorithmUtil.setArray(size);
        return executeLogic(array,num)+1; //횟수이므로 +1
    }

    @Override
    public int find(int[] array, int num) {
        return executeLogic(array,num);
    }

    private int executeLogic(int[] array, int num) {
        int idx;
        for (idx = 0; idx < array.length; idx++) {
            if (array[idx] == num) {
                return idx;
            }
        }
        return -1;
    }


}
