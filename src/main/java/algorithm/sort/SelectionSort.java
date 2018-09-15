package algorithm.sort;

public class SelectionSort implements Sort {

    @Override
    public int[] sort(int[] array) {
        if(array.length == 0) return array;

        int min; //최소값
        int tmp; //최소값을 앞으로 이동시키고 그 자리에 있는 값을 임시 저장
        int idx = 0; //최소값이 있던 인덱스
        for (int i=0; i < array.length; i++) {
            //루프시작마다 초기화
            min = array[i];
            idx = i;
            for (int j = i+1; j < array.length; j++) {
                if (min > array[j]) {
                    min = array[j];
                    idx = j; //최소값 인덱스 저장
                }
            }
            //값 치환
            tmp = array[i];
            array[i] = min;
            array[idx] = tmp;
        }
        return array;
    }
}
