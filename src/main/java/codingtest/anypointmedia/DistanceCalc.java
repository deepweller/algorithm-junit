package codingtest.anypointmedia;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DistanceCalc {

    class Point implements Comparable<Point> {
        //각각 좌표값123
        private int x;
        private int y;

        //기준이 되는 자표인지 여부123
        private boolean isBase;

        //기준이 되는 좌표와의 거리
        private double distanceFromBase;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        void setBase() {
            isBase = true;
        }

        int getX() {
            return x;
        }

        int getY() {
            return y;
        }

        double getDistanceFromBase() {
            return distanceFromBase;
        }

        void setDistanceFromBase(double distanceFromBase) {
            this.distanceFromBase = distanceFromBase;
        }

        /**
         * 결과를 출력하기 위한 override
         *
         * @return (x, y)
         */
        @Override
        public String toString() {
            String base = ""; //기준좌표여부

            //소숫점2자리로 반올림 (출처 : http://dream-kwon.tistory.com/16)
            double per = Double.parseDouble(String.format("%.2f", this.getDistanceFromBase()));

            String distance = String.valueOf("-거리:" + per); //기준좌표로부터의 거리

            if (isBase) base = "[기준]";

            return base + "(" + this.x + "," + this.y + ")" + distance;
        }

        /**
         * 기준이 되는 좌표로부터의 거리를 비교한다.
         *
         * @param o 비교객체
         * @return this가 작으면 음수, 같으면 0, 크면 양수
         */
        @Override
        public int compareTo(Point o) {
            if (this.distanceFromBase < o.getDistanceFromBase()) {
                return -1;
            } else if (this.distanceFromBase > o.getDistanceFromBase()) {
                return 1;
            }
            return 0;
        }
    }

    /**
     * 입력으로 들어온 문자열 파싱
     *
     * @param str 입력값
     * @return 좌표들의 리스트
     */
    List<Point> setDistance(String str) {
        String[] splitArray = str.split(" ");

        //기준이 되는 좌표의 인덱스
        int base = Integer.parseInt(splitArray[splitArray.length - 1]);

        List<Point> pointList = new ArrayList<>();

        //입력 내용을 리스트로 변환
        for (int i = 0; i < splitArray.length - 1; i++) {
            String[] tmp = splitArray[i].split(",");

            //x,y 좌표 값
            int x = Integer.parseInt(tmp[0].substring(1, tmp[0].length()));
            int y = Integer.parseInt(tmp[1].substring(0, tmp[1].length() - 1));

            Point point = new Point(x, y);

            //기준이 되는 좌표 flag
            if (i == base - 1) {
                point.setBase();
            }

            pointList.add(point);
        }

        return pointList;

    }

    /**
     * 기준이 되는 좌표로 부터 다른 좌표들의 거리를 구한 후 정렬
     *
     * @param pointList 정렬전 좌표
     * @return 정렬된 리스트
     */
    List<Point> sortByBaseDistance(List<Point> pointList) {

        for (int i = 0; i < pointList.size(); i++) {
            Point point = pointList.get(i);

            //기준이 되는 좌표를 찾은 후 나머지 좌표와 거리 계산
            if (point.isBase) {

                //기준이 되는 좌표는 자신과의 거리인 0을 set
                point.setDistanceFromBase(0);

                for (int j = 0; j < pointList.size(); j++) {
                    //기준이 되는 좌표를 제외한 나머지 좌표와의 거리 계산
                    if (j != i) {
                        double distance = calcDistance(pointList.get(i), pointList.get(j));
                        pointList.get(j).setDistanceFromBase(distance);
                    }
                }
            }
        }

        //distanceFromBase 에 set한 내용을 토대로 sort
        Collections.sort(pointList);

        return pointList;
    }

    /**
     * 두점사이 거리 구하기
     * 공식 출처 : http://mugrammer.tistory.com/121
     *
     * @param p1 비교할 좌표
     * @param p2 비교할 좌표
     * @return 두 점간 거리
     */
    double calcDistance(Point p1, Point p2) {

        return Math.sqrt(Math.pow(Math.abs(p1.getX() - p2.getX()), 2) + Math.pow(Math.abs(p1.getY() - p2.getY()), 2));
    }

    /**
     * 결과 출력
     *
     * @param pointList sortByBaseDistance()에 의해 정렬된 리스트
     */
    void printResult(List<Point> pointList) {
        for (Point point : pointList) {
            System.out.print(point.toString() + "\t");
        }
        System.out.println();
    }
}
