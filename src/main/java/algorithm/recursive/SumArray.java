package algorithm.recursive;

public class SumArray {

    /**
     * 분할정복방법으로 배열 원소의 합을 구함
     * @param array 배열
     * @param index 몇번째 인덱스 부터 합을 구할지
     * @return 합
     */
    public static int sumArray(int[] array, int index) {
        int sum = 0;

        if(index == array.length-1) {
            return array[index];
        } else {
            sum = array[index] + sumArray(array, index+1);
        }

        return sum;
    }
}

