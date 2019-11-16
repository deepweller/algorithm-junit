package codingtest.skt;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class test2 {

    public static void main(String[] args) {

        test2 main = new test2();

        int[] A = new int[]{1, 10, -5, 13, 26, -30, 33, 35, 48, 52, 23, 33, -33};
        int[] B = new int[]{5, 17, -2, 19, 27, -3, 39, 37, 52, 56, 33, 48, -31};
        int result = main.solution(A, B);
        System.err.println(result);
//        System.out.println("===============================");
//        System.out.println(result);
    }

    public int solution(int[] A, int[] B) {
        if (A == null || A.length == 0) {
            return 0;
        }
        if (A.length == 1) {
            return 1;
        }
        List<Interval> intervals = sortIntervals(A, B);

        //print sort
//        for (Interval item: intervals) {
//            System.out.println(item.a + ", " + item.b);
//        }

        while (combineIntervals(intervals)) {
            continue;
        }

//        System.out.println("===============================");
//        for (Interval item : intervals) {
//            System.out.println(item.a + ", " + item.b);
//        }
        return intervals.size();
    }

    private boolean combineIntervals(List<Interval> intervals) {
        for (int i = 0, cnt = intervals.size() - 1; i < cnt; i++) {
            for (int j = i + 1, cntJ = intervals.size(); j < cntJ; j++) {
                Interval first = intervals.get(i);
                Interval second = intervals.get(j);
                boolean overlap = first.equals(second);
                if (overlap) {
                    first.join(second);
                    intervals.remove(j);
                    return true;
                }
            }
        }
        return false;
    }

    public List<Interval> sortIntervals(int[] A, int[] B) {
        List<Interval> intervals = new ArrayList<>();
        for (int i = 0; i < A.length; i++) {
            intervals.add(new Interval(A[i], B[i]));
        }
        Collections.sort(intervals);
        return intervals;
    }

    public static class Interval implements Comparable {
        int a;
        int b;

        public Interval(int a, int b) {
            this.a = a;
            this.b = b;
        }

        @Override
        public int compareTo(Object o) {
            if (a > ((Interval) o).a) {
                return 1;
            } else if (a < ((Interval) o).a) {
                return -1;
            }
            return 0;
        }

        public void join(Interval that) {
            this.a = Math.min(this.a, that.a);
            this.b = Math.max(this.b, that.b);
        }

        @Override
        public boolean equals(Object obj) {
            if (obj instanceof Interval) {

                Interval that = (Interval) obj;

                if (this.b >= that.a && this.a <= that.b) {
                    return true;
                }
            }
            return false;
        }
    }
}
