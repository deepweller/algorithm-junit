package algorithm.search;

public interface Search {

    /**
     * 크기가 size인 배열에서 num을 찾는데 걸린 횟수
     * @param size 배열 크기
     * @param num 찾을 숫자
     * @return 찾는데 걸린 횟수
     */
    int findCount(int size, int num);

    /**
     * array에서 num의 index
     * @param array 배열
     * @param num 찾을 숫자
     * @return 인덱스
     */
    int find(int[] array, int num);



}
