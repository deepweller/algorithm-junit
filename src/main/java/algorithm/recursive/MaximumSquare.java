package algorithm.recursive;

public class MaximumSquare {

    /**
     * 분할정복방법 : 가로, 세로가 x, y 인 직사각형을 정사각형으로 나눈다. 이때 정사각형의 한변의 길이는?
     * @param x 가로
     * @param y 세로
     * @return 정사각형의 한 변의 길이
     */
    public static int getMaxSize(int x, int y) {
        int result = 0;

        System.out.println(x);
        System.out.println(y);
        System.out.println("-----");

        if(x%y==0) {
            result = x < y ? x : y; //기본단계 : 나눈 나머지가 0이면 남은 공간 없이 한 변으로 나눠 떨어진 다는 의미
        } else if (x > y) {
            x = x%y;
            result = getMaxSize(x, y);
        } else if (x < y) {
            y = y%x;
            result = getMaxSize(x, y);
        }

        return result;
    }
}
