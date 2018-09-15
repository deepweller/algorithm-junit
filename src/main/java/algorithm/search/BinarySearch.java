package algorithm.search;

import algorithm.AlgorithmUtil;

public class BinarySearch implements Search {

    @Override
    public int findCount(int size, int num) {
        int[] array = AlgorithmUtil.setArray(size);
        int count = 1;
        int mid;
        int start = 0;
        int end = size-1;
        while (start <= end) {
            mid = (start+end)/2;
            //남은 숫자가 2개일땐 둘중 하나이므로 틀려도 횟수는 리턴
            if(start == end -1 || num == array[mid]) {
                return count;
            } else {
                if(num > array[mid]) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
            count++;
        }
        return -1;
    }

    @Override
    public int find(int[] array, int num) {
        int mid;
        int start = 0;
        int end = array.length-1;
        while (start <= end) {
            mid = (start+end)/2;
            if(num == array[mid]) {
                return mid;
            } else {
                if(num > array[mid]) {
                    start = mid + 1;
                } else if(num < array[mid]){
                    end = mid - 1;
                }
            }
        }
        return -1;
    }
}
