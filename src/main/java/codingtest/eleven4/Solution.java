package codingtest.eleven4;

class Solution {
    public static void main(String[] args) {
        int[] a = {1, 2, 5, 6, 7, 9};
//        int[] a = {1, 2, 5, 7, 9};
        System.err.println(solution(a, 9));
    }

    static int solution(int[] A, int X) {
        int N = A.length;
        if (N == 0) {
            return -1;
        }
        int l = 0;
        int r = N - 1;
        while (l < r) {
            int m = (l + r) / 2;
            if (A[m] == X) {
                l = m;
                break;
            }
            if (A[m] > X) {
                r = m - 1;
            } else {
                l = m + 1;
            }
        }
        if (A[l] == X) {
            return l;
        }
        return -1;
    }
//    int solution(int[] A, int X) {
//        if (A.length == 0) {
//            return -1;
//        }
//
//        List<Integer> list = Arrays.stream(A)
//                .boxed()
//                .sorted()
//                .collect(Collectors.toList());
//
//        return IntStream.range(0, list.size())
//                .filter(i -> X == list.get(i))
//                .findFirst()
//                .orElse(-1);
//    }
}
