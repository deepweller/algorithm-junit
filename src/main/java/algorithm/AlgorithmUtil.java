package algorithm;

public class AlgorithmUtil {

    /**
     * 1~size 배열 생성
     * @param size
     * @return
     */
    public static int[] setArray(int size) {
        int[] array = new int[size];
        for(int i = 0; i < size; i++) {
            array[i] = i+1;
        }
        return array;
    }

    public static int[] swapValue(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
        return arr;
    }

    public static char[] swapValue(char[] arr, int a, int b) {
        char temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
        return arr;
    }
}
