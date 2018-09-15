package codingtest.anypointmedia;

import org.junit.Test;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class CalcTest {

    private DistanceCalc distanceCalc = new DistanceCalc();

    @Test
    public void getTokenListTest() {
        List<DistanceCalc.Point> pointList = distanceCalc.setDistance("(1,1) (2,2) (4,4) (5,5) 2");

        for (DistanceCalc.Point point : pointList) {

            System.out.println(point.toString());
        }
    }

    @Test
    public void checkCalcDistance() {
        List<DistanceCalc.Point> pointList = distanceCalc.setDistance("(1,1) (2,2) (4,4) (5,5) 2");

        double result = distanceCalc.calcDistance(pointList.get(0), pointList.get(1));
        System.out.println(result);

    }

    @Test
    public void sortTest() {
        List<DistanceCalc.Point> pointList = distanceCalc.setDistance("(1,1) (2,2) (4,4) (5,5) 2");
        assertThat(pointList.get(0).getX(), is(1));

        distanceCalc.sortByBaseDistance(pointList);
        assertThat(pointList.get(0).getX(), is(2));
    }

    @Test
    public void finalTest() {
        //좌표값 및 기준이되는 좌표 초기화
        List<DistanceCalc.Point> pointList = distanceCalc.setDistance("(1,1) (2,2) (4,4) (5,5) 4");

        //정렬 후 출력
        distanceCalc.printResult(distanceCalc.sortByBaseDistance(pointList));

        //좌표값 및 기준이되는 좌표 초기화
        pointList = distanceCalc.setDistance("(100,100) (200,200) (140,140) (310,310) (270,270) 2");

        //정렬 후 출력
        distanceCalc.printResult(distanceCalc.sortByBaseDistance(pointList));

        //좌표값 및 기준이되는 좌표 초기화
        pointList = distanceCalc.setDistance("(100,10) (20,200) (14,140) (310,31) (27,270) 3");

        //정렬 후 출력
        distanceCalc.printResult(distanceCalc.sortByBaseDistance(pointList));
    }

}
