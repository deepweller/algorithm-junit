package algorithm.recursive;

public class Factorial {

    /**
     * 펙토리얼 구하기
     * @param num
     * @return num!
     */
    public static int getFactorial(int num) {
        int result;

        if(num == 1) {
            return 1;
        } else {
            result = num * getFactorial(num-1);
        }

        return result;
    }
}
